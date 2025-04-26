package dev.pegorari.boltenergy.ralieapi.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "usina")
data class Usina(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "dat_geracao_conjunto_dados")
    val datGeracaoConjuntoDados: LocalDate? = null,

    @Column(name = "dat_ralie")
    val datRalie: LocalDate? = null,

    @Column(name = "ide_nucleo_ceg")
    val ideNucleoCeg: Int? = null,

    @Column(name = "cod_ceg")
    val codCeg: String? = null,

    @Column(name = "sig_uf_principal")
    val sigUfPrincipal: String? = null,

    @Column(name = "dsc_origem_combustivel")
    val dscOrigemCombustivel: String? = null,

    @Column(name = "sig_tipo_geracao")
    val sigTipoGeracao: String? = null,

    @Column(name = "nom_empreendimento")
    val nomEmpreendimento: String? = null,

    @Column(name = "mda_potencia_outorgada_kw")
    val mdaPotenciaOutorgadaKw: BigDecimal? = null,

    @Column(name = "dsc_propri_regime_pariticipacao")
    val dscPropriRegimePariticipacao: String? = null,

    @Column(name = "dsc_tipo_conexao")
    val dscTipoConexao: String? = null,

    @Column(name = "nom_conexao")
    val nomConexao: String? = null,

    @Column(name = "mda_tensao_conexao")
    val mdaTensaoConexao: BigDecimal? = null,

    @Column(name = "nom_empresa_conexao")
    val nomEmpresaConexao: String? = null,

    @Column(name = "num_cnpj_empresa_conexao")
    val numCnpjEmpresaConexao: String? = null,

    @Column(name = "dsc_viabilidade")
    val dscViabilidade: String? = null,

    @Column(name = "dsc_situacao_obra")
    val dscSituacaoObra: String? = null,

    @Column(name = "dat_previsao_inicio_obra")
    val datPrevisaoInicioObra: LocalDate? = null,

    @Column(name = "dat_contrato_epc_outorgado")
    val datContratoEpcOutorgado: LocalDate? = null,

    @Column(name = "dat_recurso_financeiro_outorgado")
    val datRecursoFinanceiroOutorgado: LocalDate? = null,

    @Column(name = "dat_canteiro_obra_outorgado")
    val datCanteiroObraOutorgado: LocalDate? = null,

    @Column(name = "dat_canteiro_obra_realizado")
    val datCanteiroObraRealizado: LocalDate? = null,

    @Column(name = "dat_inicio_obra_outorgado")
    val datInicioObraOutorgado: LocalDate? = null,

    @Column(name = "dat_inicio_obra_realizado")
    val datInicioObraRealizado: LocalDate? = null,

    @Column(name = "dat_concretagem_outorgado")
    val datConcretagemOutorgado: LocalDate? = null,

    @Column(name = "dat_concretagem_realizado")
    val datConcretagemRealizado: LocalDate? = null,

    @Column(name = "dat_desvio_rio_outorgado")
    val datDesvioRioOutorgado: LocalDate? = null,

    @Column(name = "dat_desvio_rio_realizado")
    val datDesvioRioRealizado: LocalDate? = null,

    @Column(name = "dat_montagem_outorgado")
    val datMontagemOutorgado: LocalDate? = null,

    @Column(name = "dat_montagem_realizado")
    val datMontagemRealizado: LocalDate? = null,

    @Column(name = "dat_conclusao_torres_outorgado")
    val datConclusaoTorresOutorgado: LocalDate? = null,

    @Column(name = "dat_conclusao_torres_realizado")
    val datConclusaoTorresRealizado: LocalDate? = null,

    @Column(name = "dat_enchimento_outorgado")
    val datEnchimentoOutorgado: LocalDate? = null,

    @Column(name = "dat_enchimento_realizado")
    val datEnchimentoRealizado: LocalDate? = null,

    @Column(name = "dat_comissionamento_ug_realizado")
    val datComissionamentoUgRealizado: LocalDate? = null,

    @Column(name = "dat_sis_transmissao_outorgado")
    val datSisTransmissaoOutorgado: LocalDate? = null,

    @Column(name = "dat_sis_transmissao_realizado")
    val datSisTransmissaoRealizado: LocalDate? = null,

    @Column(name = "dat_conclusao_sis_trans_outorgado")
    val datConclusaoSisTransOutorgado: LocalDate? = null,

    @Column(name = "dat_conclusao_sis_trans_realizado")
    val datConclusaoSisTransRealizado: LocalDate? = null,

    @Column(name = "dsc_justificativa_previsao")
    val dscJustificativaPrevisao: String? = null,

    @Column(name = "dsc_comercializacao_energia")
    val dscComercializacaoEnergia: String? = null,

    @Column(name = "dsc_sistema")
    val dscSistema: String? = null,

    @Column(name = "dat_conclusao_transporte_realizado")
    val datConclusaoTransporteRealizado: LocalDate? = null,

    @Column(name = "dsc_situacao_cronograma")
    val dscSituacaoCronograma: String? = null,

    @Column(name = "dat_rapeel")
    val datRapeel: LocalDate? = null,

    @Column(name = "idc_complexo")
    val idcComplexo: Int? = null,

    @Column(name = "nom_complexo")
    val nomComplexo: String? = null,

    @Column(name = "dat_emissao_lp")
    val datEmissaoLp: LocalDate? = null,

    @Column(name = "dat_validade_lp")
    val datValidadeLp: LocalDate? = null,

    @Column(name = "dsc_situacao_lp")
    val dscSituacaoLp: String? = null,

    @Column(name = "dat_emissao_li")
    val datEmissaoLi: LocalDate? = null,

    @Column(name = "dat_validade_li")
    val datValidadeLi: LocalDate? = null,

    @Column(name = "dsc_situacao_li")
    val dscSituacaoLi: String? = null,

    @Column(name = "dat_solicitacao_lo")
    val datSolicitacaoLo: LocalDate? = null,

    @Column(name = "dat_prevista_emissao_lo")
    val datPrevistaEmissaoLo: LocalDate? = null,

    @Column(name = "dat_prev_max_emissao_lo")
    val datPrevMaxEmissaoLo: LocalDate? = null,

    @Column(name = "dat_emissao_lo")
    val datEmissaoLo: LocalDate? = null,

    @Column(name = "dat_validade_lo")
    val datValidadeLo: LocalDate? = null,

    @Column(name = "dsc_situacao_lo")
    val dscSituacaoLo: String? = null,

    @Column(name = "dsc_situacao_par_acesso")
    val dscSituacaoParAcesso: String? = null,

    @Column(name = "dat_solicitacao_par_acesso")
    val datSolicitacaoParAcesso: LocalDate? = null,

    @Column(name = "dat_emissao_par_acesso")
    val datEmissaoParAcesso: LocalDate? = null,

    @Column(name = "dsc_sit_ccd")
    val dscSitCcd: String? = null,

    @Column(name = "dat_validade_ccd")
    val datValidadeCcd: LocalDate? = null,

    @Column(name = "dat_assinatura_ccd")
    val datAssinaturaCcd: LocalDate? = null,

    @Column(name = "dsc_sit_cct")
    val dscSitCct: String? = null,

    @Column(name = "dat_validade_cct")
    val datValidadeCct: LocalDate? = null,

    @Column(name = "dat_assinatura_cct")
    val datAssinaturaCct: LocalDate? = null,

    @Column(name = "dsc_situacao_cusd")
    val dscSituacaoCusd: String? = null,

    @Column(name = "dat_validade_cusd")
    val datValidadeCusd: LocalDate? = null,

    @Column(name = "dat_assinatura_cusd")
    val datAssinaturaCusd: LocalDate? = null,

    @Column(name = "dsc_sit_cust")
    val dscSitCust: String? = null,

    @Column(name = "dat_validade_cust")
    val datValidadeCust: LocalDate? = null,

    @Column(name = "dat_assinatura_cust")
    val datAssinaturaCust: LocalDate? = null,

    @Column(name = "dsc_ato_outorga")
    val dscAtoOutorga: String? = null,

    @Column(name = "dsc_numero_ato")
    val dscNumeroAto: String? = null,

    @Column(name = "nom_orgao_outorgante")
    val nomOrgaoOutorgante: String? = null,

    @Column(name = "dsc_tipo_outorga")
    val dscTipoOutorga: String? = null,

    @Column(name = "dat_emissao_ato")
    val datEmissaoAto: LocalDate? = null
)
