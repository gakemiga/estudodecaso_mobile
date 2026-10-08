/**
 * Representa um veículo.
 * tipo: 1 = Moto, 2 = Carro, 3 = Van
 */
class Veiculo(
    val placa: String,
    val modelo: String,
    val tipo: Int
) {
    fun nomeTipo(): String = when (tipo) {
        1 -> "Moto"
        2 -> "Carro"
        3 -> "Van"
        else -> "Desconhecido"
    }
}