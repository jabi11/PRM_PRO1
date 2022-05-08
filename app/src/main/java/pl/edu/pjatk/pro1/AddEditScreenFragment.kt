package pl.edu.pjatk.pro1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.edu.pjatk.pro1.databinding.FragmentAddEditScreenBinding
import java.time.LocalDate


class AddEditScreenFragment : Fragment() {

    private lateinit var binding: FragmentAddEditScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentAddEditScreenBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (DataSource.edit) {
            val selected: ToDoTask = DataSource.tasks.first { it.id == DataSource.selectedTaskId }
            binding.taskTextInput.setText(selected.name)
            binding.deadlineTextInput.setText(selected.deadline.toString())
            binding.progressTextInput.setText(selected.progress.toString())
            binding.priorityTextInput.setText(selected.priority.toString())
        }
        binding.btn.setOnClickListener {
            val maxId = DataSource.tasks.maxByOrNull { it.id }?.id
            if (maxId != null) {
                if(DataSource.edit) {
                    val selected: ToDoTask = DataSource.tasks.first { it.id == DataSource.selectedTaskId }
                    DataSource.tasks.remove(selected)
                    DataSource.tasks.add(ToDoTask(
                        selected.id,
                        binding.taskTextInput.text.toString(),
                        binding.priorityTextInput.text.toString().toInt(),
                        binding.progressTextInput.text.toString().toDouble(),
                        LocalDate.parse(binding.deadlineTextInput.text)
                    ))
                } else {
                    DataSource.tasks.add(ToDoTask(
                        maxId + 1,
                        binding.taskTextInput.text.toString(),
                        binding.priorityTextInput.text.toString().toInt(),
                        binding.progressTextInput.text.toString().toDouble(),
                        LocalDate.parse(binding.deadlineTextInput.text)
                    ))
                }
            }
            (activity as MainActivity).adapter.replace(DataSource.tasks)
            (activity as? Navigable)?.navigate(Navigable.Destination.List)
        }
    }

}