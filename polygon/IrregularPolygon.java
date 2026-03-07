package polygon;

import java.awt.geom.*; 
import java.util.ArrayList; 
import gpdraw.*; 

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    public IrregularPolygon() {}

    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        if (myPolygon.size() < 2) return 0.0;
        double perimeter = 0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());
            perimeter += current.distance(next);
        }
        return perimeter;
    }

    public double area() {
        if (myPolygon.size() < 3) return 0.0;
        double area = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % myPolygon.size());
            area += (current.getX() * next.getY()) - (next.getX() * current.getY());
        }
        return Math.abs(area / 2.0);
    }

    public void draw(DrawingTool pen, double xOffset, double yOffset)
    {
        try {
            if (myPolygon.size() > 0) {
                pen.up();
                pen.move(myPolygon.get(0).getX() + xOffset, myPolygon.get(0).getY() + yOffset);
                pen.down();
                for (int i = 1; i < myPolygon.size(); i++) {
                    pen.move(myPolygon.get(i).getX() + xOffset, myPolygon.get(i).getY() + yOffset);
                }
                pen.move(myPolygon.get(0).getX() + xOffset, myPolygon.get(0).getY() + yOffset);
            }
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }
}