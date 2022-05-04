package pl.edu.pjatk.pro1

import java.time.LocalDate

object DataSource {
    val selectedTask: ToDoTask? = null;
    val tasks = mutableListOf<ToDoTask>(
        ToDoTask("zjesc obiad", 1, 0.0, LocalDate.parse("2022-05-02")),
        ToDoTask("wyjsc z domu", 2, 0.5, LocalDate.parse("2022-05-02"))
    )
}