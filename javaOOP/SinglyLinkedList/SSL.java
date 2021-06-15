public class SSL{
    Node head;

    public SSL(){

    }
    public void addFirst(int value){
        if (head == null){
            Node x = new Node(value);
            head = x;
        } else {
            Node x = new Node(value);
            x.next = head;
            head =x;
        }
    }
    public void addLast(int value){
        Node x = new Node(value);
        Node current = head;
        while (current.next != null){
            current=current.next;
        }
        current.next= x;
    }


    public void deleteFirst(){
        if (head == null){
            return ;
        } else {
            Node current = head;
            head = head.next;
            current = null;
        }
    }

    public void print(){
        Node current = head;
        while (current != null){
            System.out.println(current.value);
            current=current.next;
        }
        
    }

    public static void main(String[] args){
        SSL mylist = new SSL();
        mylist.addFirst(4);
        mylist.addFirst(1);
        mylist.addLast(8);
        mylist.deleteFirst();

        mylist.print();

    }

    
}