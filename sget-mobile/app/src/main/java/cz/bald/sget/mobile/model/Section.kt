package cz.bald.sget.mobile.model

data class Section(
    val number: Int,
    val text: String,
    val questionCount: Int,
    val maxPoints: Int,
    val questions: List<Question>
)
