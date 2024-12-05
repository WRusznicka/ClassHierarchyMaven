package entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList <D>{
    private CustomNode<D> head;
    private int size;

    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);

    public CustomLinkedList() {
    }

    public CustomNode<D> getHead() {
        return head;
    }

    public void setHead(CustomNode<D> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(D node){
        CustomNode<D> newNode = new CustomNode<>(node);
        if(head == null){
            head = newNode;
        }
        else{
            CustomNode<D> current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void remove(D node){
        if(head == null){
            LOGGER.info("List is empty. The element is not in list");
        }
        else if(head.getData().equals(node)){
            head = head.getNext();
            size--;
        }
        else{
            CustomNode<D> current = head;
            while(current.getNext() != null && !current.getNext().getData().equals(node)){
                current = current.getNext();
            }
            if(current.getNext() != null){
                current.setNext(current.getNext().getNext());
                size--;
            }
        }

    }

    public void printList(){
        CustomNode<D> current = head;
        LOGGER.info("Elements in linked list: ");
        while(current != null){
            LOGGER.info(current.getData().toString() + "->");
            current = current.getNext();
        }
    }

    public D getFirst(){
        if(head == null){
            LOGGER.info("List is empty, no elements found");
            return null;
        }
        return head.getData();

    }

    public D getLast(){
        if(head == null){
            LOGGER.info("List is empty, no elements found");
            return null;
        }
        CustomNode<D> current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        return current.getData();
    }

    public boolean isEmpty(){
        return size==0;
    }
}
