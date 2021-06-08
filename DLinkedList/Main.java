
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    private static DLinkedList D = new DLinkedList<>();
    public static void main(String[] args) {
        Person p1 = null;
        Person p2 = null;
        Person p3 = null;
        Person p4 = null;
        Person p5 = null;
        
        try {
            p1 = new Person("John", "Egbert", "123456785");
            p2 = new Person("Rose", "Lalonde","123456786");
            p3 = new Person("Dave", "Strider","123456787");
            p4 = new Person("Jade", "Harley", "123456788");
            p5 = new Person("Jane", "Crocker", "-123456789");
        }
        catch (IllegalIDException e) {
            System.out.println("Illegal ID caught: " + e);        
        }
        
        D.add(p2);
        D.add(p1);
        D.addFirst(p3);
        D.addFirst(p4);
        D.addLast(p5);
        System.out.println();
        D.toString();
        D.deleteFirst();
        D.deleteLast();
        System.out.println();
        D.toString();
        D.deleteAt(1);
        System.out.println();
        D.toString();
    }
}
