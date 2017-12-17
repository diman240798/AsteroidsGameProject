package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Arrays;
import java.util.List;

/**
 * Created by diman on 16.12.2017.
 */
public class ScorePane extends Pane {
    public ScorePane() {
        this.setWidth(607);
        this.setHeight(407);
        this.getChildren().addAll(new ImageView(new Image("sprites/ScoreFrame.jpg")));
    }
    public void method(List<Result> list) {
        TableView tableView = new TableView<>();
        TableColumn<Result, String> tableColumn1 = new TableColumn("PlayerName");
        TableColumn<Result, Integer> tableColumn2 = new TableColumn("Score");
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("result"));
        tableView.getColumns().addAll(tableColumn1, tableColumn2);
        ObservableList<Result> data =
                FXCollections.observableArrayList(list);
        tableView.setItems(data);
        tableView.setLayoutX(58);
        tableView.setLayoutY(100);
        tableView.setOpacity(0.76);
        this.getChildren().addAll(tableView);
    }
}
