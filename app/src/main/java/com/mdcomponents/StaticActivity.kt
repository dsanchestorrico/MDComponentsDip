package com.mdcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.mdcomponents.utils.CommonUtils
import com.mdcomponents.utils.Constants

class StaticActivity : AppCompatActivity() {

    lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static)

        var nameFragment = intent.extras!!.getString(Constants.ARG_NAME, "")
        CommonUtils.setFragment(this, nameFragment, R.id.content_static)

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