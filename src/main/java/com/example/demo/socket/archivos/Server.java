package com.example.demo.socket.archivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private final Integer PORT = 13;
	
	public Server() {
		Socket clientSocket;
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true){
				System.out.println("--------1 Iniciando server socket >> EMANUEL VILCHEZ -----");
				System.out.println("--------2 A la espera del clientSocket -----");
				
				clientSocket = serverSocket.accept();
				System.out.println("--------3 llego el clientSocket -----");
				

				File fileDestino = new File("C:\\server/JAVA-VILCHEZ-2.jpg");
				FileOutputStream fos = new FileOutputStream(fileDestino);
				DataInputStream entrada = new DataInputStream(clientSocket.getInputStream());
				
				int byeLeidos;
				while((byeLeidos = entrada.read())!=-1) {
					fos.write(byeLeidos);
				}
					
				fos.close();
				entrada.close();
				
				
				
				
				
				
				
				
				System.out.println("--------4 Finaliza la atencion clientSocket -----");
				clientSocket.close();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new Server();
	}
}
