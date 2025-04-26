package dev.pegorari.boltenergy.ralieapi.repository

import dev.pegorari.boltenergy.ralieapi.model.UnidadeGeradora
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UnidadeGeradoraRepository : JpaRepository<UnidadeGeradora, Long>
