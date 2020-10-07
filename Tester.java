import edu.duke.*;
import java.util.*;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void testGetFollows() {
        MarkovOne mark = new MarkovOne();
        mark.setTraining("this is a test yes this is a test.");
        System.out.println(mark.getFollows("."));
    }
    
    public void testGetFollowsWithFile() {
        FileResource fr = new FileResource();
	String st = fr.asString();
	//st = st.replace('\n', ' ');
        MarkovOne mark = new MarkovOne();
        mark.setTraining(st);
        ArrayList<String> list = mark.getFollows("he");
        System.out.println(list.size());
    }
}
