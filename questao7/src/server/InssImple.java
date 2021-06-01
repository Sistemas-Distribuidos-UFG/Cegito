package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import idl.Inss;

public class InssImple implements Inss{

	@Override
	public boolean calcularAposetadoria(Integer idade, Integer tempoDeServico) throws RemoteException {
		boolean podeAposentar = false;
		
		if (idade >= 65) {
			podeAposentar = true;
		}
		
		if (tempoDeServico >= 30) {
			podeAposentar = true;
		}
		
		if (idade >= 60 && tempoDeServico >= 25) {
			podeAposentar = true;
		}
		
		return podeAposentar;
	} 
}
