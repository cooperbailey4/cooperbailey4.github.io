
/**
 * Write a description of class IDLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IDLinkedList<E>
{
    void add(E data);
    void addAt(Node<E> prev_node, E data);
    void addFirst(E data);
    void addLast(E data);
    E deleteAt(int index);
    E deleteFirst();
    E deleteLast();
    int size();
    void clear();
    boolean contains(E data);
    E getAt(int index);
    E getFirst();
    E getLast();
    void setAt(int index, E data);
    String toString();
}
