package dev.pegorari.boltenergy.ralieapi.service

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import dev.pegorari.boltenergy.ralieapi.model.Usina
import dev.pegorari.boltenergy.ralieapi.repository.UsinaRepository
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.net.URL

@Service
class UsinaService(
    private val repository: UsinaRepository,
    private val entityManager: EntityManager
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun getTopUsinas(): List<Usina> {
        return repository.findTop5ByOrderByPotenciaOutorgadaKwDesc()
    }

    @Transactional
    fun importFromCsv(csvUrl: URL) {
        log.info("Iniciando importação de usinas de CSV com a URL: $csvUrl")
        log.info("Deletando todas as usinas existentes...")
        repository.deleteAll()
        log.info("Todas as usinas deletadas com sucesso!")

        log.info("Importando CSV...")
        try {
            val startTime = System.currentTimeMillis()
            val registros = importUsinasFromCsv(csvUrl)
            log.info("Duração da importação: ${(System.currentTimeMillis() - startTime )/ 1000} seconds")
            log.info("Total de usinas importadas: $registros")
        } catch (e: Exception) {
            log.error("Erro ao importar CSV: ${e.message}")
            throw e
        }
        log.info("Importação concluída com sucesso!")
    }

    private fun importUsinasFromCsv(csvUrl: URL): Int {
        val batchSize = 1000
        var counter = 0

        val inputStream = csvUrl.openStream()
        csvReader().open(inputStream) {
            readAllWithHeaderAsSequence().forEach { row ->
                val potenciaStr = row["MdaPotenciaOutorgadaKw"] ?: "0.0"
                val potenciaFormatada = potenciaStr.trim().replace(",", ".")
                val potencia = potenciaFormatada.toDoubleOrNull() ?: 0.0

                val usina = Usina(
                    codCEG = row["CodCEG"] ?: "",
                    nomeEmpreendimento = row["NomEmpreendimento"] ?: "",
                    potenciaOutorgadaKw = potencia,
                    uf = row["SigUFPrincipal"] ?: "",
                    tipoGeracao = row["SigTipoGeracao"] ?: "",
                    origemCombustivel = row["DscOrigemCombustivel"] ?: "",
                    situacaoObra = row["DscSituacaoObra"] ?: ""
                )
                repository.save(usina)
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
}
