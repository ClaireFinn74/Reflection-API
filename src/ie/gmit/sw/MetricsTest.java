package ie.gmit.sw;

import junit.framework.TestCase;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.Test;

import junit.framework.*;
import jdepend.*;
import jdepend.framework.*;
import jdepend.framework.JavaPackage;

/**
 * @author Claire Finn
 *
 */
public class MetricsTest
{

	/**
	 * Creating a method to check JAR for efferent and afferent couplings and dependency cycles.
	   Ensuring method name begins with test in order for Junit to pick my test case.
	    (If method name does not begin with test, test case will fail; no tests found)
	 * @return afferent For use within my Calculations class
	 */
	@Test
	 public int testAfferentAndCycles()
	 {

		//*************************JDEPEND STUFF********************************

		 /* Initialising the use of JDepend, a tool I use to show the efferent/afferent couplings
		  and dependency cycles. You can also use a whole bunch of other metrics with JDepend */
	  JDepend _jdepend = new JDepend();

	  /* Showing JDepend the directory of the classes I want to analyse for
	  afferent/efferent couplings and dependancy cycles */
	  try
	  {
		_jdepend.addDirectory("C:/Users/owner/Desktop/Java Reflection API Project/src/ie/gmit/sw");
	  }
	  catch (IOException e)
	  {
		e.printStackTrace();
	}

	//Telling JDepend to analyse my classes
	  _jdepend.analyze();

	  //Getting the JavaPackage 'p' which is contained in jdepend.framework
	  JavaPackage p = _jdepend.getPackage("ie.gmit.sw");
	  System.out.println(p); //double-checking its not null
	//Asserting that 'p' is not null
	  assertNotNull(p);

	//***************Initialising variables for use ************

	  /*int afferent will be equal to the result of the method afferentCoupling.
	     afferentCoupling is a method found within JavaPackage 'p' */
	  int afferent = p.afferentCoupling();
	  /*boolean cycle will be equal to the result of the method containsCycle.
	  //containsCycle is a method found within JavaPackage 'p' and can be 'true' or 'false' */
	  boolean cycle= p.containsCycle();

	//*****************Asserting afferent*************************
	 assertEquals("Afferent Couplings Exist: " +p.getName(),
			  afferent, p.afferentCoupling());
	//*****************Asserting cycle****************************
	  assertEquals("Cycle exists: " + p.getName(),
	                cycle, p.containsCycle());


	//**********************Results*******************************

	  /* Printing out the result of whether my above classes in the above directory have any
	  afferent couplings or dependancy cycles, using previously defined variables */
	  System.out.println("Afferent Couplings:"
	  + "\n" + (afferent));
	  System.out.println("Cycle:"
			  + "\n" +(cycle));

	  return afferent;
	 }

	/**
	 * @return efferent For use within my Calculations class
	 */
	@Test
	 public int testEfferentAndCycles()
	 {

		//*************************JDEPEND STUFF********************************

		 /* Initialising the use of JDepend, a tool I use to show the efferent/afferent couplings
		  and dependency cycles. You can also use a whole bunch of other metrics with JDepend */
	  JDepend _jdepend = new JDepend();

	  /* Showing JDepend the directory of the classes I want to analyse for
	  afferent/efferent couplings and dependency cycles */
	  try
	  {
		_jdepend.addDirectory("C:/Users/owner/Desktop/Java Reflection API Project/src/ie/gmit/sw");
	  }
	  catch (IOException e)
	  {
		e.printStackTrace();
	  }

	//Telling JDepend to analyse my classes
	  _jdepend.analyze();

	  //Getting the JavaPackage 'p' which is contained in jdepend.framework
	  JavaPackage p = _jdepend.getPackage("ie.gmit.sw");
	  System.out.println(p); //double-checking its not null
	//Asserting that 'p' is not null
	  assertNotNull(p);

	//***************Initialising variables for use ************

	  /*int efferent will be equal to the result of the method efferentCoupling.
	    efferentCoupling is a method found within JavaPackage 'p' */
	  int efferent= p.efferentCoupling();
	  /*boolean cycle will be equal to the result of the method containsCycle.
	  //containsCycle is a method found within JavaPackage 'p' and can be 'true' or 'false' */
	  boolean cycle= p.containsCycle();

	//******************Asserting efferent*************************
	  assertEquals("Efferent Couplings Exist: " + p.getName(),
			  efferent, p.efferentCoupling());
	//*****************Asserting cycle****************************
	  assertEquals("Cycle exists: " + p.getName(),
	                cycle, p.containsCycle());


	//**********************Results*******************************

	  /* Printing out the result of whether my above classes in the above directory have any
	  efferent couplings or dependency cycles, using previously defined variables */
	  System.out.println("Efferent Couplings:"
			  + "\n" +(efferent));
	  System.out.println("Cycle:"
			  + "\n" +(cycle));

	  return efferent;
	 }
}
