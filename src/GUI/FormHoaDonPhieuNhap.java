package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import DTO.PhieuNhapDTO;
import BLL.PhieuNhapBLL;
import DTO.CTPhieuNhapDTO;
import BLL.CTPhieuNhapBLL;

public class FormHoaDonPhieuNhap {
	
	protected JFrame Frame;
	private JTable tablePhieuNhap,tableCTPN;
	private JDateChooser dateChooserFrom,dateChooserTo;
	PhieuNhapBLL PNBLL = new PhieuNhapBLL();
	CTPhieuNhapBLL CTPNBLL = new CTPhieuNhapBLL();
	
	public FormHoaDonPhieuNhap() {
		initComponents();
		LoadDSPhieuNhap();
	}
	
	public void initComponents() {
		Frame = new JFrame();
		Frame.setSize(800,800);
		Frame.setLocationRelativeTo(null);
		Frame.setResizable(false);
		Frame.setUndecorated(true);
		Frame.getContentPane().setBackground(new Color(72, 209, 204));
		Frame.getContentPane().setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Phiếu Nhập Sản Phẩm");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Arial", Font.PLAIN, 26));
		lblTieuDe.setBounds(226, 11, 318, 50);
		Frame.getContentPane().add(lblTieuDe);
		
		JLabel lblTieuDeHD = new JLabel("Bảng Phiếu Nhập");
		lblTieuDeHD.setFont(new Font("Arial", Font.BOLD, 16));
		lblTieuDeHD.setBounds(530, 55, 113, 25);
		Frame.getContentPane().add(lblTieuDeHD);
		
		tablePhieuNhap = new JTable();
		tablePhieuNhap.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoadDSCTPN();
			}
		});
		tablePhieuNhap.setFont(new Font("Arial", Font.PLAIN, 14));
		tablePhieuNhap.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablePhieuNhap.setBounds(10, 339, 988, 450);
		JScrollPane scrollPane = new JScrollPane(tablePhieuNhap);
		scrollPane.setBounds(387, 83, 403, 322);
		Frame.getContentPane().add(scrollPane);
		
		JLabel lblTieuDeCTHD = new JLabel("Bảng Chi Tiết Phiếu Nhập");
		lblTieuDeCTHD.setFont(new Font("Arial", Font.BOLD, 16));
		lblTieuDeCTHD.setBounds(300, 405, 177, 25);
		Frame.getContentPane().add(lblTieuDeCTHD);
		
		JLabel lblTuNgay = new JLabel("Từ Ngày");
		lblTuNgay.setFont(new Font("Arial", Font.BOLD, 14));
		lblTuNgay.setBounds(53, 148, 94, 37);
		Frame.getContentPane().add(lblTuNgay);
		
		JLabel lblnNgy = new JLabel("Đến Ngày");
		lblnNgy.setFont(new Font("Arial", Font.BOLD, 14));
		lblnNgy.setBounds(53, 191, 94, 37);
		Frame.getContentPane().add(lblnNgy);
		
		tableCTPN = new JTable();
		tableCTPN.setFont(new Font("Arial", Font.PLAIN, 14));
		tableCTPN.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableCTPN.setBounds(10, 403, 295, -314);
		JScrollPane scrollPane1 = new JScrollPane(tableCTPN);
		scrollPane1.setBounds(10, 432, 780, 357);
		Frame.getContentPane().add(scrollPane1);
		
		dateChooserFrom = new JDateChooser();
		dateChooserFrom.setBounds(147, 148, 178, 37);
		Frame.getContentPane().add(dateChooserFrom);
		
		dateChooserTo = new JDateChooser();
		dateChooserTo.setBounds(147, 191, 178, 37);
		Frame.getContentPane().add(dateChooserTo);
		
		JButton btnThongKe = new JButton("Thống Kê");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadDSPhieuNhapTheoNgay();
			}
		});
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 14));
		btnThongKe.setBounds(53, 239, 272, 40);
		btnThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Frame.getContentPane().add(btnThongKe);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadDSPhieuNhap();
			}
		});
		btnReset.setFont(new Font("Arial", Font.BOLD, 14));
		btnReset.setBounds(53, 290, 272, 40);
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Frame.getContentPane().add(btnReset);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.dispose();
			}
		});
		btnThoat.setFont(new Font("Arial", Font.BOLD, 14));
		btnThoat.setBounds(53, 341, 272, 40);
		btnThoat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Frame.getContentPane().add(btnThoat);
	}
	
    /*
    ============================================================
                            EVENTS           
    ============================================================
     */
	private void LoadDSPhieuNhap() {
		DefaultTableModel dtm = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
		    return false;
		}};
		tablePhieuNhap.setModel(dtm);
		dtm.addColumn("Mã HPN");
		dtm.addColumn("Mã NCC");
		dtm.addColumn("Mã NV");
		dtm.addColumn("Ngày Lập PN");
		dtm.addColumn("Tổng Tiền");
		tablePhieuNhap.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablePhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(60);
		tablePhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(60);
		tablePhieuNhap.getColumnModel().getColumn(2).setPreferredWidth(60);
		tablePhieuNhap.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablePhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(100);
		Vector<PhieuNhapDTO> arr = new Vector<PhieuNhapDTO>();
		arr = PNBLL.LayDSPhieuNhap();
		for(int i = 0;i<arr.size();i++){
			PhieuNhapDTO PN = arr.get(i);
			int id = PN.getPhieuNhap_ID();
			int idNCC = PN.getPhieuNhap_IDNCC();
			int idNV = PN.getPhieuNhap_IDNV();
			Date date = PN.getPhieuNhap_Date();
			int total = PN.getPhieuNhap_Total();
			Object[] row = {id,idNCC,idNV,date,total};
			dtm.addRow(row);
		}
	}
	private void LoadDSPhieuNhapTheoNgay() {
		try {
		Date dateFrom = new java.sql.Date(dateChooserFrom.getDate().getTime());
		Date dateTo = new java.sql.Date(dateChooserTo.getDate().getTime());
		if(dateFrom.after(dateTo)) {
			JOptionPane.showMessageDialog(null,"Vui lòng chọn đúng từ ngày nào đến ngày nào");
		} else {
			DefaultTableModel dtm = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
				    return false;
				}};
				tablePhieuNhap.setModel(dtm);
				dtm.addColumn("Mã PN");
				dtm.addColumn("Mã NCC");
				dtm.addColumn("Mã NV");
				dtm.addColumn("Ngày Lập HĐ");
				dtm.addColumn("Tổng Tiền");
				tablePhieuNhap.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tablePhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(60);
				tablePhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(60);
				tablePhieuNhap.getColumnModel().getColumn(2).setPreferredWidth(60);
				tablePhieuNhap.getColumnModel().getColumn(3).setPreferredWidth(100);
				tablePhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(100);
				Vector<PhieuNhapDTO> arr = new Vector<PhieuNhapDTO>();
				arr = PNBLL.LayDSPhieuNhapTheoNgay(dateFrom,dateTo);
				for(int i = 0;i<arr.size();i++){
					PhieuNhapDTO PN = arr.get(i);
					int id = PN.getPhieuNhap_ID();
					int idNCC = PN.getPhieuNhap_IDNCC();
					int idNV = PN.getPhieuNhap_IDNV();
					Date date = PN.getPhieuNhap_Date();
					int total = PN.getPhieuNhap_Total();
					Object[] row = {id,idNCC,idNV,date,total};
					dtm.addRow(row);
				} }
		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		}
	}
	public void LoadDSCTPN(){
		DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }};
	    tableCTPN.setModel(dtm);
		dtm.addColumn("Mã PN");
		dtm.addColumn("Mã SP");
		dtm.addColumn("Đơn Giá");
		dtm.addColumn("Số Lượng");
		dtm.addColumn("Thành Tiền");
		tableCTPN.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableCTPN.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableCTPN.getColumnModel().getColumn(1).setPreferredWidth(60);
		tableCTPN.getColumnModel().getColumn(2).setPreferredWidth(280);
		tableCTPN.getColumnModel().getColumn(3).setPreferredWidth(60);
		tableCTPN.getColumnModel().getColumn(4).setPreferredWidth(300);
		int rowSelect = tablePhieuNhap.getSelectedRow();
		int MAPN = (Integer.parseInt(tablePhieuNhap.getModel().getValueAt(rowSelect, 0).toString()));
		Vector<CTPhieuNhapDTO> arr = new Vector<CTPhieuNhapDTO>();
		arr = CTPNBLL.LayCTPNTheoMaPN(MAPN);
		for(int i = 0;i<arr.size();i++){
			CTPhieuNhapDTO CTPN = arr.get(i);
			int id = CTPN.getCTPhieuNhap_ID();
			String idsp = CTPN.getCTPhieuNhap_IDSP();
			int price = CTPN.getCTPhieuNhap_Price();
			int amount = CTPN.getCTPhieuNhap_Amount();
			int total = CTPN.getCTPhieuNhap_Total();
			Object[] row = {id,idsp,price,amount,total};
			dtm.addRow(row);
		}
	}
}
