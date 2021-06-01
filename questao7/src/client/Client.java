package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import idl.Inss;

public class Client {
	
	private static Scanner scan = null;

	public static void main(String[] args){
		try {
			
			Registry registry = LocateRegistry.getRegistry(7776);
            Inss api = (Inss) registry.lookup("calcularAposentadoria");
			
			scan = new Scanner(System.in);
			
			System.out.println("Avaliar aposentadoria: ");				
			
			System.out.println("Digite a idade do funcion�rio: ");			
			Integer idade = scan.nextInt();
			
			System.out.println("Digite o tempo de servi�o do funcion�rio: ");			
			Integer tempoDeServico = scan.nextInt();
			
			boolean podeAposentar = api.calcularAposetadoria(idade, tempoDeServico);
			
			System.out.println("----------------------");
			if(podeAposentar) {
				System.out.println("O funcion�rio j� pode se aposentar!" );
			} else {
				System.out.println("O funcion�rio ainda n�o pode se aposentar!" );
			}
			
		}	
		catch (Exception e) {		
			System.out.println("O Server n�o respondeu");
			e.printStackTrace();
		}
	}
}
