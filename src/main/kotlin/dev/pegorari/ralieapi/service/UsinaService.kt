package dev.pegorari.ralieapi.service

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import dev.pegorari.ralieapi.model.Usina
import dev.pegorari.ralieapi.repository.UsinaRepository
import dev.pegorari.ralieapi.schemas.UsinaCsvColumns
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.net.URL

@Service
class UsinaService(
    private val repository: UsinaRepository,
    private val entityManager: EntityManager
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @Value("\${usina.import.batchSize}")
    private val batchSize: Int = 1000

    fun getTopUsinas(): List<Usina> {
        return repository.findTop5DistinctUsinasByCodCEG()
    }

    @Transactional
    fun importFromCsv(csvUrl: URL) {
        log.info("Iniciando importação de usinas de CSV com a URL: $csvUrl")
        log.info("Deletando todas as usinas existentes...")
        repository.deleteAllInBatch()
        log.info("Todas as usinas deletadas com sucesso!")

        log.info("Importando CSV...")
        try {
            val startTime = System.currentTimeMillis()
            val registros = importUsinasFromCsv(csvUrl)
            log.info("Duração da importação: ${(System.currentTimeMillis() - startTime) / 1000} seconds")
            log.info("Total de usinas importadas: $registros")
        } catch (e: Exception) {
            log.error("Erro ao importar CSV: ${e.message}")
            throw e
        }
        log.info("Importação concluída com sucesso!")
    }

    private fun importUsinasFromCsv(csvUrl: URL): Int {
        var counter = 0

        val inputStream = csvUrl.openStream()
        csvReader().open(inputStream) {
            readAllWithHeaderAsSequence().forEach { row ->
                val usina = fromCsvRow(row)
                entityManager.persist(usina)

                if (++counter % batchSize == 0) {
                    entityManager.flush()
                    entityManager.clear()
                    log.info("Importando usinas... $counter registros processados")
                }
            }
        }
        entityManager.flush()
        entityManager.clear()
        return counter
    }

    private fun fromCsvRow(row: Map<String, String>): Usina {
        val potenciaStr = row[UsinaCsvColumns.POTENCIA_OUTORGADA.columnName] ?: "0.0"
        val potenciaFormatada = potenciaStr.trim().replace(",", ".")
        val potencia = potenciaFormatada.toDoubleOrNull() ?: 0.0

        return Usina(
            id = row[UsinaCsvColumns.ID.columnName]?.toInt() ?: 0,
            codCEG = row[UsinaCsvColumns.COD_CEG.columnName] ?: "",
            nomeEmpreendimento = row[UsinaCsvColumns.NOME_EMPREENDIMENTO.columnName] ?: "",
            potenciaOutorgadaKw = potencia,
            uf = row[UsinaCsvColumns.UF_PRINCIPAL.columnName] ?: "",
            tipoGeracao = row[UsinaCsvColumns.TIPO_GERACAO.columnName] ?: "",
            origemCombustivel = row[UsinaCsvColumns.ORIGEM_COMBUSTIVEL.columnName] ?: "",
            situacaoObra = row[UsinaCsvColumns.SITUACAO_OBRA.columnName] ?: ""
        )
    }
}
