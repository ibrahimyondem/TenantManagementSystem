import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginController {
    private Stage stage;
    private Coordinator coordinator;

    private TextField usernameField;
    private PasswordField passwordField;

    public LoginController(Stage stage) {
        this.stage = stage;
        this.coordinator = new Coordinator(500, 1000);
    }

    public void showLoginScreen(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button signupButton = new Button("Signup");

        loginButton.setOnAction(e -> handleLogin());
        signupButton.setOnAction(e -> showSignUpScreen());

        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 0, 2);
        gridPane.add(signupButton, 1, 2);

        Scene scene = new Scene(gridPane, 450,600);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("LOGIN FAILED", "Please fill in all fields.");
            return;
        }

        if(username.equals("landlord") && password.equals("landlord2024")){
            showDashboard();
        }else{
            showAlert("LOGIN FAILED", "INVALID USERNAME OR PASSWORD");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showDashboard() {
        DashboardController dashboardController = new DashboardController(stage, coordinator);
        dashboardController.showDashboard();
    }

    private void showSignUpScreen() {
        SignUpController signUpController = new SignUpController(stage);
        signUpController.showSignUpScreen();
    }
}
