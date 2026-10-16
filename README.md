# ADT-notes

Приложение заметок на Kotlin и Jetpack Compose. Есть экраны входа, регистрации, создания заметки, списков заметок и профиля. Для внедрения зависимостей используется Koin, для запросов — Retrofit.

## Сборка и запуск

Откройте корень проекта в Android Studio, установите Android SDK 36 и выполните синхронизацию Gradle. Используйте JDK, совместимый с версией Android Gradle Plugin проекта; настройки Java указаны в `app/build.gradle.kts`. Минимальная версия устройства — Android API 27.

Для сборки отладочного APK:

```sh
sh gradlew :app:assembleDebug
```

В Windows: `gradlew.bat :app:assembleDebug`. APK появится в `app/build/outputs/apk/debug/`. Для запуска выберите модуль `app` и устройство или эмулятор в Android Studio.

## Устройство проекта

Для авторизации нужен совместимый сервер. Базовый URL настраивается в `app/src/main/java/com/example/adt_notes/data/di/DataModule.kt`. Код приложения разделён на `data`, `domain` и `presentation`.
