package kr.or.dgit.sw_project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import kr.or.dgit.sw_project.application.client.ViewClient;
import kr.or.dgit.sw_project.application.delivery.ViewDelivery;
import kr.or.dgit.sw_project.application.sales.ViewSale;
import kr.or.dgit.sw_project.application.showlist.ViewList;
import kr.or.dgit.sw_project.application.software.ViewSoftware;
import kr.or.dgit.sw_project.application.supplycompany.ViewSupplyCompany;

public class MainTab extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSupplyComp;
	private JButton btnSoftWare;
	private JButton btnClient;
	private JMenuItem mnSale;
	private JMenuItem mnDel;
	private JPanel pButton;
	private JMenuItem mnClnt;
	private JButton btnChart;
	private JButton btnReport;
	private JMenuItem mnSup;

	public MainTab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("파일");
		menuBar.add(mnFile);
		
		JMenuItem mntmInit = new JMenuItem("초기화");
		mnFile.add(mntmInit);
		
		JMenuItem mntmBackup = new JMenuItem("백업");
		mnFile.add(mntmBackup);
		
		JMenuItem mntmRestore = new JMenuItem("복원");
		mnFile.add(mntmRestore);
		
		JMenuItem mntmExit = new JMenuItem("종료");
		mnFile.add(mntmExit);
		
		JMenu mnCustomMenu = new JMenu("Window");
		menuBar.add(mnCustomMenu);
		
		JMenu mnCustom = new JMenu("ShowButton");
		mnCustomMenu.add(mnCustom);
		
		mnSale = new JMenuItem("주문관리");
		mnSale.addActionListener(this);
		
		
		mnSup = new JMenuItem("공급회사관리");
		mnSup.addActionListener(this);
		mnCustom.add(mnSup);
		mnCustom.add(mnSale);
		
		mnDel = new JMenuItem("납품관리");
		mnCustom.add(mnDel);
		
		JMenuItem mnSw = new JMenuItem("소프트웨어 관리");
		mnCustom.add(mnSw);
		
		
		mnClnt = new JMenuItem("고객사관리");
		mnClnt.addActionListener(this);
		mnCustom.add(mnClnt);
		
		JMenu mnHelp = new JMenu("도움말");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("AboutProject");
		mnHelp.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.add("주문 관리",new ViewSale());
		tabbedPane.add("납품 관리",new ViewDelivery());
		tabbedPane.add("거래내역 확인",new ViewList());
		
		pButton = new JPanel();
		contentPane.add(pButton, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnSupplyComp = new JButton("공급사 관리");
		btnSupplyComp.addActionListener(this);
		pButton.add(btnSupplyComp);
		
		btnSoftWare = new JButton("S/W 관리");
		btnSoftWare.addActionListener(this);
		pButton.add(btnSoftWare);
		
		btnClient = new JButton("고객 관리");
		btnClient.addActionListener(this);
		pButton.add(btnClient);
		
		btnChart = new JButton("통계차트");
		
		btnReport = new JButton("보고서");
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mnSup) {
			actionPerformedMnSup(e);
		}
		if (e.getSource() == mnClnt) {
			actionPerformedMnClnt(e);
		}
		if (e.getSource() == mnSale) {
			actionPerformedMnSale(e);
		}
		if (e.getSource() == btnClient) {
			actionPerformedBtnClient(e);
		}
		if (e.getSource() == btnSoftWare) {
			actionPerformedBtnSoftWare(e);
		}
		if (e.getSource() == btnSupplyComp) {
			actionPerformedBtnSupplyComp(e);
		}
	}
	protected void actionPerformedBtnSupplyComp(ActionEvent e) {
		ViewSupplyCompany viewSupplyCompany = new ViewSupplyCompany(); 
	}
	protected void actionPerformedBtnSoftWare(ActionEvent e) {
		ViewSoftware viewSoftware = new ViewSoftware();
	}
	
	protected void actionPerformedBtnClient(ActionEvent e) {
		ViewClient viewclient = new ViewClient();
	
	}
	protected void actionPerformedMnSale(ActionEvent e) {
	
		
	}
	protected void actionPerformedMnClnt(ActionEvent e) {
		if(e.getActionCommand().equals("고객사관리")){
			mnClnt.setText("고객사관리"+" V ");
			pButton.add(btnClient);
			pButton.revalidate();
			pButton.repaint();
		}else{
			mnClnt.setText("고객사관리");
			pButton.remove(btnClient);
			pButton.revalidate();
			pButton.repaint();
			
		}
	}
	protected void actionPerformedMnSup(ActionEvent e) {
		if(e.getActionCommand().equals("공급회사관리")){
			mnSup.setText("공급회사관리"+" V ");
			pButton.add(btnSupplyComp);
			pButton.revalidate();
			pButton.repaint();
		}else{
			mnSup.setText("공급회사관리");
			pButton.remove(btnSupplyComp);
			pButton.revalidate();
			pButton.repaint();
	}
}
}
