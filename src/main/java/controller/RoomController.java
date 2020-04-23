package controller;

import Model.Color;
import Model.FloorType;
import Model.Room;
import Model.RoomDAO;

import java.util.List;
import java.util.Optional;

public class RoomController {
    RoomDAO roomDAO = new RoomDAO();
    private final int priceForEachM2 =220;

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
            System.out.println(room);
            roomDAO.addRoom(room);
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
