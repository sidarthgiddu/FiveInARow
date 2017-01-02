Tic Tac Toe, but with 5 in a row! 

This is a two-player game: options are Human, DumbAI, RandomAI, and SmartAI. SmartAI uses the minmax algorithm, looking 3 moves ahead, to 
select a move. 

Instructions: 
    1. After clicking run in Gui.Main, a JOptionPane for selecting player X appears. Select the option that describes how you want 
       X to be played. Once you do, a JOptionPane for player O will appear. Repeat. 

    2. The GUI will display and the game will begin as soon as the second JOptionPane closes. A status window on the bottom tells 
       whose turn it is. Human players should click on the button where they want to play when it is their turn.

    3. When the game is won, the status window updates with the winning player, the buttons in the 9x9 grid are disabled, and the the            winning line is colored orange. To play again, close the GUI and run Gui.Main again. 
     


    

Noteworthy Remarks: 

   I used alpha-beta pruning in my minMaxAI class. This significantly decreased the time complexity of the minMax algorithm, and as a result smartAI selects
   moves very quickly.

   I also created my gui so that the winning line of five moves is colored orange when the game has ended.
   
   Also, I modified my actionlisteners for JButton when two AI's play against each other. Clicking on JButtons during the game does not result in an 
   IllegalArgumentException being thrown.

 
