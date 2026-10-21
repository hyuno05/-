# 친구들과 하는 Cobblemon 서버

마인크래프트의 생존·건축·농사와 Cobblemon의 포켓몬 수집·배틀을 함께 즐기는 친구용 서버입니다. 농작물과 광물을 팔아 돈을 벌고, 그 돈으로 포켓몬 관련 아이템과 편의 아이템을 사는 경제를 목표로 합니다.

## 시작 구성안

- Minecraft `1.21.1`
- Fabric 모드 로더
- 귀환서는 이 프로젝트의 Fabric 모드로 구현
- 탐험 지도 UI는 클라이언트 모드 JourneyMap 사용
- Bukkit 플러그인은 핵심 기능을 만든 뒤 Cardboard 호환성을 별도 테스트

### 서버 모드

- Cobblemon `1.8.2`
- Farmer's Delight Refabricated `3.3.6`: 농사와 요리 확장
- Cobblemon - Exp. All `0.0.2`
- Cobblemon Ultra Space `1.4.1`
- Chunky `1.4.23`: 플레이어 입장 전 지형 사전 생성

### 클라이언트 편의 모드

- JourneyMap `6.0.9`: 탐험 지도 UI
- Cobblemon Party Extras `1.8.15`
- Cobblemon Highlight `1.1.0`
- Cobblemon Info `2.32.0` with EMI `1.1.24`
- Sodium `0.8.13`, Lithium `0.15.4`, FerriteCore `7.0.3`: 렌더링·게임 처리·메모리 최적화

Fabric API `0.116.17+1.21.1`, Fabric Language Kotlin `1.14.2`, Architectury API `13.0.11`은 필수 의존성입니다. REI/JEI/EMI 중 EMI를 선택했습니다.

Chunky로 지형을 미리 만들려면 운영자 권한으로 `/chunky center <X> <Z>`, `/chunky radius 1000`, `/chunky start`를 실행합니다. `<X> <Z>`는 로비 좌표로 바꾸고, 작업이 끝난 뒤 플레이어 접속을 허용합니다. 사전 생성은 새 청크 생성 중의 멈춤을 줄여주지만 렌더링 FPS나 RAM 부족을 해결하지는 않습니다.

클라이언트 전용 모드는 서버 `mods` 폴더에 넣지 않고 각 플레이어의 게임에 설치합니다. Cobblemon과 서버·클라이언트 양쪽에서 필요한 모드는 참여자 모두 같은 호환 버전으로 맞춥니다.

### 플러그인 테스트 후보

- EssentialsX: 기본 잔액·송금 등 경제 기능
- Vault: 경제 플러그인 연동 API
- TAB: 사이드바와 플레이어 목록 UI
- Shopkeepers: NPC 상점
- LuckPerms: 운영진·플레이어 권한 관리

EssentialsX를 잔액의 기준으로 삼는 동안 CobbleDollars 같은 별도 경제 모드는 함께 사용하지 않습니다. 서로 다른 경제 시스템을 동시에 쓰면 잔액과 거래가 분리될 수 있습니다.

## 구현된 기능

### 귀환서

`/setworldspawn`으로 오버월드 로비 위치를 지정한 뒤 `/give @s friends_server:return_scroll`로 지급합니다. 우클릭하면 해당 위치로 이동하고 귀환서는 소모됩니다.

### 탐험 지도

JourneyMap을 클라이언트에 설치해 사용합니다. Minecraft `1.21.1` 및 Fabric과 호환되는 버전을 선택합니다. 지도 UI와 발견 기록은 JourneyMap이 관리하며, 이 프로젝트의 모드에는 포함하지 않습니다.

귀환서 모드는 빌드까지 확인했습니다. 실제 Minecraft에서의 플레이 테스트는 아직 필요합니다.

## 아직 별도 구현·검증이 필요한 기능

- `/화폐 1000`으로 1,000원 지폐를 발행하고 우클릭해 잔액으로 바꾸는 기능
- 농작물·광물 판매 가격과 포켓몬 아이템 상점 목록
- 플레이어 포켓몬 배틀 패배자의 잔액 차감

위 기능은 후보 플러그인만으로 되는 것으로 간주하지 않습니다. Cobblemon 배틀 결과와 경제 잔액을 연결하는 연동이 필요한지 테스트한 뒤 구현 방식을 정합니다.

## 진행 순서

1. Fabric 테스트 서버를 실행하고 Minecraft `1.21.1`에서 접속 확인
2. Cobblemon과 필수 서버 모드를 추가하고 서버·클라이언트 호환 확인
3. Fabric 모드에 로비 위치 설정과 귀환서 우클릭 이동 구현
4. 클라이언트에 JourneyMap을 설치하고 지도 및 탐험 기록 확인
5. Farmer's Delight와 Exp. All을 추가하고 클라이언트 접속 및 월드 저장 확인
6. 경제·상점 기능을 정한 뒤 필요한 플러그인을 하나씩 추가하고 Cardboard 호환성 검증
7. 백업·재시작·재접속을 포함해 테스트한 뒤 실제 친구용 서버로 옮김