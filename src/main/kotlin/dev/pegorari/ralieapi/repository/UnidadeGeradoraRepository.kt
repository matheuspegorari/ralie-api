package dev.pegorari.ralieapi.repository

import dev.pegorari.ralieapi.model.UnidadeGeradora
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UnidadeGeradoraRepository : JpaRepository<UnidadeGeradora, Long>
