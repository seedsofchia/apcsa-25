package robot;
import kareltherobot.*;


public class Starter implements Directions{

  public static void main(String[] args) {


    World.setVisible(true);// allows us to see the run output
    // the bigger the street, the farther north
    World.setSize(20,20);
    World.setDelay(4);

    // The line below creates a Robot that we will refer to as rob
    // Find out what the numbers and direction do!
    // Put rob in a better location for your initials.
    Robot rob = new Robot(15,2,South,100);
    // Want a second robot?  No prob.  They are cheap :)
    //Robot dude = new Robot(7,5,West,9);
    // examples of commands you can invoke on a Robot
    rob.move();// move one step in the direction it is facing
   


    // starting the letter R
    rob.putBeeper();
    rob.turnLeft();
    rob.move();
    rob.turnLeft();
    rob.move();
    rob.putBeeper();
    turnRight(rob);
    rob.turnLeft();
    rob.move();
    turnRight(rob);
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.turnLeft();
    rob.move();
    rob.putBeeper();
    rob.move();
    turnRight(rob);
    rob.move();
    rob.putBeeper();
    turnRight(rob);
    rob.move();
    rob.turnLeft();
    rob.move();
    rob.putBeeper();
    turnRight(rob);
    rob.move();
    rob.turnLeft();
    rob.move();
    rob.putBeeper();
    rob.move();
    turnRight(rob);
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.turnLeft();
    rob.move();
    rob.putBeeper();
    turnRight(rob);
    rob.move();
    turnRight(rob);
    rob.move();
    rob.putBeeper();
    rob.turnLeft();
    rob.move();
    turnRight(rob);
    rob.move();
    rob.putBeeper();
    rob.turnLeft();
    rob.move();
    turnRight(rob);
    rob.move();
    rob.putBeeper();
    rob.turnLeft();
    rob.move();
    turnRight(rob);
    rob.move();
    rob.putBeeper();
    rob.move();
    turnRight(rob);
    rob.move();
    rob.turnLeft();
    rob.putBeeper();
    rob.move();
    turnRight(rob);
    rob.move();
    rob.putBeeper();
    rob.move();
 rob.turnLeft();
    rob.move();
    rob.putBeeper();
    rob.move();
    rob.move();


    
  

    // done with the line, now on the curve
    // rob.turnLeft();

  }
public static void turnRight(Robot rob){
  for (int i = 0; i < 3; i++)
  rob.turnLeft();

}
public static void moveForward(Robot rob,int times){
  for (int i = 0; i < times; i++){
    rob.move();
  }
}
}
