# StockNow — Android Project Structure

## Setup Instructions

1. Create a new Android project in Android Studio:
   - Template: Empty Activity
   - Name: StockNow
   - Package: com.stocknow.app
   - Language: Kotlin
   - Min SDK: API 26 (Android 8.0)
   - Build configuration: Kotlin DSL (build.gradle.kts)

2. Replace all generated files with the files in this archive.

## File Map

```
app/
├── build.gradle.kts
└── src/main/
    ├── AndroidManifest.xml
    └── java/com/stocknow/app/
        ├── MainActivity.kt
        ├── ui/
        │   ├── theme/
        │   │   ├── Color.kt
        │   │   ├── Theme.kt
        │   │   └── Type.kt
        │   ├── navigation/
        │   │   └── NavGraph.kt
        │   ├── components/
        │   │   └── BottomNavBar.kt
        │   └── screens/
        │       ├── ParametresScreen.kt
        │       ├── HistoriqueScreen.kt
        │       ├── NotificationsScreen.kt
        │       ├── ExportationScreen.kt
        │       └── MouvementsScreen.kt
```
