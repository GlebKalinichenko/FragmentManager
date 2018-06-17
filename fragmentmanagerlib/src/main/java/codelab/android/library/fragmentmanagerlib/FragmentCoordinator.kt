package codelab.android.library.fragmentmanagerlib

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class FragmentCoordinator {

    /**
     * Change fragment in layout container.
     * @param tag                       Tag of fragment in fragment manager
     * @param containerId               Layout container for fragment
     * @param fragment                  Fragment for insert
     * @param fragmentManager           Fragment manager for change fragment
     * @param type                      Direct of animation
     * @param animationStart            Resource id for animation on start
     * @param animationEnd              Resource id for animation on end
     * */
    fun replace(tag: String, containerId: Int, fragment: Fragment, fragmentManager: FragmentManager,
            animationStart: Int, animationEnd: Int, animationType: AnimationType = AnimationType.FORWARD,
            backStackType: BackStackType = BackStackType.NONE) {
        val transaction = fragmentManager.beginTransaction()

        // check animation resource type
        if (animationStart != AnimationStatus.ANIMATION_NONE && animationEnd != AnimationStatus.ANIMATION_NONE) {
            if (animationType == AnimationType.FORWARD) transaction.setCustomAnimations(animationStart, animationEnd)
            if (animationType == AnimationType.BACK) transaction.setCustomAnimations(animationStart, animationEnd)
        }

        if (backStackType == BackStackType.NONE)
            transaction.replace(containerId, fragment, tag).commit()
        if (backStackType == BackStackType.ADD)
            transaction.replace(containerId, fragment, tag).addToBackStack(tag).commit()
    }

    /**
     * Change fragment in layout container with disabled animation between changing.
     * @param tag                       Tag of fragment in fragment manager
     * @param containerId               Layout container for fragment
     * @param fragment                  Fragment for insert
     * @param fragmentManager           Fragment manager for change fragment
     * @param backStackType             Is need add fragment to backstack
     * */
    fun replace(tag: String, containerId: Int, fragment: Fragment, fragmentManager: FragmentManager,
                backStackType: BackStackType){
        replace(tag, containerId, fragment, fragmentManager, AnimationStatus.ANIMATION_NONE, AnimationStatus.ANIMATION_NONE, AnimationType.NONE,
                backStackType)
    }

    /**
     * Change fragment in layout container with disabled animation between changing.
     * @param tag                       Tag of fragment in fragment manager
     * @param containerId               Layout container for fragment
     * @param fragment                  Fragment for insert
     * @param fragmentManager           Fragment manager for change fragment
     * */
    fun replace(tag: String, containerId: Int, fragment: Fragment, fragmentManager: FragmentManager){
        replace(tag, containerId, fragment, fragmentManager, AnimationStatus.ANIMATION_NONE, AnimationStatus.ANIMATION_NONE, AnimationType.NONE)
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