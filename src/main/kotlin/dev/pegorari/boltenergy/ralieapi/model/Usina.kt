package dev.pegorari.boltenergy.ralieapi.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "usina")
data class Usina(
    @Id
    @Column(name = "id")
    val id: Int,

    @Column(name = "cod_ceg")
    val codCEG: String,

    @Column(name = "nome_empreendimento")
    val nomeEmpreendimento: String,

    @Column(name = "potencia_outorgada_kw")
    val potenciaOutorgadaKw: Double,

    @Column(name = "uf", length = 2)
    val uf: String,

    @Column(name = "tipo_geracao", length = 5)
    val tipoGeracao: String,

    @Column(name = "origem_combustivel")
    val origemCombustivel: String,

    @Column(name = "situacao_obra")
    val situacaoObra: String
)