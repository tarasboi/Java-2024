import java.util.Arrays;
import java.util.Comparator;

/**
 * Клас, що описує літак.
 */
class Airplane {
    private final String model;  // Модель літака
    private final int year;      // Рік випуску
    private final double wingspan; // Розмах крил
    private final int passengers; // Кількість пасажирів
    private final double maxSpeed; // Максимальна швидкість

    public Airplane(String model, int year, double wingspan, int passengers, double maxSpeed) {
        this.model = model;
        this.year = year;
        this.wingspan = wingspan;
        this.passengers = passengers;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getWingspan() {
        return wingspan;
    }

    public int getPassengers() {
        return passengers;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Airplane)) return false;
        Airplane other = (Airplane) obj;
        return model.equals(other.model) && year == other.year;
    }

    @Override
    public String toString() {
        return String.format("Model: %s, Year: %d, Wingspan: %.2f, Passengers: %d, Max Speed: %.2f",
                model, year, wingspan, passengers, maxSpeed);
    }
}

/**
 * Виконавчий клас з методом main.
 */
public class AirplaneSorter {
    public static void main(String[] args) {
        // Створення масиву літаків
        Airplane[] airplanes = {
            new Airplane("Boeing 747", 2005, 68.4, 416, 988.0),
            new Airplane("Airbus A380", 2007, 79.7, 555, 1020.0),
            new Airplane("Cessna 172", 1955, 11.0, 4, 226.0),
            new Airplane("Piper PA-28", 1960, 10.0, 4, 140.0),
            new Airplane("Boeing 737", 1997, 34.3, 130, 876.0)
        };

        // Сортування за роком випуску (зростання)
        Arrays.sort(airplanes, Comparator.comparingInt(Airplane::getYear));
        System.out.println("Сортовані літаки за роком випуску (зростання):");
        Arrays.stream(airplanes).forEach(System.out::println);

        // Сортування за максимальнoю швидкістю (спадання)
        Arrays.sort(airplanes, Comparator.comparingDouble(Airplane::getMaxSpeed).reversed());
        System.out.println("\nСортовані літаки за максимальною швидкістю (спадання):");
        Arrays.stream(airplanes).forEach(System.out::println);

        // Знайти ідентичний літак
        Airplane searchAirplane = new Airplane("Boeing 747", 2005, 0, 0, 0);
        boolean found = Arrays.stream(airplanes).anyMatch(a -> a.equals(searchAirplane));
        System.out.println("\nЛітак знайдено: " + found);
    }
}
