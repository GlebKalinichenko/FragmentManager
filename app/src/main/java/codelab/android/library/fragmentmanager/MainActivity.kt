package codelab.android.library.fragmentmanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import codelab.android.library.fragmentmanagerlib.FragmentCoordinator

class MainActivity : AppCompatActivity() {
    val coordinator = FragmentCoordinator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        updateFragment()
    }

    private fun updateFragment() {
        val kotlinFragment = KotlinSampleFragment.instance()
        coordinator.replaceFragment(MainActivity::javaClass.name, R.id.container_layout, kotlinFragment,
                supportFragmentManager, -1, -1)
    }
}
