package RMI_Calculo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;





public class RMI_CalculoServer extends UnicastRemoteObject implements RMI_CalculoInterface {
	
	protected RMI_CalculoServer() throws RemoteException {
		super();
		
	}

	public static void main(String[] args) {
        try {
            RMI_CalculoQuestao questao = new RMI_CalculoQuestao();

            RMI_CalculoInterface stub = (RMI_CalculoInterface) UnicastRemoteObject.exportObject(questao, 0);

            Registry registry = LocateRegistry.createRegistry(7777);

            registry.rebind("RMIQuestao", stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

	@Override
	public double CalculateReajustSalary(String name, String role, double salary) throws RemoteException {
		 try {
	            //System.setSecurityManager(new RMISecurityManager());
	            Registry registry = LocateRegistry.getRegistry(55553);
	            RMI_CalculoInterface stub = (RMI_CalculoInterface) registry.lookup("Questão");

	            double salaryReajusted1 = stub.CalculateReajustSalary("Gislainy", "Developer", 5000);
	            double salaryReajusted2 = stub.CalculateReajustSalary("Pabllo", "Operator", 3000);

	            System.out.printf("Gislainy adjusted salary is %.2f\n", salaryReajusted1);
	            System.out.printf("Pabllo adjusted salary is %.2f\n", salaryReajusted2);

	        } catch (RemoteException | NotBoundException e) {
	            e.printStackTrace();
	        }
		return salary;

	    }
	}

	

