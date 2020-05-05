package Servlet;


import Model.Color;
import Model.FloorType;
import controller.RoomController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;


public class RoomServlet extends HttpServlet {
    TemplateEngine engine;
    RoomController roomController;

    public RoomServlet(TemplateEngine engine, RoomController controller) {
        this.engine=engine;
        this.roomController=controller;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HashMap<String, Object> data = dataCreate("");
        engine.render("roomForm.ftl",data,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String width = req.getParameter("width");
        String height = req.getParameter("height");
        String floor_type = req.getParameter("floor_type");
        String color = req.getParameter("color");
        String worker_count = req.getParameter("worker_count");
        String salary_per_worker = req.getParameter("salary");

        String result = roomController.createRoom(width, height, floor_type, color, worker_count, salary_per_worker);
        HashMap<String, Object> data = dataCreate(result);

        engine.render("roomForm.ftl",data,resp);
    }

    private HashMap<String, Object> dataCreate(String message){
        HashMap<String, Object> data = new HashMap<>();
        data.put("floor_types",Arrays.stream(FloorType.values()).collect(Collectors.toList()));
        data.put("colors",Arrays.stream(Color.values()).collect(Collectors.toList()));
        data.put("message",message);
        return data;
    }
}
