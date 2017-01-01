package ticktacktoe;

import java.util.ArrayList;





public class MinimaxTTTAgent extends Agent
{
	int searchdeep;
        int previous;
	int level;
        public MinimaxTTTAgent(String name, int role)
        {
		super(name);
                this.role=role;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Game game) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
                TickTackToe fiarGame = (TickTackToe) game;
                level=-1;
                searchdeep=-1;
		
                CellValueTuple best = max(fiarGame,-10000,10000,9);
                System.out.println(best.row+" "+best.col);
                fiarGame.board[best.row][best.col] = role;
                if(best.row!=0)
                            View.grid[best.row-1][best.col].setEnabled(true);
                

                
	}
        
        
	
        public boolean chk2(int v1,int v2)
        {
            return ((v1!=-1) && (v1==v2));
        }
        
        public boolean chk3(int v1,int v2,int v3)
        {
            return ((v1!=-1) && (v1==v2) && (v2==v3));
        }
        
        public int maxEvaluate(TickTackToe game)
        {
            int value = 0;
            //2 row
            for (int i = 0; i < game.row; i++) 
            {   
                for (int j = 0; j < game.col-1; j++) 
                {   
                    if (chk2(game.board[i][j], game.board[i][j+1]) == true) 
                    {
                        value=20;
                        return value; 
                    }
                }
            }
            //3 row
            for (int i = 0; i < game.row; i++) 
            {   
                for (int j = 0; j < game.col-2; j++) 
                {   
                    if (chk3(game.board[i][j], game.board[i][j+1],game.board[i][j+2]) == true) 
                    {
                        value=40;
                        return value; 
                    }
                }
            }
            //2 col
            for (int i = 0; i < game.col; i++) 
            {   
                for (int j = 0; j < game.row-1; j++) 
                {   
                    if (chk2(game.board[j][i], game.board[j+1][i]) == true) 
                    {
                        value=20;
                        return value; 
                    }
                }
            }
            //3 col
            for (int i = 0; i < game.col; i++) 
            {   
                for (int j = 0; j < game.row-2; j++) 
                {   
                    if (chk3(game.board[j][i], game.board[j+1][i],game.board[j+2][i]) == true) 
                    {
                        value=40;
                        return value; 
                    }
                }
            }
            //2 dia
            for(int i=0;i<game.row;i++){
                for(int j=0;j<game.col;j++){

                    if( isDiagonal(i+1,j+1,game)){
                        if( game.board[i][j]!=-1 && (chk2(game.board[i][j],game.board[i+1][j+1]))){
                            //winRole=board[i][j];
                               value=20;
                               return value;
                        }
                    }
                }
            }
            
            //3 dia
            for(int i=0;i<game.row;i++){
                for(int j=0;j<game.col;j++){

                    if( isDiagonal(i+1,j+1,game)&& isDiagonal(i+2,j+2,game)){
                        if( game.board[i][j]!=-1 && (chk3(game.board[i][j],game.board[i+1][j+1],
                                game.board[i+2][j+2]))){
                            //winRole=board[i][j];
                                value=40;
                                return value;
                        }
                    }
                }
            }
            
            //2 dia
            for(int i=0;i<game.row;i++){
                for(int j=0;j<game.col;j++){

                    if( isDiagonal(i-1,j-1,game)){
                        if( game.board[i][j]!=-1 && (chk2(game.board[i][j],game.board[i-1][j-1]))){
                            //winRole=board[i][j];
                               value=20;
                               return value;
                        }
                    }
                }
            }
            
            //3 dia
            for(int i=0;i<game.row;i++){
                for(int j=0;j<game.col;j++){

                    if( isDiagonal(i-1,j-1,game)&& isDiagonal(i-2,j-2,game)){
                        if( game.board[i][j]!=-1 && (chk3(game.board[i][j],game.board[i-1][j-1],
                                game.board[i-2][j-2]))){
                            //winRole=board[i][j];
                                value=40;
                                return value;
                        }
                    }
                }
            }
            
            return value;
        }
        
        public int minEvaluate(TickTackToe game)
        {
            int value = 0;
            //2 row
            for (int i = 0; i < game.row; i++) 
            {   
                for (int j = 0; j < game.col-1; j++) 
                {   
                    if (chk2(game.board[i][j], game.board[i][j+1]) == true) 
                    {
                        value=-20;
                        return value; 
                    }
                }
            }
            //3 row
            for (int i = 0; i < game.row; i++) 
            {   
                for (int j = 0; j < game.col-2; j++) 
                {   
                    if (chk3(game.board[i][j], game.board[i][j+1],game.board[i][j+2]) == true) 
                    {
                        value=-40;
                        return value; 
                    }
                }
            }
            //2 col
            for (int i = 0; i < game.col; i++) 
            {   
                for (int j = 0; j < game.row-1; j++) 
                {   
                    if (chk2(game.board[j][i], game.board[j+1][i]) == true) 
                    {
                        value=-20;
                        return value; 
                    }
                }
            }
            //3 col
            for (int i = 0; i < game.col; i++) 
            {   
                for (int j = 0; j < game.row-2; j++) 
                {   
                    if (chk3(game.board[j][i], game.board[j+1][i],game.board[j+2][i]) == true) 
                    {
                        value=-40;
                        return value; 
                    }
                }
            }
            //2 dia
            for(int i=0;i<game.row;i++){
                for(int j=0;j<game.col;j++){

                    if( isDiagonal(i+1,j+1,game)){
                        if( game.board[i][j]!=-1 && (chk2(game.board[i][j],game.board[i+1][j+1]))){
                            //winRole=board[i][j];
                               value=-20;
                               return value;
                        }
                    }
                }
            }
            
            //3 dia
            for(int i=0;i<game.row;i++){
                for(int j=0;j<game.col;j++){

                    if( isDiagonal(i+1,j+1,game)&& isDiagonal(i+2,j+2,game)){
                        if( game.board[i][j]!=-1 && (chk3(game.board[i][j],game.board[i+1][j+1],
                                game.board[i+2][j+2]))){
                            //winRole=board[i][j];
                                value=-40;
                                return value;
                        }
                    }
                }
            }
            
            //2 dia
            for(int i=0;i<game.row;i++){
                for(int j=0;j<game.col;j++){

                    if( isDiagonal(i-1,j-1,game)){
                        if( game.board[i][j]!=-1 && (chk2(game.board[i][j],game.board[i-1][j-1]))){
                            //winRole=board[i][j];
                               value=-20;
                               return value;
                        }
                    }
                }
            }
            
            //3 dia
            for(int i=0;i<game.row;i++){
                for(int j=0;j<game.col;j++){

                    if( isDiagonal(i-1,j-1,game)&& isDiagonal(i-2,j-2,game)){
                        if( game.board[i][j]!=-1 && (chk3(game.board[i][j],game.board[i-1][j-1],
                                game.board[i-2][j-2]))){
                            //winRole=board[i][j];
                                value=-40;
                                return value;
                        }
                    }
                }
            }
            
            return value;
        }
        
        public  boolean isDiagonal(int row, int col, TickTackToe game)
        {
        
            if(row<0 || row>game.row-1) return false;
            if(col<0 || col>game.col-1) return false;
            return true;
        }
        
	private CellValueTuple max(TickTackToe game,int alpha,int beta,int depth)
	{	
		CellValueTuple maxCVT = new CellValueTuple();
		maxCVT.utility = -10000;
		level++;
		searchdeep++;
                int winner = game.checkForWin();
		
		//terminal check
		if(winner == role)
		{
			maxCVT.utility = 1000; //this agent wins
			level--;
                        return maxCVT;
		}
		else if(winner!=-1) 
		{
			maxCVT.utility = -1000; //opponent wins
			level--;
                        return maxCVT;  
		}
		else if (game.isBoardFull())
		{
			maxCVT.utility = 0; //draw
			level--;
                        return maxCVT;  
		}
                else if(depth==0)
                {
                    maxCVT.utility=maxEvaluate(game);
                    return maxCVT;
                }
                if(depth==0)return maxCVT;
		int v = -10000;
                ArrayList<CellValueTuple> temptuple = getPosition(game);
                //System.out.println("In max "+temptuple.size());
                /*for(int i=0;i<temptuple.size();i++)
                {
                    System.out.print(temptuple.get(i).row+" ");
                    System.out.print(temptuple.get(i).col+" ");
                    System.out.println(temptuple.get(i).utility+" ");
                }*/
                for(int i=0;i<temptuple.size();i++)
                {
                    game.board[temptuple.get(i).row][temptuple.get(i).col]=role;
                    CellValueTuple temp = min(game,alpha,beta,depth-1);
                   
                    if(temp.utility >= beta)
                    {
                        game.board[temptuple.get(i).row][temptuple.get(i).col]=-1;
                        maxCVT.utility=temp.utility;
                        level--;
                        return maxCVT;
                    }
                    
                    if(temp.utility>v)
                    {
                        v=temp.utility;
                        alpha=v;
                        maxCVT.row=temptuple.get(i).row;
                        maxCVT.col=temptuple.get(i).col;
                        maxCVT.utility=v;
                    }
                    else if(i!=0 && level==0 && previous>searchdeep && temp.utility==v)
                    {
                        v=temp.utility;
                        alpha=v;
                        maxCVT.row=temptuple.get(i).row;
                        maxCVT.col=temptuple.get(i).col;
                        maxCVT.utility=v;
                    }
                   
                    
                    if(level==0)
                    {
                        previous=searchdeep;
                        searchdeep=0;
                    }  
                    
                    game.board[temptuple.get(i).row][temptuple.get(i).col]=-1;
                    
                }
                level--;
		return maxCVT;	
	}
	
	private CellValueTuple min(TickTackToe game,int alpha,int beta,int depth)
	{	
		CellValueTuple minCVT = new CellValueTuple();
		minCVT.utility = 10000;
		level++;
                searchdeep++;
		int winner = game.checkForWin();
		
		//terminal check
		if(winner == role)
		{
			minCVT.utility = 1000; //max wins
			level--;
                        return minCVT;
		}
		else if(winner!=-1) 
		{
			minCVT.utility = -1000; //min wins
			level--;
                        return minCVT;  
		}
		else if (game.isBoardFull())
		{
			minCVT.utility = 0; //draw
			level--;
                        return minCVT;  
		}
		else if(depth==0)
                {
                    minCVT.utility=minEvaluate(game);
                    return minCVT;
                }
		int v = 10000;
                if(depth==0)return minCVT;
                ArrayList<CellValueTuple> temptuple = getPosition(game);
                //System.out.println("In min "+temptuple.size());
                /*for(int i=0;i<temptuple.size();i++)
                {
                    System.out.print(temptuple.get(i).row+" ");
                    System.out.print(temptuple.get(i).col+" ");
                    System.out.println(temptuple.get(i).utility+" ");
                }*/
                for(int i=0;i<temptuple.size();i++)
                {
                    game.board[temptuple.get(i).row][temptuple.get(i).col]=minRole();
                    CellValueTuple temp=max(game,alpha,beta,depth-1);
                     
                    if(temp.utility <= alpha)
                    {
                        game.board[temptuple.get(i).row][temptuple.get(i).col]=-1;
                        minCVT.utility=temp.utility;
                        level--;
                        return minCVT;
                    }
                    
                    if(temp.utility < v)
                    {
                        v=temp.utility;
                        beta=v;
                        minCVT.row = temptuple.get(i).row;
                        minCVT.col = temptuple.get(i).col;
                        minCVT.utility = v;
                    }
                    
                    game.board[temptuple.get(i).row][temptuple.get(i).col]=-1;
                }
                level--;
		return minCVT;
			
	}
	

	class CellValueTuple
	{
		int row,col, utility;
		public CellValueTuple() {
			// TODO Auto-generated constructor stub
			row =-1;
			col =-1;
		}
	}
        
        private int minRole()
	{
		if(role==0)return 1;
		else return 0;
	}
        
        ArrayList<CellValueTuple> getPosition(TickTackToe game)
        {
           
            ArrayList<CellValueTuple> empty = new ArrayList<CellValueTuple>();
            
            for(int c=0;c<game.col;c++){
                for(int r=game.row-1;r>=0;r--){
                    
                    if(game.board[r][c]!=-1) 
                        continue;
                    
                    else{
                        CellValueTuple cell= new CellValueTuple();
                        cell.row=r;
                        cell.col=c;
                        empty.add(cell);
                        break;
                    }
                }
            }
            return empty;
        }
}
