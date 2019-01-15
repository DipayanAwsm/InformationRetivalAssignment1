=========================================================
Author:Dipayan Das
Assignment:1
Roll:CS1726
Date:5-1-2019
MTECH CS
=========================================================
This is IR Assignment_1 Implementation


=========================================================
	SRS

Its coded in Java8 plat form
so any java version in or above 8 it will work	
=========================================================
How to compile code

	just put the commands in Terminal

	go inside the file directory for each zip files
	$javac *java


How to run the code


	#for method 1 run
		$ java DipayanMainInvertedIndexMethod1 folderLocation

		its output will be generated in method1 folder 


	#for method 2 run
	$ java DipayanMainInvertedIndexMethod2 folderLocation
			Its tempfiles will be generated in method2Temp
			Its output will be generated in method2 folder
*special Note for run 

 



please empty or delete the folders method2 , method2Temp before running second method.
 for the second method temp files will be generated in folder "method2Temp",
and output will be generated in folder method2
	
	$rm method1/* method2/* method2Temp/*
	$rmdir method1 method2 method2Temp


==============================================================================
==============================================================================
==============================================================================
==============================================================================
==============================================================================
		Output Time For The Methods 
 
 MethodName 			Size			TimeTaken(in second) 	comment
==============================================================================
 method1				8MB			2 sec	  					Ran nicely
 method1				500MB			90 sec  					Ran nicely
 method1				1000MB			141 sec 					Ran nicely
 method1				2000MB			281 sec 					Ran nicely
 method1				4000MB			1500 sec					after that got killedOutOfMemory
 method1				8000MB			-------						after that got killedOutOfMemory

 MethodName 			Size			TimeTaken(in second)		Comment
==============================================================================
 method2				8MB			2 sec	  					Ran nicely
 method2				500MB			85 sec 					        Ran nicely
 method2				1000MB			131 sec 					Ran nicely
 method2				2000MB			268 sec 					Ran nicely
 method2				4000MB			1336 sec 					Ran nicely
 method2				8000MB			----						after that got killedOutOfMemory




===============================================================================
**Some testing between files
1st sort method1 files as method1s output are not sorted
	$ sort -o method1/method1PostingList.txt method1/method1PostingList.txt
	$ diff method1/method1PostingList.txt method2/method2PostingList.txt
===============================================================================
Ack:
	It Done Totaly stand alone without any external source.Though Discussions were there with friens.

=======================================================
If face any problem please contact: 
picku.pickudas@gmail.com
7755990293
=======================================================
