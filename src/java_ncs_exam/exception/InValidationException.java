package java_ncs_exam.exception;

public class InValidationException extends RuntimeException {

	public InValidationException() {
		super("공란 존재");
	}

	public InValidationException(String message) {
		super(message);
	}

	public InValidationException(Throwable cause) {
		super("해당 직책을 선택하세요", cause);
	}

}
