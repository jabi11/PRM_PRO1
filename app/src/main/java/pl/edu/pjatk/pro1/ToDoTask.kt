package pl.edu.pjatk.pro1

import java.time.LocalDate
import java.util.*

class ToDoTask(
    val name: String,
    val priority: Int,
    val progress: Float,
    val deadline: LocalDate
)