package parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Parking {

    private Collection<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() + 1 <= this.capacity) {
            this.data.add(car);
        }
    }

    public Collection<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream().sorted((f, s) -> Integer.compare(s.getYear(), f.getYear())).findFirst().orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(c -> c.getModel().equals(model) && c.getManufacturer().equals(manufacturer)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:%n", this.type));
        if (!this.data.isEmpty()) {
            for (Car car : this.data) {
                sb.append(car.toString()).append(System.lineSeparator());
            }

        }
        return sb.toString().trim();
    }
}
