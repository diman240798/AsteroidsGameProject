package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main extends Application {

    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Asteroids");
        Scene mainFrame = new Scene(root);
        primaryStage.setScene(mainFrame);
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
    boolean end = false;

    public void newGame(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("GamePane");
        GamePane gamePane = new GamePane();
        Scene scene = new Scene(gamePane);
        int i = 0;
        LittleEnemyCraft[] littleEnemyCrafts = new LittleEnemyCraft[5];
        for (int j = 0; j < littleEnemyCrafts.length; j++) {
            littleEnemyCrafts[j] = new LittleEnemyCraft(random.nextDouble() * 900, -random.nextDouble() * 500 - 100);
            //littleEnemyCrafts[j].getChildren().addAll(new Rectangle(32,23));
            gamePane.getChildren().addAll(littleEnemyCrafts[j]);
        }

        MediumEnemyCraft[] mediumEnemyCrafts = new MediumEnemyCraft[5];
        for (int j = 0; j < mediumEnemyCrafts.length; j++) {
            mediumEnemyCrafts[j] = new MediumEnemyCraft(random.nextDouble() * 900, -random.nextDouble() * 500 - 100);
            //mediumEnemyCrafts[j].getChildren().addAll(new Rectangle(38,49));
            gamePane.getChildren().addAll(mediumEnemyCrafts[j]);
        }
        BigEnemyCraft[] bigEnemyCrafts = new BigEnemyCraft[5];
        for (int j = 0; j < bigEnemyCrafts.length; j++) {
            bigEnemyCrafts[j] = new BigEnemyCraft(random.nextDouble() * 900, -random.nextDouble() * 500 - 100);
            //bigEnemyCrafts[j].getChildren().addAll(new Rectangle(62,91));
            gamePane.getChildren().addAll(bigEnemyCrafts[j]);
        }
        //gamePane.mainCraft.getChildren().addAll(new Rectangle(60,76));


        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                scene.setOnKeyPressed(event1 -> {
                    gamePane.startGame(event1);
                    if (event1.getCode() == KeyCode.SPACE) {
                        Bullet bullet = new Bullet(gamePane.mainCraft.getLayoutX() + 29, gamePane.mainCraft.getLayoutY() - 20);
                        gamePane.getChildren().addAll(bullet);
                    }
                });
                gamePane.setLayoutY(gamePane.getLayoutY() - 3);
                gamePane.imageView.setLayoutY(gamePane.imageView.getLayoutY() + 3);
                gamePane.mainCraft.setLayoutY(gamePane.mainCraft.getLayoutY() + 3);

                for (LittleEnemyCraft littleEnemyCraft : littleEnemyCrafts) {
                    if (littleEnemyCraft.getLayoutY() > gamePane.imageView.getLayoutY() + 900) {
                        littleEnemyCraft.setLayoutX(random.nextDouble() * 1000);
                        littleEnemyCraft.setLayoutY(gamePane.imageView.getLayoutY());
                    }
                    littleEnemyCraft.setLayoutY(littleEnemyCraft.getLayoutY() + 5);
                    if (gamePane.mainCraft.getLayoutY() - littleEnemyCraft.getLayoutY() < 23 &&
                            gamePane.mainCraft.getLayoutY() - littleEnemyCraft.getLayoutY() > 0 &&
                             ((gamePane.mainCraft.getLayoutX() - littleEnemyCraft.getLayoutX() < 32
                            && gamePane.mainCraft.getLayoutX() - littleEnemyCraft.getLayoutX() > 0)
                            || (littleEnemyCraft.getLayoutX() - gamePane.mainCraft.getLayoutX() < 60
                            && littleEnemyCraft.getLayoutX() - gamePane.mainCraft.getLayoutX() > 0)) ) {
                        /*System.out.println("Game End");
                        System.out.println("difY " + (gamePane.mainCraft.getLayoutY() - littleEnemyCraft.getLayoutY())
                                + "difX " + (gamePane.mainCraft.getLayoutX() - littleEnemyCraft.getLayoutX()) );*/
                        end = true;
                    }
                }
                for (MediumEnemyCraft mediumEnemyCraft : mediumEnemyCrafts) {
                    if (mediumEnemyCraft.getLayoutY() > gamePane.imageView.getLayoutY() + 900) {
                        mediumEnemyCraft.setLayoutX(random.nextDouble() * 1000);
                        mediumEnemyCraft.setLayoutY(gamePane.imageView.getLayoutY());
                    }
                    mediumEnemyCraft.setLayoutY(mediumEnemyCraft.getLayoutY() + 5);
                    if (gamePane.mainCraft.getLayoutY() - mediumEnemyCraft.getLayoutY() < 49 &&
                            gamePane.mainCraft.getLayoutY() - mediumEnemyCraft.getLayoutY() > 0 &&
                            ((gamePane.mainCraft.getLayoutX() - mediumEnemyCraft.getLayoutX() < 38
                                    && gamePane.mainCraft.getLayoutX() - mediumEnemyCraft.getLayoutX() > 0)
                                    || (mediumEnemyCraft.getLayoutX() - gamePane.mainCraft.getLayoutX() < 60
                                    && mediumEnemyCraft.getLayoutX() - gamePane.mainCraft.getLayoutX() > 0)) ) {
                        /*System.out.println("Game End");
                        System.out.println("difY " + (gamePane.mainCraft.getLayoutY() - mediumEnemyCraft.getLayoutY())
                                + "difX " + (gamePane.mainCraft.getLayoutX() - mediumEnemyCraft.getLayoutX()) );*/
                        end = true;
                    }
                }
                for (BigEnemyCraft bigEnemyCraft : bigEnemyCrafts) {
                    if (bigEnemyCraft.getLayoutY() > gamePane.imageView.getLayoutY() + 900) {
                        bigEnemyCraft.setLayoutX(random.nextDouble() * 1000);
                        bigEnemyCraft.setLayoutY(gamePane.imageView.getLayoutY());
                    }
                    bigEnemyCraft.setLayoutY(bigEnemyCraft.getLayoutY() + 5);
                    if (gamePane.mainCraft.getLayoutY() - bigEnemyCraft.getLayoutY() < 91 &&
                            gamePane.mainCraft.getLayoutY() - bigEnemyCraft.getLayoutY() > 0 &&
                            ((gamePane.mainCraft.getLayoutX() - bigEnemyCraft.getLayoutX() < 62
                                    && gamePane.mainCraft.getLayoutX() - bigEnemyCraft.getLayoutX() > 0)
                                    || (bigEnemyCraft.getLayoutX() - gamePane.mainCraft.getLayoutX() < 60
                                    && bigEnemyCraft.getLayoutX() - gamePane.mainCraft.getLayoutX() > 0)) ) {
                        /*System.out.println("Game End");
                        System.out.println("difY " + (gamePane.mainCraft.getLayoutY() - bigEnemyCraft.getLayoutY())
                                + "difX " + (gamePane.mainCraft.getLayoutX() - bigEnemyCraft.getLayoutX()) );*/
                        end = true;
                    }

                }
                if (end) {
                    endGame();
                }


            }

            private void endGame() {
                end = false;
                Pane pane = new Pane();
                Button btnNewGame = new Button("New Game");
                pane.getChildren().addAll(new ImageView(new Image("sprites/You_lose.png")), btnNewGame);
                stage.setScene(new Scene(pane));
            }
        };
        animationTimer.start();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setWidth(1110);
        stage.setHeight(787);
        stage.show();
    }

    public void ShowScores(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ScorePane scorePane = new ScorePane();
        stage.setTitle("Score");
        Scene scene = new Scene(scorePane);
        stage.setScene(scene);
        stage.setResizable(false);
        scorePane.method(new ArrayList<>(Arrays.asList(new Result("Dmitriy", 1000))));
        stage.show();

        /*
         Не работает
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Score.fxml"));
        stage.setTitle("Score");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        ScoreController scoreController = new ScoreController();
        scoreController.method(new ArrayList<>(Arrays.asList(new Result("Dmitriy", 1000))));
        stage.show();*/
    }

    public void settings(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        stage.setTitle("Settings");
        Scene mainFrame = new Scene(root);
        stage.setScene(mainFrame);
        stage.setResizable(false);
        stage.show();
    }
}
