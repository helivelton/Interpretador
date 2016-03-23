public class Interpretador {

	static int contadorDePrograma;
	static int acumulador = 0;
	static String instrucao;
	static TipoInstrucao tipoDeInstrucao;
	static int enderecoDosDados;
	static String operando;
	static boolean parar = false;
	static String memoria[];

	public static void interpretador(String mem[], int enderecoInicial) {

		for (String string : mem) {
			System.out.println(string);
		}
		System.out.println("----------------------");
		memoria = mem;

		System.out.println(memoria.length);
		contadorDePrograma = enderecoInicial;

		while (!parar & memoria.length > 0) {
			System.out.println();
			System.out.println(acumulador);
			instrucao = memoria[contadorDePrograma];
			contadorDePrograma += 1;
			tipoDeInstrucao = getTipoDeInstrucao(instrucao);

			if (tipoDeInstrucao != null) {
				if (tipoDeInstrucao != TipoInstrucao.HALT)
					enderecoDosDados = encontrarDados(instrucao, tipoDeInstrucao);

				if (enderecoDosDados >= 0) {
					operando = memoria[enderecoDosDados];
					executar(tipoDeInstrucao, operando);
				}
			}

		}

	}

	public static TipoInstrucao getTipoDeInstrucao(String instrucao) {

		switch (instrucao) {
		case "AND":
			return TipoInstrucao.AND;

		case "OR":
			return TipoInstrucao.OR;

		case "XOR":
			return TipoInstrucao.XOR;

		case "HALT":
			return TipoInstrucao.HALT;

		default:
			return null;
		}

	}

	public static int encontrarDados(String instrucao, TipoInstrucao tipo) {

		for (int i = contadorDePrograma - 1; i <= memoria.length; i++) {

			if (getTipoDeInstrucao(memoria[i]) == tipo) {
				return i + 1;
			}

		}
		return (Integer) null;
	}

	public static void executar(TipoInstrucao tipoDeInstrucao, String operando) {
		System.out.println(acumulador +" "+ tipoDeInstrucao+" "+ operando);
		
		switch (tipoDeInstrucao) {
		case AND:
			acumulador = acumulador & Integer.parseInt(operando);

			break;

		case OR:
			acumulador = acumulador | Integer.parseInt(operando);

			break;

		case XOR:
			acumulador = acumulador ^ Integer.parseInt(operando);

			break;

		case HALT:
			parar = true;

			break;
		case COM:
			break;
		default:
			break;

		}
	}

}
