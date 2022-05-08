package pl.edu.pjatk.pro1

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import pl.edu.pjatk.pro1.databinding.FragmentMainScreenBinding
import pl.edu.pjatk.pro1.databinding.TodoItemBinding
import java.time.DayOfWeek
import java.time.LocalDate

class TaskViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(task: ToDoTask) {
        binding.NameLabel.text = task.name
        binding.deadlineLabel.text = task.deadline.toString()
        binding.priorityLabel.text = task.priority.toString()
        binding.progressLabel.text = task.progress.toString() + "%"
    }
}

class TasksAdapter(Activity: FragmentActivity?, val mainScreenBinding: FragmentMainScreenBinding) : RecyclerView.Adapter<TaskViewHolder>() {
    private var activity: FragmentActivity? = null;
    init {
        activity = Activity
    }
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
                (activity as? Navigable)?.navigate(Navigable.Destination.Detail)
            }
            binding.root.setOnLongClickListener{
                notifyItemChanged(selectedPosition)
                selectedPosition = vh.layoutPosition
                val newFragment = ConfirmDialogFragment(selectedTask, this)
                newFragment.show(activity!!.supportFragmentManager, "confirm")
                return@setOnLongClickListener true
            }
        }
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun replace(newData: List<ToDoTask>) {
        data.clear()
        val filteredData = newData.filter { it.deadline.isAfter(LocalDate.now()) || it.deadline == LocalDate.now()  }
        val now = LocalDate.now()
        val startOfWeek = now.with(DayOfWeek.MONDAY)
        Log.println(Log.INFO, null, startOfWeek.toString())
        val endOfWeek = startOfWeek.plusDays(6)
        Log.println(Log.INFO, null, endOfWeek.toString())
        val thisWeekTasks = filteredData.filter { (it.deadline.isAfter(startOfWeek) && it.deadline.isBefore(endOfWeek)) || it.deadline == endOfWeek }
        Log.println(Log.INFO, null, thisWeekTasks.toString())
        mainScreenBinding.tasksAmountLabel.text = thisWeekTasks.size.toString()
        data.addAll(filteredData)
        notifyDataSetChanged()
    }
}