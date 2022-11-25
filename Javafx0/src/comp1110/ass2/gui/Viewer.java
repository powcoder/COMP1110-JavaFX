https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


/**
 * A very simple viewer for shape placements in the twist game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various shape
 * placements.
 */
public class Viewer extends Application {

    public static final int SQUARE_SIZE = 60;
    private static final int VIEWER_WIDTH = 750;
    private static final int VIEWER_HEIGHT = 500;
    public static final double MARGIN_LEFT = 150;
    public static final double MARGIN_TOP = 150;
    public static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    TextField textField;
    private final Group pp = new Group(); //shapes and pegs


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement) {

        pp.getChildren().clear();
        for (int i = 0, j = 0; j < 5; ++j) {
            Line drawLine = new Line();
            drawLine.setStartX(0);
            drawLine.setStartY(i);
            drawLine.setEndX(8 * SQUARE_SIZE);
            drawLine.setEndY(i);
            pp.getChildren().add(drawLine);
            i += SQUARE_SIZE;
        }

        for (int i = 0, j = 0; j < 9; ++j) {
            Line drawLine = new Line();
            drawLine.setStartX(i);
            drawLine.setStartY(0);
            drawLine.setEndX(i);
            drawLine.setEndY(SQUARE_SIZE * 4);
            pp.getChildren().add(drawLine);
            i += SQUARE_SIZE;
        }

        // show shapes
        for (int i = 0; i < placement.length() / 4; i++) {
            System.out.println(placement.substring(i * 4, i * 4 + 4));
            ShapeView shapeView = new ShapeView(new Shape(placement.substring(i * 4, i * 4 + 4)));
            pp.getChildren().add(shapeView);
        }

    }


    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                makePlacement(textField.getText());
                textField.clear();
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("comp1110.ass2.TwistGame comp1110.ass2.Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);


        root.getChildren().add(controls);
        root.getChildren().add(pp);

        makeControls();

        pp.setLayoutX(MARGIN_LEFT);
        pp.setLayoutY(MARGIN_TOP);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


class Shape {

    int  rotation;
    char type;
    int colourType;
    int column;
    int row;
    int rowSize;
    int columnSize;
    private int[][] shape;

    public Shape(String placement) {

        this.type = placement.charAt(0);
        this.column = placement.charAt(1) - '1';
        this.row = placement.charAt(2) - 'A'; //
        this.rotation = placement.charAt(3) - '0';

        this.rowSize = 1;
        this.columnSize = 1;
        this.colourType = this.type - 'i';//
        initial();

    }


    private void initial() {
        switch (type) {
            case 'a':
                this.shape = new int[][]{
                        {1, 2, 1, 0},
                        {0, 0, 2, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                };
                colourType = 0;
                this.rowSize = 2;
                this.columnSize = 3;
                break;
            case 'b':
                this.shape = new int[][]{
                        {2, 2, 0, 0},
                        {0, 1, 2, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                };
                colourType = 0;
                this.rowSize = 2;
                this.columnSize = 3;
                break;
            case 'c':
                this.shape = new int[][]{
                        {2, 1, 2, 2},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                };
                colourType = 1;
                this.rowSize = 1;
                this.columnSize = 4;
                break;
            case 'd':
                this.shape = new int[][]{
                        {2, 2, 2, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                };
                colourType = 1;
                this.rowSize = 2;
                this.columnSize = 3;
                break;
            case 'e':
                this.shape = new int[][]{
                        {2, 1, 0, 0},
                        {0, 1, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                };
                colourType = 2;
                this.rowSize = 2;
                this.columnSize = 2;
                break;
            case 'f':
                this.shape = new int[][]{
                        {2, 2, 1, 0},
                        {0, 1, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                };
                colourType = 2;
                this.rowSize = 2;
                this.columnSize = 3;
                break;
            case 'g':
                this.shape = new int[][]{
                        {1, 0, 0, 0},
                        {1, 2, 2, 0},
                        {0, 1, 0, 0},
                        {0, 0, 0, 0}
                };
                colourType = 3;
                this.rowSize = 3;
                this.columnSize = 3;
                break;
            case 'h':
                this.shape = new int[][]{
                        {1, 2, 2, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                };
                colourType = 3;
                this.rowSize = 1;
                this.columnSize = 3;
                break;
        }

        // flip

        if (this.rotation >= 4) {//
            flipShapeY();
        }
        // rotate
        int degree = this.rotation % 4;
        // rotate once
        if (degree == 1) {
            rotateShape();
        } else if (degree == 2) {
            rotateShape();
            rotateShape();
        } else if (degree == 3) {
            System.out.println("here");
            rotateShape();
            System.out.println(this.shape);
            rotateShape();
            System.out.println(this.shape);
            rotateShape();
            System.out.println(this.shape);

        }
    }


    private void rotateShape() {
        int[][] tmp = new int[4][4];

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                tmp[i][j] = this.shape[3 - j][i];
            }
        }

        this.shape = tmp;
        boolean top = true;
        while (true) {
            // if there is a upper blank
            for (int i = 0; i < 4; ++i) {
                if (this.shape[0][i] != 0) top = false;
            }
            if (top) {
                // move to top
                for (int i = 1; i < 4; ++i) {
                    for (int j = 0; j < 4; ++j) {
                        this.shape[i - 1][j] = this.shape[i][j];
                    }
                }
                for (int i = 0; i < 4; ++i) this.shape[3][i] = 0;
            } else {
                break;
            }
        }
        boolean left = true;
        for (; ; ) {
            // if there is a left blank
            for (int i = 0; i < 4; ++i) {
                if (this.shape[i][0] != 0) left = false;
            }
            if (left) {
                // move to left
                for (int i = 1; i < 4; ++i) {
                    for (int j = 0; j < 4; ++j) {
                        this.shape[j][i - 1] = this.shape[j][i];
                    }
                }
                for (int i = 0; i < 4; ++i) this.shape[i][3] = 0;
            } else {
                break;
            }
        }
    }

    /**
     * Flip the shape matrix upside down
     */
    private void flipShapeY() {
        int[][] tmp = new int[4][4];
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                tmp[i][j] = this.shape[3 - i][j];
            }
        }
        this.shape = tmp;
        boolean top = true;
        for (; ; ) {
            for (int i = 0; i < 4; ++i) {
                if (this.shape[0][i] != 0) top = false;
            }
            if (top) {
                for (int i = 1; i < 4; ++i) {
                    for (int j = 0; j < 4; ++j) {
                        this.shape[i - 1][j] = this.shape[i][j];
                    }
                }
                for (int i = 0; i < 4; ++i) this.shape[3][i] = 0;
            } else {
                break;
            }
        }
        boolean left = true;
        while (true) {
            for (int i = 0; i < 4; ++i) {
                if (this.shape[i][0] != 0) left = false;
            }
            if (!left) {
                break;
            } else {
                for (int i = 1; i < 4; ++i) {
                    for (int j = 0; j < 4; ++j) {
                        this.shape[j][i - 1] = this.shape[j][i];
                    }
                }
                for (int i = 0; i < 4; ++i) this.shape[i][3] = 0;
            }
        }
    }


}


class ShapeView extends ImageView {


    private double dX;
    private double dY;
    Shape shape;

    public ShapeView(Shape shape) {
        this.shape = shape;

        setImage(new Image(comp1110.ass2.gui.Viewer.class.getResource((comp1110.ass2.gui.Viewer.URI_BASE+shape.type+".png")).toString()));

        setFitHeight(Viewer.SQUARE_SIZE * shape.rowSize);
        setFitWidth(Viewer.SQUARE_SIZE * shape.columnSize);

        int rotate = shape.rotation;
        if (rotate % 4 == 1 || rotate % 4 == 3) {
            switch (this.shape.type) {
                case 'a':
                case 'b':
                case 'd':
                case 'f':
                    dY = 0.5 * Viewer.SQUARE_SIZE;
                    break;
                case 'c':
                    dY = 1.5 * Viewer.SQUARE_SIZE;
                    break;
                case 'h':
                    dY = Viewer.SQUARE_SIZE;
                    break;
                default:
                    dY = 0;
            }
        } else {
            dY = 0;
        }
        dX = -dY;

        setLayoutX(Viewer.SQUARE_SIZE * shape.column + dX);
        setLayoutY(Viewer.SQUARE_SIZE * shape.row + dY);

        if (shape.type <= 'i') {
            if (shape.rotation >= 4) {
                setScaleX(1);
                setScaleY(-1);
            }
            setRotate(shape.rotation % 4 * 90);
        }
    }


}