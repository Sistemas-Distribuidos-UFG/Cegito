package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import idl.Faculdade;

public class Client {
	
	private static Scanner scan = null;

	public static void main(String[] args){
		try {
			
			Registry registry = LocateRegistry.getRegistry(7772);
            Faculdade api = (Faculdade) registry.lookup("faculdade");
			
			scan = new Scanner(System.in);
			
			System.out.println("Cálculo de notas");				
			System.out.println("Entre com a N1 do aluno: ");			
			double n1 = scan.nextDouble();
			
			System.out.println("Entre com a N2 do aluno: ");			
			double n2 = scan.nextDouble();

			System.out.println("Entre com a N3 do aluno: ");			
			double n3 = scan.nextDouble();			
			
			Boolean resultado = api.calcularMedia(n1, n2, n3);
			
			System.out.println("----------------------");
			if(resultado) {
				System.out.println("O aluno foi aprovado!");
			} else {
				System.out.println("O aluno foi reprovado!");
			}
			
		}	
		catch (Exception e) {		
			System.out.println("O Server não respondeu");
			e.printStackTrace();
		}
	}
}
