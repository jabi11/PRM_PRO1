package pl.edu.pjatk.pro1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Navigable {
    private lateinit var mainFragment: MainScreenFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainFragment = MainScreenFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, mainFragment, mainFragment.javaClass.name)
            .commit()
    }

    override fun navigate(to: Navigable.Destination) {
        supportFragmentManager.beginTransaction().apply {
            when (to) {
                Navigable.Destination.List -> replace(R.id.container, mainFragment, mainFragment.javaClass.name)
                Navigable.Destination.Add -> {
                    replace(R.id.container, AddEditScreenFragment(), AddEditScreenFragment::class.java.name)
                    addToBackStack(AddEditScreenFragment::class.java.name)
                }
                Navigable.Destination.Detail -> {
                    replace(R.id.container, TaskDetailFragment(), TaskDetailFragment::class.java.name)
                    addToBackStack(TaskDetailFragment::class.java.name)
                }
            }
        }.commit()
    }
}