import java.time.LocalDate;

public class UnitManager{
    private int maxUnits;
    private int numUnits = 0;
    private Unit[] units;
    private TenantManager tenantManager;

    public UnitManager(int maxUnits,TenantManager tenantManager){
        this.maxUnits = maxUnits;
        this.units = new Unit[maxUnits];
        this.tenantManager = tenantManager;
    }

    public boolean addUnit(Unit unit){
        if(numUnits < maxUnits){
            units[numUnits] = unit;
            numUnits++;
            System.out.println("\nUnit added successfully!");
            return true;
        }else{
            System.out.println("\nNo more space for additional units!");
            return false;
        }
    }

    public void addOneBedroomUnit(){
        addUnit(new OneBedroom());
    }

    public void addTwoBedroomUnit(){
        addUnit(new TwoBedroom());
    }

    public void addThreeBedroomUnit(){
        addUnit(new ThreeBedroom());
    }

    public boolean assignTenantToUnit(int unitID, Tenant tenant){
        //Checking if the tenant is already assigned to a unit.
            for(int i = 0; i <numUnits; i++){
            if(units[i].tenant != null && units[i].tenant.getTenantID() == tenant.getTenantID()){
                System.out.println("The tenant is already assigned to unit: " + getUnitIDByTenantID(tenant.getTenantID()));
                        return false;
            }
        }
//            boolean unitFound = false;
        for(int i = 0; i < numUnits; i++){
            if(units[i].unitID == unitID){
                if(!units[i].isOccupied){
                    System.out.println("\nAssigned tenant: " + tenant.getTenantFirstName() + " " + tenant.getTenantLastName() + "(" + tenant.getTenantID() + ")" + " to unit: " + units[i].unitID);
//                    boolean parkingNeeded = tenant.isParkingNeeded();
                    units[i].assignTenant(tenant, tenant.isParkingNeeded());
                    units[i].tenant = tenant;
//                    tenantManager.addTenant(tenant);
                    units[i].isOccupied = true;
                    return true;
                }else{
                    System.out.println("Unit ID: " + unitID + " is already occupied/assigned!");
                    return false;
                }
            }
        }
        System.out.println("\nUnit with ID " + unitID + " is not found ");
        return false;
    }

    public boolean releaseTenantFromUnit(int unitID, Tenant tenant){
        //Check if a tenant is assigned to any unit
        Unit unit = getUnitByID(unitID);
        if(unit == null){
            System.out.println("Unit with ID: " + unitID + " does not exist.");
            return false;
        }
        if(unit.tenant == null || unit.tenant.getTenantID() != tenant.getTenantID()){
            System.out.println("The tenant " + tenant.getTenantFirstName() + " " + tenant.getTenantLastName() +
                    " is not assigned to Unit: " + unitID + "!");
            return false;
        }
        //Ensure the tenant is assigned to the correct unit
        unit.isOccupied = false;
        unit.tenant = null;
        unit.isParkingNeeded = false;
        unit.releaseDate = LocalDate.now();

        System.out.println("\nYou released the tenant " + tenant.getTenantFirstName() + " " + tenant.getTenantLastName() +
                " (" + tenant.getTenantID() + ") from Unit " + unitID + " on " + unit.releaseDate + " successfully!");
        return true;
    }

        //INSTEAD OF THIS CODE I Added a getUnitByID method to increase efficiency but works too
//        for(int i = 0; i <numUnits; i++){
//            if(units[i].tenant != null && units[i].tenant.getTenantID() == tenant.getTenantID()){
//                    units[i].isOccupied = false;
//                    units[i].tenant = null;
//                    units[i].isParkingNeeded =false;
//                    units[i].releaseDate = LocalDate.now();
//                    System.out.println("\nYou released the tenant " + tenant.getTenantFirstName() + " " + tenant.getTenantLastName() +  "(" + tenant.getTenantID() + ")" + " from unit " + unitID + " on "+ units[i].releaseDate +" successfully!");
//                    return true;
//            }
//        }

//        Unit unit = getUnitByID(assignedUnitID);
//        if(unit == null && unit.tenant != null && unit.tenant.getTenantID() == tenant.getTenantID()){
//            unit.isOccupied = false;
//            unit.isParkingNeeded = false;
//            unit.tenant = null;
//            unit.releaseDate = LocalDate.now();
//            System.out.println("\nYou released the tenant " + tenant.getTenantFirstName() + " " + tenant.getTenantLastName() +  "(" + tenant.getTenantID() + ")" + " from unit " + unitID + " on "+ unit.releaseDate +" successfully!");
//            return true;
//        }
//        System.out.println("\nThe tenant isn't assigned to this unit!");
//        return false;
//    }

    public int getUnitIDByTenantID(int tenantID) {
        for(int i = 0; i < numUnits; i++){
            if(units[i].tenant != null && units[i].tenant.getTenantID() == tenantID){
                return units[i].unitID;
            }
        }
        // Tenant isn't assigned to this unit
        return -1;
    }

    public Unit getUnitByID(int unitID) {
        for(int i = 0; i < numUnits; i++){
            if(units[i].unitID == unitID){
                return units[i];
            }
        }
        return null;
    }

    public void viewAllUnits(){
        if(numUnits == 0){
            System.out.println("\nThere aren't any units!");
        }else{
            StringBuilder sb = new StringBuilder("\n------------- All Units -------------\n");
            for(int i = 0; i < numUnits; i++){
                sb.append(units[i].toString()).append("\n");
            }
            System.out.println(sb.toString());
        }
    }

    public void getAvailableUnits() {
        if(numUnits == 0){
            System.out.println("\nThere aren't any units!");
        }
        else{
            StringBuilder sb = new StringBuilder("\n------------- Available Units -------------\n");
            for (int i = 0; i < numUnits; i++) {
                if (!units[i].isOccupied) {
                    sb.append(units[i].toString()).append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public void getOccupiedUnits() {
        if(numUnits == 0){
            System.out.println("\nThere aren't any units!");
        }else{
            StringBuilder sb = new StringBuilder("\n------------- Occupied Units -------------\n");
            boolean foundOccupied = false;
            for(int i = 0; i < numUnits; i++){
                if (units[i].isOccupied) {
                    sb.append(units[i].toString()).append("\n");
                    foundOccupied = true;
                }
            }
            if(!foundOccupied){
                System.out.println("\nNo units are currently occupied!");
            }
            System.out.println(sb.toString());
        }
    }

    public int getNumUnits(){
        return numUnits;
    }

    // For printing purposes:
    public void printAvailableUnits(){
        getAvailableUnits();
    }

    public void printAllUnits(){
        viewAllUnits();
    }

    public void printOccupiedUnits(){
        getOccupiedUnits();
    }

    public Unit[] getAllUnits(){
        return units;
    }
}

