package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import idl.Calculadora;

public class Client {
	
	private static Scanner scan = null;

	public static void main(String[] args){
		try {
			
			Registry registry = LocateRegistry.getRegistry(7775);
            Calculadora api = (Calculadora) registry.lookup("calculadoraSalario");
			
			scan = new Scanner(System.in);
			
			System.out.println("Calcular sal�rio do funcion�rio");				
			
			System.out.println("Digite o nome do funcion�rio: ");			
			String nome = scan.nextLine();
			
			System.out.println("Digite o n�vel do funcion�rio (A, B, C ou D): ");			
			String nivel = scan.nextLine();
			
			System.out.println("Digite o sal�rio bruto do funcion�rio: ");			
			double salarioBruto = scan.nextDouble();
			
			System.out.println("Digite o n�mero de dependentes do funcion�rio: ");			
			Integer numeroDependentes = scan.nextInt();
			
			double salarioLiquido = api.calcularSalario(salarioBruto, nivel, numeroDependentes);
			
			System.out.println("----------------------");
			System.out.println("Nome do funcio�rio: " + nome);
			System.out.println("N�vel do funcion�rio: " + nivel);
			System.out.println("O sal�rio liquido: " + salarioLiquido);
			
		}	
		catch (Exception e) {		
			System.out.println("O Server n�o respondeu");
			e.printStackTrace();
		}
	}
}
