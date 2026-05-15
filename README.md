# Nimma-Guru (Android)

Nimma-Guru is a community mentorship Android application that connects students with experienced mentors (Gurus) for learning support, guidance, and educational interaction. The platform aims to create a bridge between learners and mentors through a simple and accessible mobile application.

---

# Problem Statement

Many students struggle to find personalized mentorship, career guidance, and local learning support. Existing platforms mainly focus on courses and content delivery but often lack direct mentor interaction and community support.

---

# Proposed Solution

Nimma-Guru acts as a digital mentorship platform where students can connect with experienced mentors for learning support and guidance.

The application provides:

- Student and mentor interaction
- User authentication
- Modern Material 3 UI
- Structured navigation flow
- Personalized learning support
- Firebase integration
- Responsive mobile experience

---

# Key Features

- Login and authentication system
- Mentor and student profile screens
- Material Design 3 based UI
- Firebase integration
- Navigation component support
- MVVM architecture implementation
- Interactive learning experience
- Responsive Android interface

---

# Technology Stack

| Layer | Technology | Purpose |
|---|---|---|
| Language | Kotlin | Main Android development language |
| IDE | Android Studio | Application development |
| UI Framework | Material Design 3 | Modern UI components |
| Architecture | MVVM | Separation of concerns |
| ViewModel | Android ViewModel | UI state handling |
| Backend | Firebase | Authentication and data handling |
| Navigation | Navigation Component | Screen transitions |
| Version Control | Git + GitHub | Source management |
| Build System | Gradle | Dependency management |

---

# Setup Instructions

## Requirements

### Software Requirements

- Android Studio Hedgehog or above
- JDK 17+
- Android SDK
- Git

### Hardware Requirements

- Minimum 8 GB RAM
- Android device or emulator
- Windows / Linux / macOS

---

## Open the Project

1. Open Android Studio  
2. Select **File → Open**  
3. Open the Nimma-Guru project folder  
4. Wait for Gradle Sync to finish  
5. Select emulator or connected device  
6. Click Run

---

# Build Commands

Build APK:

```bash
./gradlew assembleDebug
```

Install application:

```bash
./gradlew installDebug
```

---

# Folder Structure

```text
app/
├── src/main/
│   ├── java/
│   │   ├── ui/
│   │   ├── model/
│   │   ├── repository/
│   │   ├── viewmodel/
│   │   └── firebase/
│   │
│   └── res/
│       ├── drawable/
│       ├── layout/
│       └── values/

build.gradle
settings.gradle
README.md
```

---

# Important Files

| File | Purpose |
|---|---|
| MainActivity.kt | Main entry point of application |
| LoginScreen.kt | Handles login and authentication |
| ProfileScreen.kt | Displays mentor/student profile |
| ViewModel.kt | Manages application state |
| FirebaseConfig.kt | Firebase configuration |
| build.gradle | Dependency configuration |
| AndroidManifest.xml | Application metadata |

---

# System Architecture

```text
User
   ↓
UI Layer
   ↓
ViewModel
   ↓
Repository
   ↓
Firebase
```

---

# Data Model

### User Model

| Field | Type | Description |
|---|---|---|
| id | String | User ID |
| username | String | Username |
| email | String | User email |
| role | String | Student or Mentor |
| profileImage | String | Profile image path |

### Mentor Model

| Field | Type | Description |
|---|---|---|
| mentorId | String | Mentor identifier |
| mentorName | String | Mentor name |
| expertise | String | Domain expertise |
| experience | String | Experience details |

---

# Current Status

Implemented:

- Firebase integration
- Mentor and student UI
- Navigation flow
- Authentication
- Material 3 design
- MVVM structure
- Responsive screens

---

# Future Improvements

- Real-time chat support
- Video mentoring sessions
- Push notifications
- AI-based mentor recommendations
- Search and filtering
- Mentor scheduling system

---

# Submission Notes

Before uploading:

- Keep repository public
- Commit source code and README
- Avoid committing build/, .gradle/, .idea/
- Include screenshots and demo video if available

---
# Screenshots

| Home | Guru Profile | Appreciation |
|---|---|---|
| ![Home](screenshots/home.jpeg) | ![Guru Profile](screenshots/Guru_profile.png) | ![Appreciation](screenshots/appereciation.png) |

# Author

**Preethi C G**
**4SN22AI050**
