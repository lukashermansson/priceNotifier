package me.lukashermansson.pricenotifier

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
@EnableScheduling
class PriceNotifierApplication

fun main(args: Array<String>) {
    val builder = SpringApplicationBuilder(PriceNotifierApplication::class.java)
    builder.headless(false).run(*args)
}
