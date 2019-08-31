import java.util.*;
import java.io.*;
import java.lang.*;

class Node{
        public int data;
        public Node next;
        Node(int dat){
            data = dat;
            next = null;
        }
}

public class LinkedList{
    
    public static Node addNode(int data, Node front){
        Node tmp = new Node(data);
        if(front == null){
            front = tmp;
        }
        else{
        Node t = front;
        while(t.next != null){
            t = t.next;
        }
        t.next = tmp;
    }
    return front;
    }
    public static Node addAtFront(int data, Node front){
        Node tmp = new Node(data);
        tmp.next = front;
        front = tmp;
        return front;
    }
    public static void addInMiddle(int data_prev, int data_next, int data, Node front){
        Node tmp = front;
        while(tmp.next != null){
            if(tmp.data == data_prev && tmp.next.data == data_next){
                Node add = new Node(data);
                add.next = tmp.next;
                tmp.next = add;
                return;
            }
            tmp = tmp.next;
        }   
    }    
    public static void printList(Node front){
        if(front==null){
            System.out.println("List is empty");
        }
        else{
        Node t = front;
        while(t.next != null){
            Node temp = t;
            System.out.print(Integer.toString(t.data) + "->");
            t = temp.next;
            temp = t;
        }
        System.out.println(Integer.toString(t.data));  
        }
    }
    public static Node deleteNode(int data, Node front){
        if(front.next == null && front.data == data){
            front = null;
            System.out.println(Integer.toString(data) + " deleted from list, list is now empty");
            return front;
        }
        else if(front.next == null && front.data != data){
            System.out.println("No such entry");
            return front;
        }
        else if(front.data == data && front.next != null){
            Node tmp = front.next;
            front = tmp;
            System.out.println(Integer.toString(data) + " deleted from front");
            return front;
        }
        Node search = front;
        boolean found = false;
        while(search.next != null){
            Node temp = search;
            search = temp.next;
            if(search.data == data){
                temp.next = search.next;
                search.next = null;
                found = true;
                break;
            }
        }
        if(found){
            System.out.println(Integer.toString(data) + " deleted from list");
        }
        else{
            System.out.println("No such entry");
        }
        return front;
    }
    public static Node reverseList(Node front){
        Node curr = front;
        Node prev = null;
        Node next = curr.next;
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;    
        }
        return next;
    }

    public static void main(String[] args) {
        Node front = null;
        Scanner s = new Scanner(System.in);
        System.out.println("1. Add Node");
        System.out.println("2. Delete Node");
        System.out.println("3. Print List");
        System.out.println("4. Add at front");
        System.out.println("5. Insert at middle");
        System.out.println("6. Reverse List");
        System.out.println("7. Exit");
        System.out.println("Enter option: ");
        int opt = s.nextInt();
        while(opt != 7){
            if(opt == 1){
                System.out.print("Data value for node: ");
                int newData = s.nextInt();
                front = addNode(newData, front);
            }
            if(opt == 2){
                if(front == null){
                    System.out.println("List is empty");
                }
                else{
                System.out.print("Data value of node to be deleted: ");
                int delData = s.nextInt();
                front = deleteNode(delData, front);
            }
                // return;
            }
            if (opt == 3){
                printList(front);
            }
            if(opt == 4){
                System.out.print("Data value of node to be added: ");
                int addData = s.nextInt();
                front = addAtFront(addData, front);
            }
            if(opt == 5){
                if(front==null){
                    System.out.println("List empty");
                }
                else if(front.next == null)
                {
                    System.out.println("No middle element");
                }
                else if(front.next.next == null){
                    System.out.print("Data value of node to be added: ");
                    int addData = s.nextInt();
                    Node tmp = new Node(addData);
                    tmp.next = front.next;
                    front.next = tmp;
                }
                else{
                    System.out.print("Data value of node to be added: ");
                    int addData = s.nextInt();
                    System.out.print("Previous node value: ");
                    int prevData = s.nextInt();
                    System.out.print("Next node value: ");
                    int nextData = s.nextInt();
                    addInMiddle(prevData, nextData, addData, front);
                }
            }
            if(opt == 6){
                if(front.next == null){
                    front = front;
                }
                else{
                    front = reverseList(front);
                }
            }
            System.out.println("Enter option: ");
            opt = s.nextInt();
        }
    }  
 }