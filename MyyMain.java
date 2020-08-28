package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyyMain extends Application {

    private Controller Controller;


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        Controller = loader.getController();
        Controller.createPlayground();

        MenuBar menuBar = CreateMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);


        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect four");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    private MenuBar CreateMenu() {
        Menu fileMenu = new Menu("file");
        MenuItem newGame = new MenuItem("New Game");

        //LAMADA EXPRESSION
        newGame.setOnAction(event -> resetGame());



        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(event -> resetGame());


        SeparatorMenuItem SeparatorMenuItem = new SeparatorMenuItem();

        MenuItem exitGame =  new MenuItem("Exit Game");
        exitGame.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newGame,resetGame,SeparatorMenuItem,exitGame);

        //HELP MENU

        Menu helpMenu = new Menu("Help");
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());


        SeparatorMenuItem Separator =new SeparatorMenuItem();
        MenuItem aboutConnect4 = new MenuItem("About Connect4");
        aboutConnect4.setOnAction(event -> {
            aboutConnect4();
        });



        helpMenu.getItems().addAll(aboutMe,aboutConnect4,Separator);


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;

    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Shivam Panwar");
        alert.setContentText("I love to play connect4 game so i develop");                                        //TODO
        alert.show();

    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About connect4");
        alert.setHeaderText("How to play");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid." +
                " The pieces fall straight down, occupying the next available space within the column." +
                " The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs." +
                " Connect Four is a solved game. The first player can always win by playing the right moves.");                                        //TODO
        alert.show();
    }



    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {

        //TODO
    }


    public static void main(String[] args) {
        launch(args);
    }
}


/*

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyyMain extends Application {
    private Controller Controller;

    public MyyMain() {
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("game.fxml"));
        GridPane rootGridPane = (GridPane)loader.load();
        this.Controller = (Controller)loader.getController();
        this.Controller.createPlayground();
        MenuBar menuBar = this.CreateMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menuPane = (Pane)rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);
        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar CreateMenu() {
        Menu fileMenu = new Menu("file");
        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction((event) -> {
            this.resetGame();
        });
        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction((event) -> {
            this.resetGame();
        });
        SeparatorMenuItem SeparatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction((event) -> {
            this.exitGame();
        });
        fileMenu.getItems().addAll(new MenuItem[]{newGame, resetGame, SeparatorMenuItem, exitGame});
        Menu helpMenu = new Menu("Help");
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction((event) -> {
            this.aboutMe();
        });
        SeparatorMenuItem Separator = new SeparatorMenuItem();
        MenuItem aboutConnect4 = new MenuItem("About Connect4");
        aboutConnect4.setOnAction((event) -> {
            this.aboutConnect4();
        });
        helpMenu.getItems().addAll(new MenuItem[]{aboutMe, aboutConnect4, Separator});
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(new Menu[]{fileMenu, helpMenu});
        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Shivam Panwar");
        alert.setContentText("I love to play connect4 game so i develop");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About connect4");
        alert.setHeaderText("How to play");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
    }

    public static void main(String[] args) {
        launch(args);

 */
