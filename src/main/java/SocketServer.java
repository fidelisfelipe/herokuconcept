import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Fidelis.Guimaraes
 */
public class SocketServer extends HttpServlet{

	public void init() {
		Integer porta = Integer.valueOf(System.getenv("PORT") != null ? System.getenv("PORT") : "8000");

		ServerSocket escuta = null;
		try {
			escuta = new ServerSocket(porta);
		} catch (IOException e1) {
			System.out.println("Fail init ServerSocket: "+e1.getMessage());
		}
		System.out.println("***Init Server ***");
		System.out.println("*** Listen): " + porta);
		try {
			while (true) {
				Socket cliente = escuta.accept();
				System.out.println("*** conexao aceita de (remoto): " + cliente.getRemoteSocketAddress());
				ObjectInputStream ois =
						new ObjectInputStream(cliente.getInputStream());
				
				while(true){
					try{
						String data = ois.readObject().toString();
						System.out.println("data: "+data);
						
					}catch(IOException | ClassNotFoundException e){
						break;
					}
				
				}
				
			}

		} catch (IOException e) {
			System.out.println("Erro na escuta: " + e.getMessage());
		}

	}
}