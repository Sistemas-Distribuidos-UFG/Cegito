package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import idl.Inss;

public class Server {

	public static void main(String[] args) {
		try {
			InssImple calculadoraImple = new InssImple();
			
			Inss stub = (Inss) UnicastRemoteObject.exportObject(calculadoraImple, 0);
			
			Registry registry = LocateRegistry.createRegistry(7776);
			
			registry.rebind("calcularAposentadoria", stub);
			
			System.out.println("Server Rodando e aguardando!");
		} catch (RemoteException e) {
			System.out.println("Ocorreu um erro no server");
			e.printStackTrace();
		}
	}
	
}
