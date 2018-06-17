package codelab.android.library.fragmentmanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import codelab.android.library.fragmentmanagerlib.FragmentCoordinator

class KotlinMainActivity : AppCompatActivity() {
    val coordinator = FragmentCoordinator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_activity_main)
    }

    override fun onStart() {
        super.onStart()
        updateFragment()
    }

    private fun updateFragment() {
        val kotlinFragment = KotlinSampleFragment.instance()
        coordinator.replace(KotlinMainActivity::javaClass.name, R.id.container_layout, kotlinFragment,
                supportFragmentManager)
    }
}
