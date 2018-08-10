This package is the generic source-code version based on Java (JDK 1.8).
 
1.Input 
* Put all required file into "ParsiCluster/res" folder.
* Customize the input file name in the SimulatedAnnealing.java source code file.
* Run SimulatedAnnealing.java

2.Input format
(1) Data matrix (example file: "ParsiCluster/res/Example.txt")
The row represents the species. 
The column represents the character.
The inapplicable character states are coded as "-1".
ParsiCluster is only appropriate for binary character transformation series.
(* The data matrixis is given in Example.txt,  the code "-1" represents the inapplicable character states.)

(2)Hierarchical relationship among characters £¨example file: "ParsiCluster/res/Relation.txt"£©
The hierarchical relationship among characters is represents by adjacency matrix.
In adjacency matrix, the rows represent the upper characters, and the columns represent the lower characters.
The value in adjacency matrix represents the state of the upper characters when its lower characters is applicable. 
If two character is logically independent,the value of adjacency matrix is code as "-1".
(* The input adjacency matrix has given in Relation.txt. the code "-1" represents two characters are logically independent¡£) 

3.Output format
Newick tree format 

4.Parameter settings £¨In SimulatedAnnealing.java£©
TreeLength: the threshold of tree length 
bestTnum:the number of parsimony trees
Tnum: the number of iterations in the simulated annealing algorithm