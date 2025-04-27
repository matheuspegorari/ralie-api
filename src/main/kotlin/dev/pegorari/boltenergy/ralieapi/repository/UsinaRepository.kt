package dev.pegorari.boltenergy.ralieapi.repository

import dev.pegorari.boltenergy.ralieapi.model.Usina
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UsinaRepository : JpaRepository<Usina, String> {
    @Query(value = """
        WITH top_plants AS (
            SELECT DISTINCT ON (cod_ceg) *
            FROM usina
            ORDER BY cod_ceg, potencia_outorgada_kw DESC
        )
        SELECT * FROM top_plants
        ORDER BY potencia_outorgada_kw DESC
        LIMIT 5
    """, nativeQuery = true)
    fun findTop5DistinctUsinasByCodCEG(): List<Usina>
}
