/*
 * Created on Jul 20, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.bigtester.problomatic2.examples;
import org.bigtester.problomatic2.Problomatic;

/**
 * This class is a simple example of a plain ol' Java class that has some
 * inline exception handling. After running this class through the problomatic
 * compiler, it can be instrumented to expand the error handling capabilities
 * without any modification of the original class.
 * @author danstieglitz
 */
public class Instrumentation {

	public void doTest() {
		try {
			System.out.println("Hello, world!");
			Thread.sleep(1);
			Problomatic.addProblemHandlerForProblem("org.bigtester.problomatic2.problems.RawProblem",
                    "org.bigtester.problomatic2.handlers.SystemPrintlnHandler");
            Problomatic.addProblemHandlerForProblem("org.bigtester.problomatic2.problems.RawProblem",
                    "org.bigtester.problomatic2.handlers.EmailNotificationHandler");      
			throw new RuntimeException("Test exception");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		//new Instrumentation().doTest();
		Instrumentation tester = new Instrumentation();
        try {
            Problomatic.addProblemHandlerForProblem("org.bigtester.problomatic2.problems.RawProblem",
                    "org.bigtester.problomatic2.handlers.SystemPrintlnHandler");
            Problomatic.addProblemHandlerForProblem("org.bigtester.problomatic2.problems.RawProblem",
                    "org.bigtester.problomatic2.handlers.EmailNotificationHandler");            
            throw new Exception("This is a test exception");
        } catch (Exception e) {
            Problomatic.handleThrowable(tester, e);
        }
	}
	
}
