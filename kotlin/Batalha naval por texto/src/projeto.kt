import kotlin.random.Random

fun main() {
    println("Bem-vindo ao Batalha Naval por Texto!")
    println("O tabuleiro é um 7x7. Tenta encontrar e afundar o navio inimigo.")

    // Define a posição secreta do navio entre 1 e 6
    val linhaNavio = Random.nextInt(1, 7)
    val colunaNavio = Random.nextInt(1, 7)

    var navioAfundado = false
    var tentativas = 0

    while (!navioAfundado) {
        tentativas++
        println("\n--- Tentativa $tentativas ---")

        val linhaTiro = lerCoordenada("Linha")
        val colunaTiro = lerCoordenada("Coluna")

        if (linhaTiro == -1 || colunaTiro == -1) {
            println("Entrada inválida! Por favor, insere um número entre 1 e 3.")
            continue
        }

        navioAfundado = avaliarTiro(linhaTiro, colunaTiro, linhaNavio, colunaNavio)
    }

    println("\nParabéns! Afundou o navio em $tentativas tentativas.")
}

fun lerCoordenada(nome: String): Int {
    print("$nome (1-6): ")
    val entrada = readlnOrNull()

    // Tratamento de Null Safety: Operador Safe Call (?) e Elvis (?:)
    val valor = entrada?.toIntOrNull() ?: -1

    return if (valor >= 1 && valor <= 6) {
        valor
    } else {
        -1
    }
}

fun avaliarTiro(linhaTiro: Int, colunaTiro: Int, linhaNavio: Int, colunaNavio: Int): Boolean {
    when {
        linhaTiro == linhaNavio && colunaTiro == colunaNavio -> {
            println("BUM! ACERTOU O NAVIO")
            return true
        }
        linhaTiro == linhaNavio || colunaTiro == colunaNavio -> {
            println("Acertou a água! Mas está na mesma coluna!.")
            return false
        }
        else -> {
            println("ERROOOOUUUU!.")
            return false
        }
    }
}