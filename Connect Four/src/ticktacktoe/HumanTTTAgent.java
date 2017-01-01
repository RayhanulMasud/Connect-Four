package ticktacktoe;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * An example class implementing Agent class for human players. 
 * The implementation is coupled with the actual game (here, TickTackToe) the agent is playing.
 * @author Azad
 *
 */
public class HumanTTTAgent extends Agent
{

	static Scanner in = new Scanner(System.in);
	public HumanTTTAgent(String name, int role) {
		super(name);
                this.role=role;
		// TODO Auto-generated constructor stub
	}

	/*@Override
	public void makeMove(Game game) {
		// TODO Auto-generated method stub
		
		int row,col;
		TickTackToe tttGame = (TickTackToe) game;
		
		boolean first = true;
		do
		{
			if(first) 	System.out.println("Insert row and column ([0,2])");
			else System.out.println("Invalid input! Insert row and column ([0,2]) again.");
			//row = in.nextInt();
			col = in.nextInt();
			first=false;
		}while(!tttGame.isValidCell(col));
                for(int i=tttGame.row-1;i>=0;i--)
                {
                    if(tttGame.board[i][col]==-1)
                    {
                        tttGame.board[i][col] = role;
                        break;
                    }
                }
		//tttGame.board[row][col] = role;

	}*/
        
        public void makeMove(Game game) {
		// TODO Auto-generated method stub
		
		int row,col;
		TickTackToe tttGame = (TickTackToe) game;
		View.playerNameSet(name);
                while(true){
                    if(View.reset==1){
                        View.reset=0;
                        return ;
                    }
                    if(View.selectedCol!=-1){
                        col=View.selectedCol;
                        View.selectedCol=-1;
                        if(tttGame.isValidCell(col))
                            break;
                        else{
                            JOptionPane.showMessageDialog(this,"Please Choose Another Column", "Alert", JOptionPane.PLAIN_MESSAGE);
                
                        }
                    }
                }
                
		/*boolean first = true;
		do
		{
			if(first) 	System.out.println("Insert column [0,2]");
			else System.out.println("Invalid input! Insert column [0,2] again.");
			//row = in.nextInt();
			col = in.nextInt();
			first=false;
		}while(!tttGame.isValidCell(col));*/
		
                
                for(row=tttGame.row-1;row>=0;row--){
                   
                    if(tttGame.board[row][col]==-1){
                        tttGame.board[row][col] = role;
                        if(row!=0)
                            View.grid[row-1][col].setEnabled(true);
                        break;
                    }
                    
                }
		
	}


	


	

}
