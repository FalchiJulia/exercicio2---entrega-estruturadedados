package exercicio2_calculadorapolonesa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class NotacaoPolonesa {

		private String[] notacao = new String[300];
		private String[] op = {"/","*","+","-","^","%"};
		private Map<String, Integer> valor_variaveis = new HashMap<String, Integer>();
		Scanner scanner = new Scanner(System.in);
		
	

		public NotacaoPolonesa(String notacao) {
			this.notacao = notacao.toLowerCase().split(" ");
			if (this.verif_caracteres()) {
				this.pedir_valores();
				this.calcular();
			} else {
				System.out.println("Notacao Invalida!");
			}
		}
		
		private Boolean verif_caracteres() {
			Boolean valido = false;
			for (int i = 0; i < this.notacao.length; i++) {
				String c = this.notacao[i];
				for (char j = 'a'; j <= 'z'; j++) {
					if(c.equals(String.valueOf(j))) {
						valido = true;
						break;
					}
				}
				for (int k = 0; k < this.op.length; k++) {
					if(c.equals(this.op[k])) {
						valido = true;
						break;
					}
				}
			}
			return valido;
		}
		
		private void pedir_valores() {
			System.out.println("Insira um valor para: ");
			for (int i = 0; i < this.notacao.length; i++) {
				String c = this.notacao[i];
				for (char j = 'a'; j <= 'z'; j++) {
					if(c.equals(String.valueOf(j))) {
						System.out.print(c + ":");
						int val = scanner.nextInt();
						valor_variaveis.put(c, val);
						System.out.println();
					}
				}
			}
		}
		
		private void calcular() {
			float resultado = 0;
			Stack<Float> conta = new Stack<Float>();
			for (int i = 0; i < this.notacao.length; i++) {
				String c = this.notacao[i];
				if(valor_variaveis.containsKey(c)) {
					conta.push(valor_variaveis.get(c).floatValue());
				} else {
					if (c.equals("+")) {
						resultado = conta.lastElement();
						conta.pop();
						resultado += conta.lastElement();
						conta.pop();
					}
					else if (c.equals("-")) {
						resultado = conta.lastElement();
						conta.pop();
						resultado = conta.lastElement() - resultado;
						conta.pop();
					}
					else if (c.equals("/")) {
						resultado = conta.lastElement();
						conta.pop();
						resultado = conta.lastElement() / resultado;
						conta.pop();
					}
					else if (c.equals("%")) {
						resultado = conta.lastElement();
						conta.pop();
						resultado = conta.lastElement() % resultado;
						conta.pop();
					}
					else if (c.equals("*")) {
						resultado = conta.lastElement();
						conta.pop();
						resultado = conta.lastElement() * resultado;
						conta.pop();
					}
					else if (c.equals("^")) {
						resultado = conta.lastElement();
						conta.pop();
						resultado = conta.lastElement().intValue() ^ (int) resultado;
						conta.pop();
					}
					conta.push(resultado);
				}
			}
			System.out.println("Resultado: " + resultado);
		}
		
	}



