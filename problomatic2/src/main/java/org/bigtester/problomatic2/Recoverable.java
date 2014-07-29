/*
 * Created on Jun 25, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.bigtester.problomatic2;

/**
 * An interface for classes that can recover from problems that occur
 * during execution. Classes that implement Recoverable 
 * @author danstieglitz
 */
public interface Recoverable {
	
	public int getMaximumRecoveryAttempts();
	
	public int getRecoveryAttemptsCount();
	
	public void attemptedRecovery();
	
	public boolean canRecover();

}
