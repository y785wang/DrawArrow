package arrow;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class Arrow extends Group {

    // simple version arrow
    Line line;
    Polygon triangle;
    double startX;
    double startY;
    double endX;
    double endY;

    public Arrow() {

    }

    public void update() {
        line = new Line();
        line.setStroke(Color.color(0, 1, 0));
        line.setStrokeWidth(3);

        triangle = new Polygon();
        triangle.setFill(Color.TRANSPARENT);
        triangle.setStroke(Color.color(0, 1, 0));
        triangle.setStrokeWidth(3);

        double width = Math.sqrt(Math.pow((endY - startY), 2) + Math.pow((endX - startX), 2));

        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(startX + width/4*3);
        line.setEndY(startY);

        triangle.getPoints().addAll(new Double[] {
                startX + width/4*3, startY+10,
                startX + width/4*3, startY-10,
                startX + width, startY });

        line.getTransforms().clear();
        triangle.getTransforms().clear();
        double degree = Math.atan((endY - startY) / (endX - startX)) / (2 * Math.PI) * 360;
        if (startX > endX) { degree += 180; }
        Rotate rotate = new Rotate(degree, startX, startY);
        line.getTransforms().add(rotate);
        triangle.getTransforms().add(rotate);

        getChildren().addAll(line, triangle);
    }

    public void setStart(double startX, double startY) {
        getChildren().clear();
        this.startX = startX;
        this.startY = startY;
    }

    public void setEnd(double endX, double endY) {
        getChildren().clear();
        this.endX = endX;
        this.endY = endY;
    }
}