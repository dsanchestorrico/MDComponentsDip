package com.mdcomponents.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mdcomponents.R
import com.mdcomponents.entity.Component
import com.mdcomponents.utils.Constants

class SnackBarFragment : Fragment() {

    companion object {
        var TAG = "SnackBar"

        fun getmInstance(): Component {
            return Component(SnackBarFragment.TAG, R.drawable.img_singleline_action, Constants.STATIC)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_snack_bar, container, false)
    }
}