package ie.gmit.sw;

/**
 * @author Claire Finn
 *
 */
public class Calculations
{

    private String className;

    /**
     * Making a new instance of my TestCase here as my TestCase deals
    with Afferent and Efferent Couplings
     */
    MetricsTest mt = new MetricsTest();

  /* */
	/**
	 * Retrieving the methods that deal with afferent and efferent
    couplings from my MetricTest class
	 */
	private int afferentCouplings = mt.testAfferentAndCycles();
    private int efferentCouplings = mt.testEfferentAndCycles();

    /**
     * @return
     * getting ClassNames
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * @param className
     * Setting Class Name
     */
    public void setClassName(String className)
    {
        this.className = className;
    }

    /**
     * @return
     * Getting Afferent
     */
    public int getAfferent()
    {
        return afferentCouplings;
    }

    /**
     * @param afferentC
     * Setting Afferent
     */
    public void setAfferent(int afferentC)
    {
        this.afferentCouplings = afferentC;
    }

    /**
     * @return
     * Getting Efferent
     */
    public int getEfferent()
    {
        return efferentCouplings;
    }

    /**
     * @param efferentC
     * Setting Efferent
     */
    public void setEfferent(int efferentC)
    {
        this.efferentCouplings = efferentC;
    }

    /**
     * @return
     * return this double for use in other classes
     * @param positionalStability
     *  Creating a double called positionalStability
    	* setting positionalStability to 1 as if it was 0 it would error when dividing
    	* If Efferent is greater than 0
    	* ps= efference of the JAR divided by the afference plus the efference of the JAR
       *  We do the calculation this way to ensure we always get either 0 or 1 as the answer.
       *  0 is stable, 1 is unstable.
     */

    public double getPositionalStability()
    {

        double positionalStability = 1d;

        try
        {

            if(getEfferent() > 0)
            {
                positionalStability = ((double) getEfferent() / ((double) getAfferent() + (double) getEfferent()));
            }
            else
            {
                positionalStability = 0d;
            }
        }
        catch (Exception e)
        {
            positionalStability = 0d;
        }

        return positionalStability;
    }
}