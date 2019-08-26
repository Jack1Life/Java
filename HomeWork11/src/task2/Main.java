package task2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static void task2(int port, SystemInf sys) {
		System.out.println("Wait for connection...");
		try (ServerSocket ss = new ServerSocket(port); Socket incoming = ss.accept()) {
			Scanner sc = new Scanner(incoming.getInputStream());
			PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);
			System.out.println("Client connected");
			System.out.println(incoming.getInetAddress().getHostAddress());
			while (true) {
				String line = sc.nextLine();
				out.println(sys.toString());
				out.println("Enter 'exit' for end of session");
				if (line.compareTo("exit") == 0) {
					break;
				}
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Connection is closed");
	}
	
	public static void main(String[] args) {
		SystemInf info = new SystemInf("Ubuntu 16.0", "2.4 GHz", "AMD", "Intel i3");
		task2(20000, info);
	}

}
