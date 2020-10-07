import java.util.*;
/**
 * Write a description of class MarkovModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MarkovModel
{
    // instance variables - replace the example below with your own
    private String myText;
    private Random myRandom;
    private int x;

    /**
     * Constructor for objects of class MarkovModel
     */
    public MarkovModel(int num)
    {
        // initialise instance variables
        x = num;
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public ArrayList<String> getFollows(String key) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < myText.length() - key.length(); i++) {
            if (key.equals(myText.substring(i, i + key.length()))) {
                list.add(myText.substring(i + key.length(), i + key.length() +  1));
            }
        }
        return list;
    }
       
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-x);
        System.out.println(index);
        String key = myText.substring(index, index + x);
        System.out.println(key);
        sb.append(key);
        for(int k=0; k < numChars - x; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size()); 
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        return sb.toString();
    }
}
