package kr.or.dgit.sw_project.application.supplycompany;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import erp_myframework.TextFiledPanel;
import kr.or.dgit.sw_project.dto.Client;
import kr.or.dgit.sw_project.dto.SupplyCompany;
import kr.or.dgit.sw_project.service.ClientService;
import kr.or.dgit.sw_project.service.SupplyCompService;

public class ContentSupplyCompany extends JPanel {
	private JTextField textField;
	private TextFiledPanel tfpSupplyCompanyName;
	private TextFiledPanel tfpSupplyCompanyCode;
	private TextFiledPanel tfpSupplyCompanyAd;
	private TextFiledPanel tfpSupplyCompanyTel;
	private JButton button;
	private TextFiledPanel tfadr;
	public ContentSupplyCompany() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {300, 50, 50};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		tfpSupplyCompanyCode = new TextFiledPanel();
		tfpSupplyCompanyCode.setTitle("회사번호");
		tfpSupplyCompanyCode.gettF().setEditable(false);
		GridBagConstraints gbc_tfpSupplyCompanyCode = new GridBagConstraints(); 
		gbc_tfpSupplyCompanyCode.fill = GridBagConstraints.HORIZONTAL; 
		gbc_tfpSupplyCompanyCode.insets = new Insets(0, 0, 5, 5);
		gbc_tfpSupplyCompanyCode.gridx = 0;
		gbc_tfpSupplyCompanyCode.gridy = 1;
		add(tfpSupplyCompanyCode, gbc_tfpSupplyCompanyCode);
		
		tfpSupplyCompanyName = new TextFiledPanel();
		tfpSupplyCompanyName.setTitle("회사명");
		GridBagConstraints gbc_tfpSupplyCompanyName = new GridBagConstraints();
		gbc_tfpSupplyCompanyName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpSupplyCompanyName.insets = new Insets(0, 0, 5, 5);
		gbc_tfpSupplyCompanyName.gridx = 0;
		gbc_tfpSupplyCompanyName.gridy = 2;
		add(tfpSupplyCompanyName, gbc_tfpSupplyCompanyName);
		
		tfpSupplyCompanyTel = new TextFiledPanel();
		tfpSupplyCompanyTel.setTitle("전화번호");
		GridBagConstraints gbc_tfpSupplyCompanyTel = new GridBagConstraints();
		gbc_tfpSupplyCompanyTel.insets = new Insets(0, 0, 5, 5);
		gbc_tfpSupplyCompanyTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpSupplyCompanyTel.gridx = 0;
		gbc_tfpSupplyCompanyTel.gridy = 3;
		add(tfpSupplyCompanyTel, gbc_tfpSupplyCompanyTel);
		
		tfpSupplyCompanyAd = new TextFiledPanel();
		tfpSupplyCompanyAd.setTitle("주소");
		GridBagConstraints gbc_tfpSupplyCompanyAd = new GridBagConstraints();
		gbc_tfpSupplyCompanyAd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpSupplyCompanyAd.insets = new Insets(0, 0, 5, 5);
		gbc_tfpSupplyCompanyAd.gridx = 0;
		gbc_tfpSupplyCompanyAd.gridy = 4;
		add(tfpSupplyCompanyAd, gbc_tfpSupplyCompanyAd);
		
		button = new JButton("우편번호검색");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 4;
		add(button, gbc_button);
		
		tfadr= new TextFiledPanel();
		tfadr.setTitle("상세 주소");
		GridBagConstraints gbc_tfadr = new GridBagConstraints();
		gbc_tfadr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfadr.insets = new Insets(0, 0, 5, 5);
		gbc_tfadr.gridx = 0;
		gbc_tfadr.gridy = 5;
		add(tfadr, gbc_tfadr);
		
		initSetting();
		
		
	}
	
	public void initSetting(){ //코드 자동세팅 다른필드 초기화
		List<SupplyCompany> list =SupplyCompService.getInstance().selectSupplyCompByAll();
		tfpSupplyCompanyCode.setTfValue(String.format("SC%03d", list.size()+1));
		tfpSupplyCompanyName.setTfValue("");
		tfpSupplyCompanyAd.setTfValue("");
		tfpSupplyCompanyTel.setTfValue("");
		tfpSupplyCompanyName.requestFocus();
	}
	public SupplyCompany getObject(){ //text필드 값받아옴 address수정필요
		String compCode = tfpSupplyCompanyCode.getTfValue();
		String compName = tfpSupplyCompanyName.getTfValue();
		String address = tfpSupplyCompanyAd.getTfValue();
		String compTel = tfpSupplyCompanyTel.getTfValue();
		return new SupplyCompany(compCode, compName, address, compTel);
	}
	
	public void setObject(SupplyCompany supplyCompany){ //text필드에 값세팅
		tfpSupplyCompanyCode.setTfValue(supplyCompany.getCompCode());
		tfpSupplyCompanyName.setTfValue(supplyCompany.getCompName());
		tfpSupplyCompanyAd.setTfValue(supplyCompany.getAddress());
		tfpSupplyCompanyTel.setTfValue(supplyCompany.getCompTel());
	}
	
	public boolean isEmptyCheck(){ // 빈공간체크
		for(Component c: getComponents()){
			if(c instanceof TextFiledPanel){
				TextFiledPanel tfp= (TextFiledPanel) c;
				if(tfp.isEmpty()){
					return true;
				}
			}
		}return false;
		
	}
}
