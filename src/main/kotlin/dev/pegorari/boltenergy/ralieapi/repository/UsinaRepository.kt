package dev.pegorari.boltenergy.ralieapi.repository

import dev.pegorari.boltenergy.ralieapi.model.Usina
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsinaRepository : JpaRepository<Usina, String> {
    fun findTop5ByOrderByPotenciaOutorgadaKw(): List<Usina>
}
