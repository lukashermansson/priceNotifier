package me.lukashermansson.pricenotifier

interface PriceFetcher {


    fun  getLatestPrice(url: String) : Price
}