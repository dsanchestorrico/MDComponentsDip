package com.mdcomponents.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mdcomponents.R
import com.mdcomponents.entity.Component
import com.mdcomponents.utils.Constants

class TextFieldFragment : Fragment() {

    companion object {
        var TAG = "TextField"

        fun getmInstance(): Component {
            return Component(TAG, R.drawable.img_textfields_outlined_active, Constants.SCROLL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_text_field, container, false)

        var etPrice = view.findViewById<TextInputEditText>(R.id.etPrice)
        etPrice.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString().isNotEmpty() && Integer.parseInt(p0.toString()) < 5) {
                    etPrice.setError("El valor deber mayor que 5")
                }
            }
        })

        var etCapital = view.findViewById<TextInputEditText>(R.id.etCapital)

        var tilCapital = view.findViewById<TextInputLayout>(R.id.tilCapital)
        tilCapital.setEndIconOnClickListener{ view ->
             if(etCapital.text != null) {
                 var contentString = etCapital.text.toString()
                 etCapital.setText(contentString.toUpperCase())
             }
        }

        return view
    }

}