package pl.edu.pjatk.pro1

import java.time.LocalDate

object DataSource {
    var edit = false
    var selectedTaskId: Int = 0
    val tasks = mutableListOf<ToDoTask>(
        ToDoTask(0, "zjesc obiad", 1, 0.0, LocalDate.parse("2022-05-02")),
        ToDoTask(1,"wyjsc z domu", 2, 0.5, LocalDate.parse("2022-05-02")),
        ToDoTask(2,"wyjsc na uczelnie", 2, 0.5, LocalDate.parse("2023-05-02"))
    )
}