package idl;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Inss extends Remote {
	public boolean calcularAposetadoria(Integer idade, Integer tempoDeServico) throws RemoteException;

}
