public class Coordinator {
    private final UnitManager unitManager;
    private final TenantManager tenantManager;
    private final ReportManager reportManager;
    private final NotificationManager notificationManager;

    public Coordinator(int maxUnit, int maxTenant) {
        this.tenantManager = new TenantManager(maxTenant);
        this.unitManager = new UnitManager(maxUnit, tenantManager);
        this.tenantManager.setUnitManager(unitManager);
        this.reportManager = new ReportManager(unitManager.getAllUnits(), tenantManager.getAllTenants());
        this.notificationManager = new NotificationManager(9999);
    }

    public void addOneBedroom(){
        unitManager.addOneBedroomUnit();
    }

    public void addTwoBedroom(){
        unitManager.addTwoBedroomUnit();
    }

    public void addThreeBedroom(){
        unitManager.addThreeBedroomUnit();
    }

    public void printAllUnits(){
        unitManager.printAllUnits();
    }

    public void printAvailableUnits(){
        unitManager.printAvailableUnits();
    }

    public void printOccupiedUnits(){
        unitManager.printOccupiedUnits();
    }

    public void assignTenantToUnit(int unitId, Tenant tenant) {
        unitManager.assignTenantToUnit(unitId, tenant);
    }

    public void releaseTenantFromUnit(int unitId, Tenant tenant) {
        unitManager.releaseTenantFromUnit(unitId, tenant);
    }

    public boolean addTenant(Tenant tenant){
        return tenantManager.addTenant(tenant);
    }

    public boolean addTenant(String tenantFirstName, String tenantLastName, int tenantAge, String tenantEmail, String tenantPhone, boolean hasPets, boolean isParkingNeeded) {
        Tenant newTenant = new Tenant(tenantFirstName, tenantLastName, tenantAge, tenantEmail, tenantPhone, hasPets, isParkingNeeded);
        return addTenant(newTenant);
    }

    public boolean removeTenant(int tenantID){
        return tenantManager.removeTenant(tenantID);
    }

    public void printAllTenants(){
         tenantManager.printAllTenants();
    }

    public void searchTenantByID(int tenantID){
        tenantManager.searchTenantByID(tenantID);
    }
    public boolean searchTenantByName(String tenantName){
        return tenantManager.searchTenantByName(tenantName);
    }

    public int getUnitIDByTenantID(int tenantID){
        return unitManager.getUnitIDByTenantID(tenantID);
    }

    public void generateOccupancyReport(){
        reportManager.generateOccupancyReport();
    }

    public void generateIncomeReport(){
        reportManager.generateIncomeReport();
    }

    public void addNotification(String type, String message){
        notificationManager.addNotification(type, message);
    }

    public void getAllNotifications(){
        notificationManager.getAllNotifications();
    }

    public void getNotificationsByType(String type){
        notificationManager.getNotificationsByType(type);
    }

    public void removeNotification(int notificationID){
        notificationManager.removeNotification(notificationID);
    }

}
