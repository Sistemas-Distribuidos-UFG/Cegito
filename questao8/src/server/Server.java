package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import idl.Banco;

public class Server {

	public static void main(String[] args) {
		try {
			BancoImple bancoImple = new BancoImple();
			
			Banco stub = (Banco) UnicastRemoteObject.exportObject(bancoImple, 0);
			
			Registry registry = LocateRegistry.createRegistry(7778);
			
			registry.rebind("calcularCredito", stub);
			
			System.out.println("Server Rodando e aguardando!");
		} catch (RemoteException e) {
			System.out.println("Ocorreu um erro no server");
			e.printStackTrace();
		}
	}
	
}
