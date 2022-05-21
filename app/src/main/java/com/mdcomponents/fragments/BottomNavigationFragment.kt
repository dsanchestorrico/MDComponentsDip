package com.mdcomponents.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mdcomponents.R
import com.mdcomponents.entity.Component
import com.mdcomponents.utils.Constants

class BottomNavigationFragment : Fragment() {

    companion object {
        var TAG = "BottomNavigation"

        fun getmInstance(): Component {
            return Component(TAG, R.drawable.img_bottomnav_mobile_portrait, Constants.STATIC)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_bottom_navigation, container, false)
    }

}