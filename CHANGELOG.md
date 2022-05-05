# Changelog

All notable changes to this project will be documented in this file. See [standard-version](https://github.com/conventional-changelog/standard-version) for commit guidelines.

## [2.2.0](https://github.com/Pablito2020/Tetris/compare/v2.1.1...v2.2.0) (2022-05-05)


### Features

* **block-creator:** add simple and all block queue creator ([fe7068e](https://github.com/Pablito2020/Tetris/commit/fe7068e89fca93a72882d4c6954d5accb077b6b7))

### [2.1.1](https://github.com/Pablito2020/Tetris/compare/v2.1.0...v2.1.1) (2022-04-29)


### Bug Fixes

* **blockgenerator:** fix next block type ([a8b7012](https://github.com/Pablito2020/Tetris/commit/a8b701223d00c52a10630e395689481a251df0ae))

## [2.1.0](https://github.com/Pablito2020/Tetris/compare/v2.0.0...v2.1.0) (2022-04-26)


### Features

* **facade:** implement drop block ([5b1837b](https://github.com/Pablito2020/Tetris/commit/5b1837b7ebb64c08d781bcc890fbb3f038f1e975)), closes [#5](https://github.com/Pablito2020/Tetris/issues/5)


### Bug Fixes

* **facade:** unsupported operations when game has finished ([a1ea82b](https://github.com/Pablito2020/Tetris/commit/a1ea82b19aa0cd79ffd762322a9416204160737d))

## [2.0.0](https://github.com/Pablito2020/Tetris/compare/v1.1.0...v2.0.0) (2022-04-26)


### ⚠ BREAKING CHANGES

* **game:** privatize game objects
* **facade:** use ghost bool, not the hole game
* **ghost:** Facade class now accepts a game constructor for
allowing a new instance of GhostGame.
* **game:** add gamecell default values

### Features

* **block:** add serialize ([409ac21](https://github.com/Pablito2020/Tetris/commit/409ac21f9c2fa08062c5e103acf110faae24ba2e))
* **board:** add serialize ([a820d3d](https://github.com/Pablito2020/Tetris/commit/a820d3d0f29528382192bf65dafe847377e838ed))
* **facade:** use ghost bool, not the hole game ([56f132e](https://github.com/Pablito2020/Tetris/commit/56f132ebe5724ae1e3b321092c6995a5c5cd6ca5))
* **game-facade:** add serialize ([c85f6d2](https://github.com/Pablito2020/Tetris/commit/c85f6d2c65f01527ce053f4b98c4916838972930))
* **game:** privatize game objects ([ee8f271](https://github.com/Pablito2020/Tetris/commit/ee8f2711aa8107ecdd34814d98479376d7abd786))
* **ghost:** add serialize ([a39bdfd](https://github.com/Pablito2020/Tetris/commit/a39bdfdd9fea45da298741b21ece81d7e91c070d))
* **ghost:** implement ghost block game feature ([b4a1840](https://github.com/Pablito2020/Tetris/commit/b4a18406f2a259f0da4884424ef1cd73b171cd97)), closes [#4](https://github.com/Pablito2020/Tetris/issues/4)
* **normal-game:** implement serializable ([c22526c](https://github.com/Pablito2020/Tetris/commit/c22526c6742eb9b6191d3b8411ddf6fdea529610))


### Bug Fixes

* **facade:** add tetris for mobile movements ([801669c](https://github.com/Pablito2020/Tetris/commit/801669ccbdfc27a0d36acad537a79a0bdd9de7e8))
* **ghost:** ghost block overloads current block ([aca156e](https://github.com/Pablito2020/Tetris/commit/aca156e56b46a0ce5fc12f6889508e0f1037a19b))


* **game:** add gamecell default values ([111d2e5](https://github.com/Pablito2020/Tetris/commit/111d2e5805accfe1ad5004783d3aac063703b725))

## 1.1.0 (2022-04-18)


### Features

* **block_fact:** implement random factory ([0bf3b2a](https://github.com/Pablito2020/Tetris/commit/0bf3b2a77ee073280e78915b3ab948173d4d8dca))
* **block:** implement move down ([0140301](https://github.com/Pablito2020/Tetris/commit/0140301017761e5ebacfdcefb0919f05b06f2f13))
* **block:** initiate iblock class ([873642d](https://github.com/Pablito2020/Tetris/commit/873642d38a3509949a2678c76248cdc60ebea451))
* **board:** implement block cell checking ([c9578e0](https://github.com/Pablito2020/Tetris/commit/c9578e0cfd900efa0d522bdd3e4b763c3c326b14))
* **board:** implement clear method ([9d7c6cb](https://github.com/Pablito2020/Tetris/commit/9d7c6cb6d335edb2b8a0a548b39752755586eca0))
* **board:** implement isEmpty ([c2533b0](https://github.com/Pablito2020/Tetris/commit/c2533b0866fa973aece8608c4df11729e2bc8d2f))
* **board:** implement isFull ([07476d1](https://github.com/Pablito2020/Tetris/commit/07476d1426fb3940f830b16787b9e4509c51b421))
* **board:** implement isInside ([8189db4](https://github.com/Pablito2020/Tetris/commit/8189db473a471576c1a7843d2e3f9474c8939564))
* **board:** implement writePosition ([c18eab6](https://github.com/Pablito2020/Tetris/commit/c18eab6ea9c4341b5345b20cc00681dff52f844c))
* **board:** implement writePosition ([480f1fb](https://github.com/Pablito2020/Tetris/commit/480f1fb2fe408b402ba893b6250e2e3568790d8f))
* **game:** add collisions to move block ([a989a8a](https://github.com/Pablito2020/Tetris/commit/a989a8a401f2728a974d9ecd775ee701d7a90d43))
* **game:** add facade bridge ([24fc963](https://github.com/Pablito2020/Tetris/commit/24fc9637eff606ed7c036878536356e7f3c9acc6))
* **game:** add getGrid() method ([db481d8](https://github.com/Pablito2020/Tetris/commit/db481d85cc9efb9396e40eda42858f40dc42c25e))
* **game:** add has finished check method ([f93bd69](https://github.com/Pablito2020/Tetris/commit/f93bd690ca3f5ded30ce112fb95112e8e2b5a9bb))
* **game:** add move block to any direction ([f49440d](https://github.com/Pablito2020/Tetris/commit/f49440d09d24970420caef1699c3ee6d6029c2b1))
* **game:** add move down next check ([a1244be](https://github.com/Pablito2020/Tetris/commit/a1244be5bc5a11c75c33f01932086b1b1ea4974c))
* **game:** add rotation collision ([838a242](https://github.com/Pablito2020/Tetris/commit/838a242753e87c035484799a37c4f88cb0c8530e))
* **game:** add score system ([4b3ec1b](https://github.com/Pablito2020/Tetris/commit/4b3ec1b1a785eef2075e2d971f9510beefec9a44))
* **game:** add write block ([46b4c93](https://github.com/Pablito2020/Tetris/commit/46b4c939c49a4711815f837049db33fea0ef7b22))
* **iblock:** add y axis positions ([9e4e259](https://github.com/Pablito2020/Tetris/commit/9e4e259a8096700f93900314fe299ae488d3110a))
* **iblock:** implement double rotation ([43cbcf6](https://github.com/Pablito2020/Tetris/commit/43cbcf6e86aafa77494e60c10b991f5f71393119))
* **iblock:** implement initial position ([e774594](https://github.com/Pablito2020/Tetris/commit/e774594ac9257e479d54697e9fa76838cf920cb4))
* **iblock:** implement move ([d95237d](https://github.com/Pablito2020/Tetris/commit/d95237d0e47da12d89d0be5b2d0069ffcbc7e298))
* **iblock:** implement rotation to left ([75829b7](https://github.com/Pablito2020/Tetris/commit/75829b79b42d5866898bb855f09eafaaac5e3fef))
* **iblock:** implement simple left rotation ([aab8748](https://github.com/Pablito2020/Tetris/commit/aab8748ba8bf9097a6248cfa01a93e6fb2431a90))
* **iblock:** implement x axes movement ([f807881](https://github.com/Pablito2020/Tetris/commit/f807881f4e2e34e0d4cdf407200d5c31fc8ab900))
* **jblock:** implement double rotation ([082597c](https://github.com/Pablito2020/Tetris/commit/082597c591c2dc1217c9af06f4115089879d6e98))
* **jblock:** implement first state ([c2635cc](https://github.com/Pablito2020/Tetris/commit/c2635cc88e934d0e90eca2375df8cdd65d850878))
* **jblock:** implement simple movement ([a7916a9](https://github.com/Pablito2020/Tetris/commit/a7916a933684e85eff2ad4e9f679bd19fbb00085))
* **jblock:** implement simple rotation ([27431df](https://github.com/Pablito2020/Tetris/commit/27431dfde56a7ea68136bec8bb179595c1450488))
* **lblock:** implement double rotation ([8cc4ea3](https://github.com/Pablito2020/Tetris/commit/8cc4ea3f8a5e98f00b197bd3d49e5fad5e463f7c))
* **lblock:** implement simple movement ([b5c7ea9](https://github.com/Pablito2020/Tetris/commit/b5c7ea9d6c7ae386184d269d4029e7cf9421843a))
* **lblock:** implement simple rotation ([5105eb2](https://github.com/Pablito2020/Tetris/commit/5105eb271eecb6aa2a920c9fe1df1464455f2eb5))
* **lblock:** initialize position ([3897c44](https://github.com/Pablito2020/Tetris/commit/3897c44a6ce8eb9c4f2c0b49326ecd73837f9a96))
* **position:** implement addAxes ([cf143ed](https://github.com/Pablito2020/Tetris/commit/cf143ed23c15cace58c84d883fdfff1e08232fd2))
* **position:** implement move ([6259920](https://github.com/Pablito2020/Tetris/commit/625992034aa65c28694088f4babc0ed17ceb4bc3))
* **sblock:** implement Double Rotation ([44e6797](https://github.com/Pablito2020/Tetris/commit/44e6797d2066c3699ee89c2b80b719202c05ea03))
* **sblock:** implement movement ([ff6d73d](https://github.com/Pablito2020/Tetris/commit/ff6d73d9e5c0d58ae8b10d5bcd2648e1b11f3c9c))
* **sblock:** implemented first status ([a84ef86](https://github.com/Pablito2020/Tetris/commit/a84ef86c3217ff472c73d83cb9886e19827e6542))
* **sblock:** simple rotation ([e370a69](https://github.com/Pablito2020/Tetris/commit/e370a691a9f95678d8af7eccfff7b36c5a7eee8c))
* **score:** implement simple score calculator ([269789f](https://github.com/Pablito2020/Tetris/commit/269789fe3481f6b78b50b6aefd530c09b1c69f4e))
* **squareblock:** implement initial positions ([0bbcef9](https://github.com/Pablito2020/Tetris/commit/0bbcef9b896206a8cf7f74dae56155abb204616d))
* **squareblock:** implement move ([d6463ff](https://github.com/Pablito2020/Tetris/commit/d6463ffc5056f5362678b69ba9bbc7e910908ff4))
* **squareblock:** rotation ([f5ecc4c](https://github.com/Pablito2020/Tetris/commit/f5ecc4c4debab22d9edeae45752a6c99836ec70b))
* **tblock:** implement double rotation ([0fdc80a](https://github.com/Pablito2020/Tetris/commit/0fdc80a0d6f1254fff22b8ff82de9cf6c06a1615))
* **tblock:** implement initial position ([5d80824](https://github.com/Pablito2020/Tetris/commit/5d80824d6a586f84c46b4e7660fbc572b1fc5afd))
* **tblock:** implement movement ([d1a49fd](https://github.com/Pablito2020/Tetris/commit/d1a49fde562a2c41dcd76c8f568d17ad6856849a))
* **tblock:** implement simple rotation ([c19b9ba](https://github.com/Pablito2020/Tetris/commit/c19b9ba5eea1ca0f48037f6df75bdc535422e4ba))
* **zblock:** double rotation ([0595d62](https://github.com/Pablito2020/Tetris/commit/0595d62e99e6806f4ac904e7a6c6334b02b0fa21))
* **zblock:** implement move ([7cf3a13](https://github.com/Pablito2020/Tetris/commit/7cf3a13c4c7ba5b5d840710181e4e1057671d5f5))
* **zblock:** initial position ([84828e5](https://github.com/Pablito2020/Tetris/commit/84828e5bf05cdaec9ad961b10704a98fcac4919e))
* **zblock:** simple rotation ([7aabcb7](https://github.com/Pablito2020/Tetris/commit/7aabcb7873ef74f2ad1cabd488b802937827a472))


### Bug Fixes

* **lblock:** initial position test cases ([da9dd32](https://github.com/Pablito2020/Tetris/commit/da9dd327aefdeb21a5c42c895f968a62328984e4))
* **position:** test with columns and rows ([116cefb](https://github.com/Pablito2020/Tetris/commit/116cefbc633c592a37920c77b3aed46b648bb2ad))
* **random_factory:** references to blocks ([895dc8b](https://github.com/Pablito2020/Tetris/commit/895dc8ba92de458e53317ffb709313d54ba7acce))
