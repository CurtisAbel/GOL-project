import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
	
    private int Column=30,Row=30; // board size
    private  JButton[][] Cells = new JButton[Row][Column]; //Using array to create grid of cells
    private Timer Timer;

    Board(){    
        setLayout(new GridLayout(Column,Row,0,0));
        for(int i = 0; i<Row;i++) //This is setting the cells to default/random on grid
        {
            for(int j=0;j<Column;j++)
            {
                Cells[i][j] = new JButton(); 
                Cells[i][j].setBackground(Color.CYAN); 
                Cells[i][j].setPreferredSize(new Dimension(25,25));
                Cells[i][j].setActionCommand("Clicked");
                Cells[i][j].addActionListener(this);
                add(Cells[i][j]); 
            }
        }
        Timer = new Timer(500, this); // made sure that the milliseconds are 500, this will allow an iteration to happen every 0.5 seconds
        Timer.setActionCommand("Timer");
        Timer.setInitialDelay(0); 
    }
    public JButton[][] getCells() {
        return Cells;
    }
    public void setCells(JButton[][] cells) {
        this.Cells = cells;
    }

    public Timer getTimer() {
        return Timer;
    }

    public int getColumn() {
        return Column;
    }
    public int getRow() {
        return Row;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Clicked")) {

            for(int x = 0; x<Row;x++){ //This uses the SelectedCells method to modify and change cells that are selected 
                for(int y=0;y<Column;y++){

                    if(e.getSource()==Cells[x][y]){
                        selectedCells(Cells[x][y]);
                    }
                }
            }
        }
        if(e.getActionCommand().equals("Timer")){

            if(arrayCheck()==true){ //If the board becomes empty, it will create another one
                randomizeCells();
            }
            //Each timer event increments counter...
            Panel.getIteration().incrementCount();// the iteration counter additionally increase and change the status of the cells, whenever the timer increases
            NewBoard NewBoard = new NewBoard();
        }
    }

    public void reset(){//This method is essentially allowing the grid to reset and go back to the authentic state as it started as
        for(int i = 0; i<Row;i++){ 
            for(int j=0;j<Column;j++){
                Cells[i][j].setSelected(false); 
                Cells[i][j].setBackground(Color.CYAN);
            }
        }
        Timer.stop();
    }

    private void selectedCells(JButton cell){
        if(cell.isSelected()==false){ //The cells that are selected will be pink(Magenta)
            cell.setBackground(Color.MAGENTA);
            cell.setSelected(true);
        }
        
        else{
            cell.setBackground(Color.CYAN);//If cell is already selected change to Cyan(Light blue)
            cell.setSelected(false);
        }
    }

    private void randomizeCells(){ // this creates a random grid, for when it is empty

        for(int i = 0; i<Row;i++){
            for(int j=0;j<Column;j++){

                Random CellRandom = new Random();
                if(CellRandom.nextBoolean()==false){
                    Cells[i][j].setSelected(false);
                    Cells[i][j].setBackground(Color.CYAN);
                }
                else{
                    Cells[i][j].setSelected(true);
                    Cells[i][j].setBackground(Color.MAGENTA);
                }
            }
        }
    }


    private boolean arrayCheck(){//if grid is empty then outcome will be true, otherwise it outcome will be false

        for(int i=0;i<Row;i++){
            for(int j=0;j<Column;j++){
                if(Cells[i][j].isSelected()==true){
                    return false;
                }
            }
        }
        return true;
    }
}

