public class TenantManager {
    private final Tenant[] tenants;
    private final int maxTenants;
    private int numTenants = 0;
    private UnitManager unitManager;
    //Constructor
    public TenantManager(int maxTenants) {
        this.maxTenants = maxTenants;
        this.tenants = new Tenant[maxTenants];
    }

    public void setUnitManager(UnitManager unitManager) {
        this.unitManager = unitManager;
    }

    public boolean addTenant(Tenant tenant) {
        System.out.println("Attempting to add tenant: " + tenant.getTenantFirstName() + " " + tenant.getTenantLastName() + "...");
        if (numTenants < maxTenants) {
            for (int i = 0; i < numTenants; i++) {
                if (tenants[i].getTenantFirstName().equals(tenant.getTenantFirstName()) &&
                        tenants[i].getTenantLastName().equals(tenant.getTenantLastName()) &&
                        tenants[i].getTenantEmail().equals(tenant.getTenantEmail())) {
                    System.out.println("\nTenant with provided full name and email already exists!");
                    return false;
                }
            }
            tenants[numTenants] = tenant;
            numTenants++;
            System.out.println("Tenant has been added successfully!\n");
            return true;
        } else {
            System.out.println("\nThere is no more space in the building!");
            return false;
        }
    }

    public boolean addTenant(String tenantFirstName, String tenantLastName, int tenantAge, String tenantEmail, String tenantPhone, boolean hasPets, boolean isParkingNeeded) {
        Tenant newTenant = new Tenant(tenantFirstName, tenantLastName, tenantAge, tenantEmail, tenantPhone, hasPets, isParkingNeeded);
        return addTenant(newTenant);
    }

    public boolean removeTenant(int tenantID){
        if(numTenants == 0){
            System.out.println("\nThere aren't any tenants to remove!");
            return false;
        }

        if(unitManager.getUnitIDByTenantID(tenantID) != -1){
            System.out.println("You can't remove a tenant who is already assigned to a unit...\n" +
                    "Release the tenant first!\n");
            return false;
        }
        //Checking to see if a tenant is assigned to a unit
        // If tenant is assigned you can't remove the tenant unless you uMan.releaseTenantFromUnit();
//        for(int i = 0; i <numTenants; i++){
//            if(tenants[i] != null && tenants[i].getTenantID() == tenantID){
//                System.out.println("You can't remove a tenant who is already assigned to a unit...\n" +
//                        "Release the tenant first!");
//                return false;
//            }
//        }
        //Remove the tenant if not assigned to a unit
        for(int i = 0; i < numTenants; i++){
            if(tenants[i] != null && tenants[i].getTenantID() == tenantID){
                for (int j = i; j < numTenants - 1; j++) {
                    tenants[j] = tenants[j + 1];
                }
                tenants[numTenants - 1] = null;
                numTenants--;
                System.out.println("\nTenant has been removed successfully!\n");
                return true;
                }
        }
        System.out.println("\nTenant  with ID: " + tenantID + " hasn't been found!");
        return false;
    }


    public String getAllTenantDetails(){
        if(numTenants== 0){
                return "\nThere aren't any Tenants!";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n--------------------- ALL OF THE TENANTS ---------------------");
        for(int i = 0; i < numTenants; i++){
            sb.append(tenants[i].toString()).append("\n");
        }
        return (sb.toString());
    }

    public void printAllTenants(){
        System.out.println(getAllTenantDetails());
    }

    public boolean searchTenantByID(int tenantID) {
        if(numTenants == 0){
            System.out.println("\nThere aren't any tenants to search!");
        }
        for (int i = 0; i < numTenants; i++) {
            if (tenants[i] != null && tenants[i].getTenantID() == tenantID) {
                System.out.println("\nTenant ID: " + tenantID + " is found:");
                System.out.println(tenants[i].toString());
                return true;
            }
        }
        System.out.printf("\nTenant with ID %d is not found!%n",tenantID);
        return false;
    }

    public boolean searchTenantByName(String tenantName){
        if(numTenants == 0){
            System.out.println("\nThere aren't any tenants to search!");
            return false;
        }
        String lowerTypeName = tenantName.toLowerCase();
        boolean foundName = false;

            for(int i = 0; i < numTenants; i++){
                if(tenants[i] != null && tenants[i].getTenantFirstName().toLowerCase().equals(lowerTypeName)){
                    System.out.println("\nTenant Information: " + tenants[i].toString() + "\n");
                    foundName = true;
            }
        }
        if(!foundName){
            System.out.println("\nThere aren't any tenants named: " + tenantName + "\n");
            return false;
        }
        return true;
    }



    public Tenant[] getAllTenants(){
        return tenants;
    }
}
