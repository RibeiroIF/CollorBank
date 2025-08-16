package CollorBank;

import java.util.ArrayList;
import java.util.HashMap;

public class Relatorio {
	
	private HashMap<Cliente, Valores> cupom;
	private ArrayList<Valores> relatorio;
	
	public Relatorio() {
		relatorio = new ArrayList<>();
		cupom = new HashMap<>();
	}
	
	public void registrarTransferencia(Valores deposito) {
		relatorio.add(deposito);
		
	}
	
	public void registrarValor(Cliente cliente, Valores deposito) {
		cupom.put(cliente, deposito);
	}
	
	public void mostrarSaldo(Cliente cliente, Valores deposito) {
		System.out.println("Olá "+cliente.getNome()+", seu saldo na conta é de R$"+deposito.getDeposito());
	}
	
	public void mostrarCupom() {
		int operacao = 1;
		System.out.println("Suas operações: ");
		for (Valores deposito : relatorio) {
			System.out.println(operacao+"° operação: "+deposito.getDeposito());
			operacao++;
		}
		System.out.println();
	}
}
