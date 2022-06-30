
/**
 * Write a description of class TurtleLab here.
 *
 * @author kittyk4t (Katiana Wieser)
 * @version 09/05/17
 */
import java.awt.Color;
public class TurtleLab
{
    public static void main (String[] args)
    {
        //I got the RGB values from rapidtables.com 
        Color myPink=new Color(255,105,180); 
        Color myPurple=new Color(148,0,211);
        Color myOrange=new Color(255,140,0);
        Color myGreen=new Color(50,205,50);
        Color myBlue=new Color(30,144,255);
        Color myCyan=new Color(0,206,209);
        
        World myWorld= new World(1000,1000);
        Turtle mini= new Turtle(myWorld);
        Turtle wieser= new Turtle(myWorld);
        Turtle jene=new Turtle(myWorld);
        
        //mirrorM will follow mini's movements
        //mirrorW will follow wieser's movements
        Turtle mirrorM=new Turtle(myWorld);
        Turtle mirrorW=new Turtle(myWorld);
        Turtle mirrorJ=new Turtle(myWorld);
        
        // setup mini
        mini.penUp();
        mini.setShellColor(myPurple);
        mini.setWidth(10);
        mini.setHeight(10);
        mini.setPenWidth(2);
        mini.forward(100);
        mini.turn(45);
        mini.setPenColor(myPurple);
        mini.penDown();
        
        //first "petal" 
        mini.turn(-20);
        mini.forward(100);
        mini.moveTo(300,300);
        mini.moveTo(200,300);
        mini.turn(100);
        mini.forward(50);
        mini.moveTo(500,400);
        
        //second "petal"
        mini.turn(20);
        mini.forward(100);
        mini.moveTo(400,800);
        mini.moveTo(400,800);
        mini.moveTo(500,400);
        
        // third "petal"
        mini.turn(20);
        mini.forward(100);
        mini.moveTo(800,100);
        mini.moveTo(400,200);
        mini.moveTo(500,400);
        
        // fourth "petal"
        mini.turn(40);
        mini.forward(100);
        mini.moveTo(900,500);
        mini.moveTo(950,200);
        mini.moveTo(500,400);
        
        // fifth "petal"
        mini.turn(270);
        mini.forward(100);
        mini.moveTo(100,800);
        mini.moveTo(50,800);
        mini.moveTo(500,400);
        
        //setup mirrorM
        mirrorM.setPenColor(myGreen);
        mirrorM.setPenWidth(2);
        mirrorM.setShellColor(myGreen);
        
        //first "petal"
        mirrorM.turn(-10);
        mirrorM.forward(100);
        mirrorM.moveTo(290,290);
        mirrorM.moveTo(190,290);
        mirrorM.turn(98);
        mirrorM.forward(50);
        mirrorM.moveTo(500,400);
        
        //second "petal"
        mirrorM.turn(10);
        mirrorM.forward(100);
        mirrorM.moveTo(390,790);
        mirrorM.moveTo(390,7900);
        mirrorM.moveTo(500,400);
        
        // third "petal"
        mirrorM.turn(10);
        mirrorM.forward(100);
        mirrorM.moveTo(790,90);
        mirrorM.moveTo(390,190);
        mirrorM.moveTo(500,400);
        
        // fourth "petal"
        mirrorM.turn(30);
        mirrorM.forward(100);
        mirrorM.moveTo(890,490);
        mirrorM.moveTo(940,190);
        mirrorM.moveTo(500,400);
        
        // fifth "petal"
        mirrorM.turn(260);
        mirrorM.forward(100);
        mirrorM.moveTo(90,790);
        mirrorM.moveTo(40,790);
        mirrorM.moveTo(500,400);

  
        //set up wieser
        wieser.setPenWidth(2);
        wieser.penUp();
        wieser.setShellColor(myOrange);
        wieser.setPenColor(myOrange);
        
        // first "petal"
        wieser.forward(100);
        wieser.turn(20);
        wieser.penDown();
        wieser.moveTo(150,150);
        wieser.turn(-85);
        wieser.moveTo(100,150);
        wieser.turn(-100);      
        wieser.forward(50);
        wieser.moveTo(500,400);
        
        //second "petal"
        wieser.forward(100);
        wieser.turn(20);
        wieser.penDown();
        wieser.moveTo(800,800);
        wieser.turn(-85);
        wieser.moveTo(890,900);
        wieser.turn(-100);      
        wieser.forward(50);
        wieser.moveTo(500,400);
        
        // third "petal"
        wieser.forward(100);
        wieser.turn(20);
        wieser.penDown();
        wieser.moveTo(800,50);
        wieser.turn(-85);
        wieser.moveTo(890,150);
        wieser.turn(-100);      
        wieser.forward(50);
        wieser.moveTo(500,400);
        
        // fourth "petal"
        wieser.forward(100);
        wieser.turn(60);
        wieser.penDown();
        wieser.moveTo(850,550);
        wieser.turn(-85);
        wieser.moveTo(920,300);
        wieser.turn(-100);      
        wieser.moveTo(500,400);
        
        // fifth "petal"
        wieser.forward(100);
        wieser.turn(160);
        wieser.penDown();
        wieser.moveTo(50,550);
        wieser.turn(-85);
        wieser.moveTo(20,300);
        wieser.turn(-100);      
        wieser.moveTo(500,400);
        
        //setup mirrorW
        mirrorW.setPenWidth(2);
        mirrorW.setShellColor(myCyan);
        mirrorW.setPenColor(myCyan);
        
        // first "petal"
        mirrorW.forward(100);
        mirrorW.turn(10);
        mirrorW.penDown();
        mirrorW.moveTo(140,140);
        mirrorW.turn(-75);
        mirrorW.moveTo(90,140);
        mirrorW.turn(-98);      
        mirrorW.forward(40);
        mirrorW.moveTo(500,400);
        
        //second "petal"
        mirrorW.forward(100);
        mirrorW.turn(10);
        mirrorW.penDown();
        mirrorW.moveTo(790,790);
        mirrorW.turn(-75);
        mirrorW.moveTo(880,890);
        mirrorW.turn(-98);      
        mirrorW.forward(40);
        mirrorW.moveTo(500,400);
        
        // third "petal"
        mirrorW.forward(100);
        mirrorW.turn(10);
        mirrorW.penDown();
        mirrorW.moveTo(790,40);
        mirrorW.turn(-75);
        mirrorW.moveTo(880,140);
        mirrorW.turn(-98);      
        mirrorW.forward(40);
        mirrorW.moveTo(500,400);
        
        // fourth "petal"
        mirrorW.forward(100);
        mirrorW.turn(50);
        mirrorW.penDown();
        mirrorW.moveTo(840,540);
        mirrorW.turn(-75);
        mirrorW.moveTo(910,290);
        mirrorW.turn(-98);      
        mirrorW.moveTo(500,400);
        
        // fifth "petal"
        mirrorW.forward(100);
        mirrorW.turn(150);
        mirrorW.penDown();
        mirrorW.moveTo(40,540);
        mirrorW.turn(-75);
        mirrorW.moveTo(10,290);
        mirrorW.turn(-98);      
        mirrorW.moveTo(500,400);
        
        //setup jene
        jene.setShellColor(myBlue);
        jene.setPenColor(myBlue);
        jene.setPenWidth(2);
        
        //first "petal"
        jene.moveTo(600,800);
        jene.turn(60);
        jene.forward(150);
        jene.turn(-100);
        jene.moveTo(500,400);
        
        //second "petal"
        jene.turn(-150);
        jene.forward(500);
        jene.turn(50);
        jene.forward(100);
        jene.turn(80);
        jene.forward(100);
        jene.turn(70);
        jene.forward(500);
        
        //third "petal"
        jene.moveTo(350,50);
        jene.turn(50);
        jene.forward(80);
        jene.turn(80);
        jene.forward(50);
        jene.turn(100);
        jene.moveTo(500,400);
        
        //fourth "petal"
        jene.moveTo(20,590);
        jene.moveTo(25,750);
        jene.moveTo(50,725);
        jene.moveTo(500,400);
        
        //fifth "petal"
        jene.moveTo(900,20);
        jene.moveTo(920,160);
        jene.moveTo(500,400);
        
        //setup mirrorJ
        mirrorJ.setPenWidth(2);
        mirrorJ.setPenColor(myPink);
        mirrorJ.setShellColor(myPink);
        
         //first "petal"
        mirrorJ.moveTo(610,810);
        mirrorJ.turn(70);
        mirrorJ.forward(160);
        mirrorJ.turn(-110);
        mirrorJ.moveTo(500,400);
        
        //second "petal"
        mirrorJ.turn(-160);
        mirrorJ.forward(510);
        mirrorJ.turn(60);
        mirrorJ.forward(110);
        mirrorJ.turn(60);
        mirrorJ.forward(110);
        mirrorJ.turn(80);
        mirrorJ.forward(510);
        
        //third "petal"
        mirrorJ.moveTo(360,60);
        mirrorJ.turn(60);
        mirrorJ.forward(90);
        mirrorJ.turn(70);
        mirrorJ.forward(60);
        mirrorJ.turn(110);
        mirrorJ.moveTo(500,400);
        
        //fourth "petal"
        mirrorJ.moveTo(40,600);
        mirrorJ.moveTo(35,760);
        mirrorJ.moveTo(60,735);
        mirrorJ.moveTo(500,400);
        
        //fifth "petal"
        mirrorJ.moveTo(910,30);
        mirrorJ.moveTo(930,170);
        mirrorJ.moveTo(500,400);
        
        //move all to end of page and facing the same way
        mini.penUp();
        wieser.penUp();
        jene.penUp();
        mirrorM.penUp();
        mirrorW.penUp();
        mirrorJ.penUp();
        
        mini.turnToFace(0,0);
        wieser.turnToFace(0,0);
        jene.turnToFace(0,0);
        mirrorM.turnToFace(0,0);
        mirrorW.turnToFace(0,0);
        mirrorJ.turnToFace(0,0);
        
        mini.moveTo(20,900);
        wieser.moveTo(50,900);
        jene.moveTo(80,900);
        mirrorM.moveTo(110,900);
        mirrorW.moveTo(140,900);
        mirrorJ.moveTo(170,900);



        
        
        
        
        
        
        



        
        
        
    }
}
