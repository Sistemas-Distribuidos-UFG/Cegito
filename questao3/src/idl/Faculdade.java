package idl;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Faculdade extends Remote {
	public boolean calcularMedia(double n1, double n2, double n3) throws RemoteException;

}
