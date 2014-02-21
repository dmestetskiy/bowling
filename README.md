bowling
=======
need to have ant version 1.8.2
need to have java version 1.6.0_23

Set environment variables for both of these and add them to the path

ant run - will run the game
ant test - will run tests and create a report at test/reports/html

sample input:
1/-10-10-10-10-10-10-10-10-10 - each frame has two values, unless its a strike (X). Each value represents a bowl roll.
"/" indicates a spare and must come
after a number. This will calculate the total for the full game. You must enter the full ten rolls, 
unless you get a strike on the last one, you can roll
two more

dialogpanel is the main class
