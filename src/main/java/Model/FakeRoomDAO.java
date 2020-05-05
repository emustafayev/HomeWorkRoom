package Model;


import java.util.*;
import java.util.stream.Collectors;


public class FakeRoomDAO implements IRoom {
    private List<Room> rooms = new ArrayList<>();
    private List<Master> masters = Arrays.asList(new Master(200),new Master(250),new Master(230),new Master(220),new Master(240),
            new Master(230),new Master(240));
    private HashMap<Room,List<Master>> roomMaintenance = new HashMap<>();

    @Override
    public List<Room> getAllRooms() {
        return rooms;
    }


    @Override
    public Optional<Room> getRoom(int id) {
        throw new IllegalArgumentException("Not Implemented");
    }

    @Override
    public void addRoom(Room room,int worker_count, int salary) {
        addMasters(room,worker_count,salary);
        rooms.add(room);
    }

    private void addMasters(Room room, int worker_count, int salary) {
        List<Master> selectedMasters = this.masters.stream().filter(m -> m.getSalary() == salary).limit(worker_count).collect(Collectors.toList());
        this.roomMaintenance.put(room,selectedMasters);
    }

    @Override
    public void deleteRoom(Room room) {
        rooms.remove(room);
    }
}
