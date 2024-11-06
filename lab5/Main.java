public class Main {
    public static void main(String[] args) {
        try {
            Apartment apartment = new Apartment();

            // Додаємо прилади
            apartment.addAppliance(new WashingMachine("Washing Mashine", 2000, 30));
            apartment.addAppliance(new Refrigerator("Refrigerator", 150, 15));
            apartment.addAppliance(new Microwave("Microwave", 800, 50));
            apartment.addAppliance(new Toaster("Toaster", 200000, 0));


            // Увімкнути прилади в розетку
            apartment.plugInAll();

            // Підрахувати загальну споживану потужність
            System.out.println("Total consumption: " + apartment.calculateTotalPower() + "W");

            // Сортувати прилади за потужністю
            apartment.sortAppliancesByPower();
            System.out.println("Appliances sorted by power (ascending):");
            System.out.println(apartment);

            // Знайти прилади з рівнем випромінювання між 10 та 40 мкТл
            System.out.println("Consumption from 10 to 40 uT:");
            for (ElectricalAppliance appliance : apartment.findAppliancesByRadiation(10, 40)) {
                System.out.println(appliance);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
