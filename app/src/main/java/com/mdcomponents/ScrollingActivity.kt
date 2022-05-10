package com.mdcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mdcomponents.utils.CommonUtils
import com.mdcomponents.utils.Constants

class ScrollingActivity : AppCompatActivity() {

    lateinit var fab : FloatingActionButton
    lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        var nameFragment = intent.extras!!.getString(Constants.ARG_NAME, "")
        CommonUtils.setFragment(this, nameFragment, R.id.content_scroll)

        fab = findViewById(R.id.fab)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        actionBar!!.title = nameFragment
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}