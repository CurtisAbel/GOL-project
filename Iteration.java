
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class Iteration extends JLabel{

     int Count = 0;

    Iteration(){

        setOpaque(true); //this piece of code will create the box that outputs numbers and shows "Repetition"
        setText("Repetition");
        setHorizontalAlignment(JLabel.CENTER);
        setFont(getFont().deriveFont(20.0f)); //This piece of code is the font size
        setBorder(new EmptyBorder(10,10,10,10)); 

    }

    public void incrementCount(){//This will check the amount of repetitions that has happened, and display the number of time iteration has happned
        setText(String.valueOf(Count++));
    }

    public void resetCount(){ //This will reset the count to zero
        Count = 0;
        setText("Repetition");
    }

}

