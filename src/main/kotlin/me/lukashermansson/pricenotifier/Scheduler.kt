package me.lukashermansson.pricenotifier

import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import kotlin.properties.Delegates

@Component
class Scheduler(val priceFetcher: PriceFetcher, @Value("\${watcher.url:}")
val  url : String) {
    val subscribers: MutableList<(Price) -> Unit> = mutableListOf()
    var currentHiestPrice : Price by Delegates.observable(Price(0)) {  property, oldValue, newValue ->
        subscribers.forEach {
            it(newValue)
        }
    }


    @Scheduled(
        fixedDelay = 10000,
    )
    fun update() {

        val priceNow = priceFetcher.getLatestPrice(url)

        if(priceNow > currentHiestPrice) {
            currentHiestPrice = priceNow
        }
    }
}