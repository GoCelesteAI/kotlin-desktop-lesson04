# Notes App — Kotlin Desktop Lesson 04

A Compose Desktop notes app demonstrating scrollable lists and screen navigation.

![Kotlin](https://img.shields.io/badge/Kotlin-2.1-7F52FF?logo=kotlin&logoColor=white)
![Compose](https://img.shields.io/badge/Compose_Multiplatform-1.7.3-4285F4)
![Material3](https://img.shields.io/badge/Material3-Desktop-10b981)

## What This Covers

- **LazyColumn** with `items()` DSL for efficient scrollable lists
- **Card(onClick)** for clickable list items
- **Sealed class** for type-safe navigation (`Screen.List`, `Screen.Detail`)
- **When expression** for state-driven screen routing
- **State hoisting** — parent owns `currentScreen`, children fire callbacks
- **verticalScroll** with `rememberScrollState()` for scrollable detail content
- **Reusable TopBar** composable with optional back button

## Project Structure

```
src/main/kotlin/
  Colors.kt             # Purple color palette
  Note.kt               # Data class + sampleNotes() generator
  Screen.kt             # Sealed class: Screen.List, Screen.Detail(noteId)
  NoteItem.kt           # Clickable Card with title, date, body preview
  NoteListScreen.kt     # LazyColumn rendering NoteItem for each note
  TopBar.kt             # Reusable top bar with optional back arrow
  NoteDetailScreen.kt   # Full note view with scrollable body
  Main.kt               # Owns currentScreen state, when expression routes screens
```

8 files, ~190 lines total. Every file is under 40 lines.

## Run

```bash
./gradlew run
```

Requires JDK 17+.

## Screenshots

**List Screen** — 20 notes in a scrollable LazyColumn:

The list screen shows each note as a Card with title, date, and a one-line body preview using `TextOverflow.Ellipsis`.

**Detail Screen** — Full note with back navigation:

Clicking a note navigates to a detail screen. The TopBar shows a back arrow that returns to the list. Navigation is driven by a single `currentScreen` state variable.

## Key Code

```kotlin
// Screen.kt — sealed class for type-safe navigation
sealed class Screen {
    object List : Screen()
    data class Detail(val noteId: Int) : Screen()
}

// Main.kt — when expression routes screens
when (val screen = currentScreen.value) {
    is Screen.List -> NoteListScreen(
        notes = notes,
        onNoteClick = { id -> currentScreen.value = Screen.Detail(id) }
    )
    is Screen.Detail -> NoteDetailScreen(
        note = notes.first { it.id == screen.noteId },
        onBack = { currentScreen.value = Screen.List }
    )
}
```

## Tech Stack

| Tool | Version |
|------|---------|
| Kotlin | 2.1 |
| Compose Multiplatform | 1.7.3 |
| Material3 | Desktop |
| Gradle | 8.10 |
| JDK | 17+ |

## Series

This is **Lesson 04** in the Kotlin Desktop series:

- Lesson 01: Hello Window
- Lesson 02: Styling & Layout
- Lesson 03: State & Input
- **Lesson 04: Lists & Navigation** (this repo)
- Lesson 05: Theming & Dark Mode (coming soon)
