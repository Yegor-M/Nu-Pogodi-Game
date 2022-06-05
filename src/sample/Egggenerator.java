package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Egggenerator {
    public Ellipse egg;
    public Egggenerator() {
    }

    public Ellipse generate() {
        egg = new Ellipse();
        egg.setFill(Color.LIGHTYELLOW);
        egg.setCenterX(50.0);
        egg.setCenterY(100.0);
        egg.setRadiusX(25.0);
        egg.setRadiusY(35.0);
        return egg;
    }
}
