
/**
 * This class returns a random number.
 * 
 * @author Jacob Plumb 
 * @version 2017.9.25
 */

import java.lang.Math;
public class drawNum{
    public int num;
    
    public drawNum(){
        num = 0;
    }
    
    public int getRandNum(){
        num = (int)((Math.random() * 10) + 1);
        return num;
    }
}
