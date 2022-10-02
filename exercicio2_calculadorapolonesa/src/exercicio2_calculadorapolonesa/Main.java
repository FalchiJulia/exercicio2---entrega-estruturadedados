package exercicio2_calculadorapolonesa;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Insira a expressao: (separada por espacos)");
		String expressao = scanner.nextLine();
		
		NotacaoPolonesa not = new NotacaoPolonesa(expressao);
	}

}


