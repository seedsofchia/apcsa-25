package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // TODO: Calculate the perimeter.
        if (myPolygon.size() < 2) {
            return 0.0;
        }

        double perimeter = 0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());
            perimeter += current.distance(next);
        }
        return perimeter;
    }

    public double area() {
        // TODO: Calculate the area.
        
        Double area = 0.0;
        if (myPolygon.size() < 3) {
            return 0.0;
        }

        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());
            area += (current.getX() * next.getY());
            area -= (next.getX() * current.getY());
        }

        area = Math.abs(area / 2.0);
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
            if (myPolygon.size() > 0) {
                DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
                pen.up();
                pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
                pen.down();

                for (int i = 1; i < myPolygon.size(); i++) {
                    pen.move(myPolygon.get(i).getX(), myPolygon.get(i).getY());
                }

                pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
            }
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}