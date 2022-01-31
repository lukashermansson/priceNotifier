package me.lukashermansson.pricenotifier

import org.jsoup.Jsoup
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class EraSwedenPriceFetcher : PriceFetcher {
    override fun getLatestPrice(url: String): Price {
        Jsoup.connect(url).get().run {
            //2. Parses and scrapes the HTML response
            val relevantTable = select("table").first()
            val tableBody = relevantTable?.select("tbody")?.first()
            val latestEntry = tableBody?.select("tr")?.first()
            val prizeColumn = latestEntry?.select("td")?.first()
            val prizeText = prizeColumn?.text() ?: throw RuntimeException("Prize text")

            return Price(prizeText.removeSuffix("kr").trim(' ').filterNot { it.isWhitespace() }.toInt())
        }
    }
}