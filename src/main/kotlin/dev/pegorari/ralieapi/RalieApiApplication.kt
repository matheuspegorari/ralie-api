package dev.pegorari.ralieapi

import dev.pegorari.ralieapi.service.UsinaService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.support.CronExpression
import java.net.URL
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@SpringBootApplication
@EnableScheduling
class RalieApiApplication(
    private val usinaService: UsinaService
) : CommandLineRunner {
    private val log = LoggerFactory.getLogger(javaClass)

    @Value("\${usina.import.startup}")
    private val executeOnStartup: Boolean = true

    @Value("\${usina.import.url}")
    private lateinit var csvUrlString: String

    @Value("\${usina.schedule.cron}")
    private lateinit var cronExpression: String


    override fun run(vararg args: String?) {
        // Mostrar a próxima execução da Ação Agendada:
        val cronTrigger = CronExpression.parse(cronExpression)
        val next = cronTrigger.next(LocalDateTime.now())
        log.info("Próxima execução da Ação Agendada: " +
                "${next?.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))}")

        if (executeOnStartup) {
            usinaService.importFromCsv(URL(csvUrlString))
        }
    }
}

fun main(args: Array<String>) {
    runApplication<RalieApiApplication>(*args)
}
