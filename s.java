import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;

public class s extends Application {
   public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
       Text mes = new Text();
       Button bt = new Button("Say hello");
       bt.setOnAction(event -> {
           mes.setText("Hello World! FX style");
       });
       HBox rt = new HBox(50, bt, mes);
       rt.setAlignment(Pos.CENTER);

       Scene scene = new Scene(rt, 200, 250);
       primaryStage.setTitle("Hello");
       primaryStage.setScene(scene);
       primaryStage.show();
    }
}