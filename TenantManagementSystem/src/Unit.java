import java.time.LocalDate;

public abstract class Unit {
    protected int unitID;
    private static int unitIDGenerator = 99;
    protected boolean isOccupied;
    protected double monthlyRent;
    protected double monthlyParkingFee;
    protected boolean isParkingNeeded;
    Tenant tenant;
    protected LocalDate occupancyDate;
    protected LocalDate releaseDate;

    public Unit(double monthlyRent, double monthlyParkingFee) {
        this.unitID = ++unitIDGenerator;
        this.isOccupied = false;
        this.monthlyRent = monthlyRent;
        this.monthlyParkingFee = monthlyParkingFee;
        this.isParkingNeeded = false;
    }

    public abstract void assignTenant(Tenant tenant, boolean parkingNeeded);

//    public void releaseTenant(Tenant tenant, boolean parkingNeeded) {
//        if(isOccupied){
//            System.out.println("Releasing tenant...");
//            this.tenant = null;
//            this.isOccupied = false;
//            this.isParkingNeeded = false;
//            this.releaseDate = LocalDate.now();
//            System.out.println("\nYou removed the tenant " + tenant.getTenantID() +"on "+ this.releaseDate +" successfully!");
//        }else {
//            System.out.println("Unit ID: " + unitID + " is already vacant.");
//        }
//    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\nUnit ID: " + unitID +
                    "\nIs Occupied: " + isOccupied +
                    "\nMonthly Rent: " + monthlyRent +
                    "\nParking Fee: " + monthlyParkingFee +
                    "\nIs Parking Needed: " + isParkingNeeded);

        if(tenant != null){
            sb.append("\nTenant: " + tenant.getTenantFirstName() + " "+ tenant.getTenantLastName() +
                    "\nTenant ID: " + tenant.getTenantID() +
                    "\nOccupancy Date: " + occupancyDate +
                    "\nRelease Date: " + releaseDate);
        }
        return sb.toString();
    }
}
