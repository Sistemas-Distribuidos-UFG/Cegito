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
			
			System.out.println("Crédito especial");				
			
			System.out.println("Digite o saldo médio do ultimo ano do cliente: ");			
			double saldoMedio = scan.nextDouble();
			
			double valorCredito = api.calcularCredito(saldoMedio);
			
			System.out.println("----------------------");
			System.out.println("O saldo médio do cliente é : " + saldoMedio);
			System.out.println("O crédito liberado para o cliente é: " + valorCredito);
			
		}	
		catch (Exception e) {		
			System.out.println("O Server não respondeu");
			e.printStackTrace();
		}
	}
}
