# FashionStore

## Overview – Clean Architecture (MVVM)

```text
FashionOrderApp/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/fashionorderapp/
│           │   ├── base/                        # Base class (shared)
│           │   │   ├── BaseActivity.java
│           │   │   └── BaseViewModel.java
│           │   │
│           │   ├── data/                        # Data layer
│           │   │   ├── local/                   # SQLite (Room)
│           │   │   │   ├── dao/
│           │   │   │   │   └── UserDao.java
│           │   │   │   ├── entity/
│           │   │   │   │   └── UserEntity.java
│           │   │   │   └── AppDatabase.java
│           │   │   │
│           │   │   ├── remote/                  # Firebase / REST API
│           │   │   │   └── firebase/
│           │   │   │       ├── FirebaseAuthHelper.java
│           │   │   │       └── FirebaseUserMapper.java
│           │   │   │
│           │   │   └── repository/
│           │   │       └── user/
│           │   │           └── UserRepositoryImpl.java
│           │   │
│           │   ├── domain/                      # Domain layer
│           │   │   ├── model/
│           │   │   │   └── User.java
│           │   │   ├── repository/
│           │   │   │   └── IUserRepository.java
│           │   │   └── usecase/
│           │   │       ├── LoginUseCase.java
│           │   │       └── RegisterUseCase.java
│           │   │
│           │   ├── ui/                          # UI layer
│           │   │   ├── login/
│           │   │   │   ├── LoginActivity.java
│           │   │   │   └── LoginViewModel.java
│           │   │   ├── register/
│           │   │   │   ├── RegisterActivity.java
│           │   │   │   └── RegisterViewModel.java
│           │   │   ├── forgot/
│           │   │   │   ├── ForgotPasswordActivity.java
│           │   │   │   └── ForgotPasswordViewModel.java
│           │   │   └── main/
│           │   │       └── MainActivity.java
│           │   │
│           │   ├── utils/                       # Utilities
│           │   │   ├── SharedPrefManager.java
│           │   │   ├── Constants.java
│           │   │   └── Validator.java
│           │   │
│           │   └── MyApplication.java           # Custom Application class (Firebase init)
│           │
│           └── res/                             # Resources
│               ├── layout/
│               │   ├── activity_login.xml
│               │   ├── activity_register.xml
│               │   ├── activity_forgot_password.xml
│               │   └── activity_main.xml
│               └── values/
│                   ├── colors.xml
│                   ├── strings.xml
│                   └── themes.xml
│
├── build.gradle (Module: app)
└── build.gradle (Project)
