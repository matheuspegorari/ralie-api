package dev.pegorari.boltenergy.ralieapi.tasks

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledTasks {

    @Scheduled(cron = "0 * * * * *") // Roda a cada minuto
    fun onTime() {
        println("@@ Executing...")
    }
}