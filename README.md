# FashionStore

### Overview Project Structure - Clean Architecture MVVM

FashionOrderApp/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/fashionorderapp/
│   │   │   │
│   │   │   │
│   │   │   ├── base/                        # Base class (dùng chung)
│   │   │   │   ├── BaseActivity.java
│   │   │   │   └── BaseViewModel.java
│   │   │   │
│   │   │   ├── data/                        # Tầng Data
│   │   │   │   ├── local/                   # SQLite (Room)
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   └── UserDao.java
│   │   │   │   │   ├── entity/
│   │   │   │   │   │   └── UserEntity.java
│   │   │   │   │   └── AppDatabase.java
│   │   │   │   │
│   │   │   │   ├── remote/                  # Firebase / API
│   │   │   │   │   └── firebase/
│   │   │   │   │       ├── FirebaseAuthHelper.java
│   │   │   │   │       └── FirebaseUserMapper.java
│   │   │   │   │
│   │   │   │   └── repository/              # Repository implementation
│   │   │   │       └── user/
│   │   │   │           └── UserRepositoryImpl.java
│   │   │   │
│   │   │   ├── domain/                      # Tầng Domain (Business Logic)
│   │   │   │   ├── model/
│   │   │   │   │   └── User.java
│   │   │   │   ├── repository/
│   │   │   │   │   └── IUserRepository.java
│   │   │   │   └── usecase/
│   │   │   │       ├── LoginUseCase.java
│   │   │   │       └── RegisterUseCase.java
│   │   │   │
│   │   │   ├── ui/                          # Giao diện (View + ViewModel)
│   │   │   │   ├── login/
│   │   │   │   │   ├── LoginActivity.java
│   │   │   │   │   └── LoginViewModel.java
│   │   │   │   ├── register/
│   │   │   │   │   ├── RegisterActivity.java
│   │   │   │   │   └── RegisterViewModel.java
│   │   │   │   ├── forgot/
│   │   │   │   │   ├── ForgotPasswordActivity.java
│   │   │   │   │   └── ForgotPasswordViewModel.java
│   │   │   │   └── main/
│   │   │   │       └── MainActivity.java
│   │   │   │
│   │   │   ├── utils/                       # Tiện ích phụ trợ
│   │   │   │   ├── SharedPrefManager.java
│   │   │   │   ├── Constants.java
│   │   │   │   └── Validator.java
│   │   │   │
│   │   │   └── MyApplication.java           # Custom Application class (Firebase init)
│   │   │
│   │   ├── res/                             # Tài nguyên giao diện
│   │   │   ├── layout/
│   │   │   │   ├── activity_login.xml
│   │   │   │   ├── activity_register.xml
│   │   │   │   ├── activity_forgot_password.xml
│   │   │   │   └── activity_main.xml
│   │   │   └── values/
│   │   │       ├── colors.xml
│   │   │       ├── strings.xml
│   │   │       └── themes.xml
│   │   │
│   │   └── AndroidManifest.xml
│
├── build.gradle (Module: app)
└── build.gradle (Project)

