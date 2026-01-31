data class Note(
  val id: Int,
  val title: String,
  val body: String,
  val date: String
)

fun sampleNotes(): List<Note> = (1..20).map { i ->
  Note(
    id = i,
    title = "Note $i",
    body = "This is the body of note $i. It contains several sentences of text to demonstrate scrolling and detail views in our notes app.",
    date = "2025-01-${"%02d".format(i)}"
  )
}
