import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DLinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DLinkedListTest
{
    private DLinkedList<Integer> list;
    
    /**
     * Default constructor for test class DLinkedListTest
     */
    public DLinkedListTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        list = new DLinkedList<>();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        list = null;
    }
    
    /**
     * Test adding to the list adds onto the back of the list
     */
    @Test
    public void testAdd(){
        list.add(1);
        list.add(3);
        assertTrue(list.getLast() == 3);
    }
    
    /**
     * Test deleting last item from list if there is only one item
     */
    @Test
    public void testDeleteLastOneItem(){
        list.add(1);
        assertTrue(list.deleteLast() == 1);
        assertTrue(list.size() == 0);
    }
    
    /**
     * Test deleting last item from list if there is only one item
     */
    @Test
    public void testDeleteLastEmptyList(){
        assertTrue(list.deleteLast() == null);
    }
    
    /**
     * Test deleting the last item from a list w/ multiple elements
     */
    @Test
    public void testDeleteLastMultiList(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertTrue(list.deleteLast() == 4);
        assertTrue(list.size() == 3);
    }
    
    /**
     * Test list contains method if there's no items in the list
     */
    @Test
    public void testContainsNone(){
        assertFalse(list.contains(1));
    }
    
    /**
     * Test the contains method for true if the element is in the list
     */
    @Test
    public void testContainsTrue(){
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.contains(1));
    }
    
    /**
     * Test the contains method for false if the element is in the list
     */
    @Test
    public void testContainsFalse(){
        list.add(1);
        list.add(2);
        list.add(3);
        assertFalse(list.contains(1));
    }
    
    /**
     * Test deleteAt(index) method
     */
    @Test
    public void testDeleteAt(){
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.deleteAt(2) == 3);
        assertTrue(list.size() == 2);
    }
    
    /**
     * Test setAt(index, E e) method
     */
    //note: index is 0 for the first element
    @Test
    public void testSetAt(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.setAt(0,4);
        assertTrue(list.getAt(0) == 4);
    }
    
    /**
     * Test toString
     */
    @Test
    public void testToString(){
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.toString().contains("[1, 2, 3]"));
    }
}

