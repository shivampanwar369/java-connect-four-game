package com.internshala.connectfour;
/*
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
public class Controller implements Initializable {

    //LET US DEFINE VARIABLE FOR OUR CONNECT 4 GAME
    private static final int COLUMN = 7;
    private static final int ROWS = 6;
    private static final int CIRCLE_DIAMETER = 80;
    private static final String DiscColor1 = "#24303E";
    private static final String DiscColor2 = "#4CAA88";

    //for CHANCE PLAYER ONE AND PLAYER TO

    private static String PLAYER_ONE = "Player One";
    private static String PLAYER_TWO = "Player Two";
    private boolean isPlayOneTurn = true;
    private Disc[][]  insertDiscArray = new Disc[ROWS][COLUMN];         //FOR STRUCTURAL CHANGE FOR THE DEVELOPERS

    @FXML
    public GridPane rootGridPane;
    @FXML
    public Pane insertDiscPane;
    @FXML
    public Label playerNameLabel;

    //FOR CREATING A PLAYGROUND
    public void createPlayground() {


        Shape rectangleWidthHoles = createGameStructuralGuid();
        rootGridPane.add(rectangleWidthHoles,0 , 1);

        List<Rectangle> rectangleList = createClickableColumn();
        for(Rectangle rectangle: rectangleList) {


            rootGridPane.add(rectangle, 0, 1);
        }

    }
    private  Shape createGameStructuralGuid(){
        Shape rectangleWidthHoles = new Rectangle((COLUMN + 0.8)*CIRCLE_DIAMETER, (ROWS + 0.2) *CIRCLE_DIAMETER);
        for (int row = 0; row < ROWS; row++){
            for(int col = 0; col < COLUMN; col++) {
                Circle circle = new Circle();
                circle.setRadius(CIRCLE_DIAMETER / 2.4);
                circle.setCenterX(CIRCLE_DIAMETER / 2);
                circle.setTranslateY(CIRCLE_DIAMETER / 2);

                circle.setTranslateX(col * (CIRCLE_DIAMETER + 5) + CIRCLE_DIAMETER / 5);
                circle.setTranslateY(row * (CIRCLE_DIAMETER + 4) + CIRCLE_DIAMETER / 2);
                rectangleWidthHoles = Shape.subtract(rectangleWidthHoles, circle);
            }
        }

        rectangleWidthHoles.setFill(Color.WHITE);
        return rectangleWidthHoles;
    }
     private  List<Rectangle> createClickableColumn() {

         List<Rectangle> rectangleList = new ArrayList<>();

         for (int col = 0; col < COLUMN; col++) {
             Rectangle rectangle = new Rectangle(CIRCLE_DIAMETER, (ROWS + 0.1) * CIRCLE_DIAMETER);
             rectangle.setFill(Color.TRANSPARENT);
             rectangle.setTranslateX(col * (CIRCLE_DIAMETER + 5) + CIRCLE_DIAMETER / 9.0);


             rectangle.setOnMouseEntered(event ->
                     rectangle.setFill(Color.valueOf("#eeeeee26")));

             rectangle.setOnMouseExited(event ->
                     rectangle.setFill(Color.TRANSPARENT));

              final int column = col;


             rectangle.setOnMouseClicked(event -> {
                 insertDisc(new Disc(isPlayOneTurn), column);

             });

             rectangleList.add(rectangle);
         }
         return rectangleList;
     }
         private void insertDisc(Disc disc, int column) {
             int row = ROWS - 1;
             while (row > 0) {
             if (insertDiscArray[row][column] == null)
                 break;
             row--;
         }
             if(row < 0) // IF COLUMN IS FULL , WE CAN;T INSERT ANY MORE DISC
                 return;
        insertDiscArray[row] [column] = disc;
        //insertDiscPane.getChildren().add(disc);
             insertDiscPane.getChildren().add(disc);

        disc.setTranslateX (column * (CIRCLE_DIAMETER + 5) + CIRCLE_DIAMETER / 9.0);
        int currentRow = row;
             TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), disc);
             translateTransition.setToY(row * (CIRCLE_DIAMETER + 5) + CIRCLE_DIAMETER / 4);

             translateTransition.setOnFinished(event -> {

                 if (gameEnded(currentRow,column)){


                 }
                 isPlayOneTurn = !isPlayOneTurn;
                 playerNameLabel.setText(isPlayOneTurn?PLAYER_ONE:PLAYER_TWO);

             });

             translateTransition.play();
        disc.setTranslateY(5 * (CIRCLE_DIAMETER + 4) + CIRCLE_DIAMETER / 2);
     }
     private void gameEnded(int row, int column){
        
     }
         private static class Disc extends Circle {
        private final boolean isPlayerOneMove;
        public Disc(boolean isPlayerOneMove){
              this.isPlayerOneMove = isPlayerOneMove;
              setRadius(CIRCLE_DIAMETER / 2);
              setFill(isPlayerOneMove? Color.valueOf(DiscColor1): Color.valueOf(DiscColor2));
              setCenterY(CIRCLE_DIAMETER / 2);



                }
            };


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}



class Main {

    public static void main(String args[]) {

        Car car = new Car();

        car.increment();

        System.out.println(car.x);

    }

}



class Car {

    int x = 0;

    void increment() {

        x++;

        x++;

    }
}

*
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Controller implements Initializable {
    private static final int COLUMN = 7;
    private static final int ROWS = 6;
    private static final int CIRCLE_DIAMETER = 80;
    private static final String DiscColor1 = "#24303E";
    private static final String DiscColor2 = "#4CAA88";
    private static String PLAYER_ONE = "Player One";
    private static String PLAYER_TWO = "Player Two";
    private boolean isPlayOneTurn = true;
    private Controller.Disc[][] insertDiscArray = new Controller.Disc[6][7];
    @FXML
    public GridPane rootGridPane;
    @FXML
    public Pane insertDiscPane;
    @FXML
    public Label playerNameLabel;

    public Controller() {
    }

    public void createPlayground() {
        Shape rectangleWidthHoles = this.createGameStructuralGuid();
        this.rootGridPane.add(rectangleWidthHoles, 0, 1);
        List<Rectangle> rectangleList = this.createClickableColumn();
        Iterator var3 = rectangleList.iterator();

        while(var3.hasNext()) {
            Rectangle rectangle = (Rectangle)var3.next();
            this.rootGridPane.add(rectangle, 0, 1);
        }

    }

    private Shape createGameStructuralGuid() {
        Shape rectangleWidthHoles = new Rectangle(624.0D, 496.0D);

        for(int row = 0; row < 6; ++row) {
            for(int col = 0; col < 7; ++col) {
                Circle circle = new Circle();
                circle.setRadius(33.333333333333336D);
                circle.setCenterX(40.0D);
                circle.setTranslateY(40.0D);
                circle.setTranslateX((double)(col * 85 + 16));
                circle.setTranslateY((double)(row * 84 + 40));
                rectangleWidthHoles = Shape.subtract((Shape)rectangleWidthHoles, circle);
            }
        }

        ((Shape)rectangleWidthHoles).setFill(Color.WHITE);
        return (Shape)rectangleWidthHoles;
    }

    private List<Rectangle> createClickableColumn() {
        List<Rectangle> rectangleList = new ArrayList();

        for(int col = 0; col < 7; ++col) {
            Rectangle rectangle = new Rectangle(80.0D, 488.0D);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setTranslateX((double)(col * 85) + 8.88888888888889D);
            rectangle.setOnMouseEntered((event) -> {
                rectangle.setFill(Color.valueOf("#eeeeee26"));
            });
            rectangle.setOnMouseExited((event) -> {
                rectangle.setFill(Color.TRANSPARENT);
            });
            int finalCol = col;
            rectangle.setOnMouseClicked((event) -> {
                this.insertDisc(new Controller.Disc(this.isPlayOneTurn), finalCol);
            });
            rectangleList.add(rectangle);
        }

        return rectangleList;
    }

    private void insertDisc(Controller.Disc disc, int column) {
        int row;
        for(row = 5; row > 0 && this.insertDiscArray[row][column] != null; --row) {
        }

        if (row >= 0) {
            this.insertDiscArray[row][column] = disc;
            this.insertDiscPane.getChildren().add(disc);
            disc.setTranslateX((double)(column * 85) + 8.88888888888889D);
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5D), disc);
            translateTransition.setToY((double)(row * 85 + 20));
            translateTransition.setOnFinished((event) -> {
                this.isPlayOneTurn = !this.isPlayOneTurn;
                this.playerNameLabel.setText(this.isPlayOneTurn ? PLAYER_ONE : PLAYER_TWO);
            });
            translateTransition.play();
            disc.setTranslateY(460.0D);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    private static class Disc extends Circle {
        private final boolean isPlayerOneMove;

        public Disc(boolean isPlayerOneMove) {
            this.isPlayerOneMove = isPlayerOneMove;
            this.setRadius(40.0D);
            this.setFill(isPlayerOneMove ? Color.valueOf("#24303E") : Color.valueOf("#4CAA88"));
            this.setCenterY(40.0D);
        }
    }
}
