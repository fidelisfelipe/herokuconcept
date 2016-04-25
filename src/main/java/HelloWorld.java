import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
/**
 * @author Fidelis.Guimaraes
 */
public class HelloWorld extends HttpServlet {
	
	 /**
	 * UID
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		resp.getWriter().print("Hello Heroku from Java Get!\n");
	 }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("Hello Heroku from Java Post!\n");
	}
	
	 public static void main(String[] args) throws Exception{
		//Criando Server Jetty embarcado
		//
		//Toda aplicação web no Heroku deve escutar a porta declarada na variável de ambiente PORT
		//porque não temos como saber em tempo de desenvolvimento qual porta que o dyno criará para a aplicação
		//pois esta porta é gerada randomicamente pelo Heroku a cara restart
		//localmente usa-se por padrão a porta 5000
		Server server = new Server(Integer.valueOf(System.getenv("PORT") != null ? System.getenv("PORT") : "8000"));
		//criando contexto de servlet incluindo servlet
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		
		context.setContextPath("/");
		server.setHandler(context);
		//mapeamento do servlet no jetty capturando todas as requisições
		context.addServlet(new ServletHolder(new HelloWorld()),"/*");
		
		//inicio do servidor, por ser uma aplicação autosuficiente(pre-requisito do Heroku)
		//a própria aplicação é um container e assim adicionamos nela o servlet
		server.start();
		server.join();
	 }
}