package java_ncs_exam.content;

@SuppressWarnings("serial")
public class EmptyTfExeption extends RuntimeException {

	public EmptyTfExeption() {
		super("범위 초과");
	}


}
