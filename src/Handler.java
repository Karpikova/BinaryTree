import java.util.Stack;

public class Handler {

    private Tree tree;
    Stack<Node> stack = new Stack<>();

    public Handler() {
        this.tree = makeTestTree();
    }

    public String getSum() {
        Node curElement = tree.getRoot();
        addToStack(curElement);
        NextStep nextStep = NextStep.Down;
        makeNextStep(nextStep, null);
        int sum = CommonData.getSum();
        return (String.valueOf(sum));
    }

    private void makeNextStep(NextStep nextStep, Node previouseDeletedElement) {
        if (stack.size() == 1 && previouseDeletedElement == tree.getRoot().getLeftElement()){
            return;
        }

        Node curEl = stack.peek();
        if (nextStep.equals(NextStep.Down)){
            if (curEl.getRightElement()!=null){
                addToStack(curEl.getRightElement());
                makeNextStep(NextStep.Down, null);
                return;
            } else if (curEl.getLeftElement()!=null){
                addToStack(curEl.getLeftElement());
                makeNextStep(NextStep.Down, null);
                return;
            } else {
                stack.pop();
                makeNextStep(NextStep.Up, curEl);
                return;
            }
        }
        else if (nextStep.equals(NextStep.Up)) {
            if (previouseDeletedElement.equals(curEl.getLeftElement())){
                stack.pop();
                makeNextStep(NextStep.Up, curEl);
                return;
            }
            if (curEl.getLeftElement()!=null){
                addToStack(curEl.getLeftElement());
                makeNextStep(NextStep.Down, null);
                return;
            } else {
                stack.pop();
                makeNextStep(NextStep.Up, curEl);
            }
        }
        else {
            System.out.printf("Wrong command");
        }
    }

    private void addToStack(Node curElement) {
        stack.push(curElement);
        int curSum = (Integer) curElement.getThisElement().getValue();
        CommonData.addToSum(curSum);
    }

    private static Tree makeTestTree() {
        Element<Integer> e1 = new Element<>(1);
        Element<Integer> e2 = new Element<>(2);
        Element<Integer> e3 = new Element<>(3);
        Element<Integer> e4 = new Element<>(4);
        Element<Integer> e5 = new Element<>(5);
        Element<Integer> e6 = new Element<>(6);
        Element<Integer> e7 = new Element<>(7);
        Element<Integer> e8 = new Element<>(8);
        Node n8 = new Node(e8, null, null);
        Node n7 = new Node(e7, null, null);
        Node n6 = new Node(e6, n7, n8);
        Node n5 = new Node(e5, n6, null);
        Node n4 = new Node(e4, null, null);
        Node n3 = new Node(e3, n4, n5);
        Node n2 = new Node(e2, null, null);
        Node n1 = new Node(e1, n2, n3);
        Tree tree = new Tree(n1);
        return tree;
    }
}
