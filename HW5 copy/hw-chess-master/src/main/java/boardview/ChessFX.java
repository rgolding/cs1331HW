package boardview;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import gamecontrol.AIChessController;
import gamecontrol.ChessController;
import gamecontrol.GameController;
import gamecontrol.NetworkedChessController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;


/**
 * Main class for the chess application
 * Sets up the top level of the GUI
 * @author Gustavo
 * @version
 */
public class ChessFX extends Application {

    private GameController controller;
    private BoardView board;
    private Text state;
    private Text sideStatus;
    private VBox root;

    @Override
    public void start(Stage primaryStage) {
        /*
        board = new BoardView(new ChessController(),
        new Text("state"), new Text("white"));
        StackPane root = new StackPane();
        root.getChildren().add(board.getView());
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
        Button resetButton = new Button("Reset");
        */

        controller = new ChessController();
        state = new Text("Ongoing");
        sideStatus = new Text("White");
        board = new BoardView(controller, state, sideStatus);

        GridPane grid = new GridPane();
        BorderPane border = new BorderPane();
        border.setCenter(board.getView());
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        // button column 1 row 1
        Button resetButton = new Button("Reset");
        resetButton.setOnMouseClicked(resetButtonListener());
        grid.add(resetButton, 0, 0);


        // button column 2 row 1
        Button computerButton = new Button("Play Computer");
        grid.add(computerButton, 1, 0);
        computerButton.setOnMouseClicked(playComputer());

        // text column 3 row 1
        grid.add(sideStatus, 2, 0);

        // text column 4 row 1
        grid.add(state, 3, 0);

        //button column 1, row 2
        Button host = new Button("Host");
        host.setOnMouseClicked(makeHostListener());
        grid.add(host, 0, 1);

        //ip address column 2, row 2
        try {
            Text ipAddress = new Text(InetAddress.getLocalHost().toString());
            grid.add(ipAddress, 1, 1);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        //TextField column 3, row 2
        TextField friend = new TextField();
        grid.add(friend, 2, 1);

        //button column 4 row 2
        Button joinGame = new Button("Join");
        joinGame.setOnMouseClicked(makeJoinListener(friend));
        grid.add(joinGame, 3, 1);


        border.setBottom(grid);
        //StackPane root = new StackPane();
        //root.getChildren().add(board.getView());
        primaryStage.setScene(new Scene(border, 750, 500));
        primaryStage.show();


    }

    private EventHandler<? super MouseEvent> makeHostListener() {
        return event -> {
            board.reset(new NetworkedChessController());
        };
    }

    private EventHandler<? super MouseEvent> makeJoinListener(TextField input) {
        return event -> {
            try {
                InetAddress addr = InetAddress.getByName(input.getText());
                GameController newController
                    = new NetworkedChessController(addr);
                board.reset(newController);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    private EventHandler<? super MouseEvent> resetButtonListener() {
        return event -> {
            board.reset(new ChessController());
        };
    }
    private EventHandler<? super MouseEvent> playComputer() {
        return event -> {
            try {
                board.reset(new AIChessController());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }




    public static void main(String[] args) {
        launch(args);
    }
}
