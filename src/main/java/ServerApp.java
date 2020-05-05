import Database.SQLServer;
import Servlet.RoomListServlet;
import Servlet.RoomServlet;
import Servlet.TemplateEngine;
import controller.RoomController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import java.sql.Connection;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        SQLServer SQLserver = new SQLServer();
        Connection conn = SQLserver.createConnection();

        TemplateEngine engine = new TemplateEngine("./src/main/java/Template");
        RoomController controller = new RoomController(conn);

        handler.addServlet(new ServletHolder(new RoomServlet(engine,controller)),"/home/*");
        handler.addServlet(new ServletHolder(new RoomListServlet(engine,controller)),"/rooms/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
