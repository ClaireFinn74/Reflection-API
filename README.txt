README.

LINK TO GITHUB UPLOAD: https://github.com/ClaireFinn74/Reflection-API

HOW TO SETUP MY PROJECT:
1. First, you should ensure you go to "help --> Install new Software" within Eclipse and be sure to add these sites:
-- SourceForge - http://metrics.sourceforge.net/update
	Ensure you go to properties --> Metrics --> enable Metrics after adding this site
-- JDepend - http://andrei.gmxhome.de/eclipse/
	This allows you to calculate Afferent and Efferent couplings within a Test Case in Eclipse.
	Ensure you have JDepend downloaded first from the Reference link at the bottom of this README and follow the setting up procedure there.
2. Go to Project --> Properties --> Add new Library --> JUnit
	Choose JUnit4 as I have a TestCase within my code that will only work with this Version

HOW TO RUN MY CLASSES:
1. Go to the 'Runner' class and run it
2. You can choose any jar by pressing the "Browse" button
3. Then press the "JAR Info" button to see information about that JAR.
4. You can then press the "Show Dialog" button to see a table with Metric information

REASONS FOR DESIGN OF PROJECT AND OTHER DETAILS OF NOTE:
I have 26 classes within my project.
5 classes (AppSummary, AppWindow, CustomControl, Runner and TypeSummaryTableModel) all given to me by my lecturer.
9 railfence.JAR classes.
9 Reflection classes that reflect these railfence.jar classes
2 classes, Calculations and CalculationsImpl that deal with Metrics Calculations
1 Test case class called MetricsTest to use JDepend to check for Afferent/Efferent couplings within my railfence.jar

I set out my classes to deal with all 9 classes available within my railfence.jar so you might want to add all 9 classes into the classpath to avoid classpath errors.
I called my classes "Reflection....." replacing those fullstops with the name of every class within my railfence.jar.
Within these reflection classes I read/reflect lots of information from every class within my railfence.jar to show all of the great functionality you can implement using reflection.
I create a class called MetricsTest and work with JDepend to check for Afferent and Efferent couplings for railfence.jar alone just to play around with JDepend a bit.


NOTE: I have added functionality to deal with the fact that a user might not have a JAR to test just yet so I provide a default JAR, my railfence.jar from my Second Year project. Ensure you bring this JAR into eclipse when you bring in my classes. If you do not choose a JAR file by pressing the 'Browse' button, my code for reflecting the railfence.JAR classes will show up when you press the "Jar Info" button. You just simply enter a number into the console within the range 1-9 to see classes from railfence being reflected.

ANOTHER IMPORTANT NOTE:
While my Test case (MetricsTest) does not pass on running, it works with the rest of my code. I can get the test to pass if I make it's methods void, but then my code that actually tries to use Metrics test within Calculations will error out as it needs the methods to be an int instead of void.
This leaves me with two choices: 
1. Make the test pass by making it's methods void which in turn produces errors within the running of the code.
2. Make the test fail by making the methods within it an int to work with my Calculations class.

Ultimately I felt it was better to make the test Case fail and get proper working output of Afferent, Efferent couplings and cycles within my jar file than to make it pass, losing out on this nice functionality.

REFERENCES:
https://www.youtube.com/watch?v=agnblS47F18 reflection tutorial
http://clarkware.com/software/JDepend.html JDepend download and installation
http://stackoverflow.com/ General help regarding arising issues throughout the project
https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html //The Go-to website for Java
