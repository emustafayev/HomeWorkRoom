import Servlet.RoomListServlet;
import Servlet.RoomServlet;
import Servlet.TemplateEngine;
import controller.RoomController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.io.IOException;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        TemplateEngine engine = new TemplateEngine("./src/main/java/Template");
        RoomController controller = new RoomController();

        handler.addServlet(new ServletHolder(new RoomServlet(engine,controller)),"/home/*");
        handler.addServlet(new ServletHolder(new RoomListServlet(engine,controller)),"/rooms/*");
        server.setHandler(handler);
        server.start();
        server.join();
        
    }
}
