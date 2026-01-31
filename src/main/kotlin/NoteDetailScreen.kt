import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteDetailScreen(note: Note, onBack: () -> Unit) {
  Column(modifier = Modifier.fillMaxSize()) {
    TopBar(title = note.title, onBack = onBack)
    Column(
      modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(16.dp)
    ) {
      Text(note.date, fontSize = 14.sp, color = PurpleGrey40)
      Spacer(modifier = Modifier.height(12.dp))
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = DarkSurface)
      ) {
        Text(
          note.body,
          fontSize = 16.sp,
          color = PurpleGrey80,
          modifier = Modifier.padding(16.dp)
        )
      }
    }
  }
}
