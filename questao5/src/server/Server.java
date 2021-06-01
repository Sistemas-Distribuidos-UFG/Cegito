package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import idl.Avaliador;

public class Server {

	public static void main(String[] args) {
		try {
			AvaliadorImple avaliadorImple = new AvaliadorImple();
			
			Avaliador stub = (Avaliador) UnicastRemoteObject.exportObject(avaliadorImple, 0);
			
			Registry registry = LocateRegistry.createRegistry(7774);
			
			registry.rebind("avaliarAtleta", stub);
			
			System.out.println("Server Rodando e aguardando!");
		} catch (RemoteException e) {
			System.out.println("Ocorreu um erro no server");
			e.printStackTrace();
		}
	}
	
}
