// Berkay Deniz 150117003
import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.lang.Math.*;

public class Bfs {
	
	// This function calculates the distance between two agents
	public static double distance(int laptop1,int laptop2,double [][] laptops) {
		return Math.sqrt( ( laptops[laptop1][0] - laptops[laptop2][0] )*( laptops[laptop1][0] - laptops[laptop2][0] )
				 + (laptops[laptop1][1] - laptops[laptop2][1] )*( laptops[laptop1][1] - laptops[laptop2][1] ) ) ;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
	// The user is supposed to enter the input file name with its extension (.txt) 
    System.out.println("Please enter the input file name");
    String fileName="";
    if(args.length>0) {
    	fileName+=args[0];
    }
    else {
    	System.out.println("Wrong file name");
    	System.exit(0);
    }
	File file=new File(fileName);
	
	Scanner input =new Scanner(file);  // This scanner is used to read the input file
    
	int n;                  // n is the number of agents
	
	// This while loop ignores the comment lines in the input file
	while(true) {
		String s=input.next();
		if(s.charAt(0)!='#') {          // If a line does not start with the character '#' then it is not a comment line
			n=Integer.parseInt(s);
			break;
		}
		input.nextLine();          
   }
	  
	// This array stores the informations about the laptops (x,y and r)
	// The last column of the array represent whether the laptop is visited or not
	//  This will be useful while traversing the graph 
    double[][] laptops =new double[n][4];    
    
    for(int i=0;i<n;i++) {
    	laptops[i][0]=input.nextDouble();
    	laptops[i][1]=input.nextDouble();
    	laptops[i][2]=input.nextDouble();
    	laptops[i][3]=0;  // This means unvisited
    }
    
    // This two dimensional ArrayList is can be considered to be an adjacency matrix
    ArrayList < ArrayList <Integer> > graph=new ArrayList < ArrayList <Integer> >();
    for(int i=0;i<n;i++)
    	graph.add(new ArrayList <Integer>());
    
    for(int i=0;i<n;i++) {
    	for(int j=i+1;j<n;j++) {
    		// If the distance between two agents is not greater than the sum of their wireless ranges then they are connected  
    		if(laptops[i][2]+laptops[j][2] >= distance(i,j,laptops)) {  
    			graph.get(i).add(j);
    			graph.get(j).add(i);
    		}
    	}
    }
    
    // I declare a Queue to traversing the graph with breadth first search
    Queue <Integer> queue =new LinkedList <Integer>();
    int[] hops =new int [n];    // This array stores the hop distances between first agent and every other agent
    hops[0]=0;
    queue.add(0);
    laptops[0][3]=1;
    int level=0;  // This actually represents the hop distance
    int size; // This represents the size of the Queue
    
    while(!queue.isEmpty()) {
    	size=queue.size();
    	// This loop iterates for each element that exist in the queue in this level 
    	while(size>0) {
    		size--;
    		int a=queue.poll(); // Every time the first element is removed from the queue
        	hops[a]=level;      // When I remove an element I store its level
        	// And for each removed element I add their unvisited adjacent elements into the queue 
        	for(int b=0; b<graph.get(a).size(); b++) {
        		if(laptops[graph.get(a).get(b)][3]==0) {
        			laptops[graph.get(a).get(b)][3]=1;
        			queue.add(graph.get(a).get(b));
        		}
        	}
    	}
    	// In this level we remove the elements in the queue that exist in the queue at the beginning of the level.
    	// Then we store their levels in the hop distances array 
    	// Then we add their unvisited adjacent elements into the queue
    	// Now its time to increase the level and do the same operations for the next level if the queue is not empty
    	level ++;
    }
    
    // This prints the results on the console
    for(int i=0;i<n;i++)
    	 System.out.println(hops[i]);
	}
}
