package pl.edu.pjatk.pro1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import pl.edu.pjatk.pro1.databinding.FragmentTaskDetailBinding

class TaskDetailFragment : Fragment() {

    private lateinit var binding: FragmentTaskDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentTaskDetailBinding.inflate(inflater, container, false).also { fragmentTaskDetailBinding ->
            binding = fragmentTaskDetailBinding
            val selected: ToDoTask = DataSource.tasks.first { it.id.equals(DataSource.selectedTaskId) }
            binding.taskLabel.text = selected.name
            binding.DeadlineLabel.text = selected.deadline.toString()
            binding.PriorityLabel.text = selected.priority.toString()
            binding.ProgressTextField.setText(selected.progress.toString())
            binding.editButton.setOnClickListener {
                DataSource.edit = true
                (activity as? Navigable)?.navigate(Navigable.Destination.Add)
            }
        }.root
    }

}