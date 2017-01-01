/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticktacktoe;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class View extends JFrame implements ActionListener
{
    JMenuItem newGameMI;
  /**
   * The menu item that allows the user to reset the board.
   */
   JMenuItem resetMI;
   
   /**
    * The menu item that allows the user to exit the board. 
    */
   JMenuItem exitMI;
   
   /**
    * The Textfield that displays the player that has the turn.
    */
   JTextField currentPlayer;
   
   /**
    * The buttons that allow the user to choose which column
    * to place a token in.
    */
   static JButton[] placing;
   
   /**
    * The group of text fields that will display the pieces placed.
    */
   static JButton[][] grid;
   
   /** 
    * The Model object that allows all the functions of 
    * Model to be implemented in the GUI.
    */
   //Model game;
   
   TickTackToe game;
   /**
    * The constructor. Initializes the Model and the GUI.
    */
   
   static int selectedCol=-1;
   static JLabel thePlayer;
   
  public View(TickTackToe game)
  {
    //game = new Model(); 
    this.game=game;
    //JFrame frame = new JFrame("Connect 4");
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Connect Four");
    setPreferredSize(new Dimension(500, 500));
      //setBackground(Color.BLACK);
    
     // Menu options
       JMenuBar menuBar = new JMenuBar(); 
       JMenu menuItems = new JMenu("File");
       resetMI = new JMenuItem("Reset");
       resetMI.addActionListener(this);
       exitMI = new JMenuItem("Exit");
       exitMI.addActionListener(this);
       newGameMI= new JMenuItem("New Game");
       newGameMI.addActionListener(this);
       
       menuItems.add(newGameMI);
       menuItems.add(resetMI);
       menuItems.add(exitMI);
       
       menuBar.add(menuItems);
       setJMenuBar(menuBar);
       
       //the Panel that informs the user about the current player.
       JPanel playerPanel = new JPanel();
       playerPanel.setLayout(new GridLayout(1,1));
       thePlayer = new JLabel("Current Player: ");
       //currentPlayer = new JTextField("1");//initializes to 1
       //currentPlayer.setEnabled(false);//no manipulating the player is allowed
       playerPanel.add(thePlayer);
       
       JPanel piecesPanel = new JPanel();
       piecesPanel.setLayout(new GridLayout(game.row,game.col));
       grid = new JButton[game.row][game.col];
       for(int i = 0; i <game.row; i++)
       {
         for(int j = 0; j < game.col; j++)
         {
           grid[i][j] = new JButton("");
           if(i!=game.row-1)
            grid[i][j].setEnabled(false);
           grid[i][j].addActionListener(this);
           grid[i][j].setBackground(Color.green);

           piecesPanel.add(grid[i][j]);
         }
       }       
       
       
       add(piecesPanel, BorderLayout.CENTER);
       add(playerPanel, BorderLayout.NORTH);
       //add(buttonPanel, BorderLayout.SOUTH);
       
       pack();
       setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e)
  {
      if(!game.playerName.contains("Computer")){
      for(int i=0; i<game.row; i++){
          
          for(int j=0; j<game.col;j++){
              if(e.getSource() == grid[i][j]){
                  selectedCol=j;
                  break;
                  
              }
          }
      }
      
      
      }
      
     if(e.getSource() == exitMI)//user chooses to exit the game
        System.exit(0);
     
     if(e.getSource() == resetMI)//user chooses to reset the game
      {
          for(int i = 0; i <game.row; i++)
          {
            for(int j = 0; j < game.col; j++)
            {
                if(i!=game.row-1)
                    grid[i][j].setEnabled(false);
                grid[i][j].setBackground(Color.green);
                game.board[i][j]=-1;
           
            }
          }
          
          reset=1;
          //this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
          //game.play();
      }
     
      if(e.getSource() == newGameMI)//user chooses to reset the game
      {
          for(int i = 0; i <game.row; i++)
          {
            for(int j = 0; j < game.col; j++)
            {
                if(i!=game.row-1)
                    grid[i][j].setEnabled(false);
                grid[i][j].setBackground(Color.green);
                game.board[i][j]=-1;
           
            }
          }
          
          newGame=0;
          //this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
          //game.play();
      }
     
  }
  
  static int reset = 0;
  static int newGame = 0;
  static void playerNameSet(String name){
      thePlayer.setText("Current Player : "+name);
  }
  
 }
