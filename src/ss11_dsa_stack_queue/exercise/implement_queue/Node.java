package ss11_dsa_stack_queue.exercise.implement_queue;

public class Node {
    private int data;
    private Node link;

    public Node() {
    }

    public Node(int data, Node link) {
        this.data = data;
        this.link = link;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", link=" + link +
                '}';
    }
}
