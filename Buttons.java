import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttons extends JPanel implements ActionListener{

    private JButton Start = new JButton("Start");
    private JButton Halt = new JButton("Halt");
    private JButton Reset = new JButton("Reset");

    Buttons(){

        setLayout(new GridLayout(1,3,0,0));

        Reset.setBackground(Color.RED); //sets button colour to RED
        Reset.setFont(Reset.getFont().deriveFont(15.0f)); 
        Reset.setEnabled(false); //only able to be clicked after the start button has been clicked
        Reset.setActionCommand("Reset");
        Reset.addActionListener(this);
        
        Start.setBackground(Color.GREEN); //Sets button colour to Green
        Start.setFont(Start.getFont().deriveFont(15.0f)); //Font size 15
        Start.setActionCommand("Start");
        Start.addActionListener(this);

        Halt.setBackground(Color.ORANGE); //Sets button colour to Orange 
        Halt.setFont(Halt.getFont().deriveFont(15.0f)); 
        Halt.setEnabled(false); //This button can only be clicked upon when the button "Start" is clicked on
        Halt.setActionCommand("Halt");
        Halt.addActionListener(this);

        add(Start);
        add(Halt);
        add(Reset);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Board Board = Panel.getBoard();
        Iteration Iteration = Panel.getIteration();

        if(e.getActionCommand()=="Start"){
            Start.setEnabled(false); 
            //When the "start" button is clicked upon, it will become obsolete until the buttons reset or halt is clicked.When start is click the other buttons can be clicked on
            Halt.setEnabled(true); 
            Reset.setEnabled(true); 
            Board.getTimer().start();// In order for the events to occur, the start timer will need to be on within the 'boad.java class'
        }
        if(e.getActionCommand()=="Halt"){
            Halt.setEnabled(false); //When pause button is clicked upon the button will be disabled and other button will be available to be clicked upon
            Start.setEnabled(true); 
            Board.getTimer().stop(); //This will stop the timer in the board class
        }
        if(e.getActionCommand()=="Reset"){
            Reset.setEnabled(false); 
            Halt.setEnabled(false);
            Start.setEnabled(true);
            Board.reset();
            Iteration.resetCount();
        }
    }
}