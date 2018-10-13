
public class Main {

	public static void main(String[] args) {
		exibeTempoDePreparo(8, 26, 37);
	}

	private static void exibeTempoDePreparo(int tempoDePreparo, int ampulheta1, int ampulheta2) {
		int tempoMinimoDePreparo = calculaTempoMinimoDePreparo(tempoDePreparo, ampulheta1, ampulheta2);
		if (tempoMinimoDePreparo == -1) {
			System.out.printf("\nNão é possível cozinhar o miojo no tempo exato" + " com as ampulhetas disponíveis.\n");
			return;
		}
		System.out.printf("\nTempo mínimo de preparo do miojo: %d minutos", tempoMinimoDePreparo);
	}

	/**
	 * Calcula o tempo mínimo para o preparo de um miojo usando duas ampulhetas
	 * 
	 * @param tempoDePreparo
	 *            - tempo de preparo do miojo
	 * @param ampulheta1
	 *            - duração de uma das ampulhetas em minutos
	 * @param ampulheta2
	 *            - duração da outra ampulheta em minutos
	 * @return - retorna o tempo mínimio de preparo em minutos ou -1 caso não
	 *         seja possível preparar o miojo no tempo exato com as ampulhetas
	 *         dadas
	 */
	private static int calculaTempoMinimoDePreparo(int tempoDePreparo, int ampulheta1, int ampulheta2) {
		int maiorAmpulheta = ampulheta1 > ampulheta2 ? ampulheta1 : ampulheta2;
		int menorAmpulheta = ampulheta1 < ampulheta2 ? ampulheta1 : ampulheta2;
		for (int i = 1; i <= 100; i++) {
			int tempoAnterior = Integer.MIN_VALUE;
			for (int j = 1; j <= 100; j++) {
				int a = maiorAmpulheta * i;
				int b = menorAmpulheta * j;
				int tempo = Math.abs(a - b);
				if (tempo == tempoDePreparo) {
					return a > b ? a : b;
				}
				if (tempoEstaSeDistanciandoDoDesejado(tempo, tempoAnterior, tempoDePreparo)) {
					break;
				}
				tempoAnterior = tempo;
			}
		}
		return -1;
	}

	private static boolean tempoEstaSeDistanciandoDoDesejado(int tempoAtual, int tempoAnterior, int tempoDesejado) {
		return Math.abs(tempoAtual - tempoDesejado) >= Math.abs(tempoAnterior - tempoDesejado);
	}
}
