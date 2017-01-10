package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ReflectionTextScorer
{
	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{

		/* ****************** READING IN JAR SECTION **************** */
	     // Instantiating the class to reflect, in this case its TextScorer
		 System.out.println("What are the classes within the JAR?");
		JarInputStream in = new JarInputStream(new FileInputStream(new File("C:/Users/owner/Desktop/Java Reflection API Project/src/ie/gmit/sw/railfence.jar")));
		JarEntry next = in.getNextJarEntry();
		while (next != null)
		{
		 if (next.getName().endsWith(".class"))
		 {
		 String name = next.getName().replaceAll("/", "\\.");
		 name = name.replaceAll(".class", "");
		 if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
		 System.out.println(name);
		 }
		 next = in.getNextJarEntry();
		}
		System.out.println();

		 /* ****************** INSTANTIATION SECTION **************** */
	     // Instantiating the class to reflect, in this case its TextScorer
		Class reflectClass = Class.forName("ie.gmit.sw.TextScorer");

	     /* ****************** CLASS NAME SECTION **************** */
	     // Get the class name of an Object
	     String className = reflectClass.getName();
	     System.out.println("What is the name of the class I'm testing here?");
	     System.out.println(className + "\n");

	     /* ****************** PACKAGE NAME SECTION **************** */
	     // Get the package name of an Object
	     Package pack = reflectClass.getPackage();
	     System.out.println("What is the name of the Package within the JAR?");
	     System.out.println(pack + "\n");

	     /* ****************** FIELD NAMES SECTION **************** */
	     // Get the package name of an Object
	     Field[] fields = reflectClass.getFields();
	     System.out.println("What is the name of the Fields within the JAR?");
	     System.out.println(fields + "\n");

	     /* ****************** SUPERCLASS SECTION **************** */
	     /* Get the super class for TextScorer
	     This will print out java.lang.object
	     Java.lang.object is the default Superclass for all classes */
	     Class Super = reflectClass.getSuperclass();
	     System.out.println("What is the Superclass name? (Defaulting to Java.lang.Object if none specific)");
	     System.out.println(Super.getName() + "\n");

	     /* ****************** MODIFIERS SECTION **************** */
	     //Is there a public class within TextScorer?
	     int publicClass = reflectClass.getModifiers();
	     System.out.println("There is a public class within the class TextScorer");
	     System.out.println(Modifier.isPublic(publicClass) + "\n");

	     //Is there a Private class within TextScorer?
	     int privateClass = reflectClass.getModifiers();
	     System.out.println("There is a private class within the class TextScorer");
	     System.out.println(Modifier.isPrivate(privateClass) + "\n");

	   //Is there an Abstract class within TextScorer?
	     int AbstractClass = reflectClass.getModifiers();
	     System.out.println("There is an Abstract class within the class TextScorer");
	     System.out.println(Modifier.isAbstract(AbstractClass) + "\n");

	     //Is there a Final class within TextScorer?
	     int finalClass = reflectClass.getModifiers();
	     System.out.println("There is a Final class within the class TextScorer");
	     System.out.println(Modifier.isFinal(finalClass) + "\n");

	   //Is there a Static class within TextScorer?
	     int staticClass = reflectClass.getModifiers();
	     System.out.println("There is a Static class within the class TextScorer");
	     System.out.println(Modifier.isStatic(staticClass) + "\n");

	   //Is there a Protected class within TextScorer?
	     int protectedClass = reflectClass.getModifiers();
	     System.out.println("There is a Protected class within the class TextScorer");
	     System.out.println(Modifier.isProtected(protectedClass) + "\n");

	     //Is there an Interface within TextScorer?
	     int interfaceClass = reflectClass.getModifiers();
	     System.out.println("There is an Interface within the class TextScorer");
	     System.out.println(Modifier.isInterface(interfaceClass) + "\n");


	     /* ****************** METHODS/RETURN TYPES/PARAMETERS SECTION **************** */
	  // Get the objects methods, return type and parameter type & using an array in case of multiples
	     Method[] Methods = reflectClass.getMethods();

	     /*Using a forEach loop so I can check 'myMethod' on the first iteration of the loop
	     and then I'm going back to check the 'methods' array on the second iteration of the loop */
	     for(Method myMethod : Methods){

	         // Get the method name within TextScorer
	         System.out.println("What is the name of the methods within TextScorer? " + myMethod.getName());

	         // Check if the method within TextScorer is a getter or setter
	         if(myMethod.getName().startsWith("get"))
	         {
	             System.out.println("There is a Getter Method within TextScorer");
	         }
	         else if(myMethod.getName().startsWith("set"))
	         {
	             System.out.println("There is a Setter Method within TextScorer");
	         }

	         // Get the methods within TextScorer's return type
	         System.out.println("The Return Type within TextScorer: " + myMethod.getReturnType());

	         Class[] parameterType = myMethod.getParameterTypes();

	         // List parameters for a method within TextScorer
	         System.out.println("The Parameters within TextScorer:");

	         for(Class parameter : parameterType)
	         {
	             System.out.println(parameter.getName());
	         }
	         System.out.println();
	     }

	     /* ****************** CONSTRUCTORS SECTION **************** */
	     // How to access class constructors
	     Constructor constructor = null;
	     Object constructor2 = null;

         // To return an array of constructors within TextScorer
	     System.out.println("The Constructors within TextScorer:");
         Constructor[] constructors = reflectClass.getConstructors();
}
	public static void ReflectionReferenceTextScorer() throws FileNotFoundException, IOException, ClassNotFoundException
	{
			/* ****************** READING IN JAR SECTION **************** */
		     // Instantiating the class to reflect, in this case its TextScorer
			 System.out.println("What are the classes within the JAR?");
			JarInputStream in = new JarInputStream(new FileInputStream(new File("C:/Users/owner/Desktop/Java Reflection API Project/src/ie/gmit/sw/railfence.jar")));
			JarEntry next = in.getNextJarEntry();
			while (next != null)
			{
			 if (next.getName().endsWith(".class"))
			 {
			 String name = next.getName().replaceAll("/", "\\.");
			 name = name.replaceAll(".class", "");
			 if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
			 System.out.println(name);
			 }
			 next = in.getNextJarEntry();
			}
			System.out.println();

			 /* ****************** INSTANTIATION SECTION **************** */
		     // Instantiating the class to reflect, in this case its TextScorer
			Class reflectClass = Class.forName("ie.gmit.sw.TextScorer");

		     /* ****************** CLASS NAME SECTION **************** */
		     // Get the class name of an Object
		     String className = reflectClass.getName();
		     System.out.println("What is the name of the class I'm testing here?");
		     System.out.println(className + "\n");

		     /* ****************** PACKAGE NAME SECTION **************** */
		     // Get the package name of an Object
		     Package pack = reflectClass.getPackage();
		     System.out.println("What is the name of the Package within the JAR?");
		     System.out.println(pack + "\n");

		     /* ****************** FIELD NAMES SECTION **************** */
		     // Get the package name of an Object
		     Field[] fields = reflectClass.getFields();
		     System.out.println("What is the name of the Fields within the JAR?");
		     System.out.println(fields + "\n");

		     /* ****************** SUPERCLASS SECTION **************** */
		     /* Get the super class for TextScorer
		     This will print out java.lang.object
		     Java.lang.object is the default Superclass for all classes */
		     Class Super = reflectClass.getSuperclass();
		     System.out.println("What is the Superclass name? (Defaulting to Java.lang.Object if none specific)");
		     System.out.println(Super.getName() + "\n");

		     /* ****************** MODIFIERS SECTION **************** */
		     //Is there a public class within TextScorer?
		     int publicClass = reflectClass.getModifiers();
		     System.out.println("There is a public class within the class TextScorer");
		     System.out.println(Modifier.isPublic(publicClass) + "\n");

		     //Is there a Private class within TextScorer?
		     int privateClass = reflectClass.getModifiers();
		     System.out.println("There is a private class within the class TextScorer");
		     System.out.println(Modifier.isPrivate(privateClass) + "\n");

		   //Is there an Abstract class within TextScorer?
		     int AbstractClass = reflectClass.getModifiers();
		     System.out.println("There is an Abstract class within the class TextScorer");
		     System.out.println(Modifier.isAbstract(AbstractClass) + "\n");

		     //Is there a Final class within TextScorer?
		     int finalClass = reflectClass.getModifiers();
		     System.out.println("There is a Final class within the class TextScorer");
		     System.out.println(Modifier.isFinal(finalClass) + "\n");

		   //Is there a Static class within TextScorer?
		     int staticClass = reflectClass.getModifiers();
		     System.out.println("There is a Static class within the class TextScorer");
		     System.out.println(Modifier.isStatic(staticClass) + "\n");

		   //Is there a Protected class within TextScorer?
		     int protectedClass = reflectClass.getModifiers();
		     System.out.println("There is a Protected class within the class TextScorer");
		     System.out.println(Modifier.isProtected(protectedClass) + "\n");

		     //Is there an Interface within TextScorer?
		     int interfaceClass = reflectClass.getModifiers();
		     System.out.println("There is an Interface within the class TextScorer");
		     System.out.println(Modifier.isInterface(interfaceClass) + "\n");


		     /* ****************** METHODS/RETURN TYPES/PARAMETERS SECTION **************** */
		  // Get the objects methods, return type and parameter type & using an array in case of multiples
		     Method[] Methods = reflectClass.getMethods();

		     /*Using a forEach loop so I can check 'myMethod' on the first iteration of the loop
		     and then I'm going back to check the 'methods' array on the second iteration of the loop */
		     for(Method myMethod : Methods){

		         // Get the method name within TextScorer
		         System.out.println("What is the name of the methods within TextScorer? " + myMethod.getName());

		         // Check if the method within TextScorer is a getter or setter
		         if(myMethod.getName().startsWith("get"))
		         {
		             System.out.println("There is a Getter Method within TextScorer");
		         }
		         else if(myMethod.getName().startsWith("set"))
		         {
		             System.out.println("There is a Setter Method within TextScorer");
		         }

		         // Get the methods within TextScorer's return type
		         System.out.println("The Return Type within TextScorer: " + myMethod.getReturnType());

		         Class[] parameterType = myMethod.getParameterTypes();

		         // List parameters for a method within TextScorer
		         System.out.println("The Parameters within TextScorer:");

		         for(Class parameter : parameterType)
		         {
		             System.out.println(parameter.getName());
		         }
		         System.out.println();
		     }

		     /* ****************** CONSTRUCTORS SECTION **************** */
		     // How to access class constructors
		     Constructor constructor = null;
		     Object constructor2 = null;

	         // To return an array of constructors within TextScorer
		     System.out.println("The Constructors within TextScorer:");
	         Constructor[] constructors = reflectClass.getConstructors();
	}
}
