package TrialPodcast;

public class ArrayQueue {
    private Podcast[] queue;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue() {
        queue = new Podcast[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(Podcast podcast) {
        if (size == queue.length) {
            resize();
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = podcast;
        size++;
    }

    public Podcast dequeue() {
        if (isEmpty()) {
            return null;
        }

        Podcast podcast = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return podcast;
    }

    public Podcast peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Podcast[] newQueue = new Podcast[queue.length * 2];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }

        queue = newQueue;
        front = 0;
        rear = size - 1;
    }

    public Podcast[] getElements() {
        Podcast[] elements = new Podcast[size];
        for (int i = 0; i < size; i++) {
            elements[i] = queue[(front + i) % queue.length];
        }
        return elements;
    }
}

