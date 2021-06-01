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
			
			System.out.println("Calcular salário do funcionário");				
			
			System.out.println("Digite o nome do funcionário: ");			
			String nome = scan.nextLine();
			
			System.out.println("Digite o nível do funcionário (A, B, C ou D): ");			
			String nivel = scan.nextLine();
			
			System.out.println("Digite o salário bruto do funcionário: ");			
			double salarioBruto = scan.nextDouble();
			
			System.out.println("Digite o número de dependentes do funcionário: ");			
			Integer numeroDependentes = scan.nextInt();
			
			double salarioLiquido = api.calcularSalario(salarioBruto, nivel, numeroDependentes);
			
			System.out.println("----------------------");
			System.out.println("Nome do funcioário: " + nome);
			System.out.println("Nível do funcionário: " + nivel);
			System.out.println("O salário liquido: " + salarioLiquido);
			
		}	
		catch (Exception e) {		
			System.out.println("O Server não respondeu");
			e.printStackTrace();
		}
	}
}
