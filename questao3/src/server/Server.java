package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import idl.Faculdade;

public class Server {

	public static void main(String[] args) {
		try {
			FaculdadeImple faculdadeImple = new FaculdadeImple();
			
			Faculdade stub = (Faculdade) UnicastRemoteObject.exportObject(faculdadeImple, 0);
			
			Registry registry = LocateRegistry.createRegistry(7772);
			
			registry.rebind("faculdade", stub);
			
			System.out.println("Server Rodando e aguardando!");
		} catch (RemoteException e) {
			System.out.println("Ocorreu um erro no server");
			e.printStackTrace();
		}
	}
	
}
