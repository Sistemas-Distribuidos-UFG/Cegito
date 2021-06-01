package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import idl.Banco;

public class Client {
	
	private static Scanner scan = null;

	public static void main(String[] args){
		try {
			
			Registry registry = LocateRegistry.getRegistry(7778);
            Banco api = (Banco) registry.lookup("calcularCredito");
			
			scan = new Scanner(System.in);
			
			System.out.println("Cr�dito especial");				
			
			System.out.println("Digite o saldo m�dio do ultimo ano do cliente: ");			
			double saldoMedio = scan.nextDouble();
			
			double valorCredito = api.calcularCredito(saldoMedio);
			
			System.out.println("----------------------");
			System.out.println("O saldo m�dio do cliente � : " + saldoMedio);
			System.out.println("O cr�dito liberado para o cliente �: " + valorCredito);
			
		}	
		catch (Exception e) {		
			System.out.println("O Server n�o respondeu");
			e.printStackTrace();
		}
	}
}
