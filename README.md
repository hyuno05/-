# 친구들과 하는 Cobblemon 서버

마인크래프트의 생존·건축·농사와 Cobblemon의 포켓몬 수집·배틀을 함께 즐기는 친구용 서버입니다. 농작물과 광물을 팔아 돈을 벌고, 그 돈으로 포켓몬 관련 아이템과 편의 아이템을 사는 경제를 목표로 합니다.

## 시작 구성안

- Minecraft `1.21.1`
- Cobbleverse `1.7.42` 메인 모드팩
- Fabric 모드 로더
- 귀환서는 이 프로젝트의 Fabric 모드로 구현
- 지도 기능은 Cobblemon 자체 기능 사용
- Bukkit 플러그인은 핵심 기능을 만든 뒤 Cardboard 호환성을 별도 테스트

### 서버 모드

- Cobblemon `1.7.3`: Cobbleverse 기본 버전
- Farmer's Delight Refabricated `3.3.6`: 농사와 요리 확장
- Cobblemon - Exp. All `0.0.2`
- Cobblemon Ultra Space `1.4.1`
- Lithium `0.15.4`, FerriteCore `7.0.3`: 게임 처리 및 메모리 최적화
- Chunky `1.4.23`: 플레이어 입장 전 지형 사전 생성

### 클라이언트 편의 모드

- Cobblemon Party Extras `1.8.15`
- Cobblemon Highlight `1.1.0`
- Cobblemon Info `2.32.1` with EMI `1.1.24`
- JourneyMap `6.0.9`: Fabric 1.21.1용 클라이언트 지도 모드
- Cobblemon JEI & JourneyMap Integration `1.10.2`: JourneyMap에서 포켓몬 종과 스폰 가능 구역을 추적하는 클라이언트 모드
- Just Enough Items `19.70.0.469`: 위 통합 모드의 필수 JEI 의존성
- Sodium `0.8.13`: 렌더링 최적화

[JourneyMap + 포켓몬 추적 클라이언트 ZIP 다운로드](https://github.com/hyuno05/-/releases/download/journey-map-pokemon-v1.10.2/JourneyMap-1.21.1-Fabric.zip)

Fabric API `0.116.14+1.21.1`, Fabric Language Kotlin `1.13.13`, Architectury API `13.0.8`은 Cobbleverse 제공 라이브러리입니다. 중복 모드인 기존 Lithium, FerriteCore, Highlight, Sodium은 제외했습니다.

[Cobbleverse + 친구 서버 통합 모드팩 다운로드](https://github.com/hyuno05/-/releases/download/cobbleverse-friends-v1.7.42/COBBLEVERSE-Friends-1.21.1-Fabric.mrpack)

전체 모드 구성은 Modrinth App에서 가져올 수 있는 [`Cobblemon-Server-Mods-1.21.1-Fabric.mrpack`](./Cobblemon-Server-Mods-1.21.1-Fabric.mrpack)으로 제공합니다. 모드 JAR은 각 제작자의 Modrinth 배포처에서 런처가 내려받습니다.

Chunky로 지형을 미리 만들려면 운영자 권한으로 `/chunky center <X> <Z>`, `/chunky radius 1000`, `/chunky start`를 실행합니다. `<X> <Z>`는 로비 좌표로 바꾸고, 작업이 끝난 뒤 플레이어 접속을 허용합니다. 사전 생성은 새 청크 생성 중의 멈춤을 줄여주지만 렌더링 FPS나 RAM 부족을 해결하지는 않습니다.

클라이언트 전용 모드는 서버 `mods` 폴더에 넣지 않고 각 플레이어의 게임에 설치합니다. Cobblemon과 서버·클라이언트 양쪽에서 필요한 모드는 참여자 모두 같은 호환 버전으로 맞춥니다.

### 플러그인 후보와 역할

플러그인은 모두 Paper/Spigot 계열을 대상으로 만들어졌습니다. [Cardboard의 1.21.1 지원 상태가 Low](https://github.com/CardboardPowered/cardboard)이므로 Fabric + Cardboard 조합에서의 실제 호환은 검증되지 않았습니다. 별도 복사본에서 하나씩 시험해야 합니다.

- [EssentialsX](https://essentialsx.net/): 잔액, 송금, 아이템 판매 가격 설정, `/withdraw <금액>`으로 실물 지폐 인출
- [Vault](https://www.spigotmc.org/resources/vault.34315/): 경제 플러그인을 상점 플러그인과 연결하는 API
- [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/) + [TAB](https://modrinth.com/plugin/tab-was-taken): 잔액 플레이스홀더를 오른쪽 사이드바에 표시
- [EconomyShopGUI](https://www.spigotmc.org/resources/economyshopgui.69927/): 작물·광물 등 일반 아이템의 구매/판매 상점
- [Shopkeepers](https://www.spigotmc.org/resources/shopkeepers.80756/): NPC 상점이 꼭 필요할 때 추가로 시험할 후보
- [LuckPerms](https://luckperms.net/): 운영진·플레이어 권한 관리

경제 잔액의 기준은 EssentialsX 하나로 둡니다. CobbleDollars나 Cobblemon Economy를 함께 잔액 기준으로 사용하면 잔액이 분리될 수 있으므로, 이 구성에는 넣지 않습니다. EssentialsX의 `/withdraw`는 원하는 지폐 기능과 비슷하지만 명령어가 `/화폐`는 아닙니다. 별칭 설정으로 이름을 바꿀 수 있는지 시험 서버에서 확인합니다.

플러그인은 Cardboard와 Cobblemon에서 함께 실행되는지 확인되기 전까지 확정 설치로 보지 않습니다. 안정적인 플러그인 구동이 안 되면 Paper 플러그인을 억지로 끼우지 않고, Cobblemon용 Fabric 경제 모드 등으로 방향을 바꿉니다.

## 구현된 기능

### 귀환서

`/setworldspawn`으로 오버월드 로비 위치를 지정한 뒤 `/give @s friends_server:return_scroll`로 지급합니다. 우클릭하면 해당 위치로 이동하고 귀환서는 소모됩니다.

### 탐험 지도

JourneyMap `6.0.9` 클라이언트 모드를 사용합니다.

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
4. Farmer's Delight와 Exp. All을 추가하고 클라이언트 접속 및 월드 저장 확인
5. 경제·상점 기능을 정한 뒤 필요한 플러그인을 하나씩 추가하고 Cardboard 호환성 검증
6. 백업·재시작·재접속을 포함해 테스트한 뒤 실제 친구용 서버로 옮김