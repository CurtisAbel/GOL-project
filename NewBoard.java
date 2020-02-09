import java.awt.Color;

import javax.swing.JButton;

public class NewBoard {

    private Board Board = Panel.getBoard();
    private JButton[][] Cells = Board.getCells();
    private int Row = Board.getRow(), Column = Board.getColumn();
    private boolean NewCells[][] = new boolean[Row][Column];

    NewBoard(){
        Neighbours(); 
    }

    private void Neighbours(){ 
    	//This method checks the amounts of neighbours a cell has
        for(int i = 0; i<Row;i++)
        {
            for(int j=0;j<Column;j++)
            {
                int Neighbours=0;
                for(int x = -1; x<2;x++){
                    for(int y=-1;y<2;y++){
                        if(x==0 && y==0);
                        else if(Cells[(i+x+Column)%Column][(j+y+Row)%Row].isSelected()==true)
                        {
                            Neighbours++;
                        }
                    }
                }
                NewCells[i][j] = setCellStatus(Cells[i][j],NewCells[i][j],Neighbours);
                //the new cells that are created on the grid, are stored within the boolean array
                //setCellStatus will detects if the cells are either dead or alive, as stated within the rules.
                //A different array is created, so that the event will not loop through
                //when the cell has been checked, the rules state that the previous cells change places
                
            }
        }
        createNewBoard();//This will change the event occurring into one, merge
    }

    private boolean setCellStatus(JButton Cell, boolean NewCell, int Neighbours){ 
    	//This sets the current cells on current grid to a new position and let cells know what they should be doing for the new grid, which rules state

        if(Cell.isSelected()==true && ((Neighbours < 2) || (Neighbours > 3))) NewCell=false;

        else if(Cell.isSelected()==false && (Neighbours==3)) NewCell=true;

        else if(Cell.isSelected()==true) NewCell=true;

        else{
            NewCell=false; //returns false if code above doesn't relate to situation
        }
        return NewCell; //Returns the outcome of Newcell
    }

    private void createNewBoard(){ //this method fundamentally creates an entirely new grid basing is on the boolean array (NewCell) 

        for(int x = 0; x<Row;x++){
            for(int y = 0; y<Column;y++){

                if(NewCells[x][y]==true){
                    Cells[x][y].setSelected(true);
                    Cells[x][y].setBackground(Color.MAGENTA);
                }
                else{
                    Cells[x][y].setSelected(false);
                    Cells[x][y].setBackground(Color.CYAN);
                }
            }
        }
        Board.setCells(Cells);
    }
}
