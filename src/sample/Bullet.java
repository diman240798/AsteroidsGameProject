package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by diman on 16.12.2017.
 */
public class Bullet extends Pane {
    Bullet(double x, double y) {
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.getChildren().addAll(new ImageView(new Image("drawable/blue_bullet.png")));
    }

    public void move() {
        double y = this.getLayoutY();
        System.out.println(y);
        while (y > -5)
        this.setLayoutY(y-=0.000001);
    }
}
