package sample;

import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;

public class MoveBasket {
    public static MoveTo movefrom;
    public static LineTo moveto;
    public static PathTransition pathTransition;
    public MoveBasket(MoveTo prev_place,Rectangle basket,int side) {
        Path path = new Path();
        movefrom = prev_place;

        switch (side) {
            case 1:
                moveto = leftbottom();
                break;
            case 2:
                moveto = leftup();
                break;
            case 3:
                moveto = rightup();
                break;
            case 4:
                moveto = rightbottom();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + side);
        }

        path.getElements().add(movefrom);
        path.getElements().addAll(moveto);
        pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(0.5 ));
        pathTransition.setNode(basket);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        movefrom = new MoveTo(moveto.getX(),moveto.getY());
    }

    public LineTo leftup() {
        return new LineTo(250, 300);
    }

    public LineTo leftbottom() {
        return new LineTo(250, 400);
    }

    public LineTo rightup() {
        return new LineTo(450, 300);
    }

    public LineTo rightbottom() {
        return new LineTo(450, 400);
    }

    public void move() {
        pathTransition.play();
    }

    public MoveTo new_pos() {
        return movefrom;
    }
}
