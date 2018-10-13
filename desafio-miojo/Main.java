
public class Main {

	public static void main(String[] args) {
		exibeTempoDePreparo(3, 4, 8);
	}

	private static void exibeTempoDePreparo(int tempoDePreparo,
			int ampulheta1, int ampulheta2){
		int tempoMinimoDePreparo = 
				calculaTempoMinimoDePreparo(tempoDePreparo, ampulheta1, ampulheta2);
		if(tempoMinimoDePreparo == -1){
			System.out.printf("\nNão é possível cozinhar o miojo no tempo exato"
					+ " com as ampulhetas disponíveis.\n");
			return;
		}
		System.out.printf("\nTempo mínimo de preparo do miojo: %d minutos",
				tempoMinimoDePreparo);
	}
	
	/**
	 * Calcula o tempo mínimo para o preparo de um miojo usando duas ampulhetas
	 * @param tempoDePreparo - tempo de preparo do miojo
	 * @param ampulheta1 - duração de uma das ampulhetas em minutos
	 * @param ampulheta2 - duração da outra ampulheta em minutos
	 * @return - retorna o tempo minimio de preparo em minutos ou -1
	 * caso não seja possível preparar o miojo no tempo exato com as
	 * ampulhetas dadas
	 */
	private static int calculaTempoMinimoDePreparo(int tempoDePreparo, 
			int ampulheta1, int ampulheta2){
		int a, b;
		for(int i=0;i<100;i++){
			for(int j=0;j<100;j++){
				a = ampulheta1*i;
				b = ampulheta2*j;
				int tempo = Math.abs(a - b);
				if (tempo == tempoDePreparo){
					return (a > b)? a : b;
				}
			}
		}
		return -1;
	}
}
