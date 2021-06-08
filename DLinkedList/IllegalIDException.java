
/**
 * Illegal ID Exception
 */
public class IllegalIDException extends Exception
{
    private String ID;
    
    /**
     * Constructor for objects of class IllegalIDException
     */
    public IllegalIDException(String ID)
    {
        this.ID = ID;
    }
    
    @Override
    public String toString(){
        return "Illegal ID: " + ID;
    }
}
