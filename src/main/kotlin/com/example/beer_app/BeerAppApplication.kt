package com.example.beer_app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BeerAppApplication

fun main(args: Array<String>) {
    runApplication<BeerAppApplication>(*args)
}
