package pl.edu.pjatk.pro1

import java.time.LocalDate
import java.util.*

class ToDoTask(
    val id: Int,
    val name: String,
    val priority: Int,
    var progress: Double,
    val deadline: LocalDate
)