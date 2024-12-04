import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DashboardController extends Application {
    private Stage stage;
    private Coordinator coordinator;

    public DashboardController(Stage stage, Coordinator coordinator) {
        this.stage = stage;
        this.coordinator = coordinator;
    }

    public void showDashboard() {
            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);

            Label titleLabel = new Label("Tenant Management System");
            gridPane.add(titleLabel, 0, 0, 2, 1);

            Button addOneBedroomButton = new Button("Add 1-Bedroom Unit");
            addOneBedroomButton.setOnAction(e -> coordinator.addOneBedroom());
            Button addTwoBedroomButton = new Button("Add 2-Bedroom Unit");
            addTwoBedroomButton.setOnAction(e -> coordinator.addTwoBedroom());
            Button addThreeBedroomButton = new Button("Add 3-Bedroom Unit");
            addThreeBedroomButton.setOnAction(e -> coordinator.addThreeBedroom());
            Button printAllUnitsButton = new Button("Print All Units");
            printAllUnitsButton.setOnAction(e -> coordinator.printAllUnits());

            gridPane.add(addOneBedroomButton, 0, 1);
            gridPane.add(addTwoBedroomButton, 1, 1);
            gridPane.add(addThreeBedroomButton, 0, 2);
            gridPane.add(printAllUnitsButton, 1, 2);

            Button printAllTenantsButton = new Button("Print All Tenants");
            printAllTenantsButton.setOnAction(e -> coordinator.printAllTenants());
            Button searchTenantButton = new Button("Search Tenant");
            searchTenantButton.setOnAction(e -> coordinator.searchTenantByName("John Doe")); // Example search

            gridPane.add(printAllTenantsButton, 0, 3);
            gridPane.add(searchTenantButton, 1, 3);

            Button occupancyReportButton = new Button("Generate Occupancy Report");
            occupancyReportButton.setOnAction(e -> coordinator.generateOccupancyReport());
            Button incomeReportButton = new Button("Generate Income Report");
            incomeReportButton.setOnAction(e -> coordinator.generateIncomeReport());

            gridPane.add(occupancyReportButton, 0, 4);
            gridPane.add(incomeReportButton, 1, 4);

            Button viewNotificationsButton = new Button("View Notifications");
            viewNotificationsButton.setOnAction(e -> coordinator.getAllNotifications());
            Button addNotificationButton = new Button("Add Notification");
            addNotificationButton.setOnAction(e -> coordinator.addNotification("Info", "Sample Notification"));

            gridPane.add(viewNotificationsButton, 0, 5);
            gridPane.add(addNotificationButton, 1, 5);

            Scene dashboardScene = new Scene(gridPane, 600, 400);
            stage.setScene(dashboardScene);
            stage.setTitle("Dashboard");
            stage.show();
        }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
