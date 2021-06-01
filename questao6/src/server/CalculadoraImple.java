package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import idl.Calculadora;

public class CalculadoraImple implements Calculadora{

	@Override
	public double calcularSalario(double salarioBruto, String nivel, Integer numeroDependentes) throws RemoteException {	
		double salarioLiquido = 0;
	
		switch (nivel) {
		case "A":
			if(numeroDependentes > 0) {
				salarioLiquido = salarioBruto - (salarioBruto * 0.08);
			} else {
				salarioLiquido = salarioBruto - (salarioBruto * 0.03);
			}			
			break;
		
		case "B":
			if(numeroDependentes > 0) {
				salarioLiquido = salarioBruto - (salarioBruto * 0.10);
			} else {
				salarioLiquido = salarioBruto - (salarioBruto * 0.05);
			}
			break;
			
		case "C":
			if(numeroDependentes > 0) {
				salarioLiquido = salarioBruto - (salarioBruto * 0.15);
			} else {
				salarioLiquido = salarioBruto - (salarioBruto * 0.08);
			}
			break;
			
		case "D":
			if(numeroDependentes > 0) {
				salarioLiquido = salarioBruto - (salarioBruto * 0.17);
			} else {
				salarioLiquido = salarioBruto - (salarioBruto * 0.10);
			}
			break;	
		}
		
		return salarioLiquido;
	} 
}
