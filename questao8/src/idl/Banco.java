package idl;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Banco extends Remote {
	public double calcularCredito(double saldoMedio) throws RemoteException;

}
