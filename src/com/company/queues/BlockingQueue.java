package com.company.queues;

public class BlockingQueue {

    private Node first;
    private Node last;

    public int getCapacity() {
        return capacity;
    }

    private int capacity;

    public int getSize() {
        return size;
    }

    private int size=0;

    public BlockingQueue(int capacity){
        this.capacity=capacity;
    }

    public boolean isEmpty(){
        return first ==null;
    }

    public String take(){
        String text = first.getText();
        first=first.next;
        if(isEmpty())
            last=null;
        size--;
        return text;
    }

    public void put(String text){
        Node node = last;
        last=new Node(text);
        last.next=null;
        if (isEmpty()) first=last;
        else
            node.next=last;
        size++;

        if (size>capacity)
            take();

    }
}
