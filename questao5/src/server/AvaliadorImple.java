package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import idl.Avaliador;

public class AvaliadorImple implements Avaliador{

	@Override
	public String avaliarAtleta(Integer idade) throws RemoteException {
		String categoria = new String();		
		
		if(idade < 5) {
			categoria = "ainda não se enquadra em nenhuma categoria";
		}
		
		if(idade >= 5 && idade <= 7) {
			categoria = "infantil A";
		}
		
		if(idade >= 8 && idade <= 10) {
			categoria = "infantil B";
		}
		
		if(idade >= 11 && idade <= 13) {
			categoria = "juvenil A";
		}
		
		if(idade >= 14 && idade <= 17) {
			categoria = "juvenil B";
		}
		
		if(idade >= 18) {
			categoria = "adulto";
		}
		
		return categoria;
	} 
}
