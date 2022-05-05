package pl.edu.pjatk.pro1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.pjatk.pro1.databinding.FragmentMainScreenBinding
import java.time.DayOfWeek
import java.time.LocalDate

class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private lateinit var adapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentMainScreenBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TasksAdapter(activity, binding).apply {
            replace(DataSource.tasks)
        }

        (activity as MainActivity).adapter = adapter

        binding.taskList.let {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(requireContext())
        }

        binding.addBtn.setOnClickListener {
            DataSource.edit = false
            (activity as? Navigable)?.navigate(Navigable.Destination.Add)
        }

    }

}