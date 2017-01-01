package ticktacktoe;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 * Example class extending Game class
 * @author Azad
 *
 */
public class TickTackToe extends Game 
{

	/**
	 * The actual game board
	 * -1 empty, 0 -> O, 1 -> X
	 */
	public int[][] board;
        int row;
        int col;
        
        View view;
	//ArrayList<Integer,Integer> blankBorad = new ArrayList<Pair<Integer,Integer>>();
	/**
	 * First agent starts with O
	 * @param a
	 * @param b
	 */
	public TickTackToe(Agent a, Agent b) {
		super(a, b);
		// TODO Auto-generated constructor stub
		
		a.setRole(0); // The first argument/agent is always assigned O (0)
		b.setRole(1); // The second argument/agent is always assigned X (1)
					  // NOtice that, here first dows not mean that afent a will make the first move of the game.
					  // Here, first means the first argument of the constructor
					  // Which of a and b will actually give the first move is chosen randomly. See Game class
		row = 6;
                col = 7;
		name = "Tick Tack Toe";
		
		board = new int[row][col];
		view = new View(this);
                
                
	}

	/**
	 * Called by the play method of Game class. It must update the winner variable. 
	 * In this implementation, it is done inside checkForWin() function.
	 */
	@Override
	boolean isFinished() {
		// TODO Auto-generated method stub
		if(checkForWin() != -1)
			return true;
		else if(isBoardFull())
			return true;
		else return false;
	}

	@Override
	void initialize(boolean fromFile) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = -1;
			}
		}
	}

	/**
	 * Prints the current board (may be replaced/appended with by GUI)
	 */
	@Override
	void showGameState() {
		// TODO Auto-generated method stub
		 
        System.out.println("-----------------------------");
		
        for (int i = 0; i < row; i++) 
        {
            System.out.print("| ");
            for (int j = 0; j < col; j++) 
            {
            	if(board[i][j]==-1)
            		System.out.print(" " + " | ");
            	else if	(board[i][j]==0){
            		System.out.print( "O | ");
                        view.grid[i][j].setBackground(Color.red);
                }
                else{
            		System.out.print( "X | ");
                        view.grid[i][j].setBackground(Color.yellow);
                }
            }
            System.out.println();
            System.out.println("------------------------------");
        }
    }
	
    /** Loop through all cells of the board and if one is found to be empty (contains -1) then return false.
    	Otherwise the board is full.
    */
    public boolean isBoardFull() {

		
        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < col; j++) 
            {
                if (board[i][j] == -1) 
                {
                   return false;
                }
            }
        }
		
        return true;
    }
	
	
    /** Returns role of the winner, if no winner/ still game is going on -1.
     * @return role of the winner, if no winner/ still game is going on -1.
     */
    public int checkForWin() 
    {
    	winner = null;
    	int winRole=-1;
    	//row
        for (int i = 0; i < row; i++) 
        {   
            for (int j = 0; j < col-3; j++) 
            {   
                if (checkRowCol(board[i][j], board[i][j+1], board[i][j+2],board[i][j+3]) == true) 
                {
                    winRole = board[i][j];
                    
                    if(winRole!=-1)
                    {
                        winner = agent[winRole];
                    }
                    return winRole; 
                }
            }
        }
        
        //column
        for (int i = 0; i < col; i++) 
        {   
            for (int j = 0; j < row-3; j++) 
            {   
                if (checkRowCol(board[j][i], board[j+1][i], board[j+2][i],board[j+3][i]) == true) 
                {
                    winRole = board[j][i];
                    
                    if(winRole!=-1)
                    {
                        winner = agent[winRole];
                    }
                    return winRole; 
                }
            }
        }
        
        
        //diagonal
    /*	if(checkRowCol(board[0][0], board[1][1], board[2][2]))
    		winRole =  board[0][0];
    	
    	if (checkRowCol(board[0][2], board[1][1], board[2][0]))
    		winRole =  board[0][2];
    */
        //first diagonal win check
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                
                if( isDiagonal(i+1,j+1) && isDiagonal(i+2,j+2) &&
                        isDiagonal(i+3,j+3)){
                    if( board[i][j]!=-1 && (checkRowCol(board[i][j],board[i+1][j+1],
                        board[i+2][j+2],board[i+3][j+3]))){
                        //winRole=board[i][j];
                        winRole=board[i][j];
                       if(winRole!=-1)
                        {
                            winner = agent[winRole];
                        }
                        return winRole; 
                    }
                }
            }
        }
        
        //second diagonal win check
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                
                if( isDiagonal(i+1,j-1) && isDiagonal(i+2,j-2) &&
                        isDiagonal(i+3,j-3)){
                    if( board[i][j]!=-1 && (checkRowCol(board[i][j],board[i+1][j-1],
                        board[i+2][j-2],board[i+3][j-3]))){
                        //winRole=board[i][j];
                        winRole=board[i][j];
                        if(winRole!=-1)
                        {
                            winner = agent[winRole];
                        }
                        return winRole; 
                    }
                }
            }
        }
        

    /*	if(winRole!=-1)
    	{
    		winner = agent[winRole];
    	}
        */
	return winRole;
    }
    

/* 
*/	
    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(int c1, int c2, int c3,int c4) 
    {
        return ((c1 != -1) && (c1 == c2) && (c2 == c3) && (c3 == c4));
    }
	
	public boolean isValidCell(int col)
	{
		if(col<0 ||col>this.col) return false;
		if(board[0][col]!=-1) return false;
		
		return true;
	}

	@Override
	void updateMessage(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}
        
        public static void main(String[] args) 
	{
		

		Agent human = new HumanTTTAgent("Masud",0);
		//Agent human = new MinimaxTTTAgent("007");
		Agent machine = new MinimaxTTTAgent("Computer",1);
                //JOptionPane.showInputDialog(this, "Enter Player Name", JOptionPane.)
		//System.out.println(human.name+" vs. "+machine.name);
		
		Game game = new TickTackToe(human,machine);
                
                while(true){
                    
                    if(View.newGame==0)
                        game.play();
                
                }
                    
		
	}
        
        //masud
	public  boolean isDiagonal(int row, int col)
        {
        
            if(row<0 || row>this.row-1) return false;
            if(col<0 || col>this.col-1) return false;
            return true;
        }
}
