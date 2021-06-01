package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import idl.Avaliador;

public class Client {
	
	private static Scanner scan = null;

	public static void main(String[] args){
		try {
			
			Registry registry = LocateRegistry.getRegistry(7774);
            Avaliador api = (Avaliador) registry.lookup("avaliarAtleta");
			
			scan = new Scanner(System.in);
			
			System.out.println("Avaliar categoria do nadador");				
			System.out.println("Digite a idade do nadador: ");			
			Integer idade = scan.nextInt();
			
			String categoria = api.avaliarAtleta(idade);
			
			System.out.println("----------------------");
			System.out.println("A categoria do nadador é: " + categoria);
			
		}	
		catch (Exception e) {		
			System.out.println("O Server não respondeu");
			e.printStackTrace();
		}
	}
}
