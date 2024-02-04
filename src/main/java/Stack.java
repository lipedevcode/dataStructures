public class Stack {
    private class Node {
        double data;
        Node next;
    }
    private Node top;
    public void push(double info){
        if(this.top == null){
            this.top = new Node();
            this.top.data = info;
            this.top.next = null;
        }
        else{
            Node node = new Node();
            node.data = info;
            node.next = this.top;
            this.top = node;
        }
    }
    public String pop(){
        if(this.top!=null) {
            double info = this.top.data;
            this.top = this.top.next;
            return String.valueOf(info);
        }
        return "Stack is empty!";
    }
    public String pop(double info){
        if(this.top == null)
            return "Stack is empty!";
        else if(this.top.data == info){
            this.top = this.top.next;
            return String.valueOf(info);
        }
        else{
            Node predecessor = getNodePredecessor(info);
            if(predecessor!=null){
                Node nodeRemove = predecessor.next;
                predecessor.next = nodeRemove.next;
                return String.valueOf(info);
            }
            else
                return "Node not found!";
        }
    }
    private Node getNodePredecessor(double info){
        Node auxTop = this.top;
        while(auxTop.next!=null){
            Node auxTopNext = auxTop.next;
            if(auxTopNext.data == info)
                return auxTop;
            auxTop = auxTop.next;
        }
        return null;
    }
    public String getTop(){
        if(this.top == null)
            return "Stack is empty!";
        return String.valueOf(this.top.data);
    }
}
