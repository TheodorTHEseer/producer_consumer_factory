package com.company.queues;

public class Node {

    private final String text;
    protected Node next;

    public Node(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
