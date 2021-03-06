package kr.or.dgit.sw_project.application.software;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import erp_myframework.ComboPanel;
import erp_myframework.RadioPanel;
import erp_myframework.TextFiledPanel;

@SuppressWarnings("serial")
public class ContentSoftware extends JPanel implements MouseListener {
	private JLabel lblImage;
	private TextFiledPanel tfpSWCode;
	private TextFiledPanel tfpSWName;
	private TextFiledPanel tfpSwPrice;
	private ComboPanel tfpCompName;
	private ComboPanel tfpGroupName;
	private RadioPanel tfpIsSale;

	public ContentSoftware() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 300, 300, 300, 50};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		tfpSWCode = new TextFiledPanel();
		tfpSWCode.setTitle("제품번호");
		GridBagConstraints gbc_tfpSWCode = new GridBagConstraints(); 
		gbc_tfpSWCode.fill = GridBagConstraints.HORIZONTAL; 
		gbc_tfpSWCode.insets = new Insets(0, 0, 5, 5);
		gbc_tfpSWCode.gridx = 1;
		gbc_tfpSWCode.gridy = 1;
		add(tfpSWCode, gbc_tfpSWCode);
		
		tfpSWName = new TextFiledPanel();
		tfpSWName.setTitle("제품명");
		GridBagConstraints gbc_tfpSWName = new GridBagConstraints();
		gbc_tfpSWName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpSWName.insets = new Insets(0, 0, 5, 5);
		gbc_tfpSWName.gridx = 1;
		gbc_tfpSWName.gridy = 2;
		add(tfpSWName, gbc_tfpSWName);
		
		tfpSwPrice = new TextFiledPanel();
		tfpSwPrice.setTitle("판매가격");
		GridBagConstraints gbc_tfpSwPrice = new GridBagConstraints();
		gbc_tfpSwPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpSwPrice.insets = new Insets(0, 0, 0, 5);
		gbc_tfpSwPrice.gridx = 1;
		gbc_tfpSwPrice.gridy = 3;
		add(tfpSwPrice, gbc_tfpSwPrice);
		
		tfpCompName = new ComboPanel();
		tfpCompName.setTitle("공급회사");
		GridBagConstraints gbc_tfpCompName = new GridBagConstraints();
		gbc_tfpCompName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpCompName.insets = new Insets(0, 0, 5, 5);
		gbc_tfpCompName.gridx = 2;
		gbc_tfpCompName.gridy = 1;
		add(tfpCompName, gbc_tfpCompName);
				
		tfpGroupName = new ComboPanel();
		tfpGroupName.setTitle("분류");
		GridBagConstraints gbc_tfpGroupName = new GridBagConstraints();
		gbc_tfpGroupName.insets = new Insets(0, 0, 5, 5);
		gbc_tfpGroupName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpGroupName.gridx = 2;
		gbc_tfpGroupName.gridy = 2;
		add(tfpGroupName, gbc_tfpGroupName);

		tfpIsSale = new RadioPanel();
		tfpIsSale.setTitle("판매여부");
		tfpIsSale.setRadioItems("판매","판매중지");
		GridBagConstraints gbc_tfpIsSale = new GridBagConstraints();
		gbc_tfpIsSale.insets = new Insets(0, 0, 0, 5);
		gbc_tfpIsSale.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpIsSale.gridx = 2;
		gbc_tfpIsSale.gridy = 3;
		add(tfpIsSale, gbc_tfpIsSale);
		
		lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(130, 80));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.addMouseListener(this);
		lblImage.setIcon(new ImageIcon("sw_project/src/main/resources/softwareimage/DGIT_Logo.png"));

		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.fill = GridBagConstraints.BOTH;
		gbc_lblImage.gridx = 3;
		gbc_lblImage.gridy = 1;
		gbc_lblImage.insets = new Insets(0, 70, 10, 0);
		gbc_lblImage.gridheight = 3;
		add(lblImage, gbc_lblImage);
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == lblImage) {
			mousePressedLblImage(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mousePressedLblImage(MouseEvent e) {
		JOptionPane.showMessageDialog(null, "파일추저지롱~");
	}
	
	
}
