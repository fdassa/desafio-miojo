import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Qual o tempo de preparo do miojo em minutos");
		int tempoDePreparo = scanner.nextInt();
		System.out.println("Qual o tempo de dura��o da ampulheta 1 em minutos");
		int ampulheta1 = scanner.nextInt();
		System.out.println("Qual o tempo de dura��o da ampulheta 2 em minutos");
		int ampulheta2 = scanner.nextInt();
		exibeTempoDePreparo(tempoDePreparo, ampulheta1, ampulheta2);
	}

	private static void exibeTempoDePreparo(int tempoDePreparo, int ampulheta1, int ampulheta2) {
		int tempoMinimoDePreparo = calculaTempoMinimoDePreparo(tempoDePreparo, ampulheta1, ampulheta2);
		if (tempoMinimoDePreparo == -1) {
			System.out.println("N�o � poss�vel cozinhar o miojo no tempo exato com as ampulhetas dispon�veis.");
			return;
		}
		System.out.printf("Tempo m�nimo de preparo do miojo: %d minutos\n", tempoMinimoDePreparo);
	}

	/**
	 * Calcula o tempo m�nimo para o preparo de um miojo usando duas ampulhetas
	 * 
	 * @param tempoDePreparo
	 *            - tempo de preparo do miojo
	 * @param ampulheta1
	 *            - dura��o de uma das ampulhetas em minutos
	 * @param ampulheta2
	 *            - dura��o da outra ampulheta em minutos
	 * @return - retorna o tempo m�nimio de preparo em minutos ou -1 caso n�o
	 *         seja poss�vel preparar o miojo no tempo exato com as ampulhetas
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

	/**
	 * Avalia se o tempo atual se distanciou do tempo desejado tendo como base o
	 * tempo anterior
	 * 
	 * @param tempoAtual
	 * @param tempoAnterior
	 * @param tempoDesejado
	 * @return
	 */
	private static boolean tempoEstaSeDistanciandoDoDesejado(int tempoAtual, int tempoAnterior, int tempoDesejado) {
		return Math.abs(tempoAtual - tempoDesejado) >= Math.abs(tempoAnterior - tempoDesejado);
	}
}
