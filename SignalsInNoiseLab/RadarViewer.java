import javax.swing.JFrame;
import java.util.Scanner;
/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author @gcschmit
 * @version 19 July 2014
 */
public class RadarViewer
{
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    public static void main(String[] args) throws InterruptedException
    {
        // create the radar, set the monster location, and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        Radar radar;
        Scanner s=new Scanner(System.in);
        // prompt the user to optionally enter the location of the monster
        //  (if they don't, leave the location randomly determined)

        System.out.print("\n2 Monsters? (y/n) ");
        if(s.next().equals("y"))
        {
            radar = new Radar(ROWS, COLS,true);

            System.out.print("\nSpecify Location of Monster1 ? (y/n) "); 
            //asks user if they want to specify the monsterLocation
            if(s.next().equals("y"))
            {
                System.out.print("\nMonster 1 Row: ");
                int row=s.nextInt(); //specified row of monster

                System.out.print("\nMonster 1 Column: ");
                int column=s.nextInt(); //specified column of monster

                radar.setMonsterLocation(new Location(row,column));
            }

            System.out.print("\nSpecify Location of Monster 2? (y/n) "); 
            //asks user if they want to specify the monsterLocation2
            if(s.next().equals("y"))
            {
                System.out.print("\nMonster 2 Row: ");
                int row=s.nextInt(); //specified row of monster

                System.out.print("\nMonster 2 Column: ");
                int column=s.nextInt(); //specified column of monster

                radar.setMonsterLocation2(new Location(row,column));
            }
        }
        else
        {
            radar = new Radar(ROWS, COLS);

            System.out.print("\nSpecify Location of Monster ? (y/n) "); //asks user if they want to specify the monsterLocation
            if(s.next().equals("y"))
            {
                System.out.print("\nMonster Row: ");
                int row=s.nextInt(); //specified row of monster

                System.out.print("\nMonster Column: ");
                int column=s.nextInt(); //specified column of monster

                radar.setMonsterLocation(new Location(row,column));
            }
        }
        
        radar.setNoiseFraction(0.10);
        radar.scan();

        JFrame frame = new JFrame();

        frame.setTitle("Signals in Noise Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // a frame contains a single component; create the radar component and add it to the frame
        RadarComponent component = new RadarComponent(radar);
        frame.add(component);

        // set the size of the frame to encompass the contained component
        frame.pack();

        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);

        // perform 100 scans of the radar wiht a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        for(int i = 0; i < 100; i++)
        {
            Thread.sleep(100); // sleep 100 milliseconds (1/10 second)

            radar.scan();

            frame.repaint();
        }
    }

}
