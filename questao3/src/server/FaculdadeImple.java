package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import idl.Faculdade;

public class FaculdadeImple implements Faculdade{

	@Override
	public boolean calcularMedia(double n1, double n2, double n3) throws RemoteException {
		double mediaN1eN2 = (n1 + n2) / 2;
		double mediaTotal = (n1 + n2 + n3) / 3; 	
		
		//media n1 e n2 >= 7
		if(mediaN1eN2 >= 7) { 
			return true;
		} else {
			//media n1, n2 e n3
			if(mediaN1eN2 > 3 & mediaN1eN2 < 7) {
				if(mediaTotal >= 5) {
					return true;
				}
			}
		}
		return false;
	} 
}
