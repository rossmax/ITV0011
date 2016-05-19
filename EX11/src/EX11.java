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

    /**
     * The constant HEIGHT.
     */
    public static final int HEIGHT = 50;
    /**
     * The constant WIDTH.
     */
    public static final int WIDTH = 300;

    /**
     * The constant COLLUMS.
     */
    public static final int COLLUMS = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox center = new HBox();

        Scene scene = new Scene(center, width, heigh);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(true);

        TextField name = new TextField();
        name.setPromptText("Enter your first name.");
        name.setPrefColumnCount(COLLUMS);
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
