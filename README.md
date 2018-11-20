# WordChainSolver

- Execute ./bin/setup.sh : This script will install all dependencies and will also run Tests
- Execute ./bin/word_chain_solver.sh : This script will run the MainController.java class which is the entry point of the class.

This script takes 2 arguments:

First argument it takes the file path of the Input file.

Second argument it takes the file path of all the relations separated by space.


```
Below is a programming problem. Please read the description thoroughly then
create a program to solve the problem. Please Note: If you submit more than one solution, we will review only one.
· For the solution, we request that you use Java, Golang, Ruby, C#, Python or
JavaScript.
· There must be a way to supply the application with the input data via text file
· The application must run
· You should provide sufficient evidence that your solution is complete by indicating
that it works correctly against the supplied test data
Word Chain Solver :
Two words are connected by a word chain if it is possible to change one into the other by
making a series of single-character changes, such that every intermediate form is also a
word. For example, CAT and DOG are connected with a word chain because CAT, COT, COG
and DOG are all words. DEMONIC and UMBRELLA are not. Write a program that takes a list of words (for example /usr/share/dict/words on a unix
system or download the file
from : https://github.com/dwyl/english-words/blob/master/words.txt if you are using
windows) and then reads pairs of words on stdin and prints 'YES' if the words are
connected by a chain, and 'NO' if they are not. If YES, the words in the word chain should
be listed out on the console. The program should take the path to the word list from a
file, and should then loop, reading pairs of whitespace-delimited words from the
file and printing 'YES' or 'NO.'
Constraints:
Only one operation is allowed between words in the chain.
The operation may consist of changing any single character but the length of the words
should not change.
All comparisons should be case insensitive.
The answer should return the shortest word chain that solves each word chain puzzle.
```
