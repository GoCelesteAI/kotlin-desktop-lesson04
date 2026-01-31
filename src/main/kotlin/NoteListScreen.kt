import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NoteListScreen(notes: List<Note>, onNoteClick: (Int) -> Unit) {
  Column(modifier = Modifier.fillMaxSize()) {
    TopBar(title = "My Notes")
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(vertical = 8.dp)
    ) {
      items(notes) { note ->
        NoteItem(note = note, onClick = { onNoteClick(note.id) })
      }
    }
  }
}
