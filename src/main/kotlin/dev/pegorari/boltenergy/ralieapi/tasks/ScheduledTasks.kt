package dev.pegorari.boltenergy.ralieapi.tasks

import dev.pegorari.boltenergy.ralieapi.service.UsinaService
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.net.URL

@Component
class ScheduledTasks(
    private val usinaService: UsinaService
) {
    @Value("\${usina.import.url}")
    private lateinit var csvUrlString: String

    @Scheduled(cron = "\${usina.schedule.cron}")
    fun onTime() {
        usinaService.importFromCsv(URL(csvUrlString))
    }
}