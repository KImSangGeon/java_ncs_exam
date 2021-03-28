package java_ncs_exam.content;

import javax.swing.JPanel;

public abstract class AbstractContentPanel<T> extends JPanel {
	
	public abstract void setItme(T t);
	public abstract T getItem();
	public abstract void validCheck();
	public abstract void clearTf();
	
	

}
