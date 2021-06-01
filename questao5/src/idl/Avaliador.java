package idl;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Avaliador extends Remote {
	public String avaliarAtleta(Integer idade) throws RemoteException;

}
