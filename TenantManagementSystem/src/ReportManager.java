import java.util.Enumeration;

public class ReportManager {
    private Unit[] units;
    private Tenant[] tenants;

    public ReportManager(Unit[] units, Tenant[] tenants){
        this.units = units;
        this.tenants = tenants;
    }

    public void generateOccupancyReport(){
        int occupied = 0;
        int vacant = 0;

        for(Unit unit : units){
            if(unit != null){
                if(unit.isOccupied){
                    occupied++;
                }
                else {
                    vacant++;
                }
            }
        }
        System.out.println("\n------------- OCCUPANCY REPORT -------------\n");
        System.out.printf("Total Units: %d\n", occupied + vacant);
        System.out.printf("\nOccupied Units: %d\n", occupied);
        System.out.printf("\nVacant Units: %d\n", vacant);
    }

    public void generateIncomeReport(){
        double totalIncome = 0;
        for(int i = 0; i < units.length; i++){
            if(units[i] != null && units[i].isOccupied){
                totalIncome += units[i].monthlyRent;
            }
        }
        System.out.println("\n------------- INCOME REPORT -------------");
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("-----------------------------------------\n");

    }
}
