package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * @author Claire Finn
 *
 */
public class CalculationsImpl
{
	/**
	 * Creating a Map to put my Calculations class into
	 */
	private HashMap<String, Calculations> calcs = new HashMap<>();

    /**
     * Initialising the jar path
     */
    private String pathOfJar;

    /**
     * @param pathOfJar
     * Jar choice
     */
    /**
     * @param addingToMap
     *  Add to map method
     */

    /**
     * @param myCalculation
     * myCalculation method instance
     */
    public CalculationsImpl(String pathname)
    {
        this.pathOfJar = pathname;
        addingToMap();
        myCalculation();
    }

    /**
     * @return data
     * returning data for use in other classes
     * @param Object
     * Creates data array and names fields that will go into it
     * @param int i
     * initialising i at 0 for use below
     * @param size Creating 2d object array with a size of 4
     *  @param foreach Populating the array with my stability info
     *  @param getClassName Class Name info
     *  @param getPositionalStability Positional Stability info
     *  @param getAfferent Afferent info
     *  @param getEfferent Afferent info
     *  @param i++ Incrementing the array by 1 so it goes to the next column
     */
    public Object[][] getInfoAboutMetric()
    {
        int i = 0;

        Object[][] data = new Object[calcs.size()][4];

        for(Calculations c : calcs.values())
        {
            data[i][0] = c.getClassName();
            data[i][1] = c.getPositionalStability();
            data[i][2] = c.getAfferent();
            data[i][3] = c.getEfferent();
            i++;
        }
        return data;

    }

    /**
     * @param addingToMap Using my previously created Map
     * @param int i Initializing i
     * @param file Initialising a jar entry file path
     * @param JarInputStream Using a JarInputStream to read in the selected JAR
     * @param JarEntry Getting the next JAR Entry from the user
     * @param while Handling reading in the JAR
     * If the JAR being read in has the extension .class
     * Replace all / with \\ to handle errors
     * Removes .class extension
     * If the name does not contain $
     * putting name into Map
     * gets name from Calcs and sets it to the name here
     * Incrementing
     * moves onto the next entry
     * printing out Jar
     *
     */

    private void addingToMap()
    {
        int i = 0;

        try
        {
            File file  = new File(pathOfJar);
            JarInputStream in = new JarInputStream(new FileInputStream(file));
            JarEntry nextJarEntry = in.getNextJarEntry();

            while (nextJarEntry != null)
            {
                if (nextJarEntry.getName().endsWith(".class"))
                {
                    String name = nextJarEntry.getName().replaceAll("/", "\\.");
                    name = name.replaceAll(".class", "");
                    if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
                    calcs.put(name, new Calculations());
                    calcs.get(name).setClassName(name);
                    i++;
                }

                nextJarEntry = in.getNextJarEntry();

            }
            System.out.println(i + " classes");

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * @param pathOfJar Instantiating the file again here
     * @param URL creates a path to the file
     * Puts this path into an array for multiples handling
     * @param classLoader Loads the classes from the JAR file being read in
     * @param for putting names into the previously created map
     */

    private void myCalculation()
    {
        try
        {
            File file = new File(pathOfJar);
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);

            for (String className : calcs.keySet())
            {
                Class cls = Class.forName(className, false, cl);
                info(cls);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    /**
     * @param cls
     * Checking for interfaces within the class
     * Places these interfaces into an array in case of multiples
     * for each loop for every class that has an interface
     * if the class contains the name
     * Efferent count goes up
     * Increment afferent for other class
     * Getting constructors and placing them in an array
     * for each loop for every class that has constructors
     * getting parameter types
     * for each loop to deal with parameters
     * Getting fields and placing them in an array
     * for each loop to deal with fields
     * Getting Methods and placing them in an array
     * for each loop to deal with methods
     * dealing with method parameter types
     * Setting efferent here
     */
    private void info(Class cls)
    {
        int efferent = 0;
        boolean iface = cls.isInterface();
        Class[] interfaces = cls.getInterfaces();

        for(Class i : interfaces)
        {
            if(calcs.containsKey(i.getName()))
            {
                efferent++;
                Calculations m = calcs.get(i.getName());
                m.setAfferent(m.getAfferent() + 1);
            }

        }

        Constructor[] cons = cls.getConstructors();
        Class[] constructorParams;

        for(Constructor c : cons)
        {
            constructorParams = c.getParameterTypes();

            for(Class param : constructorParams)
            {
                if(calcs.containsKey(param.getName()))
                {
                    efferent++;
                    Calculations m = calcs.get(param.getName());
                    m.setAfferent(m.getAfferent() + 1);
                }
            }
        }

        Field[] fields = cls.getFields();

        for(Field f : fields)
        {
            if(calcs.containsKey(f.getName()))
            {
                efferent++;
                Calculations m = calcs.get(f.getName());
                m.setAfferent(m.getAfferent() + 1);
            }
        }

        Method[] methods = cls.getMethods();
        Class[] methodParams;

        for(Method m : methods)
        {
            Class methodReturnType = m.getReturnType();

            if(calcs.containsKey(methodReturnType.getName()))
            {
                efferent++;
                Calculations cal = calcs.get(methodReturnType.getName());
                cal.setAfferent(cal.getAfferent() + 1);
            }

            methodParams = m.getParameterTypes();
            for(Class mp : methodParams)
            {
                if(calcs.containsKey(mp.getName()))
                {
                    efferent++;
                    Calculations cal = calcs.get(mp.getName());
                    cal.setAfferent(cal.getAfferent() + 1);

                }
            }
        }
        calcs.get(cls.getName()).setEfferent(efferent);
    }
}
