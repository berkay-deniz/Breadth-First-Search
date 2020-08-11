# Breadth-First-Search
Solving a graph problem with breadth first search

# Problem Description
Suppose that there are n laptops each containing a wireless transmitter. For each laptop i,
following information are known:
- Position, (xi, yi),
- Wireless transmission range, ri
That is, we can imagine that the wireless range of laptop i is a circle centered at (xi, yi) 
with radius r. We say that the laptops i and j can communicate if their wireless ranges overlap. Of
course, not every laptop can communicate with every other laptop, but laptops can send
messages by using intermediate laptops as routers. Hop distance h(i, j) is defined as the
minimum number of intermediate laptops used to send a message from laptop i to laptop j.
For example, if two laptops can communicate directly, the hop distance between them is 1.
Now, you are asked to do the following:
- Given a set of n agents with their positions and wireless ranges, design an algorithm
based on Breadth-first Search (BFS) to compute the hop-distance from the first
laptop to every other reachable laptop(s). If agent i is not reachable from agent j then
the hop distance h(i, j) will be set to 0.

# My Solution To The Problem With My Algorithm Structure

In my code, I first want user to enter the input file name. Then I read the input file. I ignore the
comment lines in the input file also.
ALGORİTHM STRUCTURE :
While my program is reading the input file, it stores the information about the laptops in a two
dimensional arrray called laptops. Each row represents a laptop. I also use one more column to
indicate whether the laptop is visited or not. This is useful during the breadth first traversal later.
Secondly, I declare an ArrayList whose elements are another ArrayList whose elements are integer.
This can be considered an adjacency list. For example, in the first array list there should be only the
first laptop’s adjacent laptops’ s index. I think that the problem can be solved by using a graph and i
use the name ‘graph’ fort his ArrayList. Now it is time to explain how are the laptops can be ajdacent
to another laptops. We can clearly understand this by the given information in the problem. If we
calculate the distance between two laptops and compare the distance with the sum of the wireless
ranges of that laptops, we can observe their connectivity. I the distance is greater, the laptops are
not connected. I write a method to calculate the distance between two laptops by using their
positions. Then I check every pair of laptops whether they are connected or not. And I store the
connection information into my ArrayList called graph ( like an adjacency list).
The final part is to traverse the graph with breadth first search. I use a queue fort his purpose. At first
i add the first element into the queue. Then I remove all the elements in the queue. When I remove
an element, I store which level i remove this element. ( I store them in an array which is called hops
(hop distances) ) I add all unvisited adjacent elements of removed elements then i increase the level.
I do these operations until the queue becomes empty.

# Space Complexity Of My Algorithm 
 I use a two dimensional array to store the connection information of every pair
of laptops. In the array list there are n elements and each element can be consists of another n
elements so the complexity is O (n^2) (n square)

# Time Complexity Of My Algorithm
 The traversing operation decides the time complexity. Since I use an adjacency
list, the complexity can be written as O (V + E) ( V is the number of elements and E is the number of
edges)
