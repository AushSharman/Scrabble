package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.util.Scanner;

public class Controller
{
    @FXML
    private GridPane square;
    @FXML
    private Button quitButton;
    @FXML
    private Button passButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button exchangeButton;

    public void initialize()
    {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        final int size = 15;

        //Board Design :
        for(int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
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
                else if (row == 1 && col == 1 || row == 1 && col == 13 || row == 2 && col == 2 || row == 2 && col == 12 ||
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
                else if (row == 7 && col == 7)
                {
                    style_maker.append("-fx-background-color:").append("rgb(255,204,204)").append(';');
                    square.setStyle(String.valueOf(style_maker));
                    Label label = new Label("C");
                    square.getChildren().add(label);
                }

                //Triple Letter Score :
                else if (row == 1 && col == 5 || row == 1 && col == 9 || row == 5 && col == 1 || row == 5 && col == 5 ||
                        row == 5 && col == 9 || row == 5 && col == 13 || row == 9 && col == 1 || row == 9 && col == 5 ||
                        row == 9 && col == 9 || row == 9 && col == 13 || row == 13 && col == 5 || row == 13 && col == 9)
                {
                    style_maker.append("-fx-background-color:").append("rgb(0,102,153)").append(';');
                    square.setStyle(String.valueOf(style_maker));
                    Label label = new Label("3L");
                    square.getChildren().add(label);
                }

                //Double Letter Score
                else if (row == 0 && col == 3 || row == 0 && col == 11 || row == 2 && col == 6 || row == 2 && col == 8 ||
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
            }
        }

        for (int i = 0; i < size; i++)
        {
            gridPane.getColumnConstraints().add(new ColumnConstraints(52, Control.USE_PREF_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            gridPane.getRowConstraints().add(new RowConstraints(51, Control.USE_PREF_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }

        square.getChildren().add(gridPane);
    }

    @FXML
    public void onButtonClicked(ActionEvent event)
    {
        if(event.getSource().equals(quitButton))
        {
            System.out.print("Quit Game \n");
        }

        else if(event.getSource().equals(passButton))
        {
            //System.out.println("Turn is now - " + (!(counter % 2 == 0) ? p1.getPlayerName() : p2.getPlayerName()));
        }

        else if(event.getSource().equals(helpButton))
        {
            System.out.println("Help Button Triggered \n");
        }

        else if(event.getSource().equals(exchangeButton))
        {
            UI.exchangeButton();
        }
    }
}
