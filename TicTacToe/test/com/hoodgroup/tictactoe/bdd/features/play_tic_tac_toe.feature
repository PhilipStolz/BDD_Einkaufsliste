Feature: Play Tic Tac Toe
In order to pass my time playing a computer game
As a game player
I want to play Tic Tac Toe with a friend.
					 
Scenario:  A straight forward game where the first player wins.
Given a game with first player "Ron" and second player "Mike"
When a turn on 1,1 is made
And a turn on 2,1 is made
And a turn on 0,2 is made
And a turn on 2,0 is made
And a turn on 2,2 is made
And a turn on 0,0 is made
And a turn on 1,2 is made
Then "Ron" shall win the game.


Scenario:  A straight forward game where the second player wins.
Given a game with first player "Ron" and second player "Mike"
When a turn on 1,1 is made
And a turn on 2,1 is made
And a turn on 0,1 is made
And a turn on 1,0 is made
And a turn on 0,2 is made
And a turn on 2,0 is made
And a turn on 2,2 is made
And a turn on 0,0 is made
Then "Mike" shall win the game.