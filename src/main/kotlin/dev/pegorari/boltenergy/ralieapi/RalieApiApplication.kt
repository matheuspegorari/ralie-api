package dev.pegorari.boltenergy.ralieapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RalieApiApplication

fun main(args: Array<String>) {
    runApplication<RalieApiApplication>(*args)
}
