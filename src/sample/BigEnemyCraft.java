package sample;

        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.Pane;

/**
 * Created by diman on 16.12.2017.
 */
public class BigEnemyCraft extends Pane{
    public BigEnemyCraft(double x, double y) {
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.getChildren().addAll(new ImageView(new Image("drawable/big.png")));
    }
}