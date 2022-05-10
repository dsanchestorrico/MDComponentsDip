package com.mdcomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.mdcomponents.adapter.ComponentAdapter
import com.mdcomponents.adapter.OnClickListener
import com.mdcomponents.entity.Component
import com.mdcomponents.fragments.ButtonFragment
import com.mdcomponents.fragments.SnackBarFragment
import com.mdcomponents.utils.Constants

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ComponentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        configAdapter()
        configRecyclerView()
    }

    private fun configAdapter() {
        adapter = ComponentAdapter()
        adapter.add(ButtonFragment.getmInstance())
        adapter.add(SnackBarFragment.getmInstance())
        adapter.setOnItemClickListener(this)

        /**
         * 2da Opcion: de creacion de onclicklistener
         * */
        //adapter.setOnItemClickListener(onClickListener)
    }

    /**
     * 2da Opcion : creamos el onclick de nuestra interfaz OnClickListener
     * */
    var onClickListener = object: OnClickListener{
        override fun onClick(component: Component) {
        }
    }

    private fun configRecyclerView() {
        recyclerView.adapter = adapter
    }

    override fun onClick(component: Component) {
        var intent: Intent
        if(component.type == Constants.SCROLL) {
            intent = Intent(this, ScrollingActivity::class.java)
        } else {
            intent = Intent(this, StaticActivity::class.java)
        }
        intent.putExtra(Constants.ARG_NAME, component.name)
        startActivity(intent)
    }

}