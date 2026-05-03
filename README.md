# Nimma-Guru (Android)

Nimma-Guru is a community mentorship Android app that connects retired professionals (Gurus) with students for local learning support.

## Features
- Firebase Email/Password Authentication
- Guru profile management (skills, availability, location, bio)
- Search Gurus by skill and location
- Class calendar list (sessions)
- Wall of appreciation
- Kannada + English app naming support

## Tech Stack
- Kotlin + MVVM
- AndroidX Navigation, LiveData, ViewModel
- Material Design 3 UI
- Firebase Auth + Firestore

## Installation (Android Studio)
1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   cd Nimmaguru
   ```
2. Open project in Android Studio (open root folder containing `settings.gradle`).
3. Add Firebase config file:
   - Download `google-services.json` from Firebase Console
   - Place it at: `app/google-services.json`
4. In Firebase Console enable:
   - **Authentication** -> Email/Password
   - **Firestore Database**
5. Sync Gradle and run app.

## Build
```bash
./gradlew :app:assembleDebug
```

## Notes
- If lists look empty initially, add records to Firestore collections:
  - `users`
  - `gurus`
  - `sessions`
  - `appreciations`
- UI was redesigned using XML/resources only, without changing app logic or backend integration.
