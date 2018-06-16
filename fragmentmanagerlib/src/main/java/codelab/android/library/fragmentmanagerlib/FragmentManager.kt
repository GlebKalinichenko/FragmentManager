package codelab.android.library.fragmentmanagerlib

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

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
        animationStart: Int, animationEnd: Int, animationType: AnimationType) {
    val translaction = fragmentManager.beginTransaction()

    if (animationType == AnimationType.FORWARD) translaction.setCustomAnimations(animationStart, animationEnd)
    else translaction.setCustomAnimations(animationStart, animationEnd)

    translaction.replace(containerId, fragment, tag).commit()
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