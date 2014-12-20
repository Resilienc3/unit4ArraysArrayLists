
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RadarTest.
 *
 * @author  (Jalen Smith)
 * @version (12/20/14)
 */
public class RadarTest
{
    /*
     * Tests any dx dy pair you input
     */
    @Test
    public void RadarTestDxDy() throws InterruptedException
    
    {
        // create the radar, set the monster location, and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        Radar radar = new Radar(ROWS, COLS);
        radar.setNoiseFraction(0.01);
        radar.setMonsterLocation();
       
        radar.scan();
        
        
        for(int i = 0; i < 50; i++)
        {                       
            radar.scan();
        }
    
        assertEquals(radar.getDx(),radar.getGuessDx());
        assertEquals(radar.getDy(),radar.getGuessDy());
   }

}
