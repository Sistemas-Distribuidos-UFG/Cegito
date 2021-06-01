package idl;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {
	public double calcularSalario(double salarioBruto, String nivel, Integer numeroDependentes) throws RemoteException;

}
