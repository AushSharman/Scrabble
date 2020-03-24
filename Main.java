import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>
{
    Stage currentWindow;

    Button quitButton;
    Button passButton;
    Button helpButton;
    Button exchangeButton;

    @Override
    public void start(Stage primaryStage)
    {
        GridPane gridPane = new GridPane();
        BorderPane borderPane = new BorderPane();
        gridPane.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        final int size = 15;

        //To Do : *Top Design*
        borderPane.setTop(new Label("S C R A B B L E"));

        //Board Design :
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                StackPane square = new StackPane();
                var style_maker = new StringBuilder();

                //Triple Word Score :
                if (row == 0 && col == 0 || row == 0 && col == 7 || row == 0 && col == 14 || row == 7 && col == 0 ||
                        row == 7 && col == 14 || row == 14 && col == 0 || row == 14 && col == 7 || row == 14 && col == 14)
                {
                    style_maker.append("-fx-background-color:").append("rgb(255,112,77)").append(';');
                    square.setStyle(String.valueOf(style_maker));
                    Label label = new Label("3W");
                    square.getChildren().add(label);
                }

                //Double Word Score :
                else if(row == 1 && col == 1 || row == 1 && col == 13 || row == 2 && col == 2 || row == 2 && col == 12 ||
                        row == 3 && col == 3 || row == 3 && col == 11 || row == 4 && col == 4 || row == 4 && col == 10 ||
                        row == 10 && col == 4 || row == 10 && col == 10 || row == 11 && col == 3 || row == 11 && col == 11 ||
                        row == 12 && col == 2 || row == 12 && col == 12 || row == 13 && col == 1 || row == 13 && col == 13)
                {
                    style_maker.append("-fx-background-color:").append("rgb(255,204,204)").append(';');
                    square.setStyle(String.valueOf(style_maker));
                    Label label = new Label("2W");
                    square.getChildren().add(label);
                }

                //Center :
                else if(row == 7 && col == 7)
                {
                    style_maker.append("-fx-background-color:").append("rgb(255,204,204)").append(';');
                    square.setStyle(String.valueOf(style_maker));
                    Label label = new Label("C");
                    square.getChildren().add(label);
                }

                //Triple Letter Score :
                else if(row == 1 && col == 5 || row == 1 && col == 9 || row == 5 && col == 1 || row == 5 && col == 5 ||
                        row == 5 && col == 9 || row == 5 && col == 13 || row == 9 && col == 1 || row == 9 && col == 5 ||
                        row == 9 && col == 9 || row == 9 && col == 13 || row == 13 && col == 5 || row == 13 && col == 9)
                {
                    style_maker.append("-fx-background-color:").append("rgb(0,102,153)").append(';');
                    square.setStyle(String.valueOf(style_maker));
                    Label label = new Label("3L");
                    square.getChildren().add(label);
                }

                //Double Letter Score
                else if(row == 0 && col == 3 || row == 0 && col == 11 || row == 2 && col == 6 || row == 2 && col == 8 ||
                        row == 3 && col == 0 || row == 3 && col == 7 || row == 3 && col == 14 || row == 6 && col == 2 ||
                        row == 6 && col == 6 || row == 6 && col == 8 || row == 6 && col == 12 || row == 7 && col == 3 ||
                        row == 7 && col == 11 || row == 8 && col == 2 || row == 8 && col == 6 || row == 8 && col == 8 ||
                        row == 8 && col == 12 || row == 11 && col == 0 || row == 11 && col == 7 || row == 11 && col == 14 ||
                        row == 12 && col == 6 || row == 12 && col == 8 || row == 14 && col == 3 || row == 14 && col == 11)
                {
                    style_maker.append("-fx-background-color:").append("rgb(204,230,255)").append(';');
                    square.setStyle(String.valueOf(style_maker));
                    Label label = new Label("2L");
                    square.getChildren().add(label);
                }

                else
                {
                    style_maker.append("-fx-background-color:").append("FFEBCD").append(';');
                    square.setStyle(String.valueOf(style_maker));
                }

                gridPane.add(square, col, row);
                borderPane.setCenter(gridPane);
            }
        }

        //Buttons :
        TilePane bottomPane = new TilePane();
        quitButton = new Button("QUIT");
        quitButton.setStyle("-fx-background-color: rgb(0,102,153); -fx-font-size: 20");
        quitButton.setOnAction(this);
        bottomPane.getChildren().add(quitButton);

        passButton = new Button("PASS");
        passButton.setStyle("-fx-background-color: rgb(0,102,153); -fx-font-size: 20");
        passButton.setOnAction(this);
        bottomPane.getChildren().add(passButton);

        helpButton = new Button("HELP");
        helpButton.setStyle("-fx-background-color: rgb(0,102,153); -fx-font-size: 20");
        helpButton.setOnAction(this);
        bottomPane.getChildren().add(helpButton);

        exchangeButton = new Button("EXCHANGE");
        exchangeButton.setStyle("-fx-background-color: rgb(0,102,153); -fx-font-size: 20");
        exchangeButton.setOnAction(this);
        bottomPane.getChildren().add(exchangeButton);

        borderPane.setBottom(bottomPane);

        for (int i = 0; i < size; i++)
        {
            gridPane.getColumnConstraints().add(new ColumnConstraints(1, Control.USE_PREF_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            gridPane.getRowConstraints().add(new RowConstraints(1, Control.USE_PREF_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }

        //Stage :
        currentWindow = primaryStage;
        currentWindow.setTitle("Scrabble");
        Scene scene = new Scene(borderPane, 800, 800);
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @Override
    public void handle(ActionEvent event)
    {
        if(event.getSource() == quitButton)
        {
            System.out.print("Quit Game \n");
        }

        else if(event.getSource() == passButton)
        {
            System.out.println("Pass Turn \n");
        }

        else if(event.getSource() == helpButton)
        {
            System.out.println("Help Button Triggered \n");
        }

        else if(event.getSource() == exchangeButton)
        {
            System.out.println("Exchanging Tiles \n");
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}