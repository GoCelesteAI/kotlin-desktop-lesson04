import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun App() {
  val notes = remember { sampleNotes() }
  val currentScreen = remember { mutableStateOf<Screen>(Screen.List) }

  MaterialTheme(colorScheme = darkColorScheme()) {
    Surface(
      modifier = Modifier.fillMaxSize(),
      color = DarkBackground
    ) {
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
    }
  }
}

fun main() = application {
  Window(
    onCloseRequest = ::exitApplication,
    title = "Notes App"
  ) {
    App()
  }
}
