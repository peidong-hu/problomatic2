package org.bigtester.problomatic2.handlers;

import java.util.Properties;

import org.bigtester.problomatic2.InitException;
import org.bigtester.problomatic2.Problem;
import org.bigtester.problomatic2.ProblemHandler;
import org.bigtester.problomatic2.Problomatic;
import org.bigtester.problomatic2.config.XMLConfigurator;

public class SpecificHandler extends AbstractProblemHandler {

	private Properties handlers;

	public void init(Properties properties) throws InitException {
		handlers = properties;
	}

	public void handleProblem(Problem aProblem) {
		// TODO Use chained exceptions instead of list? Probably better...
		Throwable throwable = (Throwable) aProblem.getUnderlyingExceptions()
				.get(0);
		if (throwable != null) {
			String throwableName = throwable.getClass().getName();
			String handlerName = (String) handlers.get(throwableName);
			if (handlerName != null) {
				try {
					Class clazz = Class.forName(handlerName);
					ProblemHandler handler = (ProblemHandler) clazz
							.newInstance();
					Properties props = XMLConfigurator.getDefaultProperties(handler
							.getClass().getName());
					handler.init(props);
					if (Problomatic.isVerbose()) {
						System.out.println("SpecificHandler switching to "+handler.getClass().getName());
						System.out.println("SpecificHandler found properties "+props);
					}
					handler.handleProblem(aProblem);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InitException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
