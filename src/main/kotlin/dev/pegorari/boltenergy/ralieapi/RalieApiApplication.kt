package dev.pegorari.boltenergy.ralieapi

import dev.pegorari.boltenergy.ralieapi.repository.UsinaRepository
import dev.pegorari.boltenergy.ralieapi.service.UsinaService
import dev.pegorari.boltenergy.ralieapi.tasks.CSV_URL
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import java.net.URL

@SpringBootApplication
@EnableScheduling
class RalieApiApplication(
    private val usinaService: UsinaService
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        usinaService.importFromCsv(URL(CSV_URL))
    }
}

fun main(args: Array<String>) {
    runApplication<RalieApiApplication>(*args)
}
