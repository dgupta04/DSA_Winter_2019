import java.util.Scanner;

class Stack{
	
     class Node { 
        int data; 
        Node link; 

        Node(int i){
        	data = i;
        }
        int getData(){
        	return data ;
        }
        Node getLink(){
        	return link;
        }
        void setData(int i){
        	data = i;
        }
        void setLink(Node n){
        	link = n;
        }
    }
    Node top; 
    Stack(){ 
        this.top = null; 
    }

    public void push(int x) {         
        Node temp = new Node(x);     
        temp.data = x ;   
        temp.link = top; 
        top = temp;  
    }
    public boolean isEmpty() { 
        return top == null; 
    }

    public int peek(){ 
        if (!isEmpty()) { 
            return top.getData(); 
        }
        else{ 
            return -1; 
        } 
    }
    public void pop(){         
        if (top == null){ 
            return; 
        } 
        top = top.getLink();
    }
}


public class L6_1{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for(int i =0 ; i<n; i++){
			a[i] = s.nextInt();
		}
		Stack st = new Stack();
		int[] out = new int[n];
		for(int i = n-1; i>=0; i--){
			if(!st.isEmpty()){
			while(st.isEmpty() == false && st.peek() <= a[i]){
				st.pop();
			}}
			if(st.isEmpty()){
				out[i] = -1;
			}
			else{
				out[i] = st.peek();
			}
			st.push(a[i]);
			}
		
		for(int i = 0; i < n-1; i++){  
        System.out.print(Integer.toString(out[i]) + " "); 
		}
		System.out.print(out[n-1]);
	
}}