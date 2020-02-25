Test Smell: Mystery Guest

The “Mystery Guest Smell” is test data from outside the test method. This can be some external resource like a file or a database record, or data from external website or data from a general fixture, which is centralized test setup for multiple tests. As such, this test data is disconnected from the rest of the test.


A bigger problem is when this external resource is shared by several tests. Now there is the risk of somebody else editing it without knowing how it’s used, and break our tests. Actually, it doesn’t have to be somebody else, just you working on another feature that uses the same resource. Here is an example of mystery guest smell: 
	@Test
	void testSetDepthCounter() {
		File file = new File("input.csv") ;
		Agents agents = new Agents(file) ;
		int depth  = 4 ;
		boolean expected = false ;
		if(agents.setDepthCounter(depth))
 {
			expected = true ;
		}
		assertEquals(expected, true);
	}

So, here using data from input.csv is a mystery guest test smell.

To find the Mystery guest test smell I have used ‘Java Parser’ to parse java code and then I have implemented some algorithm to generalize the smell. I have used a regex pattern to find the external file used by any method. The pattern is "\\w://[^\"]+". This can find any external resource successfully. 

User Manual

To run this project you have to add Java parser libraries. Download from this link:
•	javaparser-symbol-solver-core(version 3.14.159265359) [ https://jar-download.com/artifacts/com.github.javaparser ]
•	javaparser-core(version 3.5.7) [ https://jar-download.com/artifacts/com.github.javaparser/javaparser-core/3.5.7/source-code ]
 

(1)	Then, after executing the project this UI will appear-
 




(2)	Now we can choose file or directory by clicking ‘Choose File’ button. Then this window will appear- 
 














(3)	Now we will select file and click on ‘Analyze’ button to get test result. By selecting a project ‘egit-master’ and after clicking on ‘analyze’ button we get following result.
 


(4)	Output file is also written in the base directory of project we’ve selected.


Conclusion

It was interesting to find test smell within test method. Using Java parser made this project easier to complete. And this regex pattern can find the outsider resource with 100% of accuracy. 
