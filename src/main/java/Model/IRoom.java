package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IRoom {
    List<Room> getAllRooms();
    Optional<Room> getRoom(int id);
    void addRoom(Room room,int worker_count, int salary);
    void deleteRoom(Room room);
}
