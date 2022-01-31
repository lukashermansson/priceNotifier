package me.lukashermansson.pricenotifier

import java.text.NumberFormat
import java.util.*

data class Price(val amount : Int) {
    operator fun compareTo(currentHiestPrice: Price): Int {
        return this.amount.compareTo( currentHiestPrice.amount)
    }


    override fun toString(): String {
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = Currency.getInstance("SEK")
        return format.format(amount)
    }
}