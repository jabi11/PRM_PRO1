package pl.edu.pjatk.pro1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.edu.pjatk.pro1.databinding.FragmentAddEditScreenBinding
import pl.edu.pjatk.pro1.databinding.FragmentMainScreenBinding


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

}