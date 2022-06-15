# Genesis_Technical_Evaluation
Problem Description

 

Tony has a magical box in which he can insert random bills, and at any given point push a button on the box to expel a bill back to his hand.

This is represented in two operations:

Operation 1: Tony inserts a new bill into the box.
Operation 2: Tony presses the button on the box to expel a bill.

But Tony has no idea how this box works. He asked you to help him figure it out!

Tony has given you the list of bills he inserted, and the output of the box each time he presses the button in order. Your job is to figure out the type of data structure the box uses. (A stack, queue, a priority queue, or something else entirely)

Sometimes Tony tries to cheat the box, inserting fake monopoly bills instead of actual cash. The box ignores these bills and doesn't ever expel them out when the button is pressed. You should filter out his input, avoiding all values you know for certain can't be bills. For reference, the following are the only valid bill values:
1, 5, 10, 20, 50, 100

Input

There is an unspecified number of test cases, your program should always accept input when it's available. The first line of input will always be an integer n (where n > 0 and n < 500) defining the number of operations Tony took. The following n lines will contain the operations Tony performed using the box in the following format:

1 b
This is Operation 1 (insertion) where Tony has inserted a bill b into the box

or

2 b
This is Operation 2 (retrieval) where Tony has pressed the button on the box and received an expelled bill b.

In Operation 1, b is not always guaranteed to be a valid bill value.
In Operation 2, b is not always guaranteed to be a logical output value. In this case, your program should consider the operation invalid.

Output

Your program must write the output to a file called Results.txt. For each test case, your program should write a single line containing a single letter defining the type of data structure you have guessed:

"s" in case of stack.
"q" in case of queue.
"p" in case of priority queue.
"?" in case of more than one type being possible.
"!" in case of inability to determine the type or invalid operation.

Sample Input
6
1 5
1 20
1 50
2 5
2 20
2 50
6
1 5
1 80
1 50
2 5
2 50
6
1 1
1 5
1 10
2 10
2 5
2 1
4
1 100
1 50
2 50
2 100
2
1 20
2 100

Sample Output
q
q
?
s
!

HOW TO RUN:

1- Download the "evaluation" folder
2-Open Eclipse IDE
3-browse to your desired workspace
4-File -> Open Projects From File System -> browse to the evaluation folder downloaded
5- Open TonyMagicBox.java 
6- Run as java application

IF YOU ARE USING A DIFFERENT IDE JUST DOWNLOAD THE JAVA FILE & RUN INSIDE YOUR PROJECT
