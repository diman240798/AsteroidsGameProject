package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * Created by diman on 16.12.2017.
 */
public class MainCraft extends Pane {
    public MainCraft() {
        ImageView imageView = new ImageView(new Image("drawable/plane.png"));
        this.getChildren().addAll(imageView);
    }

    public void move(KeyEvent event) {
            switch (event.getCode()) {
                case A:
                    if (this.getLayoutX() > 0)
                        this.setLayoutX(this.getLayoutX() - 5);
                    break;
                case D:
                    if (this.getLayoutX() < 1039)
                        this.setLayoutX(this.getLayoutX() + 5);
                    break;
            }
    }
}
