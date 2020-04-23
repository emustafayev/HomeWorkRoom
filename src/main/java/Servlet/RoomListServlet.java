package Servlet;

import controller.RoomController;
import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RoomListServlet extends HttpServlet {
    private TemplateEngine engine;
    private RoomController roomController;
    public RoomListServlet(TemplateEngine engine, RoomController controller) {
        this.engine=engine;
        this.roomController=controller;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        data.put("rooms",roomController.getRooms());
        engine.render("roomList.ftl",data,resp);
    }
}
