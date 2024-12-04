public class Main {
    public static void main(String[] args) {
//        Coordinator coordinator = new Coordinator(10, 20);
//        coordinator.addOneBedroom();
//        coordinator.addTwoBedroom();
//        coordinator.addThreeBedroom();
//        coordinator.printAllUnits();

//        Tenant tenant1 = new Tenant("John", "Doe", 30, "john.doe@example.com", "555-1234", true, true);
//        Tenant tenant2 = new Tenant("Jane", "Smith", 28, "jane.smith@example.com", "555-5678", false, false);
//
//        coordinator.addTenant(tenant1);
//        coordinator.addTenant(tenant2);
//
//        coordinator.printAllTenants();
//
//        coordinator.assignTenantToUnit(100, tenant1);
//        coordinator.assignTenantToUnit(100, tenant2);
//        coordinator.searchTenantByID(1000);
//        coordinator.searchTenantByID(1001);
//        coordinator.assignTenantToUnit(101, tenant2);
//
//        coordinator.releaseTenantFromUnit(100, tenant2);
//        coordinator.printAvailableUnits();
//        coordinator.releaseTenantFromUnit(101, tenant2);
//        coordinator.releaseTenantFromUnit(101, tenant2);
//        coordinator.releaseTenantFromUnit(999, tenant2);
//
//                // Create NotificationManager with a maximum of 5 notifications
//                NotificationManager manager = new NotificationManager(9999);
//
//                // Add notifications
//                manager.addNotification("Info", "Server started successfully.");
//                manager.addNotification("Warning", "Disk space is running low.");
//                manager.addNotification("Info", "User logged in.");
//                manager.addNotification("Info", "User logged in and completed the form.");
//                manager.addNotification("Error", "Unable to connect to database.");
//                manager.addNotification("Warning", "High memory usage detected.");
//
//                // Get and display all notifications
//                System.out.println("All Notifications:");
//                manager.getAllNotifications();
//
//                // Get and display notifications by type
//                System.out.println("\nNotifications of type 'Warning':");
//                manager.getNotificationsByType("Warning");
//
//                System.out.println("\nNotifications of type 'Info':");
//                manager.getNotificationsByType("Info");
//
//                System.out.println("\nNotifications of type 'Error':");
//                manager.getNotificationsByType("Error");
//
//                // Test with a type that doesn't exist
//                System.out.println("\nNotifications of type 'Debug':");
//                manager.getNotificationsByType("Debug");
//
                // Initialize Coordinator with max units and tenants
//                Coordinator coordinator = new Coordinator(10, 10);
//
//                // Adding units
//                coordinator.addOneBedroom();
//                coordinator.addTwoBedroom();
//                coordinator.addThreeBedroom();
//
//                // Printing units
//                coordinator.printAllUnits();
//                coordinator.printAvailableUnits();
//                coordinator.printOccupiedUnits();
//
//                // Adding tenants
//                Tenant tenant1 = new Tenant("John", "Doe", 28, "john.doe@example.com", "123-456-7890", true, true);
//                coordinator.addTenant(tenant1);
//
//                // Assigning tenant to unit
//                coordinator.assignTenantToUnit(100, tenant1); // Assuming 100 is a valid unitID
//
//                // Printing tenant info
//                coordinator.printAllTenants();
//                coordinator.searchTenantByID(tenant1.getTenantID());
//
//                // Generating reports
//                coordinator.generateOccupancyReport();
//                coordinator.generateIncomeReport();
//
//                // Adding notifications
//                coordinator.addNotification("Info", "New tenant added");
//                coordinator.getAllNotifications();
//                coordinator.getNotificationsByType("Info");
//
//                // Releasing tenant from unit
//                coordinator.releaseTenantFromUnit(100, tenant1); // Assuming 100 is a valid unitID
//
//                // Removing tenant
//                coordinator.removeTenant(tenant1.getTenantID());


//        coordinator.printAvailableUnits();

//        coordinator.printOccupiedUnits();
//        coordinator.printAllTenants();
//        coordinator.printAllUnits();



//        coordinator.releaseTenantFromUnit(100, tenant2);

        // FIXED THE NEED OF RELEASING TENANT BEFORE REMOVING THE TENANT

        //THE PROBLEM IS RELEASING A TENANT FROM A UNIT THAT IS NOT ASSIGNED
//        coordinator.printAllUnits();
//        coordinator.printAvailableUnits();
    }
}
