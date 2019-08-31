import java.io.*;
import java.util.*;
import java.lang.*;

class AlmightyReader
{
	BufferedReader br;
	StringTokenizer tk;
	public AlmightyReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		tk=new StringTokenizer("");
	}
	public int nextInt() throws IOException
	{
		while(!tk.hasMoreTokens())
			tk=new StringTokenizer(br.readLine());
		return Integer.parseInt(tk.nextToken());
	}
}	
class Node
{
	int num;
	Node next;
	Node(int x)
	{
		num=x;
		next=null;
	}
}

class LinkedList
{
	Node start;
	public LinkedList()
	{
		start=new Node(-1); //Dummy start node which is not considered as part of the list	
	}
	public boolean isEmpty()
	{
		return !(start.next==null);
	}
	public void display()
	{
		Node ptr=start.next;
		while(ptr!=null)
		{
			System.out.print(ptr.num+" ");
			ptr=ptr.next;
		}
		System.out.println();
	}
}


class L4_2
{
	static void func(LinkedList L, LinkedList ans1_list, LinkedList ans2_list)
	{
		// Write your solution here, you may choose to create any number of helper functions or classes	
		// When the function exits, the ans1_list should be same as the odd element list and ans2_list should be same as the even element list.
		// DO NOT PRINT anything on the screen (the template code will print the contents of ans1_list and ans2_list for you)
		// DO NOT use any data structure (NO Array, NO ArrayList, ...) other than the linked list defined in the template code.
		// NOTE: The LinkedList class is defined such that the start node is a dummy node containing -1 and is automatically created with creation of any LinkedList Object. The nodes following the start node i.e. starting from start.next (inclusive) represent the original list. 
		//Therefore if the list 1 is [3, 5, 7, 9], then ans1_list should have the structure [-1 3 5 7 9].

		ans1_list.display(); ans2_list.display(); //This should be the last line of the function
	}
	public static void main(String args[]) throws IOException
	{
		AlmightyReader rd=new AlmightyReader();
		LinkedList ans1=new LinkedList(),ans2=new LinkedList(), L=new LinkedList();
		Node curr=L.start;
		int i,N=rd.nextInt();
		for(i=0;i<N;i++)
		{
			curr.next=new Node(rd.nextInt());
			curr=curr.next;
		}
		func(L,ans1,ans2);
	}
}