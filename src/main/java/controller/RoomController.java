package controller;

import Model.*;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class RoomController {
    private FakeRoomDAO fakeRoomDAO;
    private RoomDAO roomDAO;
    private final int priceForEachM2 =220;


    public RoomController(Connection conn) {
        fakeRoomDAO=new FakeRoomDAO();
        roomDAO = new RoomDAO(conn);
    }

    public String createRoom(String width, String length, String floor_type, String color_type,String workerCount,String salary){
        String res;
        try {
            FloorType floor = FloorType.valueOf(floor_type);
            Color color = Color.valueOf(color_type);
            int widthR = toInt(width);
            int lengthR = toInt(length);
            int worker_countR = toInt(workerCount);
            int salaryR = toInt(salary);
            int area = area(widthR,lengthR);
            Room room = new Room(area,floor,color,calcPrice(area,floor,color,worker_countR,salaryR));
            roomDAO.addRoom(room, worker_countR, salaryR);
            res = "Object created!";
        }catch (NumberFormatException e){
            res = "Number is Not correct format!";
        }catch (Exception e){
            e.printStackTrace();
            res = "Something went wrong!";
        }
        return res;
    }

    private int toInt(String integer) {
        return Integer.parseInt(integer);
    }


    private float calcPrice(int area,FloorType floor, Color color,int workerCount, int salary){
        return area* priceForEachM2
                +floor.getPrice()
                +color.getPrice()
                +workerCount*salary;
    }

    private int area(int width,int length){
        return width*length;
    }

    public List<Room> getRooms(){
        return roomDAO.getAllRooms();
    }
}
