
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Fidelis.Guimaraes
 *
 */
public class HelloWorkClientTCP {
	
	public static void main(String[] args) {
		Socket socket = null;
		Integer porta = Integer.valueOf(System.getenv("PORT") != null ? System.getenv("PORT") : "8000");
		
		try {
			String hostRemote = "http://herokuconcept.herokuapp.com";
			String hostLocal = "localhost";
			socket = new Socket(hostRemote, 80);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("teste client");
		} catch (UnknownHostException e) {
			System.out.println("UnknownHost: "+e.getMessage());
		}catch (EOFException e) {
			System.out.println("EOF: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("E/S: "+e.getMessage());
		}finally{
			if(socket != null){
				try{
					socket.close();
				}catch(IOException e){
					System.out.println("Close socket fail: "+e.getMessage());
				}
			}
		}
		
	}
	
	
}
