public class Queue {
    private class Node{
        double data;
        Node next;
    }
    private Node first;
    private Node last;
    public void enqueue(double info){
        Node node = new Node();
        node.data = info;
        if(this.first == null){
            this.first = node;
            this.last = node;
            this.first.next = this.last;
        }
        else{
            this.last.next = node;
            this.last = node;
        }
    }
    public String dequeue(){
        if(this.first != null){
            double info = this.first.data;
            this.first = this.first.next;
            if(first == null) //fila vazia;
                last = null;
            return String.valueOf(info);
        }
        return "Queue is empty!";
    }
    public String dequeue(double info){
        if(this.first == null)
            return "Queue is empty!";
        else if(this.first.data == info){
            this.first = this.first.next;
            if(first == null) // fila vazia
                last = null;
            return String.valueOf(info);
        }
        else{
            Node sucessor = getNodeSucessor(info);
            if(sucessor != null){
                Node nodeRemove = sucessor.next;
                sucessor.next = nodeRemove.next;
                return String.valueOf(info);
            }
            else return "Node not found";
        }
    }
    private Node getNodeSucessor(double info){
        Node auxFirst = this.first;
        while(auxFirst.next != null){
            Node auxFirstNext = auxFirst.next;
            if(auxFirstNext.data == info)
                return auxFirst;
            auxFirst = auxFirst.next;
        }
        return null;
    }
    public String getFirst(){
        if(this.first == null)
            return "Queue is empty!";
        return String.valueOf(this.first.data);
    }
}
