# Cobblemon 친구 서버 모드 파일

## 기준 버전

- Minecraft 1.21.1
- Fabric
- Java 21 or newer
- Fabric Loader 0.19.5 or newer
- Cobblemon 1.8.2
- 모드 파일은 Modrinth 공식 배포 파일에서 받았습니다.

## 폴더 안내

- `mods-shared/`: 서버와 플레이어 클라이언트 모두의 `mods` 폴더에 넣습니다.
- `mods-client-only/`: 각 플레이어 클라이언트의 `mods` 폴더에만 넣습니다. 전용 서버에는 넣지 않습니다.

클라이언트에는 두 폴더의 모드를 모두 설치합니다. 서버에는 `mods-shared/`만 설치합니다. Fabric Loader는 이 압축 파일에 포함되어 있지 않으므로 별도로 설치하세요.

## 포함된 모드

### 서버와 클라이언트 공통

- Cobblemon 1.8.2
- Fabric API 0.116.17+1.21.1
- Architectury API 13.0.11
- Farmer's Delight Refabricated 1.21.1-3.3.6
- Cobblemon - Exp. All 0.0.2
- Fabric Language Kotlin 1.14.2

### 클라이언트 전용

- Cobblemon Party Extras 1.8.15
- Cobblemon Highlight 1.1.0
- Cobblemon Info for REI / JEI / EMI 2.32.1
- EMI 1.1.24+1.21.1

Cobblemon Info는 아이템·레시피 뷰어로 EMI를 선택해 구성했습니다. REI와 JEI는 함께 넣지 않았습니다.

## 설치 순서

1. 서버를 끄고 월드와 설정을 백업합니다.
2. 서버에 Fabric Loader 1.21.1을 설치합니다.
3. `mods-shared/` 안의 JAR 파일을 서버의 `mods/` 폴더에 복사합니다.
4. 각 플레이어는 같은 Minecraft/Fabric 버전을 사용하고, `mods-shared/`와 `mods-client-only/`의 JAR 파일을 클라이언트 `mods/` 폴더에 복사합니다.
5. 서버를 켜서 콘솔에 모드 오류가 없는지 확인한 뒤 클라이언트로 접속합니다.

모드를 넣은 것만으로 모든 조합의 실제 실행 호환성이 보장되는 것은 아닙니다. 처음에는 복사한 테스트 월드에서 실행하고, 오류가 나면 로그를 확인하세요. 이 파일에는 Bukkit 플러그인이나 Cardboard가 포함되어 있지 않습니다.

## 경제·플러그인 방향

이번 모드 묶음에는 경제 모드를 추가하지 않았습니다. 플러그인 경제를 시험할 때는 EssentialsX를 유일한 잔액 기준으로 삼고, Vault, PlaceholderAPI, TAB, EconomyShopGUI를 후보로 사용합니다. NPC 상점이 필요하면 Shopkeepers를 추가로 시험할 수 있습니다.

이 플러그인들은 Paper/Spigot 계열용입니다. Fabric + Cardboard에서 Cobblemon과 함께 작동하는지는 확인이 필요하므로, 별도 복사본에 하나씩 넣어 시험하세요. EssentialsX의 `/withdraw <금액>`은 실물 지폐 인출 후보이며 `/화폐` 명령 별칭은 별도 확인 대상입니다. Cobblemon 배틀 패배자의 돈을 차감하는 기능은 이번 구성에 포함하지 않았습니다.

## 출처

- [Cobblemon](https://modrinth.com/mod/cobblemon)
- [Fabric API](https://modrinth.com/mod/fabric-api)
- [Architectury API](https://modrinth.com/mod/architectury-api)
- [Farmer's Delight Refabricated](https://modrinth.com/mod/farmers-delight-refabricated)
- [Cobblemon - Exp. All](https://modrinth.com/mod/cobblemon-exp.-all)
- [Cobblemon Party Extras](https://modrinth.com/mod/cobblemon-party-extras)
- [Cobblemon Highlight](https://modrinth.com/mod/cobblemon-highlight)
- [Cobblemon Info for REI / JEI / EMI](https://modrinth.com/mod/cobbledex-rei-emi-jei)
- [EMI](https://modrinth.com/mod/emi)
- [Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin)
