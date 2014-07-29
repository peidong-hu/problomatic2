package org.bigtester.problomatic2.renderers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bigtester.problomatic2.Problem;
import org.bigtester.problomatic2.ProblemRenderer;

public class DefaultRenderer implements ProblemRenderer {

	public Object renderProblem(Problem aProblem) {
		StringWriter writer = new StringWriter();
		writer.write("Problem "+aProblem.getClass().getName()+" occured on "+new Date()+"\n");
		PrintWriter out = new PrintWriter(writer);
		List exceptions = aProblem.getUnderlyingExceptions();
		Iterator exceptionIterator = exceptions.iterator();
		while (exceptionIterator.hasNext()) {
			Throwable throwable = (Throwable) exceptionIterator.next();
			throwable.printStackTrace(out);
		}
		out.flush();
		writer.flush();
		out.close();
		try {
			writer.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return writer.toString();
	}

}
