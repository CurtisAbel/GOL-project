import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Panel extends JPanel 
{

    private static Board Board;
    private static Buttons Buttons;
    private static Iteration Iteration;

    
    public Panel() //This method is creating the button panel 
    //this class gets information from the classes, Board, Iterations and buttons
    {
        setLayout(new BorderLayout());//Setting up main panel's border layout
        Buttons = new Buttons();
        Board = new Board();
        Iteration = new Iteration();
     //The lines above will add the buttons to the main panel.

        add(Buttons,BorderLayout.NORTH);//this determines where to button will be on the layout
        add(Board,BorderLayout.CENTER);
        add(Iteration,BorderLayout.SOUTH);
        //above is where we all the buttons will be positioned on the layout.
    }

    public static Board getBoard() {
        return Board;
    }

    public static Iteration getIteration(){
        return Iteration;
    }
}