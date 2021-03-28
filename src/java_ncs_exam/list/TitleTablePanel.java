package java_ncs_exam.list;

import javax.swing.SwingConstants;

import java_ncs_exam.dto.Title;
import java_ncs_exam.exception.NotSelectedException;
import java_ncs_exam.service.TitleService;

@SuppressWarnings("serial")
public class TitleTablePanel extends AbstractCustomTablePanel<Title> {
	public TitleTablePanel() {
	}
	private TitleService service;
	
	@Override
	public Title getItem() {
		
		int row = table.getSelectedRow();		
		if (row == -1) {
			throw new NotSelectedException();
		}
		return (Title) table.getValueAt(row, 0);
	}

	@Override
	protected void initList() {
		list = service.showTitle();
		}
	
	public void setService(TitleService service) {
		this.service = service;
	}

	@Override
	public String[] getColumnNames() {
		return new String[]{"직책번호", "직책명"};
	}

	@Override
	protected void setAlignAndWidth() {
		
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		
		setTableCellWidth(100,250);
	}

	@Override
	protected Object[] toArray(Title title) {
		return new Object[] {title, title.gettName()};
	}

}
