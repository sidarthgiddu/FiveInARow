Names/NetID's: Sidarth Giddu/sg766

Instructions: 
    1. After clicking run in Gui.Main, a JOptionPane for selecting player X appears. Select the option that describes how you want 
       X to be played. Once you do, a JOptionPane for player O will appear. Repeat. 

    2. The GUI will display and the game will begin as soon as the second JOptionPane closes. A status window on the bottom tells 
       whose turn it is. Human players should click on the button where they want to play when it is their turn.

    3. When the game is won, the status window updates with the winning player, the buttons in the 9x9 grid are disabled, and the the winning line is 
       colored orange. To play again, close the GUI and run Gui.Main again. 


Bugs/Shortcomings: 
    One problem with my game is that smartAI vs smartAI ends too early. Even though one of the players could win or both of them could draw, I think a win
    should only happen when almost all the squares are covered. However, my logic seems fine, I passed the smartAI test,
    and no one who played against my smartAI experienced any issues.

    A shortcoming of my GUI that would like to implement in the future is to highlight the JButton where the most recent move was played. I think this is 
    a good idea because on a 9x9 grid with many squares covered, it can be difficult to notice where the last move was played. 
    

Additional Designs/Implementations: 

   I used alpha-beta pruning in my minMaxAI class. This significantly decreased the time complexity of the minMax algorithm, and as a result smartAI selects
   moves very quickly.

   I also created my gui so that the winning line of five moves is colored orange when the game has ended.
   
   Also, I modified my actionlisteners for JButton when two AI's play against each other. Clicking on JButtons during the game does not result in an 
   IllegalArgumentException being thrown.

 
Feedback: 

   This assignment was challenging, but it definitely helped me improve my understanding of GUI's and AI's. My major complaint, though, is that many 
   of the TA's appeared unwilling to help with either the GUI or MinMaxAI. Multiple office hours that I wanted to attend were canceled. As a result I had
   took to look online to answer my questions, which was very inefficient.

   Also, I feel like the description for minMaxAI could be improved a little. I looked at last year's handout for the GUI assignment and there were
   diagrams that went through how the board changes as minMax is called. For next semester, it would be nice to bring those diagrams back. Many of the
   students, including me, understood the description in minMaxAI but had a very hard time visualizing it. 

   But overall, the time given for this assignment was definitely enough and the javadoc had very clear method specifications! I'm happy about that, 
   because the javadoc helped me understand how model, view, and controller classes work together. Now I know how to implement a game with AI's, and it
   feels great to have that knowledge! 
   





