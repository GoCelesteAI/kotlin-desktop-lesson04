sealed class Screen {
  object List : Screen()
  data class Detail(val noteId: Int) : Screen()
}
