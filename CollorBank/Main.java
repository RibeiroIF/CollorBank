package CollorBank;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner input = new Scanner (System.in);
		Relatorio rel = new Relatorio();
		
		String confirmacao = "S", nome = "";
		float deposito = 0, saque = 0, resultado = 0;
		
		System.out.println("Qual o seu nome: ");
		nome = input.nextLine();
		
		while (confirmacao.equalsIgnoreCase("S")) {
			System.out.println("Qual ação deseja realizar?: "
							+ "\n0 : Nenhuma"
							+ "\n1 : Depósito"
							+ "\n2 : Saque");
			int operacao = input.nextInt();
			while (operacao < 0 || operacao > 2) {
				System.out.println("Valor inválido, favor inserir um valor entre 0 e 2: ");
				operacao = input.nextInt();
			}
			if (operacao == 0) {
				System.out.println("Ok, operação finalizada!!\n");
				break;
			}
			else if (operacao == 1) {
				System.out.println("Qual valor deseja depositar?: ");
				deposito = input.nextFloat();
				Valores atualizacao1 = new Valores(deposito);
				rel.registrarTransferencia(atualizacao1);
				
			}
			else if (operacao == 2) {
				System.out.println("Qual valor deseja sacar?: ");
				saque = input.nextFloat();
				Valores atualizacao2 = new Valores(saque*(-1));
				rel.registrarTransferencia(atualizacao2);
			}
			resultado = (deposito - saque);
		}
		
		Cliente nome_cliente = new Cliente(nome);
		Valores saldo_final = new Valores(resultado);
		
		rel.registrarValor(nome_cliente, saldo_final);
		
		rel.mostrarCupom();
		Thread.sleep(1000);
		rel.mostrarSaldo(nome_cliente, saldo_final);
		
		input.close();
	}

}
