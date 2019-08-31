import java.util.Scanner;

class Node { 
    public int data;
    public Node link;
    
    Node() {
     // a simple node 
    data = 0;
    link = null;
    }
    Node(int n) { 
    // a node with a given value
    data = n;
    link = null; 
    } 
    Node(int n, Node p) {
    // a node with given value and reference 
        data = n;
        link = p; 
    }

    public void setLink( Node n ) {

        link = n;
    }

    public Node getLink() {
        return link;
    }
    public int data() {
        return data ; 
    }

}

public class inputer {

    public static Node reverseList( Node current ){

        Node previous = null ;
        Node next = null ;
        while ( current != null ){
            next = current.getLink() ; 
            current.setLink( previous );
            previous = current ;
            current = next ;
        }
        return previous ;
    }

    static void insert( int position , Node start , Node toAdd ){

        Node ptr = null ;
        Node next = null ;
        for ( int i = 1 ; i<position ; i++  ){

            if ( ptr == null ){
                ptr = start ;
                next = ptr.getLink();
            } else {
                ptr = next;
                next = ptr.getLink();
            }
        }

        ptr.setLink( toAdd );
        toAdd.setLink( next );
    }
       
    static void delete( int position , Node start){
        Node ptr = null ;
        Node next = null ;
        for ( int i = 1 ; i<position ; i++  ){

            if ( ptr == null ){
                ptr = start ;
                next = ptr.getLink();
            } else {
                ptr = next;
                next = ptr.getLink();
            }
        }
        Node z = next.getLink();
        ptr.setLink(z);
    }   

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in ) ;
        Node front = null ;
        Node ptr = null ;
        int size = input.nextInt(); 
        for ( int i = 0 ; i  < size ; i++ ){

            int data = input.nextInt();      
            Node temp = new Node( data );
            
            if ( front == null ) {
                front = temp ;
                temp = null ;    
            }else if ( ptr == null ){
                ptr = temp ;
                temp = null ;
                front.setLink( ptr ) ;
            }
            else {
                ptr.setLink( temp );
                ptr = temp ;
                temp = null ;
            }
        }
        System.out.println("_______________________________");
        Node temp = front ;
        while ( front != null ){
            System.out.print( front.data() );
            System.out.print(" ");
            front = front.getLink() ;
        }
        System.out.println();\
        System.out.println();
        System.out.println("_______________________________");
        Node y = new Node( 90 );
        delete( 3 , temp  );

        while ( temp != null ){
            System.out.print( temp.data() );
            System.out.print(" ");
            temp = temp.getLink() ;
        }
        System.out.println();
        System.out.println();
        System.out.println("_______________________________");
    }
}