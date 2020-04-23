package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomDAO implements IRoom {
    private List<Room> rooms = new ArrayList<>();

    @Override
    public List<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public Optional<Room> getRoom(int id) {
        return rooms.stream().filter(r ->
                r.getID()==id)
                .findAny();
    }


}
