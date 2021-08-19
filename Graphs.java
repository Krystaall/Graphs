/*
  
 NAME:           SHARVARI SONKUSARE
 CNUM:           C22019221458
 ASSIGNMENT:     4
 ROLL NO.:       2459
 
 
 PROBLEM STATEMENT: Implement graph data structure using adjacency list and adjacency matrix and perform traversals on it.

*/

package graphs;
import java.util.*;


class node
{
	node next;
	int data;
	
	public node (int d){
		next=null;
		data=d;
		}
}

class graph{
	int n; //number of vertices
	int e; //number of edges
	int[][] adjmat; //adjacency matrix of the graph  
	node[] head;    //array of heads of linked list used for adjacency list
	boolean visited[];

	graph(){
		n = 0;
		e = 0;
		}
	Scanner sc= new Scanner(System.in);	
	LinkedList<Integer> list[];


void createUsingAdjMat()
{
	
	System.out.println("ENTER NUMBER OF HOUSES: ");
	n=sc.nextInt();               //HOUSES ARE VERTICES
	
	System.out.println("ENTER NUMBER OF LANES: ");
	e=sc.nextInt();             //LANES ARE EDGES  
	adjmat = new int[n][n];
	for(int i=0; i<e;i++) {
		System.out.println("Enter beginning house for lane "+(i+1)+":");
		int u = sc.nextInt();
		System.out.println("Enter last house for lane "+(i+1)+":");
		int v = sc.nextInt();
		    adjmat[u][v]=1;
		    adjmat[v][u]=1;

	}
		
	}

void displayAdjMat()    //displaying adjacency matrix
{
	
	System.out.println("Graph: (Adjacency Matrix)");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <n ; j++) {
            System.out.print(adjmat[i][j]+ " ");
        }
        System.out.println();
    }
}

void newEdge(int u,int v) {
	
	node new_node = new node(v);
	if(head[u]==null) { 
		head[u] = new_node;  //if no element present attaching as head
		return;
	}
	node  temp= head[u];
	while(temp.next!=null) {
		temp = temp.next;
	}
	temp.next = new_node;
}

void createUsingAdjList()
{
	
	System.out.println("ENTER NUMBER OF HOUSES: ");
	n=sc.nextInt();
	
	System.out.println("ENTER NUMBER OF LANES: ");
	e=sc.nextInt();
	
	head= new node[n];
	
  //For every lane Accept house number
   
    for(int i=0;i<e;i++) {
	System.out.println("Enter beginning house for lane "+(i+1)+":");
	int u = sc.nextInt();
	System.out.println("Enter last house for lane "+(i+1)+":");
	int v = sc.nextInt();
		    
	        //add edge
	        newEdge(u,v);

	        //add back edge ((for undirected)
	        if(u!=v) {
	        	newEdge(v,u);
	        }
    	}
    }
    

void displayAdjList()      //displaying adjacency list
{
	for(int i=0;i<n;i++) {
		node  temp = head[i];
		System.out.print(i);
		while(temp!=null) {
			System.out.print(" ->"+temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
 }

	


//Using Queue
void bfs()                //O(V+E)   
	
	//s=index number from where u want to start search
    {
		System.out.println("Enter starting vertex: ");
		int s=sc.nextInt();
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++) {
    		visited[i] = false;
    	}
    	
 
        //queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
        System.out.println(s+" ");
 
        while (!queue.isEmpty())
        {
            // Dequeue a vertex from queue and print it
            int temp = queue.remove();  
            node ptr = head[temp];
			while(ptr!=null) {
				if(visited[ptr.data]!=true) {
					queue.add(ptr.data);
					visited[ptr.data] = true;
					System.out.println(ptr.data+" ");
				}
				ptr = ptr.next;
        }
        }
    }
	
	

    //using stack
	void DFS(int vertex) {           //O(V + E)

		
		boolean visited[] = new boolean[n];
		for(int i=0;i<n;i++) {
			visited[i] = false;
		}
		Stack<Integer> s = new Stack<Integer>();
		
		System.out.println("Enter starting vertex:");
		int startVertex = sc.nextInt();
		s.push(startVertex);
		visited[startVertex] =true;
		System.out.print(startVertex+" ");
		
		while(!s.isEmpty()) {
			int top = s.peek();
			int flag = 0;
			int unvisited = -1;
			for(int j=0; j<n; j++) {
				if(adjmat[top][j] == 1 && visited[j]!=true) {
					flag =1;
					unvisited = j;
				}
			}
			if(flag==0) {
				s.pop();
			}
			else {
				visited[unvisited] = true;
				System.out.print(unvisited+" ");
				s.push(unvisited);
			}
		}
	}
	  }


public class Graphs{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int ch;
		graph g = new graph();
		do
		{
			System.out.println("\nEnter a choice: ");
			System.out.println("\n1.Adjacency Matrix");
			System.out.println("\n2.Adjacency List");
			System.out.println("\n3.Exit");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				g.createUsingAdjMat();
				g.displayAdjMat();
				g.DFS(0);
				break;
			case 2:
				g.createUsingAdjList();
				g.displayAdjList();
				System.out.println("\nBFS:");
				g.bfs();
				System.out.println();
			break;
			case 3:
				System.exit(0);
				}
			}while(ch != 3);
		}
	}


/*
 TIME COMPLEXITY:
 
 1.creation of adjacency matrix=O(N^2)
 2.displayAdjMat=O(N^2)
 3.DFS=O(N) , matrix= O(N^2)
 4.creation of adjacency list=O(N)
 5.displayAdjList=O(N)
 6.BFS=O(N) , matrix= O(N^2)
 7.newNode=O(N)
 
 
 OUTPUT:
 
Enter a choice: 

1.Adjacency Matrix

2.Adjacency List

3.Exit
1
ENTER NUMBER OF HOUSES: 
5
ENTER NUMBER OF LANES: 
6
Enter beginning house for lane 1:
0
Enter last house for lane 1:
1
Enter beginning house for lane 2:
1
Enter last house for lane 2:
4
Enter beginning house for lane 3:
0
Enter last house for lane 3:
2
Enter beginning house for lane 4:
2
Enter last house for lane 4:
4
Enter beginning house for lane 5:
0
Enter last house for lane 5:
3
Enter beginning house for lane 6:
3
Enter last house for lane 6:
4
Graph: (Adjacency Matrix)
0 1 1 1 0 
1 0 0 0 1 
1 0 0 0 1 
1 0 0 0 1 
0 1 1 1 0 
Enter starting vertex:
0
0 3 4 2 1 


Enter a choice: 

1.Adjacency Matrix

2.Adjacency List

3.Exit
2
ENTER NUMBER OF HOUSES: 
4
ENTER NUMBER OF LANES: 
5
Enter beginning house for lane 1:
0
Enter last house for lane 1:
2
Enter beginning house for lane 2:
0
Enter last house for lane 2:
1
Enter beginning house for lane 3:
2
Enter last house for lane 3:
3
Enter beginning house for lane 4:
1
Enter last house for lane 4:
2
Enter beginning house for lane 5:
0
Enter last house for lane 5:
3
0 ->2 ->1 ->3
1 ->0 ->2
2 ->0 ->3 ->1
3 ->2 ->0

BFS:
Enter starting vertex: 
0
0 
2 
1 
3 


Enter a choice: 

1.Adjacency Matrix

2.Adjacency List

3.Exit
3
 
 
 
 */


