import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignUpController extends Application {
    private Stage stage;

    private TextField usernameField;
    private PasswordField passwordField;

    public SignUpController(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        showSignUpScreen();
    }

    public void showSignUpScreen() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        Button signUpButton = new Button("Signup");

        signUpButton.setOnAction(e -> handleSignup());

        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(signUpButton, 1, 2);

        Scene signUpScreen = new Scene(gridPane, 450, 600);
        stage.setScene(signUpScreen);
        stage.setTitle("SignUp");
        stage.show();
    }

    private void handleSignup() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Signup Failed", "Please fill in all fields.");
            return;
        }
        showAlert("Signup Successful", "You can now log in ");
        showLoginScreen();
    }

    private void showLoginScreen() {
        LoginController loginController = new LoginController(stage);
        loginController.showLoginScreen();
    }

    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
