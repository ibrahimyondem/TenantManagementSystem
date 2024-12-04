public class Tenant {
    private String tenantFirstName;
    private String tenantLastName;
    private String tenantEmail;
    private String tenantPhone;
    private final int tenantID;
    private static int idGenerator = 999;
    private int tenantAge;
    private boolean hasPets;
    private boolean parkingNeeded;
    private UnitManager unitManager;

    public Tenant(String tenantFirstName, String tenantLastName, int tenantAge, String tenantEmail, String tenantPhone, boolean hasPets, boolean parkingNeeded) {
        this.tenantFirstName = tenantFirstName;
        this.tenantLastName = tenantLastName;
        this.tenantAge = tenantAge;
        this.tenantEmail = tenantEmail;
        this.tenantPhone = tenantPhone;
        this.hasPets = hasPets;
        this.parkingNeeded = parkingNeeded;
        tenantID = ++idGenerator;
    }

    public String getTenantFirstName() {
        return tenantFirstName;
    }

    public void setTenantFirstName(String tenantFirstName) {
        this.tenantFirstName = tenantFirstName;
    }

    public String getTenantLastName() {
        return tenantLastName;
    }

    public void setTenantLastName(String tenantLastName) {
        this.tenantLastName = tenantLastName;
    }

    public String getTenantPhone() {
        return tenantPhone;
    }

    public void setTenantPhone(String tenantPhone) {
        this.tenantPhone = tenantPhone;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public int getTenantID() {
        return tenantID;
    }

    public int getTenantAge() {
        return tenantAge;
    }

    public void setTenantAge(int tenantAge) {
        if(tenantAge < 0 || tenantAge > 120) {
            System.out.println("Invalid Age!");
        }else{
            this.tenantAge = tenantAge;
        }
    }

    public boolean hasPets() {
        return hasPets;
    }

    public void setHasPets(boolean hasPets) {
        this.hasPets = hasPets;
    }

    public boolean isParkingNeeded() {
        return parkingNeeded;
    }

    public void setParkingNeeded(boolean parkingNeeded) {
        this.parkingNeeded = parkingNeeded;
    }

    @Override
    public String toString() {
        return "\nFirst Name: " + tenantFirstName +
                "\nLast Name: " + tenantLastName +
                "\nEmail: " + tenantEmail +
                "\nPhone Number: " + tenantPhone +
                "\nID: " + tenantID +
                "\nAge: " + tenantAge +
                "\nOwn any Pets: " + hasPets;
    }
}
