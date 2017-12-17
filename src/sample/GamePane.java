package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.Random;

public class GamePane extends Pane {
    Random random = new Random();
    MainCraft mainCraft;
    ImageView imageView;
    GamePane() {
        imageView = new ImageView(new Image("/sprites/GameFrame.JPG"));
        this.getChildren().addAll(imageView);
        this.setWidth(1110);
        this.setHeight(787);

        mainCraft = new MainCraft();
        mainCraft.setLayoutY(670);
        mainCraft.setLayoutX(200 + random.nextDouble() * 700);
        this.getChildren().addAll(mainCraft);

    }

    public void startGame(KeyEvent event) {
        mainCraft.move(event);


    }
}
