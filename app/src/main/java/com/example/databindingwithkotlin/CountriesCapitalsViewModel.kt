package com.example.databindingwithkotlin

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.support.v7.widget.LinearLayoutManager
import com.example.databindingwithkotlin.model.Countries

class CountriesCapitalsViewModel(var app: Application) : AndroidViewModel(app) {
    val TAG = CountriesCapitalsViewModel::class.java.simpleName

    lateinit var countryAdapter:CountriesAdapter

    var listOfItems:ArrayList<Countries>


    init {
        listOfItems =  ArrayList<Countries>()
        countryAdapter = CountriesAdapter()
        countryAdapter.notifyDataSetChanged()
    }



    fun getLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(app)
    }

    fun getAdapters():CountriesAdapter{
        return countryAdapter
    }



}