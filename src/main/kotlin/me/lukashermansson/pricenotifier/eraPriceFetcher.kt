package me.lukashermansson.pricenotifier

import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class eraPriceFetcher : PriceFetcher {
    override fun getLatestPrice(url: String): Price {
        Jsoup.connect(url).get().run {
            //2. Parses and scrapes the HTML response
            val first = select("table").first()
            val e = select("tbody").first()
            val r = e.select("tr").first()
            val first1 = r.select("td").first()
            val text = first1.text()

            return Price(text.removeSuffix("kr").trim(' ').filterNot { it.isWhitespace() }.toInt())
        }
    }
}