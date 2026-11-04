# Cobblemon 친구 서버 모드팩

## 설치 기준

- Minecraft 1.21.1
- Cobbleverse 1.7.42 기반
- Fabric Loader 0.18.4
- Java 21 이상
- Fabric API 0.116.14+1.21.1
- Cobblemon 1.7.3

이 파일은 Modrinth `.mrpack` 모드팩입니다. JAR 파일을 재배포하는 대신 공식 Modrinth 다운로드를 참조하므로, Modrinth App에서 가져오면 필요한 파일이 자동으로 설치됩니다. 전용 서버에 설치할 때는 `.mrpack`을 지원하고 서버/클라이언트 구분 정보를 따르는 서버용 설치 도구를 사용하세요. 클라이언트 전용 모드는 서버에 설치하지 않습니다.

## Cobblemon 모드

### 서버와 클라이언트 공통

- Cobblemon 1.7.3: Cobbleverse가 제공하는 기본 포켓몬 모드
- Cobblemon - Exp. All 0.0.2: 파티 포켓몬의 경험치 획득을 돕는 모드
- Cobblemon Ultra Space 1.4.1: 울트라 스페이스 차원 콘텐츠 추가

### 클라이언트 전용

- Cobblemon Party Extras 1.8.15: 파티 화면과 포켓몬 관리 편의 기능
- Cobblemon Highlight 1.1.0: 월드에서 포켓몬을 눈에 띄게 표시
- Cobblemon Info for REI / JEI / EMI 2.32.1: 포켓몬 관련 아이템·정보 표시 기능
- JourneyMap 6.0.9: Minecraft 1.21.1용 클라이언트 지도 모드
- EMI 1.1.24: 아이템과 조리법을 검색하는 뷰어. Cobblemon Info의 연동 대상으로 사용

## 함께 포함한 이전 모드와 필수 라이브러리

- Farmer's Delight Refabricated 3.3.6: 농사와 요리 콘텐츠 추가
- Fabric API 0.116.14: Cobbleverse가 제공하는 Fabric 공통 기능 라이브러리
- Architectury API 13.0.8: Cobbleverse가 제공하는 모드 로더 공통 라이브러리
- Fabric Language Kotlin 1.13.13: Cobbleverse가 제공하는 Kotlin 실행 라이브러리

## 최적화 및 운영 모드

### 서버와 클라이언트 공통

- Lithium 0.15.4: 게임 로직을 최적화해 서버 처리 부담과 틱 지연을 줄이는 데 도움
- FerriteCore 7.0.3: 메모리 사용량을 줄이는 데 도움

### 서버 전용

- Chunky 1.4.23: 플레이어 입장 전에 월드 청크를 미리 생성해 탐험 중의 청크 생성 지연을 줄이는 도구

### 클라이언트 전용

- Sodium 0.8.13: 렌더링 성능과 프레임률을 개선하는 클라이언트 모드

Chunky는 명령으로 지형을 사전 생성할 때만 사용합니다. 최적화 모드는 서버 성능과 설정에 따라 효과가 다르며, 실제 운영 전에 백업한 테스트 월드에서 확인하세요.

## Cobbleverse 통합 팩

[`COBBLEVERSE-Compatible-1.21.1-Fabric.mrpack`](https://github.com/hyuno05/-/releases/download/cobbleverse-compatible-v1.7.42/COBBLEVERSE-Compatible-1.21.1-Fabric.mrpack)은 Cobbleverse 1.7.42를 메인 베이스로 사용합니다. Lithium, FerriteCore, Highlight, Sodium, Fabric API, Architectury API, Fabric Language Kotlin은 Cobbleverse 버전을 유지했습니다. Farmer's Delight, 귀환서 모드, C2ME는 호환성 문제를 막기 위해 제외했습니다.

호환 확인 후 추가한 모드는 다음과 같습니다.

- Farmer's Delight Refabricated 3.3.6
- Cobblemon - Exp. All 0.0.2
- Cobblemon Party Extras 1.8.15
- Cobbledex 2.32.1
- EMI 1.1.24
- Cobblemon Ultra Space 1.4.1
- Chunky 1.4.23
- 귀환서 서버 모드 0.1.0

## 지도

JourneyMap 6.0.9 클라이언트 모드를 별도 ZIP으로 제공합니다. 서버에는 넣지 않고, 각 플레이어의 게임 `mods` 폴더에만 설치합니다.

## 라이선스 및 다운로드

모드 파일은 각 제작자의 공식 Modrinth 배포처에서 모드팩 런처가 내려받습니다. 이 모드팩에는 모드 원본 JAR을 재배포하지 않습니다. 버전, 공식 다운로드 주소, 무결성 해시는 `modrinth.index.json`에 기록되어 있습니다.
