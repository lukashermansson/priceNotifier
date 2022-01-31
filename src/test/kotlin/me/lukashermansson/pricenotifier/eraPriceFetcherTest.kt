package me.lukashermansson.pricenotifier

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class eraPriceFetcherTest {

    @Test
    fun e() {
        val eraPriceFetcher = eraPriceFetcher()

        eraPriceFetcher.getLatestPrice()
    }
}