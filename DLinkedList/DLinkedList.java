import java.util.List;
/**
 * Write a description of class DLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DLinkedList<E> implements IDLinkedList<E>
{
    private Node<E> head;
    private int size;
    private E value;
    
    public DLinkedList(){
        head = null;
        size = 0;
    }

    /**
     * add an item to the list (default is to the end of the list)
     */
    public void add(E data){
        addLast(data);
    }
    
    /**
     * add an item to the end of the list
     */
    public void addLast(E data){
        if (isEmpty()){
            addToEmptyList(data);
        }
        else{
            //create node
            Node<E> new_node = new Node(data);
            //set next and prev values,
            
            //set the next of the previous last node in the list
            head.getPrevNode().setNextNode(new_node);
            
            // set the previous value of the new node to the next node from the head 
            new_node.setPrevNode(head.getPrevNode());
            
            // set the next value in the new node to the head
            new_node.setNextNode(head);
            
            //set the prev value in head to new node
            head.setPrevNode(new_node);
            
            size += 1;
            // 
        }
    }
    
    /**
     * Adding a node to the beginning of the list
     */
    public void addFirst(E data){
        if (isEmpty()){
            addToEmptyList(data);
        }
        else{
            //create node
            Node<E> new_node = new Node(data);
            //set next and prev values,
            //set the next of the new node to head
            new_node.setNextNode(head);
            //set the prev of the new node to the head's last prev node
            new_node.setPrevNode(head.getPrevNode());
            //set next of the previous last node in the list to the new_node
            head.getPrevNode().setNextNode(new_node);
            //set prev node of head to the last node in the list which is new_node
            head.setPrevNode(new_node);
            //set the head to the new node as it will now be our first node
            head = new_node;
            //increase the size of the list
            size += 1;
        }
    }
    
    /**
     * add node in the middle of the list
     */
    public void addAt(Node<E> prev_node, E data) {
        if (isEmpty()){
            addToEmptyList(data);
        }
        else{
            //new node to insert in the middle of the list
            Node new_node = new Node(data);
            //set new node's next value to that of the next node after the prev_node 
            new_node.setNextNode(prev_node.getNextNode());
            //set the previous node of the node after the new node
            prev_node.getNextNode().setPrevNode(new_node);
            //set the previous node's next node to the new node were inserting 
            prev_node.setNextNode(new_node);
            //set the prev node of the new node to the previous node
            new_node.setPrevNode(prev_node);
            //increase the size of the list
            size += 1;
        }
    }
    
    /**
     * add node to an empty list 
     * (how the first node of the list is added)
     */
    public void addToEmptyList(E data){
        Node<E> node = new Node(data);
        node.setPrevNode(node);
        node.setNextNode(node);
        head = node;
        size += 1;
    }

    /**
     * Delete node at a specified index and return it's data
     */
    public E deleteAt(int index){
        //initialize variable data to null
        E data = null;
        
        //check index is within range of size
        if(index < size && index >= 0){
            //create tmp node variable 
            Node<E> tmp = head;
            
            int count = 0;
            //find the node we want to delete
            while(count < index){
                tmp = tmp.getNextNode();
                count++;
            }
            //set our variable to the tmp value we have found
            data = tmp.getData();
            //handle deleting the node
            tmp.getNextNode().setPrevNode(tmp.getPrevNode());
            tmp.getPrevNode().setNextNode(tmp.getNextNode());
            tmp.setData(null);
            size -= 1;
        }
        
        return data;
    }
    
    /**
     * Delete the first node in the list and return it's data
     */
    public E deleteFirst() {
        E data = null;

        if (size() > 0) {
            head.getData();
            Node<E> tmp = head;

            head = head.getNextNode();
            tmp.setNextNode(null); 
            size -= 1;
        }

        return data;
    }

    /**
     * Delete the last Item and return its data or null if empty list
     */
    public E deleteLast() {
        E data = null;
        
        if(!isEmpty()) {
            Node<E> temp = lastNode();
            data = temp.getData();
            //if there is only one item in the list, make the head item null 
            //( this.head.getNextNode() == head;) would be a valid test
            if(size() == 1) {
                head = null;
            }
            else {
                head.setPrevNode(temp.getPrevNode());
                head.getPrevNode().setNextNode(head);
            }
            //adjust the size of the list
            size -= 1;
        }  
        
        return data;
    }
    
    /**
     * get data at a specified index
     */
    public E getAt(int index){
        E data = null;
        
        if(index < size && index >= 0){
            Node<E> tmp = head;
            int count = 0;
            
            while(count < index){
                tmp = tmp.getNextNode();
                count++;
            }
            data = tmp.getData();
        }
        
        return data;
    }
    
    /**
     * set data at a specified index
     */
    public void setAt(int index, E data) {
        if(index < size && index >= 0){
            Node<E> tmp = head;
            int count = 0;
            
            while(count < index){
                tmp = tmp.getNextNode();
                count++;
            }
            
            tmp.setData(data);
        }
    }
    
    /**
     * get first Node data in linked list
     */
    public E getFirst() {
        return head.getData();
    }
    
    /**
     * get last Node's data in linked list
     */
    public E getLast() {
        return lastNode().getData();
    }
    
    /**
     * return true if list contains the data, else return false
     */
    public boolean contains(E data) { 
        //if (list.isEmpty)
        // assigning a temporary pointer to head 
        Node<E> tmp = head;
        //iterate over the list while it isn't empty,
        while (tmp != null) {
            if (tmp.getData().equals(data)) {
                return true;
            }
            tmp = tmp.getNextNode();
        }
        return false;
    }
    
   
    /**
     * clears the list by setting the head to null; 
     * sending all subsequent information to garbage collection
     */
    public void clear() {
        head = null;
    }

    /**
     * get the last node in the list
     */
    public Node<E> lastNode() {
        return head.getPrevNode();
    }
    
    /**
     * return the size of the list as a method
     */
    public int size() { 
        return size;
    }

    /**
     * returns the boolean value of whether the list is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * return the list as a comma separated String
     */
    @Override
     public String toString() {
         StringBuilder sb = new StringBuilder("[");
         
         for (int i = 0; i < size(); i++) {
             System.out.println(i + " " + this.getAt(i));
             sb.append(this.getAt(i) + ", "); 
         }
         
         String result = sb.toString();
         
         if (size > 0) {
             result = result.substring(0, result.length() - 2);    
         }
         
         return result + "]";
     }
     
}