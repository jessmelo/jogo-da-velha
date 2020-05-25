/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   Turma 04 - Norton Trevisan Roman                              **/
/**                                                                 **/
/**   Terceiro Exercício-Programa                                   **/
/**                                                                 **/
/**   Jéssica da Paixão Melo               Nº USP: 10875986         **/
/**                                                                 **/
/**   --/--/2020                                                    **/
/*********************************************************************/

/*
	Jogo da Velha - programa para verificar o status de um jogo.
	
	Lista de Status calculado:
	0 - Jogo nao iniciado: o tabuleiro esta 'vazio', isto é sem pecas X e O;
    1 - Jogo encerrado1: o primeiro jogador (que usa as pecas X) a o ganhador;
    2 - Jogo encerrado2: o segundo jogador (que usa as pecas O) a o ganhador;
    3 - Jogo encerrado3: empate - todas as casas do tabuleiro estao preenchidas com X e O, mas nenhum dos jogadores ganhou;
    4 - Jogo ja iniciado e em andamento: nenhuma das alternativas anteriores.	
*/

public class JogoDaVelha {
	static final char pecaX = 'X';
	static final char pecaY = 'O';
	static final char espacoVazio = ' ';

	/*
		Determina o status de uma partida de Jogo da Velha
		
		Entrada:
			tabuleiro - matriz 3x3 de caracteres representando uma partida valida de Jogo da Velha
			
		Saida:
			um inteiro contendo o status da partida (valores validos de zero a quatro)
	*/
	static int verificaStatus(char[][] tabuleiro) {
		int status = -1;
		
		// checando as diagonais

		boolean diagX1 = tabuleiro[0][0] == pecaX && tabuleiro[1][1] == pecaX && tabuleiro[2][2] == pecaX;
		boolean diagX2 = tabuleiro[0][2] == pecaX && tabuleiro[1][1] == pecaX && tabuleiro[2][0] == pecaX;

		boolean diagO1 = tabuleiro[0][0] == pecaY && tabuleiro[1][1] == pecaY && tabuleiro[2][2] == pecaY;
		boolean diagO2 = tabuleiro[0][2] == pecaY && tabuleiro[1][1] == pecaY && tabuleiro[2][0] == pecaY;

		if(diagX1 || diagX2) {
			return status = 1;
		} else if(diagO1 || diagO2) {
			return status = 2;
		}

		// checando horizontal e vertical

		for(int i=0; i < 3; i++){
			if(tabuleiro[i][0] == pecaX && tabuleiro[i][1] == pecaX && tabuleiro[i][2] == pecaX){
				return status = 1;
			} else if (tabuleiro[i][0] == pecaY && tabuleiro[i][1] == pecaY && tabuleiro[i][2] == pecaY){
				return status = 2;
			} 
		}

		// outros casos

		boolean temPeca = false;

		for (int i=0; i < tabuleiro.length; i++) {
			for (int j=0; j < tabuleiro[i].length; j++){
				if(tabuleiro[i][j] == espacoVazio){
					status = 0;
				} else {
					temPeca = true;
				} 
			} 
		}		

		boolean temEspacoVazio = false;
		if(status == 0 && temPeca) {
			for (int i=0; i < tabuleiro.length; i++) {
				for (int j=0; j < tabuleiro[i].length; j++){
					if(tabuleiro[i][j] == espacoVazio){
						temEspacoVazio = true;
					} 
				} 
			}		
		}

		if(temEspacoVazio && temPeca) {
			// se tiver espaco vazio e nenhum ganhador, o jogo ainda está em andamento (status 4)
			status = 4;
		} else if(temPeca) status = 3; // se tiver n tiver espaco vazio ou ganhador é empate (status 3)

		return status;
	}
	
	/*
		Apenas para seus testes. ISSO SERA IGNORADO NA CORRECAO
	*/
	public static void main(String[] args) {
		// escreva seu codigo (para testes) aqui

		char[][] tab0 = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		char[][] tab1 = {{'X','X','X'},{'O','O',' '},{' ',' ',' '}};
		char[][] tab2 = {{'O','X','X'},{'X','O','O'},{' ',' ','O'}};
		char[][] tab3 = {{'O','X','X'},{'X','O','O'},{'O','X','X'}};
		char[][] tab4 = {{' ',' ',' '},{'X','O','X'},{' ',' ',' '}};

		System.out.println("Status calculado: " + verificaStatus(tab0));
		System.out.println("Status esperado para o tabuleiro0: 0\n");

		System.out.println("Status calculado: " + verificaStatus(tab1));
		System.out.println("Status esperado para o tabuleiro1: 1\n");

		System.out.println("Status calculado: " + verificaStatus(tab2));
		System.out.println("Status esperado para o tabuleiro2: 2\n");
		
		System.out.println("Status calculado: " + verificaStatus(tab3));
		System.out.println("Status esperado para o tabuleiro1: 3\n");
		
		System.out.println("Status calculado: " + verificaStatus(tab4));
		System.out.println("Status esperado para o tabuleiro4: 4\n");
		
	}
}
