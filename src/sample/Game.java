package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Game {
    public Group group;
    public Stage primarystage;
    public int Player_Score,random_pos,current_pos;
    public MoveBasket movebasket;
    public MoveTo prev_pos;
    public Ellipse new_egg;
    public ObservableList<String> records;
    public ListView<String> show_records;
    public Stat new_stat;
    public int dropped_eggs;
    public Timeline dropegg;
    public VBox Gameintro;

    public Game(Stage stage) {
        Player_Score = 0;
        current_pos = 2;
        new_stat = new Stat();
        records = new_stat.get();
        group = new Group();
        primarystage = stage;
        Gameintro = new VBox();
    }

    public void setstyle() {
        group = new Group();

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        Button newGame = new Button("New Game");
        Button stat = new Button("High Scores");
        Button exit = new Button("Exit");

        newGame.setMaxWidth(Double.MAX_VALUE);
        stat.setMaxWidth(Double.MAX_VALUE);
        exit.setMaxWidth(Double.MAX_VALUE);
        newGame.setStyle("-fx-font-size: 15pt;");
        stat.setStyle("-fx-font-size: 15pt;");
        exit.setStyle("-fx-font-size: 15pt;");

        Gameintro.setSpacing(10);
        Gameintro.setPadding(new Insets(0, 20, 10, 20));
        Gameintro.getChildren().addAll(newGame, stat, exit);
        Gameintro.setLayoutX(250);
        Gameintro.setLayoutY(150);

        Line line1 = new Line(0, 250, 200, 350);
        Line line2 = new Line(0, 150, 200, 250);
        Line line3 = new Line(700, 250, 500, 350);
        Line line4 = new Line(700, 150, 500, 250);

        line1.setStrokeWidth(15.0);
        line1.setStroke(Color.ORANGE);
        line2.setStrokeWidth(15.0);
        line2.setStroke(Color.ORANGE);
        line3.setStrokeWidth(15.0);
        line3.setStroke(Color.ORANGE);
        line4.setStrokeWidth(15.0);
        line4.setStroke(Color.ORANGE);


        Rectangle basket =new Rectangle();
        basket.setX(210);
        basket.setY(250);
        basket.setWidth(80);
        basket.setHeight(100);
        basket.setFill(Color.BROWN);
        basket.setArcHeight(35);
        basket.setArcWidth(35);

        Button leftup = new Button("");
        Button leftbottom = new Button("");
        Button rightup = new Button("");
        Button rightbottom = new Button("");
        leftup.setStyle("-fx-background-color: #964B00");
        leftbottom.setStyle("-fx-background-color: #964B00");
        rightup.setStyle("-fx-background-color: #964B00");
        rightbottom.setStyle("-fx-background-color: #964B00");

        Button ok = new Button("Close");
        ok.setStyle("-fx-font-size: 15pt;");
        ok.setLayoutX(300);
        ok.setLayoutY(400);
        ok.setMaxWidth(Double.MAX_VALUE);

        leftup.setMinWidth(230);
        leftup.setMinHeight(75);
        leftup.setLayoutX(0);
        leftup.setLayoutY(155);

        leftbottom.setMinWidth(230);
        leftbottom.setMinHeight(75);
        leftbottom.setLayoutX(0);
        leftbottom.setLayoutY(255);

        rightup.setMinWidth(230);
        rightup.setMinHeight(75);
        rightup.setLayoutX(495);
        rightup.setLayoutY(260);

        rightbottom.setMinWidth(230);
        rightbottom.setMinHeight(75);
        rightbottom.setLayoutX(495);
        rightbottom.setLayoutY(360);

        leftup.getTransforms().add(new Rotate(27, 0, 0));
        leftbottom.getTransforms().add(new Rotate(27, 0, 0));
        rightup.getTransforms().add(new Rotate(-27,0,0));
        rightbottom.getTransforms().add(new Rotate(-27,0,0));

        prev_pos = new MoveTo(250,300);
        current_pos = 2;

        leftbottom.setOnAction(actionEvent ->  {
            movebasket = new MoveBasket(prev_pos,basket,1);
            current_pos = 1;
            prev_pos = movebasket.new_pos();
            movebasket.move();
        });

        leftup.setOnAction(actionEvent ->  {
            movebasket = new MoveBasket(prev_pos,basket,2);
            current_pos = 2;
            prev_pos = movebasket.new_pos();
            movebasket.move();
        });

        rightup.setOnAction(actionEvent ->  {
            movebasket = new MoveBasket(prev_pos,basket,3);
            current_pos = 3;
            prev_pos = movebasket.new_pos();
            movebasket.move();
        });

        rightbottom.setOnAction(actionEvent ->  {
            movebasket = new MoveBasket(prev_pos,basket,4);
            current_pos = 4;
            prev_pos = movebasket.new_pos();
            movebasket.move();
        });

        TextField input = new TextField();
        Button save = new Button("Save");
        save.setMinWidth(input.getWidth());
        save.setMinHeight(40);
        input.setPromptText("Enter your name.");
        input.setFont(new Font("Arial", 20));
        input.setLayoutX(230);
        input.setLayoutY(300);
        save.setLayoutX(230);
        save.setLayoutY(330);

        HBox Score = new HBox();
        Label text = new Label();
        text.setFont(new Font("Arial", 50));
        text.setText(Integer.toString(Player_Score));
        text.setTextFill(Color.web("#fff"));
        text.setPadding(new Insets(25, 30, 50, 25));
        Score.getChildren().addAll(text);
        Score.setLayoutX(310);

        Label lost = new Label();
        lost.setFont(new Font("Arial", 50));
        lost.setTextFill(Color.web("#fff"));
        lost.setText("You Lost");
        lost.setLayoutX(250);
        lost.setLayoutY(100);


        Image img = new Image("/background.jpg");
        ImageView background = new ImageView(img);

        background.setFitHeight(500);
        background.setFitWidth(700);
        group.getChildren().addAll(background);
        group.getChildren().add(line1);
        group.getChildren().add(line2);
        group.getChildren().add(line3);
        group.getChildren().add(line4);
        group.getChildren().add(Score);
        group.getChildren().add(leftbottom);
        group.getChildren().add(leftup);
        group.getChildren().add(rightup);
        group.getChildren().add(rightbottom);
        group.getChildren().add(basket);
        group.getChildren().add(Gameintro);
        Gameintro.toFront();


        Timeline checkscore = new Timeline(new KeyFrame(Duration.seconds(4.5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (random_pos == current_pos)
                    Player_Score++;
                else
                    dropped_eggs++;
                text.setText(Integer.toString(Player_Score));
                group.getChildren().remove(new_egg);
            }
        }));

        dropegg = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
            if (dropped_eggs >= 3) {
                dropegg.stop();
                group.getChildren().add(lost);
                group.getChildren().add(input);
                group.getChildren().add(save);
                basket.toBack();
            }
            else {
                random_pos = ((int) (Math.random() * (5 - 1))) + 1;
                Egggenerator egg = new Egggenerator();
                new_egg = egg.generate();
                Animation animation = new Animation(new_egg, random_pos);
                group.getChildren().add(new_egg);
                basket.toFront();
                animation.animate();
                checkscore.play();
            }
        }));

        save.setOnAction(e -> {
            group.getChildren().remove(save);
            group.getChildren().remove(input);
            group.getChildren().remove(lost);
            group.getChildren().add(Gameintro);
            String data = input.getText();
            records.add(Player_Score + " - " + data);
            new_stat.save(records);
        });

        ok.setOnAction(actionEvent -> {
            group.getChildren().remove(show_records);
            group.getChildren().remove(ok);
        });

        newGame.setOnAction(actionEvent ->  {
            group.getChildren().remove(Gameintro);
            dropped_eggs = 0;
            Player_Score = 0;
            dropegg.setCycleCount(Timeline.INDEFINITE);
            dropegg.play();
        });

        stat.setOnAction(actionEvent -> {
            show_records = new_stat.records(records);
            group.getChildren().add(show_records);
            group.getChildren().add(ok);
            ok.toFront();
        });

        exit.setOnAction(actionEvent -> {
            primarystage.close();
        });
    }

    public Scene setscene() {
        Scene scene = new Scene(group, 700, 500);
        KeyCombination combintation = new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_ANY,KeyCombination.SHIFT_ANY);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(final KeyEvent keyEvent) {
                if (combintation.match(keyEvent)) {
                    dropegg.stop();
                    group.getChildren().remove(new_egg);
                    group.getChildren().add(Gameintro);
                    Player_Score = 0;
                    keyEvent.consume();
                }
            }
        });
        return scene;
    }
}
    