package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import DTO.HoaDonBanDTO;
import BLL.HoaDonBanBLL;
import DTO.CTHDBanDTO;
import BLL.CTHDBanBLL;

public class FormHoaDonBan {
	
	protected JFrame Frame;
	private JTable tableHoaDon,tableCTHD;
	private JDateChooser dateChooserFrom,dateChooserTo;
	HoaDonBanBLL HDBBLL = new HoaDonBanBLL();
	CTHDBanBLL CTHDBBLL = new CTHDBanBLL();
	
	public FormHoaDonBan() {
		initComponents();
		LoadDSHoaDonBan();
	}
	
	public void initComponents() {
		Frame = new JFrame();
		Frame.setSize(800,800);
		Frame.setLocationRelativeTo(null);
		Frame.setResizable(false);
		Frame.setUndecorated(true);
		Frame.getContentPane().setBackground(new Color(72, 209, 204));
		Frame.getContentPane().setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Hóa Đơn Bán Sản Phẩm");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Arial", Font.PLAIN, 26));
		lblTieuDe.setBounds(226, 11, 318, 50);
		Frame.getContentPane().add(lblTieuDe);
		
		JLabel lblTieuDeHD = new JLabel("Bảng Hóa Đơn");
		lblTieuDeHD.setFont(new Font("Arial", Font.BOLD, 16));
		lblTieuDeHD.setBounds(530, 55, 113, 25);
		Frame.getContentPane().add(lblTieuDeHD);
		
		tableHoaDon = new JTable();
		tableHoaDon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoadDSCTHDB();
			}
		});
		tableHoaDon.setFont(new Font("Arial", Font.PLAIN, 14));
		tableHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableHoaDon.setBounds(10, 339, 988, 450);
		JScrollPane scrollPane = new JScrollPane(tableHoaDon);
		scrollPane.setBounds(387, 83, 403, 322);
		Frame.getContentPane().add(scrollPane);
		
		JLabel lblTieuDeCTHD = new JLabel("Bảng Chi Tiết Hóa Đơn");
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
		
		tableCTHD = new JTable();
		tableCTHD.setFont(new Font("Arial", Font.PLAIN, 14));
		tableCTHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableCTHD.setBounds(10, 403, 295, -314);
		JScrollPane scrollPane1 = new JScrollPane(tableCTHD);
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
				LoadDSHoaDonBanTheoNgay();
			}
		});
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 14));
		btnThongKe.setBounds(53, 239, 272, 40);
		btnThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Frame.getContentPane().add(btnThongKe);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadDSHoaDonBan();
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
	private void LoadDSHoaDonBan() {
		DefaultTableModel dtm = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
		    return false;
		}};
		tableHoaDon.setModel(dtm);
		dtm.addColumn("Mã HDB");
		dtm.addColumn("Mã KH");
		dtm.addColumn("Mã NV");
		dtm.addColumn("Ngày Lập HĐ");
		dtm.addColumn("Tổng Tiền");
		tableHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableHoaDon.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableHoaDon.getColumnModel().getColumn(1).setPreferredWidth(60);
		tableHoaDon.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableHoaDon.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableHoaDon.getColumnModel().getColumn(4).setPreferredWidth(100);
		Vector<HoaDonBanDTO> arr = new Vector<HoaDonBanDTO>();
		arr = HDBBLL.LayDSHoaDonBan();
		for(int i = 0;i<arr.size();i++){
			HoaDonBanDTO HDB = arr.get(i);
			int id = HDB.getHoaDonBan_ID();
			int idKH = HDB.getHoaDonBan_IDKH();
			int idNV = HDB.getHoaDonBan_IDNV();
			Date date = HDB.getHoaDonBan_DateHD();
			int total = HDB.getHoaDonBan_Total();
			Object[] row = {id,idKH,idNV,date,total};
			dtm.addRow(row);
		}
	}
	private void LoadDSHoaDonBanTheoNgay() {
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
				tableHoaDon.setModel(dtm);
				dtm.addColumn("Mã HDB");
				dtm.addColumn("Mã KH");
				dtm.addColumn("Mã NV");
				dtm.addColumn("Ngày Lập HĐ");
				dtm.addColumn("Tổng Tiền");
				tableHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tableHoaDon.getColumnModel().getColumn(0).setPreferredWidth(60);
				tableHoaDon.getColumnModel().getColumn(1).setPreferredWidth(60);
				tableHoaDon.getColumnModel().getColumn(2).setPreferredWidth(60);
				tableHoaDon.getColumnModel().getColumn(3).setPreferredWidth(100);
				tableHoaDon.getColumnModel().getColumn(4).setPreferredWidth(100);
				Vector<HoaDonBanDTO> arr = new Vector<HoaDonBanDTO>();
				arr = HDBBLL.LayDSHoaDonBanTheoNgay(dateFrom,dateTo);
				for(int i = 0;i<arr.size();i++){
					HoaDonBanDTO HDB = arr.get(i);
					int id = HDB.getHoaDonBan_ID();
					int idKH = HDB.getHoaDonBan_IDKH();
					int idNV = HDB.getHoaDonBan_IDNV();
					Date date = HDB.getHoaDonBan_DateHD();
					int total = HDB.getHoaDonBan_Total();
					Object[] row = {id,idKH,idNV,date,total};
					dtm.addRow(row);
				} }
		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		}
	}
	public void LoadDSCTHDB(){
		DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }};
	    tableCTHD.setModel(dtm);
		dtm.addColumn("Mã HDB");
		dtm.addColumn("Mã SP");
		dtm.addColumn("Số Lượng");
		dtm.addColumn("Đơn Giá");
		dtm.addColumn("Thành Tiền");
		tableCTHD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableCTHD.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableCTHD.getColumnModel().getColumn(1).setPreferredWidth(60);
		tableCTHD.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableCTHD.getColumnModel().getColumn(3).setPreferredWidth(280);
		tableCTHD.getColumnModel().getColumn(4).setPreferredWidth(300);
		int rowSelect = tableHoaDon.getSelectedRow();
		int MAHDB = (Integer.parseInt(tableHoaDon.getModel().getValueAt(rowSelect, 0).toString()));
		Vector<CTHDBanDTO> arr = new Vector<CTHDBanDTO>();
		arr = CTHDBBLL.LayCTHDTheoMAHDB(MAHDB);
		for(int i = 0;i<arr.size();i++){
			CTHDBanDTO CTHDB = arr.get(i);
			int id = CTHDB.getCTHDBan_ID();
			String idsp = CTHDB.getCTHDBan_IDSP();
			int amount = CTHDB.getCTHDBan_Amount();
			int price = CTHDB.getCTHDBan_Price();
			int total = CTHDB.getCTHDBan_TotalPrice();
			Object[] row = {id,idsp,amount,price,total};
			dtm.addRow(row);
		}
	}
}
