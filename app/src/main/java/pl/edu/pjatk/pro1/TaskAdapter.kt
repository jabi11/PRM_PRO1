package pl.edu.pjatk.pro1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.edu.pjatk.pro1.databinding.FragmentMainScreenBinding
import pl.edu.pjatk.pro1.databinding.TodoItemBinding
import java.time.LocalDate

class TaskViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(task: ToDoTask) {
        binding.NameLabel.text = task.name
        binding.deadlineLabel.text = task.deadline.toString()
        binding.priorityLabel.text = task.priority.toString()
        binding.progressLabel.text = task.progress.toString() + "%"
    }
}

class TasksAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    private val data = mutableListOf<ToDoTask>()
    private var selectedPosition: Int = 0
    val selectedTask: ToDoTask
        get() = data[selectedPosition]
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TodoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TaskViewHolder(binding).also { vh ->
            binding.root.setOnClickListener {
                notifyItemChanged(selectedPosition)
                selectedPosition = vh.layoutPosition
                DataSource.selectedTaskId = data[selectedPosition].id
            }
        }
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun replace(newData: List<ToDoTask>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
}