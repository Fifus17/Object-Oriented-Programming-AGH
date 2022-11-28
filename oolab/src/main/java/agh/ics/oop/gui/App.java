package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.util.Arrays;

public class App extends Application implements IAnimalObserver{

    private GrassField map;
    private GridPane grid;
    private SimulationEngine engine;

    public void init() throws Exception {
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(5, 5)};
        this.engine = new SimulationEngine(map, positions);
        this.engine.addObserver(this);
        this.engine.setDelay(300);
        this.grid = new GridPane();
        System.out.println(map);
    }

    private void drawMap(boolean flag) {
        grid.setGridLinesVisible(false);
        grid.setGridLinesVisible(true);
        Label axis = new Label("y/x");
        axis.setFont(new Font(16));
        grid.add(axis, 0, 0);
        GridPane.setHalignment(axis, HPos.CENTER);
        GuiElementBox elementCreator;
        try {
            elementCreator = new GuiElementBox();
            for (int k = 0; k <= map.getTopRight().x - map.getBottomLeft().x; k++) {
                Label idx = new Label("" + (map.getBottomLeft().x + k));
                idx.setFont(new Font(16));
                grid.add(idx, k + 1, 0);
                GridPane.setHalignment(idx, HPos.CENTER);
            }

            for (int i = 0; i <= map.getTopRight().y - map.getBottomLeft().y; i++) {
                Label idx = new Label("" + (map.getTopRight().y - i));
                idx.setFont(new Font(16));
                grid.add(idx, 0, i + 1);
                GridPane.setHalignment(idx, HPos.CENTER);
            }

            for (int i = 0; i <= map.getTopRight().x - map.getBottomLeft().x; i++) {
                for (int j = 0; j <= map.getTopRight().y - map.getBottomLeft().y; j++) {
                    Vector2d curMapPos = new Vector2d(map.getBottomLeft().x + i, map.getTopRight().y - j);
                    if (map.objectAt(curMapPos) != null) {
                        VBox sq = elementCreator.mapElementView((IMapElement) map.objectAt(curMapPos));
                        grid.add(sq, i + 1, j + 1);
                        GridPane.setHalignment(sq, HPos.CENTER);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't load files");
            if (!flag) {
                for (int k = 0; k <= map.getTopRight().x - map.getBottomLeft().x + 1; k++)
                    grid.getColumnConstraints().add(new ColumnConstraints(30));
                for (int l = 0; l <= map.getTopRight().y - map.getBottomLeft().y + 1; l++)
                    grid.getRowConstraints().add(new RowConstraints(30));
            }
        }
    }

    public void start(Stage primaryStage) throws Exception {

        TextField movesInput = new TextField();
        Button startButton = new Button("Start");
        VBox inputBox = new VBox(movesInput, startButton);
        VBox appBox = new VBox(this.grid, inputBox);
        grid.setAlignment(Pos.CENTER);
        inputBox.setAlignment(Pos.CENTER);
        appBox.setAlignment(Pos.CENTER);
        movesInput.setMaxWidth(80);


        drawMap(false);
        Scene scene = new Scene(appBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        startButton.setOnAction(ev -> {
            String[] args = movesInput.getText().split("");
            MoveDirection[] directions = new OptionsParser().parse(args);
            engine.setMoves(directions);
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });
    }
    @Override
    public void animalMoved() {
        Platform.runLater(() -> {
            grid.getChildren().clear();
            drawMap(true);
        });
    }
}
