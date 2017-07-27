public class Node {
    Element thisElement;
    Node rightElement;
    Node leftElement;

    public Node(Element thisElement, Node leftElement, Node rightElement) {
        this.thisElement = thisElement;
        this.leftElement = leftElement;
        this.rightElement = rightElement;

    }

    public Element getThisElement() {
        return thisElement;
    }

    public Node getRightElement() {
        return rightElement;
    }

    public Node getLeftElement() {
        return leftElement;
    }
}
