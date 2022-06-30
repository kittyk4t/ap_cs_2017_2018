Signals in Noise Lab

# Introduction
# 
The goal of this lab is to apply your understanding of 2D arrays to
	implement a complex algorithm. In addition, you will implement a
	unit test for your program using the JUnit framework and create
	documentation for your program using JavaDoc.

One common application of computing is signal analysis. In real-world
	applications, the data that is processed is a combination of
	something of interest (the signal) and garbage that obscures the
	signal (noise). Computational techniques for signal analysis are
	prevalent in a wide variety of scientific and financial
	applications. This lab provides a simplified context in which to
	explore signal analysis. Conceptually, the techniques you will
	use in this lab are similar to those used in particle physics
	experiments.

You will write a Monster Early Warning program that finds a
	stationary monster based on the data from your noisy radar
	system. This is described in DataGenetics blog post, "[Detecting
	Signals in
	Noise](http://www.datagenetics.com/blog/may22014/index.html)."
	The final application will look similar to the following.

![image alt text](image_0.png)

The left side of the window represents a single scan of the noisy
	radar system. Light green pixels are potential monster locations
	(one may be the actual location of the monster and the others are
	false-positives). Dark green pixels are locations where there is
	no monster or a false-negative. The right side of the window is a
	graphical representation of the accumulator. The grayscale value
	corresponds to the number of scans in which that location was a
	potential monster location. The lighter the color, the more often
	a monster was potentially identified at that location. After a
	sufficient number of scans, the accumulator should clearly
	indicate the location of the monster.

# Requirements
# 
* The starter code in GitHub implements the graphics and the
	foundation of the Radar class.

    * Create the Location class that encapsulates a row-column pair.
    	The Location class must have a constructor that takes the row
    	and column and two accessor methods: getRow and getCol.

    * Complete the methods in the Radar class (look for "!!! add code
    	here !!!" comments)

    * Add code to prompt the user to optionally specify the location
    	of the monster in the main method of the RadarViewer class
    	(look for "!!! add code here !!!" comments).

* Implement a unit test for your program that tests multiple cases.
	You will invoke the setMonsterLocation method in the Radar class
	to explicitly set the monster’s location for the purpose of the
	unit test. Unlike other unit tests that we have written, don’t
	test each method of the Radar class individually. Instead, have a
	single method in the test class that tests the Radar class as a
	whole (create a Radar object, set the monster location, perform a
	bunch of scans, get the location of the monster, assert that the
	row and column match). Since the Radar class doesn’t support the
	equals method, you have to test the row and column individually
	with the assertEquals method.

* Document your code with standard JavaDoc comments.

# Extensions:
# 
* Add support for detecting multiple monsters.

* Add support to determine when the accumulator has a statistically
	significant result and no more scans are needed.

* Add support for a moving monster. This is significantly more
	complicated!

* Add more awesome.

# Submission:
# 
* Submit a link to your GitHub repository with this assignment.

https://docs.google.com/document/d/1GNOBmSKTAv5peuMHF6CCpKLp1T_GZNDBRCwW5PXOrS4/edit
