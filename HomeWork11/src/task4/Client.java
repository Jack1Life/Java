package task4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{
	private Socket client;
	private String baseAnswer;
	private Thread myThread;
	
	public Client(Socket client, String baseAnswer) {
		super();
		this.client = client;
		this.baseAnswer = baseAnswer;
		this.myThread = new Thread(this);
		myThread.start();
	}

	public void run() {
		try(InputStream is = client.getInputStream(); OutputStream os = client.getOutputStream()){
			PrintWriter pw = new PrintWriter(os);
			while(!client.isClosed()) {
				if(is.available() > 0) {
					byte[] reqest = new byte[is.available()];
					is.read(reqest);
					System.out.println(new String(reqest));
					pw.print(baseAnswer);
					pw.flush();
				}
			}
			System.out.println("Conection closed.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
