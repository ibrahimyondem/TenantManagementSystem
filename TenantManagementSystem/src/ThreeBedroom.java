import java.time.LocalDate;

public class ThreeBedroom extends Unit{
    private Tenant tenant;

    public ThreeBedroom() {
        super(2699,100);
    }
    @Override
    public void assignTenant(Tenant tenant, boolean parkingNeeded) {
        if(!isOccupied){
            this.tenant = tenant;
            this.isOccupied = true;
            this.isParkingNeeded = parkingNeeded;
            this.occupancyDate = LocalDate.now();
            System.out.println("You assigned the Three-Bedroom on "+ this.occupancyDate + " successfully!");
            if(parkingNeeded){
                double totalRent = monthlyRent + monthlyParkingFee;
                System.out.println("Total rent: " + totalRent);
            }else{
                System.out.println("Total rent: " + monthlyRent);
            }
        }else{
            System.out.println("\nThis unit is already occupied!");
        }
    }

    @Override
    public String toString() {
        return "\n----------- Three Bedroom -----------" +
        super.toString();
    }
}