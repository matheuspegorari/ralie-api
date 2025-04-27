package dev.pegorari.boltenergy.ralieapi.schemas

enum class UsinaCsvColumns(val columnName: String) {
    COD_CEG("CodCEG"),
    NOME_EMPREENDIMENTO("NomEmpreendimento"),
    POTENCIA_OUTORGADA("MdaPotenciaOutorgadaKw"),
    UF_PRINCIPAL("SigUFPrincipal"),
    TIPO_GERACAO("SigTipoGeracao"),
    ORIGEM_COMBUSTIVEL("DscOrigemCombustivel"),
    SITUACAO_OBRA("DscSituacaoObra")
}