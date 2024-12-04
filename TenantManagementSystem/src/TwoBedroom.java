import java.time.LocalDate;

public class TwoBedroom extends Unit{
    private Tenant tenant;
    public TwoBedroom() {
        super(1999,100);
    }
    @Override
    public void assignTenant(Tenant tenant, boolean parkingNeeded) {
        if(!isOccupied){
            this.tenant = tenant;
            this.isOccupied = true;
            this.isParkingNeeded = parkingNeeded;
            this.occupancyDate = LocalDate.now();
            System.out.println("You assigned the Two-Bedroom on "+ this.occupancyDate + " successfully!");
            if(parkingNeeded){
                double totalRent = monthlyRent + monthlyParkingFee;
                System.out.println("Total rent: " + totalRent + "\n");
            }else{
                System.out.println("Total rent: " + monthlyRent + "\n");
            }
        }else{
            System.out.println("\nThis unit is already occupied!");
        }
    }

    @Override
    public String toString() {
        return "\n----------- Two Bedroom -----------" +
                super.toString();
    }
}
