https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package comp1110.ass2.gui;

import comp1110.ass2.gui.Viewer;
import comp1110.ass2.gui.Shape;
import comp1110.ass2.gui.ShapeView;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Board extends Application {
    // FIXME Task 7: Implement a basic playable Twist Game in JavaFX that only allows pieces to be placed in valid places
    //Code written by Shuning Ma u6151029

    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;
    public static final int SQUARE_SIZE = 60;
    public static final int PIECES_BOARD_WIDTH = 8 * SQUARE_SIZE;
    public static final int PIECES_BOARD_HEIGHT = 4 * SQUARE_SIZE;
    public static final double MARGIN_X = 226.5;
    public static final double MARGIN_Y = 350;
    public static final int ROW_SIZE = 4;
    private static final int COLUM_SIZE = 8;
    public static final int rowSize = 1;
    public static final int columnSize = 1;
    /*assets*/
    public static final String URI_BASE = "assets/";

    /*groups*/
    private final Group root = new Group();
    private final Group controls = new Group();
    private final Group pieces = new Group();
    private final Group solution = new Group();
    private final Group board = new Group();
    private final Group objective = new Group();

    /* variables*/
    private boolean dRagg = false;
    /*unplaced pieces*/
    public static final char UNPLACED_PIECES = 300;
    /* difficulty slider*/
    //private final Slider difficulty = new Slider();
    /* the state of the pieces*/
    char[] piecesState = new char[8];

    class playPieces extends ImageView {
        String piece;
        char p;

        playPieces(char p) {
            this.p = p;
            if (p>='a'&&p<='h') {
                throw new IllegalArgumentException("Bad pieces: \"" + p + "\"");
            }
                setImage(new Image(comp1110.ass2.gui.Board.class.getResource((comp1110.ass2.gui.Board.URI_BASE + p + ".png")).toString()));
                setFitHeight(Viewer.SQUARE_SIZE * rowSize);
                setFitWidth(Viewer.SQUARE_SIZE * columnSize);
        }

        /*Shape(char p,int x,int y){
            if(!(p>='a'&&p<='h')){
                throw new IllegalArgumentException("Bad pieces: \"" + p + "\"");
            }
        }*/
    }

    class MovePieces extends playPieces {
        double homeX;
        double homeY;
        double mouseA;
        double mouseB;
        Board b;
        boolean flip;

        MovePieces(char p) {
            super(p);
            //this.b = b;
            flip = false;
            piecesState[p - 'A'] = UNPLACED_PIECES;

            //original placement for pieces
            homeX = ((BOARD_WIDTH - (8 * SQUARE_SIZE)) / 2) + (SQUARE_SIZE * 4 * (((p - 'a') % 4)));
            setLayoutX(homeX);
            homeY = (MARGIN_X * 2) + (SQUARE_SIZE * ROW_SIZE) + (SQUARE_SIZE * 2 * ((p - 'a') / 4));
            setLayoutY(homeY);

            setOnScroll(event -> {
                setRotate((getRotate() + 90) % 360);
                event.consume();
            });

            /*setOnMouseClicked(event -> {
                MouseButton button = event.getButton();
                if (button == MouseButton.SECONDARY) {
                    if (!flip) {
                        setScaleY(-1);
                        flip = true;
                    } else if (flip) {
                        setScaleY(1);
                        flip = false;
                    }
                }
            });*/

            setOnMousePressed(event -> {
                mouseA = event.getSceneX();
                mouseB = event.getSceneY();
            });

            setOnMouseDragged(event -> {
                toFront();
                dRagg = true;
                double moveX = event.getSceneX() - mouseA;
                double moveY = event.getSceneY() - mouseB;
                setLayoutX(getLayoutX() + moveX);
                setLayoutY(getLayoutY() + moveY);
                mouseA = event.getSceneX();
                mouseB = event.getSceneY();
                event.consume();
            });

            setOnMouseReleased(event -> {
                if (dRagg) {
                    snapToGrid();
                    dRagg = false;
                }
            });
        }


        private void snapToHome() {
            setLayoutX(homeX);
            setLayoutY(homeY);
            setRotate(0);
        }

        private boolean isOnBoard(int x, int y) {
            return x >= 0 && x < 9 && y >= 0 && y < 5;
        }


        private void snapToGrid() {
            //Convert Y to a row relative to board
            int rowY = (int) ((getLayoutY() - (SQUARE_SIZE)) / (SQUARE_SIZE));

            //Convert X to a col relative to board
            int colX = (int) ((getLayoutX() - ((SQUARE_SIZE * 3))) / (SQUARE_SIZE));

            if (isOnBoard(colX, rowY) == false) {
                snapToHome();
            } else {
                snapToHome();
            }
        }
    }


        private void resetPieces() {
            pieces.toFront();
            for (Node node : pieces.getChildren()) {
                ((MovePieces) node).snapToHome();
            }
        }

        private void setHandler(Scene scene) {
            /* create handlers for key press and release events */
            scene.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.A) {
                    event.consume();
                } else if (event.getCode() == KeyCode.S) {
                    Platform.exit();
                    event.consume();
                } else if (event.getCode() == KeyCode.ENTER) {
                    solution.setOpacity(1.0);
                    pieces.setOpacity(0);
                    event.consume();
                }
            });
            scene.setOnKeyReleased(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    solution.setOpacity(0);
                    pieces.setOpacity(1.0);
                    event.consume();
                }
            });
        }

    /**
     * Represents the board
     */
    private void makeBoard(){
        board.getChildren().clear();
        ImageView baseboard = new ImageView();
        baseboard.setFitWidth(PIECES_BOARD_WIDTH);
        baseboard.setFitHeight(PIECES_BOARD_HEIGHT);
        baseboard.setLayoutX(MARGIN_X);
        board.getChildren().add(baseboard);
        board.toFront();
    }

    /**
     * Represents the pieces.
     */
    private void makePieces() {
        pieces.getChildren().clear();
        for (char p = 'a'; p <= 'h'; p++) {
            pieces.getChildren().add(new MovePieces(p));
        }
    }

        private void newOne() {
        makePieces();
        resetPieces();
        }

    /**
     * Add the objective to the board
     */
    /*private void addObjectiveToBoard() {
        objective.getChildren().clear();
        objective.getChildren().add(new Shape());
    }*/

        private void makeControls() {
            Button button = new Button("New One");
            button.setLayoutX(BOARD_WIDTH / 8 + 30);
            button.setLayoutY(BOARD_HEIGHT/4 - 45);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    newOne();
                }
            });
            controls.getChildren().add(button);

        }






    // FIXME Task 8: Implement starting placements

    // FIXME Task 10: Implement hints

    // FIXME Task 11: Generate interesting starting placements

    //Code written by Shuning Ma, u6151029.
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("comp1110.ass2.TwistGame comp1110.ass2.Board");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);

        root.getChildren().add(controls);
        root.getChildren().addAll(pieces);
        root.getChildren().add(board);
        root.getChildren().add(objective);

        /*for (int i = 0, j = 0; j < 5; ++j) {
            Line drawLine = new Line();
            drawLine.setStartX(0);
            drawLine.setStartY(i);
            drawLine.setEndX(8 * SQUARE_SIZE);
            drawLine.setEndY(i);
            pieces.getChildren().add(drawLine);
            i += SQUARE_SIZE;
        }

        for (int i = 0, j = 0; j < 9; ++j) {
            Line drawLine = new Line();
            drawLine.setStartX(i);
            drawLine.setStartY(0);
            drawLine.setEndX(i);
            drawLine.setEndY(SQUARE_SIZE * 4);
            pieces.getChildren().add(drawLine);
            i += SQUARE_SIZE;
        }*/

        setHandler(scene);
        makeBoard();
        makeControls();
        makePieces();

        newOne();

        pieces.setLayoutX(MARGIN_X);
        pieces.setLayoutY(MARGIN_Y);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
