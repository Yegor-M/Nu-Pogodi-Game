package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.Random;

public class Animation {
    public RotateTransition rotateTransition;
    public PathTransition pathTransition;
    public Ellipse egg;
    public Path path;

    public Animation(Ellipse new_egg,int random) {
        egg = new_egg;
        rotateTransition = new RotateTransition(Duration.seconds(5), egg);
        rotateTransition.setCycleCount(2);
        rotateTransition.setAutoReverse(true);
        pathTransition = new PathTransition(Duration.seconds(5), egg);
        path = new Path();
        switch (random) {
            case 1:
                dropfromleft();
                leftbottompath();
                break;
            case 2:
                dropfromleft();
                leftuppath();
                break;
            case 3:
                dropfromright();
                rightuppath();
                break;
            case 4:
                dropfromright();
                rightbottompath();
                break;
        }
        pathTransition.setNode(egg);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(1);
    }

    public void leftuppath() {
        path.getElements().add(new MoveTo(0, 100));
        path.getElements().add(new LineTo(220, 210));
        path.getElements().add(new LineTo(250, 300));
    }

    public void leftbottompath() {
        path.getElements().add(new MoveTo(0, 200));
        path.getElements().add(new LineTo(220, 310));
        path.getElements().add(new LineTo(250, 400));
    }

    public void rightuppath() {
        path.getElements().add(new MoveTo(700, 100));
        path.getElements().add(new LineTo(480, 210));
        path.getElements().add(new LineTo(450, 300));
    }

    public void rightbottompath() {
        path.getElements().add(new MoveTo(700, 200));
        path.getElements().add(new LineTo(480, 310));
        path.getElements().add(new LineTo(450, 400));
    }

    public void dropfromleft() {
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(180);
    }

    public void dropfromright() {
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(-180);
    }

    public void animate() {
        ParallelTransition parallelTransition = new ParallelTransition(egg);
        parallelTransition.getChildren().addAll(rotateTransition, pathTransition);
        parallelTransition.setCycleCount(1);
        parallelTransition.setAutoReverse(true);
        parallelTransition.play();
    }
}
