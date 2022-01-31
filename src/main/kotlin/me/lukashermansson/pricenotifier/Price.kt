package me.lukashermansson.pricenotifier

data class Price(val amount : Int) {
    operator fun compareTo(currentHiestPrice: Price): Int {
        return this.amount.compareTo( currentHiestPrice.amount)
    }
}