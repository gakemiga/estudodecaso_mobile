class Estacionamento {

    private val tickets = mutableListOf<Ticket>()

    companion object {
        const val TAXA_LAVAGEM = 35.0
        const val LIMITE_DESCONTO_HORAS = 4.0
        const val PERCENTUAL_DESCONTO = 0.15
    }

    fun registrarEntrada(veiculo: Veiculo, horaEntrada: Double, servicoLavagem: String? = null): Ticket {
        val ticket = Ticket(veiculo, horaEntrada, servicoLavagem)
        tickets.add(ticket)
        return ticket
    }

    fun registrarSaida(placa: String, horaSaida: Double): Ticket? {
        val ticket = tickets.find { it.veiculo.placa == placa && it.estaAberto }
        if (ticket == null) {
            println("Veículo $placa não encontrado no estacionamento.")
            return null
        }
        if (horaSaida <= ticket.horaEntrada) {
            println("Hora de saída inválida para o veículo $placa.")
            return null
        }
        ticket.horaSaida = horaSaida
        return ticket
    }

    // Tarifa por hora conforme o tipo do veículo (when)
    fun tarifaPorHora(tipo: Int): Double = when (tipo) {
        1 -> 5.0   // Moto
        2 -> 10.0  // Carro
        3 -> 15.0  // Van
        else -> 0.0
    }

    // Cálculo do valor final do ticket
    fun calcularValor(ticket: Ticket): Double {
        val horas = ticket.horasPermanencia()
        var valorPermanencia = horas * tarifaPorHora(ticket.veiculo.tipo)

        // Desconto de longa permanência (if/else)
        if (horas > LIMITE_DESCONTO_HORAS) {
            valorPermanencia -= valorPermanencia * PERCENTUAL_DESCONTO
        }

        // Serviço opcional (Null Safety): se nulo, adiciona 0.0
        val valorLavagem = if (ticket.servicoLavagem != null) TAXA_LAVAGEM else 0.0

        return valorPermanencia + valorLavagem
    }

    // Lista os veículos ainda estacionados (for)
    fun listarEstacionados() {
        println("=== Veículos estacionados ===")
        var contador = 0
        for (ticket in tickets) {
            if (ticket.estaAberto) {
                val v = ticket.veiculo
                val lavagem = ticket.servicoLavagem ?: "sem serviço"
                println("${v.placa} | ${v.modelo} | ${v.nomeTipo()} | entrada: ${ticket.horaEntrada}h | $lavagem")
                contador++
            }
        }
        if (contador == 0) println("Nenhum veículo estacionado.")
    }

    // Recibo de saída
    fun imprimirRecibo(ticket: Ticket) {
        val v = ticket.veiculo
        println("--- Recibo ---")
        println("Placa: ${v.placa} (${v.modelo} - ${v.nomeTipo()})")
        println("Permanência: ${"%.1f".format(ticket.horasPermanencia())} h")
        println("Lavagem: ${ticket.servicoLavagem ?: "não contratada"}")
        println("Total: R$ ${"%.2f".format(calcularValor(ticket))}")
        println("--------------")
    }
}