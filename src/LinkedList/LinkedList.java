package LinkedList;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;

public class LinkedList {
    private int size;
    private Node header;
    private HashSet<Node> linkedList;

    public LinkedList(){
        linkedList = new HashSet<Node>();
        header = new Node();
        header.setNextNode(null);
        size = 0;
    }

    public void append(int val){
        Node currentNode = this.header;
        while(currentNode.getNextNode()!=null){
            currentNode = currentNode.getNextNode();
        }
        Node newNode = new Node();
        newNode.setValue(val);
        newNode.setNextNode(null);
        currentNode.setNextNode(newNode);
        this.linkedList.add(newNode);
        this.size++;
    }

    public void insert(int index, int val) throws ArrayIndexOutOfBoundsException{
        if(index < this.size){
            Node currentNode = this.header;
            for(int i = 0; i < index; i++){
                currentNode = currentNode.getNextNode();
            }
            Node aux = currentNode.getNextNode();
            Node newNode = new Node();
            newNode.setValue(val);
            newNode.setNextNode(aux);
            currentNode.setNextNode(newNode);
            this.linkedList.add(newNode);
            this.size++;
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int get(int index) throws ArrayIndexOutOfBoundsException{
        if(index < this.size){
            Node currentNode = this.header;
            for(int i = 0; i <= index; i++){
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getValue();
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException{
        if(index < this.size){
            Node currentNode = this.header;
            for(int i = 0; i < index; i++){
                currentNode = currentNode.getNextNode();
            }
            Node aux1 = currentNode.getNextNode();//node to be deleted
            Node aux2 = aux1.getNextNode();
            currentNode.setNextNode(aux2);
            this.linkedList.remove(aux1);
            this.size--;
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
