import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
         for (Point currPt : s.getPoints()){
             count++;
         }
        return count;
    }

    public double getAverageLength(Shape s) {
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        double all = 0;
        double count = 0;
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            all += currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
            count++;
        }
        return all/count;
    }

    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        double max = 0;
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            if (max<currDist) max = currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return max;
    }

    public double getLargestX(Shape s) {
        double lX = s.getLastPoint().getX();
        for (Point currPt : s.getPoints()) {
            if (lX<currPt.getX())lX = currPt.getX();
        }
        return lX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dir = new DirectoryResource();
        double max = 0;
        for (File f:dir.selectedFiles()){
          FileResource fr = new FileResource(f);
          Shape s = new Shape(fr);
          double length = getPerimeter(s);
          if (max < length) max = length;
        }
        return max;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dir = new DirectoryResource();
        double max = 0;
        File temp = null;
        for (File f:dir.selectedFiles()){
          FileResource fr = new FileResource(f);
          Shape s = new Shape(fr);
          double length = getPerimeter(s);
          if (max < length) {
            max = length;
            temp = f;
          }
        }
            // replace this code
        return temp.getName();
    }



    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

        public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        double num = getNumPoints(s);
        double avlen = getAverageLength(s);
        double lside = getLargestSide(s);
        double lX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("points num = " + num);
        System.out.println("av len = " + avlen);
        System.out.println("large side = " + lside);
        System.out.println("large x = " + lX);
    }
    
    public void testPerimeterMultipleFiles() {
        double l = getLargestPerimeterMultipleFiles();
        System.out.println("l perimeter = " + l);
    }

    public void testFileWithLargestPerimeter() {
        System.out.println("l perimeter file= " + getFileWithLargestPerimeter());
    }
    
    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testFileWithLargestPerimeter();
    }
}
