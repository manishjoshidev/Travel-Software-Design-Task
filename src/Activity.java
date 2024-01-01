import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private List<Passenger> passengers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger);
            System.out.println("Passenger " + passenger.getName() + " added to " + name);
        } else {
            System.out.println("Passenger capacity reached. Cannot add more passengers.");
        }
    }

    public void printItinerary() {
        System.out.println("Activity: " + name +
                ", Cost: " + cost +
                ", Capacity: " + capacity +
                ", Description: " + description);
    }
}
