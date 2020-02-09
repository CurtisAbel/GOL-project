
import javax.swing.JFrame;

public class GOLGUI implements Runnable
{

    public void run() 
    {
        JFrame Frame = new JFrame("Game of Life");//Setting up the window
       
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panel Content = new Panel(); 
        //Creating the content panel by looking at the panel class
       
        Content.setOpaque(true); 
        //Content panel, which is true, which shows that it much not see through
       
        Frame.setContentPane(Content);
        //This is the panel that is entered within the window
       
        Frame.setBounds(10,10,750,8000); 
        // This is the size of the window
        
        Frame.setResizable(true);
        //this will allow the user to drag the sides of the window, to make sure it use user preferred size.
       
        Frame.pack();
       //This piece of code allows all the content within the frame are the preferred length and height
      
        Frame.setVisible(true);
        //This displays the frame
    }
}
 