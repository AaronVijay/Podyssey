package TrialPodcast;


public class ArrayLinkedList {
    private static final int DEFAULT_CAPACITY = 10;


    private static class Node {
        Podcast data;
        int next;

        Node(Podcast data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node[] nodes;
    private int head;
    private int firstFree;
    private int size;

    public ArrayLinkedList() {
        nodes = new Node[DEFAULT_CAPACITY];
        head = -1;
        firstFree = 0;
        size = 0;


        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i] = new Node(null, i + 1);
        }
        nodes[nodes.length - 1] = new Node(null, -1);
    }

    public void add(Podcast podcast) {
        if (firstFree == -1) {
            resize();
        }

        int newNodeIndex = firstFree;
        firstFree = nodes[firstFree].next;


        nodes[newNodeIndex].data = podcast;


        nodes[newNodeIndex].next = head;
        head = newNodeIndex;

        size++;
    }

    public void addLast(Podcast podcast) {
        if (firstFree == -1) {

            resize();
        }


        int newNodeIndex = firstFree;
        firstFree = nodes[firstFree].next;

        // Set the data
        nodes[newNodeIndex].data = podcast;
        nodes[newNodeIndex].next = -1;

        if (head == -1) {
            head = newNodeIndex;
        } else {
            int current = head;
            while (nodes[current].next != -1) {
                current = nodes[current].next;
            }
            nodes[current].next = newNodeIndex;
        }

        size++;
    }

    public Podcast get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        int current = head;
        for (int i = 0; i < index; i++) {
            current = nodes[current].next;
        }

        return nodes[current].data;
    }

    public boolean remove(int index) { 
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            if (head == -1) {
                return false;
            }

            int oldHead = head;
            head = nodes[head].next;
            nodes[oldHead].data = null;
            nodes[oldHead].next = firstFree;
            firstFree = oldHead;

            size--;
            return true;
        }

        int current = head;
        for (int i = 0; i < index - 1; i++) {
            current = nodes[current].next;
            if (current == -1) {
                return false;
            }
        }

        if (nodes[current].next == -1) {
            return false;
        }
        int toRemove = nodes[current].next;
        nodes[current].next = nodes[toRemove].next;

        nodes[toRemove].data = null;
        nodes[toRemove].next = firstFree;
        firstFree = toRemove;

        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        Node[] newNodes = new Node[nodes.length * 2];

        System.arraycopy(nodes, 0, newNodes, 0, nodes.length);


        for (int i = nodes.length; i < newNodes.length - 1; i++) {
            newNodes[i] = new Node(null, i + 1);
        }
        newNodes[newNodes.length - 1] = new Node(null, -1);


        if (firstFree == -1) {
            firstFree = nodes.length;
        }

        nodes = newNodes;
    }

    public Podcast[] toArray() {
        Podcast[] result = new Podcast[size];
        int current = head;
        for (int i = 0; i < size; i++) {
            result[i] = nodes[current].data;
            current = nodes[current].next;
        }
        return result;
    }
}



