package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.List;

/**
 * Created by diman on 16.12.2017.
 */
public class ScoreController {
    @FXML
    private TableView tableView;

    public void method(List<Result> list) {
        ObservableList<Result> data =
                FXCollections.observableArrayList(list);
        tableView.setItems(data);
    }

}
