package cl.previred.Desafio_Uno.exception;

/**
 * @author JI Ramirez
 */
public class PeriodException extends Exception {

    /**
	 *
	 */
	private static final long serialVersionUID = 1872720191040040931L;

	public PeriodException() {
    }

	private String messageCode;

	public PeriodException(String message){
		super(message);
	}
	public PeriodException(String message, Throwable throwable){
		super(message, throwable);
	}
	public PeriodException(String messageCode, String message, Throwable throwable){
		super(message, throwable);
		this.setMessageCode(messageCode);
	}
	public PeriodException(String messageCode, String message){
		super(message);
		this.setMessageCode(messageCode);
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
}
