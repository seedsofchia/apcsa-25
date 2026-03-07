package polygon;

import java.awt.geom.*; 
import java.util.Arrays;
import gpdraw.*;

public class TestSuite {
    public static void run(DrawingTool pen)
    {
        System.out.println("Starting TestSuite");
        boolean pass = true;

        double[][] singlePoint = { { 0, 0 } };
        pass &= basicTest("Single Point", singlePoint, 0, 0, pen, -150, -150);

        double[][] squarePoints = { { 0, 0 }, { 0, 100 }, { 100, 100 }, { 100, 0 } };
        pass &= basicTest("Unit Square", squarePoints, 400, 10000, pen, 50, 50);

        double[][] parallelogramPoints = { { 20, 10 }, { 70, 20 }, { 50, 50 }, { 0, 40 } };
        pass &= basicTest("Parallelogram", parallelogramPoints, 174.0914, 1700, pen, 50, -150);

        double[][] bowtiePoints = { { 0, 0 }, { 100, 50 }, { 100, 0 }, { 0, 50 } };
        pass &= basicTest("Bowtie", bowtiePoints, 323.6067, 0.0, pen, -50, -50);

        if (pass == true)
        {
            System.out.println("--- TEST PASSED! Congrats! ---");
        }
        else
        {
            System.out.println("--- TEST FAILED! :( ---");
        }
    }

    public static boolean basicTest(String description, double[][] points, double expectedPerimeter, double expectedArea, DrawingTool pen, double xOff, double yOff)
    {
        IrregularPolygon poly = new IrregularPolygon();
        for (double[] point : points)
        {
            poly.add(new Point2D.Double(point[0], point[1]));
        }

        poly.draw(pen, xOff, yOff);

        double perimeter = poly.perimeter();
        double area = poly.area();

        System.out.println(description + " - Perimeter: " + perimeter + ", Area: " + area);

        boolean perimeterCorrect = compareDoubles(perimeter, expectedPerimeter);
        boolean areaCorrect = compareDoubles(area, expectedArea);

        if (perimeterCorrect && areaCorrect)
        {
            System.out.println("PASS: " + description);
            return true;
        }
        else
        {
            System.out.println("FAIL: " + description);
            return false;
        }
    }

    private static boolean compareDoubles(Double a, Double b)
    {
        return Math.abs(a - b) < 0.001;
    }
}