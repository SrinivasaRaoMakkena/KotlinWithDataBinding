package com.example.databindingwithkotlin

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.databindingwithkotlin.model.Countries
import com.example.databindingwithkotlin.model.CountriesDataSource
import kotlinx.android.synthetic.main.item_country.view.*

class CountriesAdapter():RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    lateinit var items:ArrayList<Countries>

    init {
        items = ArrayList()

        items = CountriesDataSource().getAllCountries()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {

        val inflatedView = parent.inflate(R.layout.item_country, false)
        return CountriesHolder(inflatedView)

    }

    override fun getItemCount(): Int = this.items?.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is CountriesHolder) {
            var country:Countries = this.items[position]
            viewHolder.itemView.textview_country.text = country.countryName

            viewHolder.itemView.textview_capital.text = country.capitalName

            viewHolder.bindData(country)
        }


    }


    class CountriesHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        var country1:Countries? = null


        init {
            v.setOnClickListener(this)

        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICKED!")
            val context = itemView.context

            context.toast(country1!!.countryName)
            itemView.getActivity()?.showConfirmDialog("Do you want to select this country - ${country1!!.countryName}?","")
            /**
             * Intent to other intents  when clicked on item
             */

            //val intent = Intent(context, SecondActivity::class.java)
            //context.startActivity(intent)

        }

        fun bindData(country: Countries) {
            country1 = country
        }

        companion object {

            private val KEY = "PHOTO"
        }

    }

}