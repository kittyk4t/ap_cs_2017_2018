import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The panel that contains the controls and indicators for the drawing editor
 * panel that holds the buttons
 * 
 * @author gcschmit
 * @version 23 June 2015
 */
public class ControlPanel extends JPanel
{
    private JButton pickColor; // pick color button
    private JButton circ; //add circle button
    private JButton sq;  //add square button
    private JPanel curColor; // panel that displays current color next to pick color button
    private DrawingPanel canvas; //canvas that the panel "controls"

    /**
     * Constructor for objects of class ControlPanel
     */
    public ControlPanel( DrawingPanel canvas)
    {
        this.canvas = canvas;

        this.pickColor=new JButton("Pick Color");
        this.circ=new JButton("Add Circle");
        this.sq=new JButton("Add Square");

        ActionListener colorListener= new ActionListener()
            {
                public void actionPerformed (ActionEvent event)
                {
                    canvas.pickColor();
                    curColor.setBackground(canvas.getColor());
                } 
            };
            
        ActionListener circListener= new ActionListener()
            {
                public void actionPerformed (ActionEvent event)
                {
                    canvas.addCircle();
                } 
            };
            
        ActionListener sqListener= new ActionListener()
            {
                public void actionPerformed (ActionEvent event)
                {
                    canvas.addSquare();
                } 
            };
        this.pickColor.addActionListener(colorListener);
        this.circ.addActionListener(circListener);
        this.sq.addActionListener(sqListener);

        this.curColor= new JPanel();
        this.curColor.setBackground(this.canvas.getColor());

        this.add(pickColor);
        this.add(curColor);
        this.add(circ);
        this.add(sq);

    }

    //
    // ... create inner class that implements the ActionListener interface to respond to button clicks
    //
}
