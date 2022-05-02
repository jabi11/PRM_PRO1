package pl.edu.pjatk.pro1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var mainFragment: MainScreenFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainFragment = MainScreenFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, mainFragment, mainFragment.javaClass.name)
            .commit()
    }
}