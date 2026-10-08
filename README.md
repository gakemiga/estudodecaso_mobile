# Estacionamento Rotativo (Zona Azul)

Sistema em Kotlin para controle de permanência e faturamento de estacionamento rotativo.

## Estrutura
- `Veiculo.kt` – placa, modelo e tipo (1 Moto, 2 Carro, 3 Van)
- `Ticket.kt` – hora de entrada/saída e serviço de lavagem opcional (`String?`)
- `Estacionamento.kt` – regras de negócio (tarifa com `when`, desconto com `if/else`, listagem com `for`)
- `Main.kt` – demonstração

## Regras
- Tarifa/hora: Moto R$ 5, Carro R$ 10, Van R$ 15
- Lavagem (se preenchida): + R$ 35,00
- Permanência > 4h: 15% de desconto sobre o valor da permanência

## Executar
```
kotlinc src/*.kt -include-runtime -d estacionamento.jar
java -jar estacionamento.jar
```