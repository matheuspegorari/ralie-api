package dev.pegorari.ralieapi.schemas

enum class UsinaCsvColumns(val columnName: String) {
    ID("_id"),
    COD_CEG("CodCEG"),
    NOME_EMPREENDIMENTO("NomEmpreendimento"),
    POTENCIA_OUTORGADA("MdaPotenciaOutorgadaKw"),
    UF_PRINCIPAL("SigUFPrincipal"),
    TIPO_GERACAO("SigTipoGeracao"),
    ORIGEM_COMBUSTIVEL("DscOrigemCombustivel"),
    SITUACAO_OBRA("DscSituacaoObra")
}