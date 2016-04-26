import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.http.HttpServlet;

/**
 * @author Fidelis.Guimaraes
 */
public class SocketServer extends HttpServlet {
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		listener();
	}
	
	public static void listener(){
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

				try{
				ObjectInputStream ois =
						new ObjectInputStream(cliente.getInputStream());

				while(true){
					try{
						Object data = ois.readObject();
						System.out.println("data: "+data.toString());
						
					}catch(EOFException e){
						System.out.println("no data 1");
						break;
					}catch(IOException | ClassNotFoundException e){
						System.out.println("no data 2");
						break;
					}
				
				}
				
				}catch(EOFException e){
					System.out.println("no data 3");
				}catch(IOException e){
					System.out.println("no data 4");
				}
				
				
			}
			
		} catch (StreamCorruptedException e){
			e.printStackTrace();
			System.out.println("Stream Inválida: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro na escuta: " + e.getCause());
		}

	}
}