/**
 * Created by Max Ross on 5/19/2016 8:10 AM.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * The type Ex 11.
 */
public class EX11 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox center = new HBox();
        /*container.setId("checkUpdatesBar");
        container.setPrefSize(50, 50);
        container.setMinSize(50, 50);
        container.setMaxSize(200, 200);*/

        Scene scene = new Scene(center, 300, 50);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(true);

        /*GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);*/

        TextField name = new TextField();
        name.setPromptText("Enter your first name.");
        name.setPrefColumnCount(10);
        name.getText();
        //GridPane.setConstraints(name, 0, 0);
        center.getChildren().add(name);

        Button b1 = new Button();
        b1.setAlignment(Pos.CENTER);
        b1.setText("Submit");
        //GridPane.setConstraints(b1, 1, 0);
        center.getChildren().add(b1);

        Label label = new Label("My Label");
        name.setPromptText("Enter");
        center.getChildren().add(label);


        b1.setOnAction(e -> {
            label.setText(name.getText());
        });


    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
