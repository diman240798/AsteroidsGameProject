package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by diman on 16.12.2017.
 */
public class LittleEnemyCraft extends Pane{
    public LittleEnemyCraft(double x, double y) {
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.getChildren().addAll(new ImageView(new Image("drawable/small.png")));
    }

}
