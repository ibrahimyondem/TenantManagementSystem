import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        LoginController loginController = new LoginController(primaryStage);
        loginController.showLoginScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
