package dev.pegorari.boltenergy.ralieapi.controller

import dev.pegorari.boltenergy.ralieapi.model.Usina
import dev.pegorari.boltenergy.ralieapi.service.UsinaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/usinas")
class UsinaController(private val usinaService: UsinaService) {

    @GetMapping("/top")
    fun getTopUsinas(): List<Usina> {
        return usinaService.getTopUsinas()
    }
}