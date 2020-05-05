package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RoomDAO implements IRoom{
    private final Connection conn;

    public RoomDAO(Connection conn) {
        this.conn=conn;
    }

    @Override
    public List<Room> getAllRooms() {
        try {
            List<Room> rooms = new ArrayList<>();
            String SQL = "SELECT  RoomID, area, floor, color, price FROM mpl2task.Room";
            PreparedStatement statement = conn.prepareStatement(SQL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int roomID = resultSet.getInt("RoomID");
                int area = resultSet.getInt("area");
                FloorType floor = FloorType.valueOf(resultSet.getString("floor"));
                Color color = Color.valueOf(resultSet.getString("color"));
                float price = resultSet.getFloat("price");
                Room room = new Room(roomID, area, floor, color, price);
                rooms.add(room);
            }
            return rooms;
        }catch (SQLException e) {
            throw new RuntimeException("There is a problem with SQL Server!");
        }
    }


    @Override
    public Optional<Room> getRoom(int id) {
        throw new IllegalArgumentException("Not Implemented");
    }

    @Override
    public void addRoom(Room room, int worker_count, int salary) {
        int addedRoomID = addRoomExplicitly(room);
        List<Integer> masterID = addMastersExplicitily(worker_count,salary);
        IntStream.range(0,masterID.size()).forEach(i->{
            try {
                String SQL = "INSERT INTO mpl2task.roommaintenance(room,master) VALUES(?,?)";
                PreparedStatement statement = conn.prepareStatement(SQL);
                statement.setInt(1,addedRoomID);
                statement.setInt(2,masterID.get(i));
                int i1 = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("SQL syntax error(roomMaintenance)!");
            }
        });
    }

    private List<Integer> addMastersExplicitily(int worker_count, int salary) {
        return IntStream.range(0,worker_count).map(i->{
            try {
                String SQL = "INSERT INTO mpl2task.master(salary) VALUES(?)";
                PreparedStatement statement = conn.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1,salary);
                statement.executeUpdate();
                ResultSet result = statement.getGeneratedKeys();
                if (result.next()){
                    return result.getInt(1);
                }else throw new RuntimeException("Generated key of master error!");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Statement error!");
            }
        }).boxed().collect(Collectors.toList());
    }

    private int addRoomExplicitly(Room room) {
        try{
            String SQL = "INSERT INTO mpl2task.Room (area, floor, color, price) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,room.getArea());
            statement.setString(2, room.getFloor());
            statement.setString(3,room.getColor());
            statement.setDouble(4,room.getPrice());

            int i = statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()){
                return generatedKeys.getInt(1);
            }else throw new RuntimeException("Cant get the generated key");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sql statement error!");
        }
    }

    @Override
    public void deleteRoom(Room room) {
        throw new IllegalArgumentException("Not impl");
    }

}

