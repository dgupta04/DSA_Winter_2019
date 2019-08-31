import java.util.*;
import java.io.*;
import java.lang.*;

public class LinkedList{
    public class Node{
        private int data;
        private Node next;
        public static Node(int data){
            this.data = data;
            next = null;
        }
        public static int getData(){
            return data;
        }
        public static void setData(int data){
            this.data = data;
        }
        public static Node getNext(){
            return next;
        }
        public static void setNext(Node next){
            this.next = next;
        }
    }
    public static void addNode(int data, Node front){
        Node t = front;
        while(t.next != null){
            Node temp = t;
            t = temp.next;
            temp = t;
        }
        Node newNode = new Node(data);
        t.setNext(newNode);
    }
    public static void main(String[] args) {
        Node front = null;
    }  
 }