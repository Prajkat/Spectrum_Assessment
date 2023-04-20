package com.example.assesmentapplication.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assesmentapplication.R

/**
 * Reference for generics: https://kotlinlang.org/docs/reference/generics.html
 * Basically BaseActivity will take any class that extends BaseViewModel
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

}