package com.mdcomponents.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
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
        var view = inflater.inflate(R.layout.fragment_snack_bar, container, false)

        var container = view.findViewById<FrameLayout>(R.id.container)

        Snackbar.make(container, "Evento ocurrido con exito!!!", Snackbar.LENGTH_LONG)
            .setAction("Volver", View.OnClickListener { view1: View? -> requireActivity().finish() })
            .show()

        return view
    }
}