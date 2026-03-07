package polygon;

import java.awt.geom.*;

public class Main {
    public static void main(String [] args)
    {
        IrregularPolygon myPolygon = new IrregularPolygon();
        myPolygon.add(new Point2D.Double(20, 10));
        myPolygon.add(new Point2D.Double(70, 20));
        myPolygon.add(new Point2D.Double(50, 50));
        myPolygon.add(new Point2D.Double(0, 40));
        myPolygon.draw();

        TestSuite.run();
    }
    
}
