/**
 * 
 */
package pt.isep.dei.simov.android.sellit.exception;

/**
 * @author i090543
 *
 */
public class SELLITRootException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SELLITRootException() {
		super();
	}

	/**
	 * @param detailMessage
	 */
	public SELLITRootException(String detailMessage) {
		super(detailMessage);
	}

	/**
	 * @param throwable
	 */
	public SELLITRootException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * @param detailMessage
	 * @param throwable
	 */
	public SELLITRootException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

}
