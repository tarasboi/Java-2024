import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Клас для управління електроприладами у квартирі
 */
public class Apartment {
    private final List<ElectricalAppliance> appliances;

    public Apartment() {
        appliances = new ArrayList<>();
    }

    /**
     * Додає електроприлад до списку
     * @param appliance Електроприлад
     */
    public void addAppliance(ElectricalAppliance appliance) {
        appliances.add(appliance);
    }

    /**
     * Увімкнути всі прилади в розетку
     */
    public void plugInAll() {
        for (ElectricalAppliance appliance : appliances) {
            appliance.plugIn();
        }
    }

    /**
     * Підраховує загальну потужність увімкнених приладів
     * @return Загальна споживана потужність
     */
    public int calculateTotalPower() {
        int totalPower = 0;
        for (ElectricalAppliance appliance : appliances) {
            totalPower += appliance.getPower();
        }
        return totalPower;
    }

    /**
     * Сортує прилади за потужністю
     */
    public void sortAppliancesByPower() {
    appliances.sort(Comparator.comparingInt(ElectricalAppliance::getPower));
}

    /**
     * Знайти прилад у заданому діапазоні електромагнітного випромінювання
     * @param min мінімальний рівень випромінювання
     * @param max максимальний рівень випромінювання
     * @return Список приладів у заданому діапазоні
     */
    public List<ElectricalAppliance> findAppliancesByRadiation(int min, int max) {
        List<ElectricalAppliance> result = new ArrayList<>();
        for (ElectricalAppliance appliance : appliances) {
            int radiation = appliance.getElectromagneticRadiation();
            if (radiation >= min && radiation <= max) {
                result.add(appliance);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Electrical Applieance:\n");
        for (ElectricalAppliance appliance : appliances) {
            sb.append(appliance).append("\n");
        }
        return sb.toString();
    }
}
