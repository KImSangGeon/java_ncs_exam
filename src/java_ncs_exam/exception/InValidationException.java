package java_ncs_exam.exception;

public class InValidationException extends RuntimeException {

	public InValidationException() {
		super("���� ����");
	}

	public InValidationException(String message) {
		super(message);
	}

	public InValidationException(Throwable cause) {
		super("�ش� ��å�� �����ϼ���", cause);
	}

}
