package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IRoom {
    List<Room> getAllRooms();
    void addRoom(Room room);
    Optional<Room> getRoom(int id);
}
