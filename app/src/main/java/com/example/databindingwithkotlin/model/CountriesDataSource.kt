package com.example.databindingwithkotlin.model

class CountriesDataSource(){

    lateinit var countries:ArrayList<Countries>

    constructor(items:ArrayList<Countries>):this(){

    }

    fun getAllCountries():ArrayList<Countries>{
        countries =  arrayListOf<Countries>()
        this.countries.add(Countries("India","New Delhi"))
        this.countries.add(Countries("United States of America","New York"))

        this.countries.add(Countries("England","London"))

        this.countries.add(Countries("Canada","Ottawa"))

        this.countries.add(Countries("France","Parris"))

        this.countries.add(Countries("Srilanka","Colombo"))

        this.countries.add(Countries("Pakistan","Islamabad"))

        this.countries.add(Countries("Russia","Masco"))

        this.countries.add(Countries("Bangladesh","Dhaka"))

        this.countries.add(Countries("Italy","Rome"))

        this.countries.add(Countries("Bhutan","Thimpu"))

        return countries;


    }

}