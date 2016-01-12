package boardview;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import model.Position;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Text;
import javafx.scene.layout.Background;
import javafx.geometry.Insets;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;




/**
 * View class for a tile on a chess board
 * A tile should be able to display a chess piece
 * as well as highlight itself during the game.
 *
 * @author Rachel Golding
 */
public class TileView implements Tile {
    private Position pos;
    private Label symbol;
    private Rectangle rec;
    private StackPane stack;
    private Color colorBitches;
    private Label tileLabel;




    /**
     * Creates a TileView with a specified position
     * @param p
     */
    public TileView(Position p) {
        pos = p;
        stack = new StackPane();
        rec = new Rectangle(50, 50);
        rec.setFill(Color.TRANSPARENT);
        symbol = new Label();
        int posSum = p.getRow() + p.getCol();
        if (posSum % 2 == 0) {
            colorBitches = Color.GAINSBORO;
        } else {
            colorBitches = Color.LIGHTSLATEGREY;
        }
        Background b = new Background(new BackgroundFill(colorBitches,
                new CornerRadii(0), new Insets(0)));
        stack.setBackground(b);
        symbol.setFont(new Font(50));
        tileLabel = new Label("");
        tileLabel.setFont(new Font("Arial", 40));
        stack.getChildren().addAll(rec, tileLabel);





    }


    @Override
    public Position getPosition() {
        return pos;
    }


    @Override
    public Node getRootNode() {
        symbol.setFont(new Font(50));
        return stack;
    }

    @Override
    public void setSymbol(String symbol) {

        this.symbol = new Label(symbol);
        stack.getChildren().setAll(rec, this.symbol);
        //symbol.setFont(new Font(35));
    }


    @Override
    public String getSymbol() {
        return symbol.getText();
    }

    @Override
    public void highlight(Color color) {
        //rec.setFill(color);
        //stack.getChildren().setAll(rec, symbol);
        //Background bitches = new Background(new BackgroundFill(color,
        //  stack.setBackground(bitches)));

        Background highlight = new Background(new BackgroundFill(color,
            new CornerRadii(0), new Insets(0)));
        stack.setBackground(highlight);
    }

    @Override
    public void clear() {
        symbol = new Label("");
        stack.getChildren().setAll(rec, symbol);
    }
}
