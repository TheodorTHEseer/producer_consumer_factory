package com.company.queues;

public class BlockingQueue {

    private Node head;
    private Node tail;
    private int capacity;

    public BlockingQueue(int capacity){
        this.capacity=capacity;
    }

    public int getSize(){
        int size=0;
        Node n = head;
        while (n!=null){
            n=n.next;
            size++;
        }
        return size;
    }

    public String take(){
        head=head.next;
        return head.getText();
    }


    public void put(String text){
        Node node = new Node(text);
        if(getSize()!=capacity){//до заполнения буфера
            node.next=head;
            head=node;
        }

        if(getSize()==capacity){
            tail=head;
            node.next=head;
        }

//
//        if(getSize()==capacity){
//            tail=head;
//        }
    }
}
