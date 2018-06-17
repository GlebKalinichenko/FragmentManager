package codelab.android.library.fragmentmanager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class KotlinSampleFragment: Fragment() {

    companion object {
        fun instance() = KotlinSampleFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.kotlin_fragment, container, false)
        return view
    }
}