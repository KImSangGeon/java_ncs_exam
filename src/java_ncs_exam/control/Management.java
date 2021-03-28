package java_ncs_exam.control;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java_ncs_exam.content.EmptyTfExeption;
import java_ncs_exam.content.TitlePanel;
import java_ncs_exam.dto.Title;
import java_ncs_exam.exception.NotSelectedException;
import java_ncs_exam.list.TitleTablePanel;
import java_ncs_exam.service.TitleService;

@SuppressWarnings("serial")
public class Management extends JFrame implements ActionListener   {

	private JPanel contentPane;
	private TitlePanel pContent;
	private JPanel pBtns;
	private TitleTablePanel pList;
	private TitleService service;
	private JButton btnAdd;
	private JButton btnCancel;
	private Title preItem;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Management() {
		service= new TitleService();
		initialize();
	}

	private void initialize() {
		setTitle("직책관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pContent = new TitlePanel();
		contentPane.add(pContent);
		
		pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		pList = new TitleTablePanel();
		pList.setService(service);
		pList.loadData();
		contentPane.add(pList);
		
		JPopupMenu popupMenu = createPopupMenu();
		pList.setPopupMenu(popupMenu);
	}


	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(PopupMenuListener);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(PopupMenuListener);
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	
	ActionListener PopupMenuListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			if(e.getActionCommand().contentEquals("삭제")) {	
				Title delTitle = pList.getItem();
				service.removeTitle(delTitle);
				pList.loadData();
				JOptionPane.showMessageDialog(null, delTitle + "이(가)"
						+ " 삭제되었습니다.");			
			}
			if(e.getActionCommand().contentEquals("수정")) {
				Title updateTitle = pList.getItem();				
				service.modifyTitle(updateTitle);
				pContent.setItme(updateTitle);
				btnAdd.setText("수정");
				preItem = pContent.getItem();
				System.out.println(preItem);
			}
			}catch(IndexOutOfBoundsException | NotSelectedException e1) {
				JOptionPane.showMessageDialog(null, "해당 직책을 선택하세요.", "선택 오류", JOptionPane.WARNING_MESSAGE);			

			}catch(Exception e3) {
				e3.printStackTrace();
			}			
		}
	};
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		try {
		if (e.getSource() == btnAdd) {
			if(e.getActionCommand().contentEquals("추가")) {
			actionPerformedBtnAdd(e);
			}else {
			actionPerformedBtnUpdate(e);
			}
		}
		}catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "공란 존재","오류", JOptionPane.ERROR_MESSAGE);
			pContent.clearTf();
		}catch(EmptyTfExeption e2) {
			JOptionPane.showMessageDialog(null, "형식이 맞지 않습니다.","오류", JOptionPane.ERROR_MESSAGE);		}
	}
	private void actionPerformedBtnUpdate(ActionEvent e) {		
			Title updateItem = pContent.getItem();	
			service.modifyTitle(updateItem);
			pList.loadData();		
			pContent.clearTf();
			btnAdd.setText("추가");
			JOptionPane.showMessageDialog(null, preItem.toString2() + "이(가) "+updateItem.toString2() + "로 변경되었습니다."); 
		}
		
		
	
	protected void actionPerformedBtnAdd(ActionEvent e) {
			Title title = pContent.getItem();			
			service.addTitle(title);
			pList.loadData();
			pContent.clearTf();
			JOptionPane.showMessageDialog(null, title.toString2() + "이(가) 추가되었습니다.");									
		}
		
		
		
	
	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clearTf();
		
		if(btnAdd.equals("수정")) {
			btnAdd.setText("추가");
		}
		
		
		
	}
}
