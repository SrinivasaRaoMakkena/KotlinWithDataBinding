package com.example.databindingwithkotlin.activities


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.databindingwithkotlin.databinding.ActivityMainBinding
import android.arch.lifecycle.ViewModelProviders
import com.example.databindingwithkotlin.CountriesCapitalsViewModel
import com.example.databindingwithkotlin.R


class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CountriesCapitalsViewModel
    var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity,
            R.layout.activity_main
        )

        viewModel = ViewModelProviders.of(this).get(CountriesCapitalsViewModel::class.java)
        //toolbar = binding.toolbar
        binding.viewModel = viewModel
        //setUpToolBar(toolbar!!,MainActivity@this)

    }
}
