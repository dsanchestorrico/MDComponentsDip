package com.mdcomponents.utils

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mdcomponents.fragments.BottomNavigationFragment
import com.mdcomponents.fragments.ButtonFragment
import com.mdcomponents.fragments.SnackBarFragment
import com.mdcomponents.fragments.TextFieldFragment

class CommonUtils {

    companion object {

        fun setFragment(activity: AppCompatActivity, nameFragment: String, contentRes: Int) {
            var fragment = getFragmentById(nameFragment)
            activity.supportFragmentManager.beginTransaction()
                .add(contentRes, fragment)
                .commit()
        }

        fun getFragmentById(nameFragment: String): Fragment{
            var fragment: Fragment? = null
            when(nameFragment) {
                ButtonFragment.TAG -> {
                    fragment = ButtonFragment()
                }
                SnackBarFragment.TAG -> {
                    fragment = SnackBarFragment()
                }
                TextFieldFragment.TAG -> {
                    fragment = TextFieldFragment()
                }
                BottomNavigationFragment.TAG -> {
                    fragment = BottomNavigationFragment()
                }
            }
            return fragment!!
        }
    }

}