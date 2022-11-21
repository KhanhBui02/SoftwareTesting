package GUI;

import DTO.NhaCungCapDTO;
import BLL.NhaCungCapBLL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class FormNhaCungCap {

	protected JFrame Frame;
	private NhaCungCapBLL NCCBLL= new NhaCungCapBLL();
	private JTextField txtfMaNhaCungCap,txtfTenNhaCungCap,txtfSDT,txtfDiaChi;
	private JTable table;
	
	public FormNhaCungCap() {
		initComponents();
		LoadDSNhaCungCap();
	}
	
	public void initComponents() {
		Frame = new JFrame();
		Frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfMaNhaCungCap.setText("");
				txtfTenNhaCungCap.setText("");
				txtfSDT.setText("");
				txtfDiaChi.setText("");
			}
		});
		Frame.setSize(800,600);
		Frame.setLocationRelativeTo(null);
		Frame.setResizable(false);
		Frame.setUndecorated(true);
		Frame.getContentPane().setBackground(new Color(247, 248, 252));
		Frame.getContentPane().setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Quản Lý Nhà Cung Cấp");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Arial", Font.PLAIN, 26));
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setBounds(241, 11, 356, 50);
		Frame.getContentPane().add(lblTieuDe);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				BindingNhaCungCap();
			}});
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(10, 339, 988, 450);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 339, 780, 250);
		Frame.getContentPane().add(scrollPane);
		
		JLabel lblMaNhaCungCap = new JLabel("Mã Nhà Cung Cấp");
		lblMaNhaCungCap.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaNhaCungCap.setBounds(241, 65, 148, 37);
		Frame.getContentPane().add(lblMaNhaCungCap);
		
		txtfMaNhaCungCap = new JTextField();
		txtfMaNhaCungCap.setEnabled(false);
		txtfMaNhaCungCap.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfMaNhaCungCap.setColumns(10);
		txtfMaNhaCungCap.setBounds(399, 73, 198, 29);
		Frame.getContentPane().add(txtfMaNhaCungCap);
		
		JLabel lblTenNhaCungCap = new JLabel("Tên Nhà Cung Cấp");
		lblTenNhaCungCap.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenNhaCungCap.setBounds(241, 113, 148, 37);
		Frame.getContentPane().add(lblTenNhaCungCap);

		txtfTenNhaCungCap = new JTextField();
		txtfTenNhaCungCap.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfTenNhaCungCap.setColumns(10);
		txtfTenNhaCungCap.setBounds(399, 121, 198, 29);
		Frame.getContentPane().add(txtfTenNhaCungCap);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại");
		lblSoDienThoai.setFont(new Font("Arial", Font.BOLD, 14));
		lblSoDienThoai.setBounds(241, 161, 148, 37);
		Frame.getContentPane().add(lblSoDienThoai);

		txtfSDT = new JTextField();
		txtfSDT.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfSDT.setColumns(10);
		txtfSDT.setBounds(399, 164, 198, 29);
		Frame.getContentPane().add(txtfSDT);

		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiaChi.setBounds(241, 209, 148, 37);
		Frame.getContentPane().add(lblDiaChi);
		
		txtfDiaChi = new JTextField();
		txtfDiaChi.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfDiaChi.setColumns(10);
		txtfDiaChi.setBounds(399, 211, 198, 29);
		Frame.getContentPane().add(txtfDiaChi);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNhaCungCap();
			}
		});
		btnThem.setFocusPainted(false);
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBorderPainted(false);
		btnThem.setBackground(new Color(102, 153, 102));
		btnThem.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem.setBounds(32, 305, 120, 35);
		ImageIcon iconThem = new ImageIcon(this.getClass().getResource("/add.png"));
		Image newimgThem = iconThem.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconThem = new ImageIcon(newimgThem);
		btnThem.setIcon(iconThem);
		Frame.getContentPane().add(btnThem);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteNhaCungCap();
			}
		});
		btnXoa.setFocusPainted(false);
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setBorderPainted(false);
		btnXoa.setBackground(new Color(204, 0, 0));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoa.setBounds(182, 305, 120, 35);
		ImageIcon iconXoa = new ImageIcon(this.getClass().getResource("/delete.png"));
		Image newimgXoa = iconXoa.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconXoa = new ImageIcon(newimgXoa);
		btnXoa.setIcon(iconXoa);
		Frame.getContentPane().add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editNhaCungCap();
			}
		});
		btnSua.setFocusPainted(false);
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSua.setBackground(new Color(51, 102, 153));
		btnSua.setBorderPainted(false);
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Arial", Font.BOLD, 14));
		btnSua.setBounds(332, 305, 120, 35);
		ImageIcon iconSua = new ImageIcon(this.getClass().getResource("/edit.png"));
		Image newimgSua = iconSua.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconSua = new ImageIcon(newimgSua);
		btnSua.setIcon(iconSua);
		Frame.getContentPane().add(btnSua);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadDSNhaCungCapTheoTen();
			}
		});
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTimKiem.setBackground(new Color(0, 191, 255));
		btnTimKiem.setBorderPainted(false);
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setFont(new Font("Arial", Font.BOLD, 14));
		btnTimKiem.setBounds(483, 305, 140, 35);
		ImageIcon iconTimKiem = new ImageIcon(this.getClass().getResource("/search.png"));
		Image newimgTimKiem = iconTimKiem.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconTimKiem = new ImageIcon(newimgTimKiem);
		btnTimKiem.setIcon(iconTimKiem);
		Frame.getContentPane().add(btnTimKiem);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadDSNhaCungCap();
			}
		});
		btnReset.setFocusPainted(false);
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReset.setBackground(Color.BLACK);
		btnReset.setBorderPainted(false);
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Arial", Font.BOLD, 14));
		btnReset.setBounds(650, 305, 120, 35);
		Frame.getContentPane().add(btnReset);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.dispose();
			}
		});
		btnThoat.setBackground(Color.RED);
		btnThoat.setBorderPainted(false);
		btnThoat.setFocusPainted(false);
		btnThoat.setFont(new Font("Arial", Font.BOLD, 14));
		btnThoat.setBounds(705, 11, 85, 21);
		Frame.getContentPane().add(btnThoat);
	}
	
    /*
    ============================================================
                            EVENTS           
    ============================================================
     */
	
	public void LoadDSNhaCungCap(){
		DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }};
		table.setModel(dtm);
		dtm.addColumn("Mã NCC");
		dtm.addColumn("Tên Nhà Cung Cấp");
		dtm.addColumn("Số Điện Thoại");
		dtm.addColumn("Địa Chỉ");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(375);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(435);
		Vector<NhaCungCapDTO> arr = new Vector<NhaCungCapDTO>();
		arr = NCCBLL.LayDSNhaCungCap();
		for(int i = 0;i<arr.size();i++){
			NhaCungCapDTO NCC = arr.get(i);
			int id = NCC.getNhaCungCap_ID();
			String name = NCC.getNhaCungCap_Name();
			String phonenum = NCC.getNhaCungCap_PhoneNumber();
			String address = NCC.getNhaCungCap_Address();
			Object[] row = {id,name,phonenum,address};
			dtm.addRow(row);
		}
	}
	public void LoadDSNhaCungCapTheoTen(){
		DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }};
		table.setModel(dtm);
		dtm.addColumn("Mã NCC");
		dtm.addColumn("Tên Nhà Cung Cấp");
		dtm.addColumn("Số Điện Thoại");
		dtm.addColumn("Địa Chỉ");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(375);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(435);
		Vector<NhaCungCapDTO> arr = new Vector<NhaCungCapDTO>();
		arr = NCCBLL.LayDSNhaCungCapTheoTen(txtfTenNhaCungCap.getText().toString());
		for(int i = 0;i<arr.size();i++){
			NhaCungCapDTO NCC = arr.get(i);
			int id = NCC.getNhaCungCap_ID();
			String name = NCC.getNhaCungCap_Name();
			String phonenum = NCC.getNhaCungCap_PhoneNumber();
			String address = NCC.getNhaCungCap_Address();
			Object[] row = {id,name,phonenum,address};
			dtm.addRow(row);
		}
	}

	private void BindingNhaCungCap() {
		try {
			int row = table.getSelectedRow();
			txtfMaNhaCungCap.setText(table.getModel().getValueAt(row, 0).toString());
			txtfTenNhaCungCap.setText(table.getModel().getValueAt(row, 1).toString());
			txtfSDT.setText(table.getModel().getValueAt(row, 2).toString());
			txtfDiaChi.setText(table.getModel().getValueAt(row, 3).toString());
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void addNhaCungCap() {
		try {
		if (txtfTenNhaCungCap.getText().trim().equals("") ||
		txtfSDT.getText().trim().equals("") ||
		txtfDiaChi.getText().trim().equals(""))
		JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
		else if (txtfSDT.getText().length()>10 || txtfSDT.getText().length()<10){
		JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng số điện thoại");
		} else {
		NhaCungCapDTO NCC = new NhaCungCapDTO();
		NCC.setNhaCungCap_Name(txtfTenNhaCungCap.getText());
		NCC.setNhaCungCap_Address(txtfDiaChi.getText());
		NCC.setNhaCungCap_PhoneNumber(txtfSDT.getText());
		JOptionPane.showMessageDialog(null,NCCBLL.addNhaCungCap(NCC));
		LoadDSNhaCungCap();}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ");
		}
	}
	
	private void deleteNhaCungCap() {
		try {
			NhaCungCapDTO NCC = new NhaCungCapDTO();
			NCC.setNhaCungCap_ID(Integer.parseInt(txtfMaNhaCungCap.getText()));
			JOptionPane.showMessageDialog(null,NCCBLL.deleteNhaCungCap(NCC));
			LoadDSNhaCungCap();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void editNhaCungCap() {
		try {
			if (
			txtfTenNhaCungCap.getText().trim().equals("") ||
			txtfSDT.getText().trim().equals("") ||
			txtfDiaChi.getText().trim().equals(""))
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
			else if (txtfSDT.getText().length()>10 || txtfSDT.getText().length()<10){
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng số điện thoại");
			} else {
			NhaCungCapDTO NCC = new NhaCungCapDTO();
			NCC.setNhaCungCap_ID(Integer.parseInt(txtfMaNhaCungCap.getText()));
			NCC.setNhaCungCap_Name(txtfTenNhaCungCap.getText());
			NCC.setNhaCungCap_PhoneNumber(txtfSDT.getText());
			NCC.setNhaCungCap_Address(txtfDiaChi.getText());
			JOptionPane.showMessageDialog(null,NCCBLL.editNhaCungCap(NCC));
			LoadDSNhaCungCap();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
