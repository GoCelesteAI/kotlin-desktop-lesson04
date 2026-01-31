import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(title: String, onBack: (() -> Unit)? = null) {
  Surface(color = DarkSurface) {
    Row(
      modifier = Modifier.fillMaxWidth().height(56.dp).padding(horizontal = 8.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      if (onBack != null) {
        IconButton(onClick = onBack) {
          Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", tint = Purple80)
        }
      } else {
        Spacer(modifier = Modifier.width(48.dp))
      }
      Text(title, fontSize = 20.sp, color = Purple80)
    }
  }
}
