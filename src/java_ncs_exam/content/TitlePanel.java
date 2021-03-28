package java_ncs_exam.content;

import java_ncs_exam.dto.Title;
import java_ncs_exam.exception.InValidationException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class TitlePanel extends AbstractContentPanel<Title> {
	private JTextField tFNo;
	private JTextField tFName;
	public TitlePanel() {
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblNo = new JLabel("Á÷Ã¥¹øÈ£");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);
		
		tFNo = new JTextField();
		tFNo.setColumns(10);
		add(tFNo);
		
		JLabel lblName = new JLabel("Á÷Ã¥ÀÌ¸§");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		tFName = new JTextField();
		tFName.setColumns(10);
		add(tFName);
	}

	@Override
	public void setItme(Title t) {
		tFNo.setText(t.gettNo() + "");
		tFName.setText(t.gettName());		
	}

	@Override
	public Title getItem() {
		typeCheck();
		validCheck();
		int tNo = Integer.parseInt(tFNo.getText().trim());
		String tName = tFName.getText().trim();
		return new Title(tNo, tName);
	}

	@Override
	public void validCheck() {
		if(tFNo.getText().contentEquals("") || tFName.getText().contentEquals("")) {
			throw new InValidationException();
		}
		
	}

	@Override
	public void clearTf() {
		tFNo.setText("");
		tFName.setText("");		
		
	}

		public void typeCheck() {
		if(!(Pattern.matches("^[0-9]*$", tFNo.getText())&&
				Pattern.matches("^[°¡-ÆR]*$", tFName.getText()))) {
			throw new EmptyTfExeption();
		}
	}
}
