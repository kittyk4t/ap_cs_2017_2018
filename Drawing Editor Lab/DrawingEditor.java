import javax.swing.JFrame;
import java.awt.BorderLayout;


/**
 * The window for the drawing editor.
 * program window
 * 
 * @author gcschmit
 * @version 23 June 2015
 */
public class DrawingEditor extends JFrame
{
    /**
     * Default constructor for objects of class DrawingEditor
     */
    public DrawingEditor()
    {
        this.setTitle( "Drawing Editor" );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        DrawingPanel canvas = new DrawingPanel();
        ControlPanel controls = new ControlPanel( canvas );
        
        // add the canvas and controls panels to the frame
        // read the BorderLayout class documentation for specifics
       
        this.setLayout(new BorderLayout()); 
        //sets canvas to center of window
        this.add(canvas);
        //sets controls to bottom of window
        this.add(controls, BorderLayout.SOUTH);
        
        this.pack();
        this.setVisible( true );
    }
    
    
    public static void main( String[] args )
    {
       DrawingEditor drawingEditor = new DrawingEditor();
    }

}
