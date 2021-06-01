package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import idl.Banco;

public class BancoImple implements Banco{

	@Override
	public double calcularCredito(double saldoMedio) throws RemoteException {
		double credito = 0;
		
		if(saldoMedio > 0 && saldoMedio <= 200) {
			credito = 0;
		} else if (saldoMedio >= 201 && saldoMedio <= 400) {
			credito = (saldoMedio * 0.2);
		} else if (saldoMedio >= 401 && saldoMedio <= 600) {
			credito = (saldoMedio * 0.3);
		} else if (saldoMedio > 601) {
			credito = (saldoMedio * 0.4);
		}
		
		return credito;
	} 
}
