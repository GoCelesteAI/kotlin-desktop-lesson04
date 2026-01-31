import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteItem(note: Note, onClick: () -> Unit) {
  Card(
    onClick = onClick,
    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = DarkSurface)
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Text(note.title, fontSize = 18.sp, color = Purple80)
        Text(note.date, fontSize = 12.sp, color = PurpleGrey40)
      }
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        note.body,
        fontSize = 14.sp,
        color = PurpleGrey80,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}
