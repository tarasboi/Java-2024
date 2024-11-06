/**
 * Базовий клас для електроприладів
 */
public abstract class ElectricalAppliance {
    protected String name;
    protected int power; // потужність в ватах
    protected boolean isPluggedIn;
    protected int electromagneticRadiation; // рівень випромінювання 

    /**
     * Конструктор для класу ElectricalAppliance
     * @param name Назва приладу
     * @param power Потужність приладу
     * @param electromagneticRadiation Рівень електромагнітного випромінювання
     */
    public ElectricalAppliance(String name, int power, int electromagneticRadiation) {
        this.name = name;
        this.power = power;
        this.electromagneticRadiation = electromagneticRadiation;
        this.isPluggedIn = false;
    }

    /**
     * Увімкнути прилад в розетку
     */
    public void plugIn() {
        isPluggedIn = true;
    }

    /**
     * Вимкнути прилад з розетки
     */
    public void unplug() {
        isPluggedIn = false;
    }

    public int getPower() {
        return isPluggedIn ? power : 0;
    }

    public int getElectromagneticRadiation() {
        return electromagneticRadiation;
    }

    @Override
    public String toString() {
        return name + " (Power: " + power + "W, Emission: " + electromagneticRadiation + " uT)";
    }
}
