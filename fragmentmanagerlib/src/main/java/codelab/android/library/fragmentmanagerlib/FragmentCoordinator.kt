package codelab.android.library.fragmentmanagerlib

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class FragmentCoordinator {

    /**
     * Change fragment in layout container
     * @param tag                       Tag of fragment in fragment manager
     * @param containerId               Layout container for fragment
     * @param fragment                  Fragment for insert
     * @param fragmentManager           Fragment manager for change fragment
     * @param type                      Direct of animation
     * @param animationStart            Resource id for animation on start
     * @param animationEnd              Resource id for animation on end
     * */
    fun replaceFragment(tag: String, containerId: Int, fragment: Fragment, fragmentManager: FragmentManager,
                        animationStart: Int, animationEnd: Int, animationType: AnimationType = AnimationType.FORWARD) {
        val transaction = fragmentManager.beginTransaction()

        if (animationStart != -1 && animationEnd != -1) {
            if (animationType == AnimationType.FORWARD) transaction.setCustomAnimations(animationStart, animationEnd)
            else transaction.setCustomAnimations(animationStart, animationEnd)
        }

        transaction.replace(containerId, fragment, tag).commit()
    }

    /**
     * Find fragment by tag in fragment manager
     * @param tag                       Tag of fragment inside fragment manager
     * @param fragmentManager           Source fragment manager
     * @return                          Fragment from fragment manager
     * */
    fun fragment(tag: String, fragmentManager: FragmentManager)= fragmentManager.findFragmentByTag(tag)

    /**
     * Find fragment by tag in fragment manager
     * @param containerId               Layout container of fragment inside fragment manager
     * @param fragmentManager           Source fragment manager
     * @return                          Fragment from fragment manager
     * */
    fun fragment(containerId: Int, fragmentManager: FragmentManager)= fragmentManager.findFragmentById(containerId)
}