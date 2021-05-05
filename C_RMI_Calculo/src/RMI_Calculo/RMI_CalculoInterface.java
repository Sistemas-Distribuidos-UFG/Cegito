package RMI_Calculo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_CalculoInterface extends Remote {
	public double CalculateReajustSalary(String name, String role, double salary) throws RemoteException;

	}


