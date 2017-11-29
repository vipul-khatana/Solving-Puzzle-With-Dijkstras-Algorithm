/*
Solving the Puzzle Problem by shortest path algorithm. 
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Puzzle 
{
	static int numTestCases;
	static ArrayList<String> startState = new ArrayList<String>();
	static ArrayList<String> endState = new ArrayList<String>();
	static int[][] costArray;
	static HashMap<String, ArrayList< String >> graphNodes =  new HashMap<String, ArrayList<String>>();
	static HashMap<String, ArrayList< String >> graphCosts =  new HashMap<String, ArrayList<String>>();
	static String startStr="12345678G";
	
	//Creating the adjacency list of the graph
	public static ArrayList< ArrayList<String> > getNeighbours(String str)
	{
		ArrayList< ArrayList<String> > ans = new ArrayList< ArrayList<String> >();
		ArrayList<String> neigh = new ArrayList<String>();
		ArrayList<String> cost = new ArrayList<String>();
		int indexOfGap=str.indexOf('G');
		if(indexOfGap==0)
		{
			String newStr1;
			//move gap left
			newStr1="";
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(1, 2)+"L");
			//move gap up
			newStr1="";
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(3, 4)+"U");
		}
		else if(indexOfGap==1)
		{
			String newStr1;
			//move gap right
			newStr1="";
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(0, 1)+"R");
			//move gap left
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(2, 3)+"L");
			//move gap Up
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(4, 5)+"U");
			
		}
		else if(indexOfGap==2)
		{
			String newStr1;
			//Move gap right
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(1, 2)+"R");
			//Move gap Up
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(5, 6)+"U");
		}
		else if(indexOfGap==3)
		{
			String newStr1;
			//Move gap Down
			newStr1="";
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(0, 1)+"D");
			//Move gap Left
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(4, 5)+"L");
			//Move gap Up
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(6, 7)+"U");
		}
		else if(indexOfGap==4)
		{
			String newStr1;
			//Move gap Right
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(3, 4)+"R");
			//Move gap Down
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(1, 2)+"D");
			//Move gap Left
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(5, 6)+"L");
			//Move gap Up
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(7, 8)+"U");
		}
		else if(indexOfGap==5)
		{
			String newStr1;
			//Move gap Right
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(4, 5)+"R");
			//Move gap Down
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(2, 3)+"D");
			//Move gap Up
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(8);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(5);
			neigh.add(newStr1);
			cost.add(str.substring(8, 9)+"U");
		}
		else if(indexOfGap==6)
		{
			String newStr1;
			//Move gap Down
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(3, 4)+"D");
			//Move gap Left
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(7, 8)+"L");
		}
		else if(indexOfGap==7)
		{
			String newStr1;
			//Move gap Right
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(6, 7)+"R");
			//Move gap Down
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(8);
			neigh.add(newStr1);
			cost.add(str.substring(4, 5)+"D");
			//Move gap Left
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(8);
			newStr1+=str.charAt(7);
			neigh.add(newStr1);
			cost.add(str.substring(8, 9)+"L");
		}
		else if(indexOfGap==8)
		{
			String newStr1;
			//Move gap Right
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(5);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(8);
			newStr1+=str.charAt(7);
			neigh.add(newStr1);
			cost.add(str.substring(7, 8)+"R");
			//Move gap Down
			newStr1="";
			newStr1+=str.charAt(0);
			newStr1+=str.charAt(1);
			newStr1+=str.charAt(2);
			newStr1+=str.charAt(3);
			newStr1+=str.charAt(4);
			newStr1+=str.charAt(8);
			newStr1+=str.charAt(6);
			newStr1+=str.charAt(7);
			newStr1+=str.charAt(5);
			neigh.add(newStr1);
			cost.add(str.substring(5, 6)+"D");
		}		
		
		ans.add(neigh);
		ans.add(cost);
		return ans;
	}
	
	//Creating the nodes from the possible states
	public static void makeGraphNodes()
	{
		Deque dequeA = new LinkedList();
		dequeA.add(startStr);
		while(!dequeA.isEmpty())
		{
			String currStr= (String) dequeA.removeFirst();
			ArrayList< ArrayList<String> > neighCost=getNeighbours(currStr);
			graphNodes.put(currStr,neighCost.get(0));
			graphCosts.put(currStr,neighCost.get(1));
			for(int i=0;i<neighCost.get(0).size();i++)
			{
				if(!graphNodes.containsKey(neighCost.get(0).get(i)))
				{
					dequeA.add(neighCost.get(0).get(i));
				}
			}
		}
	}
	static int distAns,jumpAns;
	static String pathAns;
	
	//Running the BFS to get all the possible states
	public static void runBfs(String StartState,String EndState,int[] currCostArr)
	{
		char gum='1';
		int asc1val= (int)gum;
		Deque dequeA = new LinkedList();
		HashMap<String,Boolean> visited=new HashMap<String,Boolean>();
		HashMap<String,Integer> dist=new HashMap<String,Integer>();
		HashMap<String,Integer> numJumps=new HashMap<String,Integer>();
		HashMap<String,String> pathStr=new HashMap<String,String>();
		
		for(String keyStr:graphNodes.keySet())
		{
			visited.put(keyStr, false);
			dist.put(keyStr, Integer.MAX_VALUE);
			numJumps.put(keyStr, Integer.MAX_VALUE);
			pathStr.put(keyStr, "");
		}		
		visited.put(StartState,true);
		dist.put(StartState,0);
		numJumps.put(StartState,0);
		pathStr.put(StartState, "");
		dequeA.add(StartState);
		while(!dequeA.isEmpty())
		{
			String currState=(String) dequeA.removeFirst();
			for(int i=0;i<graphNodes.get(currState).size();i++)
			{
				String currNeigh=graphNodes.get(currState).get(i);
				if(visited.get(currNeigh))
				{
					int newDist=dist.get(currState)+
							currCostArr[((int)graphCosts.get(currState).get(i).charAt(0))-asc1val];
					int newJumps=numJumps.get(currState)+1;
					//update If conditions
					if(dist.get(currNeigh)>newDist ||
							(dist.get(currNeigh)==newDist && 
							numJumps.get(currNeigh)>newJumps)
						)
					{
						//update things
						dist.put(currNeigh, newDist);
						String newPath="";
						if(pathStr.get(currState).isEmpty())
						{
							newPath=graphCosts.get(currState).get(i);
						}
						else
						{
							newPath=pathStr.get(currState)+" "+graphCosts.get(currState).get(i);
						}
						pathStr.put(currNeigh, newPath);
						numJumps.put(currNeigh, newJumps);
					}
				}
				else
				{
					visited.put(currNeigh, true);
					int newDist=dist.get(currState)+
							currCostArr[((int)graphCosts.get(currState).get(i).charAt(0))-asc1val];
					dist.put(currNeigh, newDist);
					String newPath="";
					if(pathStr.get(currState).isEmpty())
					{
						newPath=graphCosts.get(currState).get(i);
					}
					else
					{
						newPath=pathStr.get(currState)+" "+graphCosts.get(currState).get(i);
					}
					pathStr.put(currNeigh, newPath);
					int newJumps=numJumps.get(currState)+1;
					numJumps.put(currNeigh, newJumps);
					//update Dist
					dequeA.add(currNeigh);
				}
			}
		}
		if(dist.containsKey(EndState))
		{
			distAns=dist.get(EndState);
			jumpAns=numJumps.get(EndState);
			pathAns=pathStr.get(EndState);
		}
		else
		{
			distAns=-1;
			jumpAns=-1;
			pathAns="";
		}
		
	}
	
	public static void main(String[] args) throws IOException
	{
		String inputFilename=args[0];
		String outputFilename=args[1];
		
		//Loading the input file
		FileReader fileReader=new FileReader(inputFilename);
		Scanner scanner = new Scanner(new File(inputFilename));
		numTestCases=scanner.nextInt();
		costArray=new int[numTestCases][8];
		for(int i=0;i<numTestCases;i++)
		{
			startState.add(scanner.next());
			endState.add(scanner.next());
			for(int j=0;j<8;j++)
			{
				costArray[i][j]=scanner.nextInt();
			}
		}
		makeGraphNodes(); // This function will span the graph from the input 
		
		//Determining the output and writing it onto the output file
		 try {
	            //Whatever the file path is.
	            File statText = new File(outputFilename);
	            FileOutputStream is = new FileOutputStream(statText);
	            OutputStreamWriter osw = new OutputStreamWriter(is);    
	            Writer w = new BufferedWriter(osw);
	          //djikstras for each test case
	    		for(int i=0;i<numTestCases;i++)
	    		{
	    			String currStartState= startState.get(i);
	    			String currEndState= endState.get(i);
	    			int[] currCostVec=costArray[i];
				
	    			if(!graphNodes.containsKey(currStartState))
	    			{
	    				graphNodes.clear();
	    				graphCosts.clear();
	    				startStr=currStartState;
	    				makeGraphNodes();
	    			}
	    			runBfs(currStartState,currEndState,currCostVec);
	    			w.write(jumpAns+" "+distAns+System.lineSeparator());
	    			w.write(pathAns+System.lineSeparator());
	    		}
	            w.close();
	        } catch (IOException e) {
	            System.err.println("Problem writing to the file statsTest.txt");
	        }
	}
}
