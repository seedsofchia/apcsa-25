package polygon;

import java.awt.geom.*;
import gpdraw.*;

public class Main {
    public static void main(String [] args)
    {
        DrawingTool pen = new DrawingTool(new SketchPad(600, 600));
        
        IrregularPolygon myPolygon = new IrregularPolygon();
        myPolygon.add(new Point2D.Double(20, 10));
        myPolygon.add(new Point2D.Double(70, 20));
        myPolygon.add(new Point2D.Double(50, 50));
        myPolygon.add(new Point2D.Double(0, 40));
        
        myPolygon.draw(pen, -150, 150);

        System.out.println("Custom Polygon - Perimeter: " + myPolygon.perimeter() + ", Area: " + myPolygon.area());

        TestSuite.run(pen);
    }
}