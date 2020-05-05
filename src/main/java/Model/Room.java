package Model;

public class Room {
    private final int area;
    private final FloorType floor;
    private final Color color;
    private final float price;
    private int ID;

    public Room(int area, FloorType floor, Color color, float calcPrice) {
        this.area  = area;
        this.floor = floor;
        this.color = color;
        this.price = calcPrice;
    }

    public Room(int id,int area, FloorType floor, Color color, float price) {
       this(area,floor,color,price);
        this.ID    = id;
    }



    public int getArea() {
        return area;
    }

    public String getFloor() {
        return floor.toString();
    }

    public String getColor() {
        return color.toString();
    }

    public int getID() {
        return ID;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room{"+"ID"+ID+
                "area=" + area +
                ", floor=" + floor +
                ", color=" + color +
                ", price=" + price +
                '}';
    }
}

