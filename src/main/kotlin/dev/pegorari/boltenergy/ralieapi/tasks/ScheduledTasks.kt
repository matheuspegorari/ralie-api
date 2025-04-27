package dev.pegorari.boltenergy.ralieapi.tasks

import dev.pegorari.boltenergy.ralieapi.service.UsinaService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.net.URL

const val CSV_URL = "https://dadosabertos.aneel.gov.br/datastore/dump/4a615df8-4c25-48fa-bbea-873a36a79518?bom=True"

@Component
class ScheduledTasks(
    private val usinaService: UsinaService
) {
    @Scheduled(cron = "0 0 1 * * ?") // Roda todos os dias às 01:00 am
    fun onTime() {
        usinaService.importFromCsv(URL(CSV_URL))
    }
}