
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Node<E>
{
    private E data;
    private Node<E> next;
    private Node<E> prev;
    
    /**
     * Node constructor
     */
    public Node(E data){
        this.data = data; //data in the node
        next = null;
        prev = null; //showing these are assigned to null
        
    }
    
    /**
     * set the next node for this node to the new node
     */
    public void setNextNode(Node<E> node)
    {
        this.next = node;
    }
    
    /**
     *  Set the previous node for this node to the new node
     */
    public void setPrevNode(Node<E> node){
        this.prev = node;
    }
    
    /**
     * Set the data of the node to the given data
     */
    public void setData(E data){
        this.data = data;
    }
    
    /**
     * get the data of the node
     */
    public E getData(){
        return data;
    }
    
    /**
     * get the next node
     */
    public Node<E> getNextNode(){
        return next;
    }
    
    /**
     * get the prev node
     */
    public Node<E> getPrevNode(){
        return prev;
    }
    
    
}
