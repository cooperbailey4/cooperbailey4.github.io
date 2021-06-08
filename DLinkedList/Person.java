import java.util.Random;
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private String first_name = null;
    private String last_name = null;
    private String id = null;
    private static long counter = 0;
    
    private Random rand = new Random();
    
    public static void main(String[] args){
        System.out.println(digitsOnly("123456789"));
    }
    
    /**
     * Person Constructor
     */
    public Person(String first_name, String last_name, String idNumber) throws IllegalIDException {
        this.first_name = first_name;
        this.last_name = last_name;
        
        if(idNumber == null || badID(idNumber)) {
            throw new IllegalIDException(idNumber);
        }
        
        this.id = idNumber;
    } 
    
    /**
     * return false if we have a bad id
     */
    private boolean badID(String id) {
        return id.length() != 9 || !digitsOnly(id);
    }
    
    /**
     * check if a passed in String is digits only
     * @param str the String
     * @return true if all digits, false otherwise
     */
    private static boolean digitsOnly(String str) {
        boolean strOk = true;
        
        try {
            int num = Integer.parseInt(str);
            if (num < 0){
                strOk = false;
            }
        }
        catch (NumberFormatException e){
            strOk = false;
        }
        
        return strOk;
    }
    
    /**
     * set first name
     */
    private void setFirstName(String name) {
        first_name = name;
    }
    
    /**
     * set last name
     */
    private void setLastName(String name) {
        last_name = name;
    }
    
    /**
     * get the person's first name
     */
    public String getFirstName() { 
        return first_name;
    }
    
    /**
     * get the person's last name
     */
    public String getLastName() {
        return last_name;
    }
    
    /**
     * get the person's IDNumber as a String
     */
    public String getID() {
        return id;
    }
    
    /**
     * Create a new ID string between 000000000 - 999999999
     */
    public String newID(){
        counter++;//try {
        this.id = String.format("%09d", counter);
        return this.id;
    }
    
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + getID();
    }
}
