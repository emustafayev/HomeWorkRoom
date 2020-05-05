package Model;

import java.util.UUID;

public class Master {
    private final UUID ID;
    private final int salary;


    public Master(int salary) {
        ID = UUID.randomUUID();
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public UUID getID() {
        return ID;
    }
}
