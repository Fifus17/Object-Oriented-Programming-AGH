package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    private AbstractWorldMap map;
    private GridPane grid;
    private SimulationEngine engine;

    public void init() throws Exception {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(5, 5)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
    }

    private void drawMap() {
        Label axis = new Label("y/x");
        axis.setFont(new Font(16));
        this.grid = new GridPane();
        grid.add(axis, 0, 0);
        GridPane.setHalignment(axis, HPos.CENTER);
        for (int i = 0; i <= map.getTopRight().x - map.getBottomLeft().x; i++) {
            Label idx = new Label("" + (map.getBottomLeft().x + i));
            idx.setFont(new Font(16));
            grid.add(idx, i + 1, 0);
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
                    Label square = new Label(map.objectAt(curMapPos).toString());
                    square.setFont(new Font(16));
                    grid.add(square, i + 1, j + 1);
                    GridPane.setHalignment(square, HPos.CENTER);

                } else {
                    Label square = new Label(" ");
                    square.setFont(new Font(16));
                    grid.add(square, i + 1, j + 1);
                    GridPane.setHalignment(square, HPos.CENTER);
                }
            }
        }
        for (int k = 0; k <= map.getTopRight().x - map.getBottomLeft().x + 1; k++) grid.getColumnConstraints().add(new ColumnConstraints(30));

        for (int l = 0; l <= map.getTopRight().y - map.getBottomLeft().y + 1; l++) grid.getRowConstraints().add(new RowConstraints(30));
        grid.setGridLinesVisible(true);
    }

    public void start(Stage primaryStage) {
        drawMap();
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
