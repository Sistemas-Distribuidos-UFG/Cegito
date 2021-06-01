package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import idl.Calculadora;

public class Server {

	public static void main(String[] args) {
		try {
			CalculadoraImple calculadoraImple = new CalculadoraImple();
			
			Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(calculadoraImple, 0);
			
			Registry registry = LocateRegistry.createRegistry(7775);
			
			registry.rebind("calculadoraSalario", stub);
			
			System.out.println("Server Rodando e aguardando!");
		} catch (RemoteException e) {
			System.out.println("Ocorreu um erro no server");
			e.printStackTrace();
		}
	}
	
}
