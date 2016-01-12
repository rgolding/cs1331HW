package boardview;

import java.util.List;
import java.util.Map;
import gamecontrol.GameController;
import gamecontrol.GameState;
import gamecontrol.NetworkedChessController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import model.Move;
import model.Piece;
import model.PieceType;
import model.Position;
import model.Side;
import javafx.scene.paint.Color;
import java.util.Set;
import model.IllegalMoveException;
//import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import gamecontrol.ChessController;
import java.util.Optional;
import model.chess.Pawn;
import model.chess.Queen;
import model.chess.Bishop;
import model.chess.Rook;
//import model.chess.Castle;
import model.chess.Knight;



/**
 * A class for a view for a chess board. This class must have a reference
 * to a GameController for chess playing chess
 * @author Gustavo
 * @date Oct 20, 2015
 */
public class BoardView {

    /* You may add more instance data if you need it */
    protected GameController controller;
    private GridPane gridPane;
    private Tile[][] tiles;
    private Text sideStatus;
    private Text state;
    private boolean isRotated;
    private Tile tileBitches;
    private Move prevMove;
    private Move thisMove;
    private Color prevColor;
    private Color originalColor;
    private boolean fors;
    private Move move;
    private List<Position> list;
    private Position currentPos;

    /**
     * Construct a BoardView with an instance of a GameController
     * and a couple of Text object for displaying info to the user
     * @param controller The controller for the chess game
     * @param state A Text object used to display state to the user
     * @param sideStatus A Text object used to display whose turn it is
     */
    public BoardView(GameController controller, Text state, Text sideStatus) {
        this.controller = controller;
        this.state = state;
        this.sideStatus = sideStatus;
        tiles = new Tile[8][8];
        gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color : goldenrod;");
        reset(controller);
        fors = true;
        controller.beginTurn();


    }

    /**
     * Listener for clicks on a tile
     *
     * @param tile The tile attached to this listener
     * @return The event handler for all tiles.
     */
    private EventHandler<? super MouseEvent> tileListener(Tile tile) {
        return event -> {
            if (controller instanceof NetworkedChessController
                    && controller.getCurrentSide()
                    != ((NetworkedChessController) controller).getLocalSide()) {
                //not your turn!

                return;
            }

            // Don't change the code above this :)



            if (fors) {
                firstClick(tile);
                //fors = false;
            } else {
                secondClick(tile);
                //clearAllHighlighting();

                //fors = true;
            }

        };
    }

    /**
     * Perform the first click functions, like displaying
     * which are the valid moves for the piece you clicked.
     * @param tile The TileView that was clicked
     */
    private void firstClick(Tile tile) {
        this.tileBitches = tile;
        Color color1 = Color.HONEYDEW;
        Color color2 = Color.LIGHTGREEN;
        Set<Move> moves = controller.getMovesForPieceAt(
            tileBitches.getPosition());
        for (Move m : moves) {
            Position pos = m.getDestination();
            Color highlight = Color.CORNSILK;
            fors = false;
            tile.highlight(highlight);
            for (Tile[] t : tiles) {
                for (Tile x : t) {
                    Position compare = x.getPosition();
                    if (compare.equals(pos)) {

                        x.highlight(color1);
                    }
                }
            }
        }

    }

    /**
     * Perform the second click functions, like
     * sending moves to the controller but also
     * checking that the user clicked on a valid position.
     * If they click on the same piece they clicked on for the first click
     * then you should reset to click state back to the first click and clear
     * the highlighting effected on the board.
     *
     * @param tile the TileView at which the second click occurred
     */
    private void secondClick(Tile tile) {

        if (tile.equals(tileBitches)) {
            clearAllHighlighting();
            fors = true;
            return;

        }

        Set<Move> moves = controller.getMovesForPieceAt(
            tileBitches.getPosition());


        for (Move m : moves) {
            if (tile.getPosition().equals(m.getDestination())) {
                try {
                    thisMove = m;

                    controller.makeMove(thisMove);
                    controller.endTurn();
                    controller.beginTurn();
                    fors = true;
                    return;



                } catch (IllegalMoveException e) {
                    System.err.println(e.getMessage());
                }

            }



        }
        /*
        if (i==(moves.size())) {
        //currentPos = tile.getPosition();
        //if (moves.contains(currentPos)) {
            clearAllHighlighting();
            fors = true;

        }
        */



        //controller.beginTurn();
        fors = false;



    }
    public void clearAllHighlighting() {
        this.originalColor = originalColor;
        for (Tile[] arr : tiles) {
            for (Tile t : arr) {
                int posSum = t.getPosition().getRow()
                    + t.getPosition().getCol();
                if (posSum % 2 == 0) {
                    originalColor = Color.GAINSBORO;

                } else {
                    originalColor = Color.LIGHTSLATEGREY;
                }
                t.highlight(originalColor);
            }
        }



    }

    /**
     * This method should be called any time a move is made on the back end.
     * It should update the tiles' highlighting and symbols to reflect the
     * change in the board state.
     *
     * @param moveMade the move to show on the view
     * @param capturedPositions a list of positions where pieces were captured
     *
     */

    public void updateView(Move moveMade, List<Position> capturedPositions) {

        this.move = moveMade;
        Tile t = getTileAt(move.getStart());
        String symbol = getTileAt(move.getStart()).getSymbol();
        getTileAt(move.getDestination()).setSymbol(symbol);
        getTileAt(move.getStart()).clear();
        clearAllHighlighting();
        getTileAt(move.getDestination()).highlight(Color.RED);
        //setSymbol(controller.getSymbolForPieceAt(prevMove));
    }

    /**
     * Asks the user which PieceType they want to promote to
     * (suggest using Alert). Then it returns the Piecetype user selected.
     *
     * @return  the PieceType that the user wants to promote their piece to
     */
    private PieceType handlePromotion() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Promotion Time Bitches");
        alert.setHeaderText("Choose Piece To Promote To");


        ButtonType buttonPawn = new ButtonType("Pawn");
        ButtonType buttonBishop = new ButtonType("Bishop");
        //ButtonType buttonCastle = new ButtonType("Castle");
        ButtonType buttonRook = new ButtonType("Rook");
        ButtonType buttonQueen = new ButtonType("Queen");
        ButtonType buttonKnight = new ButtonType("Horsey");

        alert.getButtonTypes().setAll(buttonPawn, buttonBishop,
            buttonRook, buttonQueen, buttonKnight);
        PieceType p = new Pawn(controller.getCurrentSide()).getType();

        Optional<ButtonType> result = alert.showAndWait();


        if (result.get() == buttonPawn) {
            p = new Pawn(controller.getCurrentSide()).getType();
        } else if (result.get() == buttonBishop) {
            p = new Bishop(controller.getCurrentSide()).getType();
        } else if (result.get() == buttonRook) {
            p = new Rook(controller.getCurrentSide()).getType();
        } else if (result.get() == buttonQueen) {
            p = new Queen(controller.getCurrentSide()).getType();
        } else if (result.get() == buttonKnight) {
            p = new Knight(controller.getCurrentSide()).getType();
        }

        tileBitches.setSymbol(p.getSymbol(controller.getCurrentSide()));
        return p;

    }

    /**
     * Handles a change in the GameState (ie someone in check or stalemate).
     * If the game is over, it should open an Alert and ask to keep
     * playing or exit.
     *
     * @param s The new Game State
     */
    public void handleGameStateChange(GameState s) {
        if (s.toString().equals("White is in Check")
                || s.toString().equals("Black is in Check")
                || s.toString().equals("Ongoing")) {
            state.setText(s.toString());
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("The Game is Over");
            alert.setContentText("Keep Playing, or Exit?.");

            ButtonType buttonTypeOne = new ButtonType("Keep Playing");
            ButtonType buttonTypeCancel = new ButtonType("Cancel",
                ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne) {
                reset(new ChessController());
            } else {
                Platform.exit();
            }
        }
    }

    /**
     * Updates UI that depends upon which Side's turn it is
     *
     * @param s The new Side whose turn it currently is
     */
    public void handleSideChange(Side s) {
        sideStatus.setText(s + "'s Turn");

    }

    /**
     * Resets this BoardView with a new controller.
     * This moves the chess pieces back to their original configuration
     * and calls startGame() at the end of the method
     * @param newController The new controller for this BoardView
     */
    public void reset(GameController newController) {
        if (controller instanceof NetworkedChessController) {
            ((NetworkedChessController) controller).close();
        }
        controller = newController;
        isRotated = false;
        if (controller instanceof NetworkedChessController) {
            Side mySide
                = ((NetworkedChessController) controller).getLocalSide();
            if (mySide == Side.BLACK) {
                isRotated = true;
            }
        }
        sideStatus.setText(controller.getCurrentSide() + "'s Turn");

        // controller event handlers
        // We must force all of these to run on the UI thread
        controller.addMoveListener(
                (Move move, List<Position> capturePositions) ->
                Platform.runLater(
                    () -> updateView(move, capturePositions)));

        controller.addCurrentSideListener(
                (Side side) -> Platform.runLater(
                    () -> handleSideChange(side)));

        controller.addGameStateChangeListener(
                (GameState state) -> Platform.runLater(
                    () -> handleGameStateChange(state)));

        controller.setPromotionListener(() -> handlePromotion());


        addPieces();
        controller.startGame();
        if (isRotated) {
            setBoardRotation(180);
        } else {
            setBoardRotation(0);
        }
    }

    /**
     * Initializes the gridPane object with the pieces from the GameController.
     * This method should only be called once before starting the game.
     */
    private void addPieces() {
        gridPane.getChildren().clear();
        Map<Piece, Position> pieces = controller.getAllActivePiecesPositions();
        /* Add the tiles */
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Tile tile = new TileView(new Position(row, col));
                gridPane.add(tile.getRootNode(),
                        1 + tile.getPosition().getCol(),
                        1 + tile.getPosition().getRow());
                GridPane.setHgrow(tile.getRootNode(), Priority.ALWAYS);
                GridPane.setVgrow(tile.getRootNode(), Priority.ALWAYS);
                getTiles()[row][col] = tile;
                tile.getRootNode().setOnMouseClicked(
                        tileListener(tile));
                tile.clear();
                tile.setSymbol("");
            }
        }
        /* Add the pieces */
        for (Piece p : pieces.keySet()) {
            Position placeAt = pieces.get(p);
            getTileAt(placeAt).setSymbol(p.getType().getSymbol(p.getSide()));
        }
        /* Add the coordinates around the perimeter */
        for (int i = 1; i <= 8; i++) {
            Text coord1 = new Text((char) (64 + i) + "");
            GridPane.setHalignment(coord1, HPos.CENTER);
            gridPane.add(coord1, i, 0);

            Text coord2 = new Text((char) (64 + i) + "");
            GridPane.setHalignment(coord2, HPos.CENTER);
            gridPane.add(coord2, i, 9);

            Text coord3 = new Text(9 - i + "");
            GridPane.setHalignment(coord3, HPos.CENTER);
            gridPane.add(coord3, 0, i);

            Text coord4 = new Text(9 - i + "");
            GridPane.setHalignment(coord4, HPos.CENTER);
            gridPane.add(coord4, 9, i);
        }
    }

    private void setBoardRotation(int degrees) {
        gridPane.setRotate(degrees);
        for (Node n : gridPane.getChildren()) {
            n.setRotate(degrees);
        }
    }

    /**
     * Gets the view to add to the scene graph
     * @return A pane that is the node for the chess board
     */
    public Pane getView() {
        return gridPane;
    }

    /**
     * Gets the tiles that belong to this board view
     * @return A 2d array of TileView objects
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    private Tile getTileAt(int row, int col) {
        return getTiles()[row][col];
    }

    private Tile getTileAt(Position p) {
        return getTileAt(p.getRow(), p.getCol());
    }

}
