package dev.pegorari.boltenergy.ralieapi.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "unidade_geradora")
data class UnidadeGeradora(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "cod_ceg")
    val codCeg: Int? = null,

    @Column(name = "nom_empreendimento")
    val nomEmpreendimento: String? = null,

    @Column(name = "num_ug_usina")
    val numUgUsina: Int? = null,

    @Column(name = "nom_ug")
    val nomUg: String? = null,

    @Column(name = "cod_subsistema")
    val codSubsistema: Int? = null,

    @Column(name = "nom_subsistema")
    val nomSubsistema: String? = null,

    @Column(name = "dsc_fonte_geracao")
    val dscFonteGeracao: String? = null,

    @Column(name = "cod_fonte_combustivel")
    val codFonteCombustivel: Int? = null,

    @Column(name = "dsc_tipo_combustivel")
    val dscTipoCombustivel: String? = null,

    @Column(name = "cod_ug")
    val codUg: Int? = null,

    @Column(name = "dsc_tipo_ug")
    val dscTipoUg: String? = null,

    @Column(name = "mda_potencia_unitaria_kw")
    val mdaPotenciaUnitariaKw: BigDecimal? = null,

    @Column(name = "mda_potencia_instalada_kw")
    val mdaPotenciaInstaladaKw: BigDecimal? = null,

    @Column(name = "dsc_situacao_ug")
    val dscSituacaoUg: String? = null,

    @Column(name = "dat_ug_inicio_op_comer_outorgado")
    val datUgInicioOpComerOutorgado: LocalDate? = null,

    @Column(name = "dat_previsao_op_comercial_sfg")
    val datPrevisaoOpComercialSfg: LocalDate? = null,

    @Column(name = "dat_realizacao_op_comercial")
    val datRealizacaoOpComercial: LocalDate? = null,

    @Column(name = "ind_ug_operando")
    val indUgOperando: Boolean? = null,

    @Column(name = "dat_atualizacao")
    val datAtualizacao: LocalDate? = null
)
