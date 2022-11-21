package GUI;

import DTO.NhanVienDTO;
import DTO.KhachHangDTO;
import BLL.KhachHangBLL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class FormKhachHang {

	protected JFrame Frame;
	private KhachHangBLL KHBLL= new KhachHangBLL();
	private NhanVienDTO UsersLogin;
	private JButton btnTongQuan,btnBanSanPham,btnDichVu,btnQuanLyKhachHang,btnQuanLyNhapHang,btnQuanLyNhanVien,btnQuanLySanPham,btnDoanhThu,btnDangXuat;
	private JTextField txtfMaKhachHang,txtfTenKhachHang,txtfSDT,txtfDiaChi,txtfEmail;
	private JTable table;
	
	public FormKhachHang(NhanVienDTO UserLogin) {
		UsersLogin = UserLogin;
		initComponents();
		PhanQuyen(UsersLogin);
		LoadDSKhachHang();
	}
	
	public void initComponents() {
		Frame = new JFrame();
		Frame.setSize(1280,800);
		Frame.setLocationRelativeTo(null);
		Frame.setResizable(false);
		Frame.setUndecorated(true);
		Frame.getContentPane().setBackground(new Color(247, 248, 252));
		Frame.getContentPane().setLayout(null);
		
        /*
        ============================================================
                                SIDE MENU           
        ============================================================
         */
		
		JPanel pnSideMenu = new JPanel();
		pnSideMenu.setBounds(0, 0, 272, 800);
		pnSideMenu.setBackground(new Color(0, 191, 255));
		Frame.getContentPane().add(pnSideMenu);
		pnSideMenu.setLayout(null);

		JLabel logo = new JLabel();
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/logo.png"));
		logo.setIcon(img);
		logo.setBounds(0, 0, 115, 102);
		pnSideMenu.add(logo);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setText("<html>World<br>Computer</html>");
		lblTitle.setBounds(113, 0, 159, 102);
		pnSideMenu.add(lblTitle);
		
		JLabel lblQuanLyCuaHang = new JLabel("Quản lý cửa hàng");
		lblQuanLyCuaHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLyCuaHang.setFont(new Font("Arial", Font.BOLD, 28));
		lblQuanLyCuaHang.setForeground(new Color(255, 250, 250));
		lblQuanLyCuaHang.setBounds(0, 124, 272, 55);
		pnSideMenu.add(lblQuanLyCuaHang);
				
		btnTongQuan = new JButton("Tổng Quan");
		btnTongQuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormMainMenu frm = new FormMainMenu(UsersLogin);
				frm.Frame.setVisible(true);
				Frame.dispose();
			}
		});
		btnTongQuan.setFocusable(false);
		btnTongQuan.setOpaque(true);
		btnTongQuan.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) 
	         {
				btnTongQuan.setFont(new Font("Arial", Font.PLAIN, 22));
				btnTongQuan.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/1. activeoverview.png"));
				Image newimg = icon.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnTongQuan.setIcon(icon);
	         }
	         public void mouseExited(MouseEvent evt) 
	         {
	        	btnTongQuan.setFont(new Font("Arial", Font.PLAIN, 20));
	    		btnTongQuan.setBackground(new Color(0, 191, 255));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/1. overview.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnTongQuan.setIcon(icon);
	         }
		});
		btnTongQuan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTongQuan.setHorizontalAlignment(SwingConstants.LEFT);
		btnTongQuan.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTongQuan.setForeground(new Color(255, 250, 250));
		btnTongQuan.setBackground(new Color(0, 191, 255));
		btnTongQuan.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnTongQuan.setBounds(0, 217, 272, 55);
		ImageIcon iconTQ = new ImageIcon(this.getClass().getResource("/1. overview.png"));
		Image newimgTQ = iconTQ.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconTQ = new ImageIcon(newimgTQ);
		btnTongQuan.setIcon(iconTQ);
		pnSideMenu.add(btnTongQuan);
		
		btnBanSanPham = new JButton("Bán Sản Phẩm");
		btnBanSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormBanSanPham frm = new FormBanSanPham(UsersLogin);
				frm.Frame.setVisible(true);
				Frame.dispose();
			}
		});
		btnBanSanPham.setFocusable(false);
		btnBanSanPham.setOpaque(true);
		btnBanSanPham.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) 
	         {
				btnBanSanPham.setFont(new Font("Arial", Font.PLAIN, 22));
				btnBanSanPham.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/2. activesale.png"));
				Image newimg = icon.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnBanSanPham.setIcon(icon);
	         }
	         public void mouseExited(MouseEvent evt) 
	         {
	        	btnBanSanPham.setFont(new Font("Arial", Font.PLAIN, 20));
	    		btnBanSanPham.setBackground(new Color(0, 191, 255));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/2. sale.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnBanSanPham.setIcon(icon);
	         }
		});
		btnBanSanPham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBanSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnBanSanPham.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBanSanPham.setForeground(new Color(255, 250, 250));
		btnBanSanPham.setBackground(new Color(0, 191, 255));
		btnBanSanPham.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnBanSanPham.setBounds(0, 283, 272, 55);
		ImageIcon iconBSP = new ImageIcon(this.getClass().getResource("/2. sale.png"));
		Image newimgBSP= iconBSP.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconBSP = new ImageIcon(newimgBSP);
		btnBanSanPham.setIcon(iconBSP);
		pnSideMenu.add(btnBanSanPham);
	
		btnDichVu = new JButton("Dịch Vụ");
		btnDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormDichVu frm = new FormDichVu(UsersLogin);
				frm.Frame.setVisible(true);
				Frame.dispose();
			}
		});
		btnDichVu.setFocusable(false);
		btnDichVu.setOpaque(true);
		btnDichVu.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) 
	         {
				btnDichVu.setFont(new Font("Arial", Font.PLAIN, 22));
				btnDichVu.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/3. activeservice.png"));
				Image newimg = icon.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnDichVu.setIcon(icon);
	         }
	         public void mouseExited(MouseEvent evt) 
	         {
	        	btnDichVu.setFont(new Font("Arial", Font.PLAIN, 20));
	        	btnDichVu.setBackground(new Color(0, 191, 255));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/3. service.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnDichVu.setIcon(icon);
	         }
		});
		btnDichVu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDichVu.setForeground(new Color(255, 250, 250));
		btnDichVu.setBackground(new Color(0, 191, 255));
		btnDichVu.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnDichVu.setBounds(0, 349, 272, 55);
		ImageIcon iconDV = new ImageIcon(this.getClass().getResource("/3. service.png"));
		Image newimgDV = iconDV.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconDV = new ImageIcon(newimgDV);
		btnDichVu.setIcon(iconDV);
		pnSideMenu.add(btnDichVu);
				
		btnQuanLyKhachHang = new JButton("Quản Lý Khách Hàng");
		btnQuanLyKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormKhachHang frm = new FormKhachHang(UsersLogin);
				frm.Frame.setVisible(true);
				Frame.dispose();
			}
		});
		btnQuanLyKhachHang.setFocusable(false);
		btnQuanLyKhachHang.setOpaque(true);
		btnQuanLyKhachHang.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) 
	         {
				btnQuanLyKhachHang.setFont(new Font("Arial", Font.PLAIN, 22));
				btnQuanLyKhachHang.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/4. activecontacts.png"));
				Image newimg = icon.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLyKhachHang.setIcon(icon);
	         }
	         public void mouseExited(MouseEvent evt) 
	         {
	        	btnQuanLyKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
				btnQuanLyKhachHang.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/4. activecontacts.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLyKhachHang.setIcon(icon);
	         }
		});
		btnQuanLyKhachHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		btnQuanLyKhachHang.setForeground(new Color(255, 250, 250));
		btnQuanLyKhachHang.setBackground(new Color(100, 149, 237));
		btnQuanLyKhachHang.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnQuanLyKhachHang.setBounds(0, 415, 272, 55);
		ImageIcon iconQLKH = new ImageIcon(this.getClass().getResource("/4. activecontacts.png"));
		Image newimgQLKH = iconQLKH.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconQLKH = new ImageIcon(newimgQLKH);
		btnQuanLyKhachHang.setIcon(iconQLKH);
		pnSideMenu.add(btnQuanLyKhachHang);
		
		btnQuanLyNhapHang = new JButton("Quản Lý Nhập Hàng");
		btnQuanLyNhapHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormNhapHang frm = new FormNhapHang(UsersLogin);
				frm.Frame.setVisible(true);
				Frame.dispose();
			}
		});
		btnQuanLyNhapHang.setFocusable(false);
		btnQuanLyNhapHang.setOpaque(true);
		btnQuanLyNhapHang.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) 
	         {
				btnQuanLyNhapHang.setFont(new Font("Arial", Font.PLAIN, 22));
				btnQuanLyNhapHang.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/5. activedelivery.png"));
				Image newimg = icon.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLyNhapHang.setIcon(icon);
	         }
	         public void mouseExited(MouseEvent evt) 
	         {
	        	btnQuanLyNhapHang.setFont(new Font("Arial", Font.PLAIN, 20));
	    		btnQuanLyNhapHang.setBackground(new Color(0, 191, 255));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/5. delivery.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLyNhapHang.setIcon(icon);
	         }
		});
		btnQuanLyNhapHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyNhapHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyNhapHang.setFont(new Font("Arial", Font.PLAIN, 20));
		btnQuanLyNhapHang.setForeground(new Color(255, 250, 250));
		btnQuanLyNhapHang.setBackground(new Color(0, 191, 255));
		btnQuanLyNhapHang.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnQuanLyNhapHang.setBounds(0, 481, 272, 55);
		ImageIcon iconQLNH = new ImageIcon(this.getClass().getResource("/5. delivery.png"));
		Image newimgQLNH = iconQLNH.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconQLNH = new ImageIcon(newimgQLNH);
		btnQuanLyNhapHang.setIcon(iconQLNH);
		pnSideMenu.add(btnQuanLyNhapHang);
		
		btnQuanLyNhanVien = new JButton("Quản Lý Nhân Viên");
		btnQuanLyNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormNhanVien frm = new FormNhanVien(UsersLogin);
				frm.Frame.setVisible(true);
				Frame.dispose();
			}
		});
		btnQuanLyNhanVien.setFocusable(false);
		btnQuanLyNhanVien.setOpaque(true);
		btnQuanLyNhanVien.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) 
	         {
				btnQuanLyNhanVien.setFont(new Font("Arial", Font.PLAIN, 22));
				btnQuanLyNhanVien.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/6. activeuser.png"));
				Image newimg = icon.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLyNhanVien.setIcon(icon);
	         }
	         public void mouseExited(MouseEvent evt) 
	         {
	        	btnQuanLyNhanVien.setFont(new Font("Arial", Font.PLAIN, 20));
	    		btnQuanLyNhanVien.setBackground(new Color(0, 191, 255));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/6. user.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLyNhanVien.setIcon(icon);
	         }
		});
		btnQuanLyNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyNhanVien.setFont(new Font("Arial", Font.PLAIN, 20));
		btnQuanLyNhanVien.setForeground(new Color(255, 250, 250));
		btnQuanLyNhanVien.setBackground(new Color(0, 191, 255));
		btnQuanLyNhanVien.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnQuanLyNhanVien.setBounds(0, 547, 272, 55);
		ImageIcon iconQLNV = new ImageIcon(this.getClass().getResource("/6. user.png"));
		Image newimgQLNV = iconQLNV.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconQLNV = new ImageIcon(newimgQLNV);
		btnQuanLyNhanVien.setIcon(iconQLNV);
		pnSideMenu.add(btnQuanLyNhanVien);
		
		btnQuanLySanPham = new JButton("Quản Lý Sản Phẩm");
		btnQuanLySanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormSanPham frm = new FormSanPham(UsersLogin);
				frm.Frame.setVisible(true);
				Frame.dispose();
			}
		});
		btnQuanLySanPham.setFocusable(false);
		btnQuanLySanPham.setOpaque(true);
		btnQuanLySanPham.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) 
	         {
				btnQuanLySanPham.setFont(new Font("Arial", Font.PLAIN, 22));
				btnQuanLySanPham.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/7. activecomputer.png"));
				Image newimg = icon.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLySanPham.setIcon(icon);
	         }
	         public void mouseExited(MouseEvent evt) 
	         {
	        	btnQuanLySanPham.setFont(new Font("Arial", Font.PLAIN, 20));
	    		btnQuanLySanPham.setBackground(new Color(0, 191, 255));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/7. computer.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLySanPham.setIcon(icon);
	         }
		});
		btnQuanLySanPham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLySanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLySanPham.setFont(new Font("Arial", Font.PLAIN, 20));
		btnQuanLySanPham.setForeground(new Color(255, 250, 250));
		btnQuanLySanPham.setBackground(new Color(0, 191, 255));
		btnQuanLySanPham.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnQuanLySanPham.setBounds(0, 613, 272, 55);
		ImageIcon iconQLSP = new ImageIcon(this.getClass().getResource("/7. computer.png"));
		Image newimgQLSP = iconQLSP.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconQLSP = new ImageIcon(newimgQLSP);
		btnQuanLySanPham.setIcon(iconQLSP);
		pnSideMenu.add(btnQuanLySanPham);
		
		btnDoanhThu = new JButton("Doanh thu");
		btnDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormDoanhThu frm = new FormDoanhThu(UsersLogin);
				frm.Frame.setVisible(true);
				Frame.dispose();
			}
		});
		btnDoanhThu.setFocusable(false);
		btnDoanhThu.setOpaque(true);
		btnDoanhThu.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) 
	         {
				btnDoanhThu.setFont(new Font("Arial", Font.PLAIN, 22));
				btnDoanhThu.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/8. activerevenue.png"));
				Image newimg = icon.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnDoanhThu.setIcon(icon);
	         }
	         public void mouseExited(MouseEvent evt) 
	         {
	        	btnDoanhThu.setFont(new Font("Arial", Font.PLAIN, 20));
	    		btnDoanhThu.setBackground(new Color(0, 191, 255));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/8. revenue.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnDoanhThu.setIcon(icon);
	         }
		});
		btnDoanhThu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDoanhThu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDoanhThu.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDoanhThu.setForeground(new Color(255, 250, 250));
		btnDoanhThu.setBackground(new Color(0, 191, 255));
		btnDoanhThu.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnDoanhThu.setBounds(0, 679, 272, 55);
		ImageIcon iconDT = new ImageIcon(this.getClass().getResource("/8. revenue.png"));
		Image newimgDT = iconDT.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconDT = new ImageIcon(newimgDT);
		btnDoanhThu.setIcon(iconDT);
		pnSideMenu.add(btnDoanhThu);
		
		btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuLyDangXuat();
			}
		});
		btnDangXuat.setFocusable(false);
		btnDangXuat.setOpaque(true);
		btnDangXuat.addMouseListener(new MouseAdapter() {
			 public void mouseEntered(MouseEvent evt) 
	         {
				btnDangXuat.setFont(new Font("Arial", Font.PLAIN, 22));
				btnDangXuat.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/logout.png"));
				Image newimg = icon.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnDangXuat.setIcon(icon);
	         }
	         public void mouseExited(MouseEvent evt) 
	         {
	        	btnDangXuat.setFont(new Font("Arial", Font.PLAIN, 20));
	        	btnDangXuat.setBackground(new Color(0, 191, 255));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/logout.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnDangXuat.setIcon(icon);
	         }
		});
		btnDangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDangXuat.setForeground(new Color(255, 250, 250));
		btnDangXuat.setBackground(new Color(0, 191, 255));
		btnDangXuat.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnDangXuat.setBounds(0, 745, 272, 55);
		ImageIcon iconDX = new ImageIcon(this.getClass().getResource("/logout.png"));
		Image newimgDX = iconDX.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconDX = new ImageIcon(newimgDX);
		btnDangXuat.setIcon(iconDX);
		pnSideMenu.add(btnDangXuat);
		
        /*
        ============================================================
                                MAIN PANEL           
        ============================================================
         */
		
		JPanel pnMain = new JPanel();
		pnMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfMaKhachHang.setText("");
				txtfTenKhachHang.setText("");
				txtfSDT.setText("");
				txtfDiaChi.setText("");
				txtfEmail.setText("");
			}
		});
		pnMain.setBounds(272, 0, 1008, 800);
		pnMain.setLayout(null);
		pnMain.setBackground(new Color(247, 248, 252));
		Frame.getContentPane().add(pnMain);
		
		JLabel lblTieuDe = new JLabel("Quản Lý Khách Hàng");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Arial", Font.PLAIN, 26));
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setBounds(320, 11, 318, 50);
		pnMain.add(lblTieuDe);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				BindingKhachHang();
			}});
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(10, 339, 988, 450);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 339, 988, 450);
		pnMain.add(scrollPane);
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng");
		lblMaKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaKhachHang.setBounds(282, 65, 148, 37);
		pnMain.add(lblMaKhachHang);
		
		txtfMaKhachHang = new JTextField();
		txtfMaKhachHang.setEnabled(false);
		txtfMaKhachHang.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfMaKhachHang.setColumns(10);
		txtfMaKhachHang.setBounds(440, 73, 198, 29);
		pnMain.add(txtfMaKhachHang);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng");
		lblTenKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenKhachHang.setBounds(282, 113, 148, 37);
		pnMain.add(lblTenKhachHang);

		txtfTenKhachHang = new JTextField();
		txtfTenKhachHang.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfTenKhachHang.setColumns(10);
		txtfTenKhachHang.setBounds(440, 121, 198, 29);
		pnMain.add(txtfTenKhachHang);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại");
		lblSoDienThoai.setFont(new Font("Arial", Font.BOLD, 14));
		lblSoDienThoai.setBounds(282, 161, 148, 37);
		pnMain.add(lblSoDienThoai);

		txtfSDT = new JTextField();
		txtfSDT.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfSDT.setColumns(10);
		txtfSDT.setBounds(440, 164, 198, 29);
		pnMain.add(txtfSDT);

		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiaChi.setBounds(282, 209, 148, 37);
		pnMain.add(lblDiaChi);
		
		txtfDiaChi = new JTextField();
		txtfDiaChi.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfDiaChi.setColumns(10);
		txtfDiaChi.setBounds(440, 211, 198, 29);
		pnMain.add(txtfDiaChi);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setBounds(282, 257, 148, 37);
		pnMain.add(lblEmail);

		txtfEmail = new JTextField();
		txtfEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfEmail.setColumns(10);
		txtfEmail.setBounds(440, 258, 198, 29);
		pnMain.add(txtfEmail);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addKhachHang();
			}
		});
		btnThem.setFocusPainted(false);
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBorderPainted(false);
		btnThem.setBackground(new Color(102, 153, 102));
		btnThem.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem.setBounds(10, 301, 172, 35);
		ImageIcon iconThem = new ImageIcon(this.getClass().getResource("/add.png"));
		Image newimgThem = iconThem.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconThem = new ImageIcon(newimgThem);
		btnThem.setIcon(iconThem);
		pnMain.add(btnThem);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteKhachHang();
			}
		});
		btnXoa.setFocusPainted(false);
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setBorderPainted(false);
		btnXoa.setBackground(new Color(204, 0, 0));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoa.setBounds(210, 301, 172, 35);
		ImageIcon iconXoa = new ImageIcon(this.getClass().getResource("/delete.png"));
		Image newimgXoa = iconXoa.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconXoa = new ImageIcon(newimgXoa);
		btnXoa.setIcon(iconXoa);
		pnMain.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editKhachHang();
			}
		});
		btnSua.setFocusPainted(false);
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSua.setBackground(new Color(51, 102, 153));
		btnSua.setBorderPainted(false);
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Arial", Font.BOLD, 14));
		btnSua.setBounds(410, 301, 172, 35);
		ImageIcon iconSua = new ImageIcon(this.getClass().getResource("/edit.png"));
		Image newimgSua = iconSua.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconSua = new ImageIcon(newimgSua);
		btnSua.setIcon(iconSua);
		pnMain.add(btnSua);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadDSKhachHangTheoTen();
			}
		});
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setBorderPainted(false);
		btnTimKiem.setBackground(new Color(0, 191, 255));
		btnTimKiem.setFont(new Font("Arial", Font.BOLD, 14));
		btnTimKiem.setBounds(610, 301, 172, 35);
		ImageIcon iconTimKiem = new ImageIcon(this.getClass().getResource("/search.png"));
		Image newimgTimKiem = iconTimKiem.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconTimKiem = new ImageIcon(newimgTimKiem);
		btnTimKiem.setIcon(iconTimKiem);
		pnMain.add(btnTimKiem);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadDSKhachHang();
			}
		});
		btnReset.setFocusPainted(false);
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReset.setBackground(Color.BLACK);
		btnReset.setBorderPainted(false);
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Arial", Font.BOLD, 14));
		btnReset.setBounds(810, 301, 175, 35);
		pnMain.add(btnReset);		
	}
	
    /*
    ============================================================
                            EVENTS           
    ============================================================
     */
	
	private void XuLyDangXuat() {
		int qes;
		qes = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn đăng xuất khỏi chương trình?", "Question",JOptionPane.YES_NO_OPTION);			 
		if(qes == JOptionPane.YES_OPTION){
			FormDangNhap frm = new FormDangNhap();
			frm.Frame.setVisible(true);
			Frame.dispose();
		}
	}	
	
	private void PhanQuyen(NhanVienDTO UserLogin) {
		if(UserLogin.getNhanVien_Type()==0) {
			btnQuanLyNhanVien.setEnabled(false);
			btnQuanLySanPham.setEnabled(false);
			btnDoanhThu.setEnabled(false);
		}
	}

	public void LoadDSKhachHang(){
		DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }};
		table.setModel(dtm);
		dtm.addColumn("Mã KH");
		dtm.addColumn("Tên Khách Hàng");
		dtm.addColumn("Số Điện Thoại");
		dtm.addColumn("Địa chỉ");
		dtm.addColumn("Email");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(400);
		table.getColumnModel().getColumn(4).setPreferredWidth(215);
		Vector<KhachHangDTO> arr = new Vector<KhachHangDTO>();
		arr = KHBLL.LayDSKhachHang();
		for(int i = 0;i<arr.size();i++){
			KhachHangDTO KH = arr.get(i);
			int id = KH.getKhachHang_ID();
			String name = KH.getKhachHang_Name();
			String phonenum = KH.getKhachHang_PhoneNumber();
			String address = KH.getKhachHang_Address();
			String email = KH.getKhachHang_Email();
			Object[] row = {id,name,phonenum,address,email};
			dtm.addRow(row);
		}
	}
	public void LoadDSKhachHangTheoTen(){
		DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }};
		table.setModel(dtm);
		dtm.addColumn("Mã KH");
		dtm.addColumn("Tên Khách Hàng");
		dtm.addColumn("Số Điện Thoại");
		dtm.addColumn("Địa chỉ");
		dtm.addColumn("Email");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(400);
		table.getColumnModel().getColumn(4).setPreferredWidth(215);
		Vector<KhachHangDTO> arr = new Vector<KhachHangDTO>();
		arr = KHBLL.LayDSKhachHangTheoTen(txtfTenKhachHang.getText().toString());
		for(int i = 0;i<arr.size();i++){
			KhachHangDTO KH = arr.get(i);
			int id = KH.getKhachHang_ID();
			String name = KH.getKhachHang_Name();
			String phonenum = KH.getKhachHang_PhoneNumber();
			String address = KH.getKhachHang_Address();
			String email = KH.getKhachHang_Email();
			Object[] row = {id,name,phonenum,address,email};
			dtm.addRow(row);
		}
	}

	private void BindingKhachHang() {
		try {
			int row = table.getSelectedRow();
			txtfMaKhachHang.setText(table.getModel().getValueAt(row, 0).toString());
			txtfTenKhachHang.setText(table.getModel().getValueAt(row, 1).toString());
			txtfSDT.setText(table.getModel().getValueAt(row, 2).toString());
			txtfDiaChi.setText(table.getModel().getValueAt(row, 3).toString());
			txtfEmail.setText(table.getModel().getValueAt(row, 4).toString());
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void addKhachHang() {
		try {
		if (txtfTenKhachHang.getText().trim().equals("") ||
		txtfSDT.getText().trim().equals("") ||
		txtfDiaChi.getText().trim().equals("") ||
		txtfEmail.getText().trim().equals(""))
		JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
		else if (txtfSDT.getText().length()>10 || txtfSDT.getText().length()<10){
		JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng số điện thoại");
		} else {
		KhachHangDTO KH = new KhachHangDTO();
		KH.setKhachHang_Name(txtfTenKhachHang.getText());
		KH.setKhachHang_PhoneNumber(txtfSDT.getText());
		KH.setKhachHang_Address(txtfDiaChi.getText());
		KH.setKhachHang_Email(txtfEmail.getText());
		JOptionPane.showMessageDialog(null,KHBLL.addKhachHang(KH));
		LoadDSKhachHang();}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ");
		}
	}
	
	private void deleteKhachHang() {
		try {
			KhachHangDTO KH = new KhachHangDTO();
			KH.setKhachHang_ID(Integer.parseInt(txtfMaKhachHang.getText()));
			JOptionPane.showMessageDialog(null,KHBLL.deleteKhachHang(KH));
			LoadDSKhachHang();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void editKhachHang() {
		try {
			if (
			txtfTenKhachHang.getText().trim().equals("") ||
			txtfSDT.getText().trim().equals("") ||
			txtfDiaChi.getText().trim().equals("") ||
			txtfEmail.getText().trim().equals(""))
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
			else if (txtfSDT.getText().length()>10 || txtfSDT.getText().length()<10){
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng số điện thoại");
			} else {
			KhachHangDTO KH = new KhachHangDTO();
			KH.setKhachHang_ID(Integer.parseInt(txtfMaKhachHang.getText()));
			KH.setKhachHang_Name(txtfTenKhachHang.getText());
			KH.setKhachHang_PhoneNumber(txtfSDT.getText());
			KH.setKhachHang_Address(txtfDiaChi.getText());
			KH.setKhachHang_Email(txtfEmail.getText());
			JOptionPane.showMessageDialog(null,KHBLL.editKhachHang(KH));
			LoadDSKhachHang();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
