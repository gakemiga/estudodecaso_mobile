fun main() {
    val estacionamento = Estacionamento()

    val moto = Veiculo("ABC1D23", "Honda CG 160", 1)
    val carro = Veiculo("QWE4R56", "Fiat Argo", 2)
    val van = Veiculo("ZXC7V89", "Renault Master", 3)

    estacionamento.registrarEntrada(moto, 8.0)
    estacionamento.registrarEntrada(carro, 9.0, "Lavagem completa")
    estacionamento.registrarEntrada(van, 7.0)

    estacionamento.listarEstacionados()
    println()

    // Moto: 2h, sem desconto, sem lavagem -> R$ 10,00
    estacionamento.registrarSaida("ABC1D23", 10.0)?.let { estacionamento.imprimirRecibo(it) }

    // Carro: 6h, com desconto de 15% + lavagem -> 60 - 9 + 35 = R$ 86,00
    estacionamento.registrarSaida("QWE4R56", 15.0)?.let { estacionamento.imprimirRecibo(it) }

    // Van: 5h, com desconto de 15% -> 75 - 11,25 = R$ 63,75
    estacionamento.registrarSaida("ZXC7V89", 12.0)?.let { estacionamento.imprimirRecibo(it) }

    println()
    estacionamento.listarEstacionados()
}