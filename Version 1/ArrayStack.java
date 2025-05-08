package TrialPodcast;
public class ArrayStack {
    private Podcast[] stack;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        stack = new Podcast[DEFAULT_CAPACITY];
        top = -1;
    }

    public void push(Podcast podcast) {
        if (top == stack.length - 1) {
            resize();
        }
        stack[++top] = podcast;
    }

    public Podcast pop() {
        if (isEmpty()) {
            return null;
        }
        Podcast podcast = stack[top];
        stack[top--] = null;
        return podcast;
    }

    public Podcast peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void resize() {
        Podcast[] newStack = new Podcast[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public Podcast[] getElements() {
        Podcast[] elements = new Podcast[size()];
        for (int i = 0; i < size(); i++) {
            elements[i] = stack[i];
        }
        return elements;
    }
}
