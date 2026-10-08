/**
 * Ticket de permanência.
 * horaSaida é nula enquanto o veículo ainda está estacionado.
 * servicoLavagem é opcional (Null Safety).
 */
class Ticket(
    val veiculo: Veiculo,
    val horaEntrada: Double,
    val servicoLavagem: String? = null
) {
    var horaSaida: Double? = null

    val estaAberto: Boolean
        get() = horaSaida == null

    fun horasPermanencia(): Double {
        val saida = horaSaida ?: return 0.0
        return saida - horaEntrada
    }
}