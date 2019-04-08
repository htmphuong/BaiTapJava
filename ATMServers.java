package demo;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ATMServers {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new  ServerSocket(3102);
			Socket skServer = serverSocket.accept();
			System.out.println("Connected");
			//nhan du lieu ve
			DataInputStream inputServer = new DataInputStream(skServer.getInputStream());
			String id =inputServer.readLine();
			String tien = inputServer.readLine();			
			double sotien = Double.parseDouble(tien);
			System.out.println("tien la "+sotien);
			DBProcess db = new DBProcess();
			int i =db.changeTB("Insert into Account(Id,Balance) values ('"+id+"','"+sotien+"')");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
