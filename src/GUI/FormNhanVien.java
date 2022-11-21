package GUI;

import DTO.NhanVienDTO;
import BLL.NhanVienBLL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class FormNhanVien {
	
	protected JFrame Frame;
	private NhanVienBLL NVBLL = new NhanVienBLL();
	private NhanVienDTO UsersLogin;
	private JButton btnTongQuan,btnBanSanPham,btnDichVu,btnQuanLyKhachHang,btnQuanLyNhapHang,btnQuanLyNhanVien,btnQuanLySanPham,btnDoanhThu,btnDangXuat;
	private JTable table;
	private JTextField txtfMaNhanVien,txtfTenNhanVien,txtfSDT,txtfDiaChi,txtfTenDangNhap,txtfMatKhau;
	private JSpinner spinnerLoaiNhanVien;
	
	public FormNhanVien(NhanVienDTO UserLogin) {
		UsersLogin = UserLogin;
		initComponents();
		PhanQuyen(UsersLogin);
		LoadDSNhanVien();
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
	    		btnQuanLyKhachHang.setBackground(new Color(0, 191, 255));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/4. contacts.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLyKhachHang.setIcon(icon);
	         }
		});
		btnQuanLyKhachHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		btnQuanLyKhachHang.setForeground(new Color(255, 250, 250));
		btnQuanLyKhachHang.setBackground(new Color(0, 191, 255));
		btnQuanLyKhachHang.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnQuanLyKhachHang.setBounds(0, 415, 272, 55);
		ImageIcon iconQLKH = new ImageIcon(this.getClass().getResource("/4. contacts.png"));
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
				btnQuanLyNhanVien.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/6. activeuser.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLyNhanVien.setIcon(icon);
	         }
		});
		btnQuanLyNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyNhanVien.setFont(new Font("Arial", Font.PLAIN, 20));
		btnQuanLyNhanVien.setForeground(new Color(255, 250, 250));
		btnQuanLyNhanVien.setBackground(new Color(100, 149, 237));
		btnQuanLyNhanVien.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnQuanLyNhanVien.setBounds(0, 547, 272, 55);
		ImageIcon iconQLNV = new ImageIcon(this.getClass().getResource("/6. activeuser.png"));
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
				txtfMaNhanVien.setText("");
				txtfTenNhanVien.setText("");
				txtfSDT.setText("");
				txtfDiaChi.setText("");
				txtfTenDangNhap.setText("");
				txtfMatKhau.setText("");
			}
		});
		pnMain.setBounds(272, 0, 1008, 800);
		pnMain.setLayout(null);
		pnMain.setBackground(new Color(247, 248, 252));
		Frame.getContentPane().add(pnMain);
		
		JLabel lblTieuDe = new JLabel("Quản Lý Nhân Viên");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Arial", Font.PLAIN, 26));
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setBounds(320, 11, 318, 50);
		pnMain.add(lblTieuDe);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				BindingNhanVien();
			}});
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(10, 339, 988, 450);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 339, 988, 450);
		pnMain.add(scrollPane);
		
		JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaNhanVien.setBounds(156, 73, 110, 37);
		pnMain.add(lblMaNhanVien);
		
		txtfMaNhanVien = new JTextField();
		txtfMaNhanVien.setEnabled(false);
		txtfMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtfMaNhanVien.setColumns(10);
		txtfMaNhanVien.setBounds(276, 82, 198, 29);
		pnMain.add(txtfMaNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("Tên Nhân Viên");
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenNhanVien.setBounds(156, 121, 110, 37);
		pnMain.add(lblTenNhanVien);
		
		txtfTenNhanVien = new JTextField();
		txtfTenNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtfTenNhanVien.setColumns(10);
		txtfTenNhanVien.setBounds(276, 129, 198, 29);
		pnMain.add(txtfTenNhanVien);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDiaChi.setBounds(156, 215, 110, 37);
		pnMain.add(lblDiaChi);
		
		txtfDiaChi = new JTextField();
		txtfDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtfDiaChi.setColumns(10);
		txtfDiaChi.setBounds(276, 219, 198, 29);
		pnMain.add(txtfDiaChi);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSDT.setBounds(156, 168, 110, 37);
		pnMain.add(lblSDT);
		
		txtfSDT = new JTextField();
		txtfSDT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtfSDT.setColumns(10);
		txtfSDT.setBounds(276, 176, 198, 29);
		pnMain.add(txtfSDT);
		
		JLabel lblLoaiNhanVien = new JLabel("Loại Nhân Viên");
		lblLoaiNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLoaiNhanVien.setBounds(530, 213, 110, 37);
		pnMain.add(lblLoaiNhanVien);
		
	    SpinnerModel spinnerModel = new SpinnerNumberModel(0,0,1,1);
		spinnerLoaiNhanVien = new JSpinner(spinnerModel);
		spinnerLoaiNhanVien.setBounds(650, 222, 44, 29);
		pnMain.add(spinnerLoaiNhanVien);
		
		JLabel lblTenDangNhap = new JLabel("Tên Đăng Nhập");
		lblTenDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenDangNhap.setBounds(530, 121, 110, 37);
		pnMain.add(lblTenDangNhap);
		
		txtfTenDangNhap = new JTextField();
		txtfTenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtfTenDangNhap.setColumns(10);
		txtfTenDangNhap.setBounds(650, 130, 198, 29);
		pnMain.add(txtfTenDangNhap);
		
		JLabel lblMatKhau = new JLabel("Mật Khẩu");
		lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMatKhau.setBounds(530, 169, 110, 37);
		pnMain.add(lblMatKhau);
		
		txtfMatKhau = new JTextField();
		txtfMatKhau.setBounds(650, 174, 198, 29);
		pnMain.add(txtfMatKhau);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNhanVien();
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
				deleteNhanVien();
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
				editNhanVien();
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
				LoadDSNhanVienTheoTen();
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
				LoadDSNhanVien();
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
	
	private void LoadDSNhanVien(){
		DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }};
		table.setModel(dtm);
		dtm.addColumn("Mã NV");
		dtm.addColumn("Tên Nhân Viên");
		dtm.addColumn("Số Điện Thoại");
		dtm.addColumn("Địa Chỉ");
		dtm.addColumn("Tên Đăng Nhập");
		dtm.addColumn("Mật Khẩu");
		dtm.addColumn("Loại NV");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(355);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		table.getColumnModel().getColumn(5).setPreferredWidth(125);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		Vector<NhanVienDTO> arr = new Vector<NhanVienDTO>();
		arr = NVBLL.LayDSNhanVien();
		for(int i = 0;i<arr.size();i++){
			NhanVienDTO NV = arr.get(i);
			int id = NV.getNhanVien_ID();
			String name = NV.getNhanVien_Name();
			String phonenum = NV.getNhanVien_PhoneNumber();
			String address = NV.getNhanVien_Address();
			String username = NV.getNhanVien_Username();
			String password = NV.getNhanVien_Password();
			int type = NV.getNhanVien_Type();
			Object[] row = {id,name,phonenum,address,username,password,type};
			dtm.addRow(row);
		}
	}
	private void LoadDSNhanVienTheoTen(){
		DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }};
		table.setModel(dtm);
		dtm.addColumn("Mã NV");
		dtm.addColumn("Tên Nhân Viên");
		dtm.addColumn("Số Điện Thoại");
		dtm.addColumn("Địa Chỉ");
		dtm.addColumn("Tên Đăng Nhập");
		dtm.addColumn("Mật Khẩu");
		dtm.addColumn("Loại NV");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(355);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		table.getColumnModel().getColumn(5).setPreferredWidth(125);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		Vector<NhanVienDTO> arr = new Vector<NhanVienDTO>();
		arr = NVBLL.LayDSNhanVienTheoTen(txtfTenNhanVien.getText().toString());
		for(int i = 0;i<arr.size();i++){
			NhanVienDTO NV = arr.get(i);
			int id = NV.getNhanVien_ID();
			String name = NV.getNhanVien_Name();
			String phonenum = NV.getNhanVien_PhoneNumber();
			String address = NV.getNhanVien_Address();
			String username = NV.getNhanVien_Username();
			String password = NV.getNhanVien_Password();
			int type = NV.getNhanVien_Type();
			Object[] row = {id,name,phonenum,address,username,password,type};
			dtm.addRow(row);
		}
	}

	private void BindingNhanVien() {
		try {
			int row = table.getSelectedRow();
			txtfMaNhanVien.setText(table.getModel().getValueAt(row, 0).toString());
			txtfTenNhanVien.setText(table.getModel().getValueAt(row, 1).toString());
			txtfSDT.setText(table.getModel().getValueAt(row, 2).toString());
			txtfDiaChi.setText(table.getModel().getValueAt(row, 3).toString());
			txtfTenDangNhap.setText(table.getModel().getValueAt(row, 4).toString());
			txtfMatKhau.setText(table.getModel().getValueAt(row, 5).toString());
			spinnerLoaiNhanVien.setValue(Integer.parseInt(table.getModel().getValueAt(row, 6).toString()));
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void addNhanVien() {
		try {
		if (txtfTenNhanVien.getText().trim().equals("") ||
		txtfSDT.getText().trim().equals("") ||
		txtfDiaChi.getText().trim().equals("") ||
		txtfTenDangNhap.getText().trim().equals("") ||
		txtfMatKhau.getText().trim().equals("") ||
		spinnerLoaiNhanVien.getValue().equals(""))
		JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
		else if (txtfSDT.getText().length()>10 || txtfSDT.getText().length()<10){
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng số điện thoại");
		} else {
		NhanVienDTO NV = new NhanVienDTO();
		NV.setNhanVien_Name(txtfTenNhanVien.getText());
		NV.setNhanVien_PhoneNumber(txtfSDT.getText());
		NV.setNhanVien_Address(txtfDiaChi.getText());
		NV.setNhanVien_Username(txtfTenDangNhap.getText());
		NV.setNhanVien_Password(txtfMatKhau.getText());
		NV.setNhanVien_Type((int) spinnerLoaiNhanVien.getValue());
		JOptionPane.showMessageDialog(null,NVBLL.addNhanVien(NV));
		LoadDSNhanVien();}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ");
		}
	}
	private void editNhanVien(){
		try{
			if (
			txtfTenNhanVien.getText().trim().equals("") ||
			txtfSDT.getText().trim().equals("") ||
			txtfDiaChi.getText().trim().equals("") ||
			txtfTenDangNhap.getText().trim().equals("") ||
			txtfMatKhau.getText().trim().equals("") ||
			spinnerLoaiNhanVien.getValue().equals(""))
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
			else if (txtfSDT.getText().length()>10 || txtfSDT.getText().length()<10){
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng số điện thoại");
			} else {
			NhanVienDTO NV = new NhanVienDTO();
			NV.setNhanVien_ID(Integer.parseInt(txtfMaNhanVien.getText()));
			NV.setNhanVien_Name(txtfTenNhanVien.getText());
			NV.setNhanVien_PhoneNumber(txtfSDT.getText());
			NV.setNhanVien_Address(txtfDiaChi.getText());
			NV.setNhanVien_Username(txtfTenDangNhap.getText());
			NV.setNhanVien_Password(txtfMatKhau.getText());
			NV.setNhanVien_Type(Integer.parseInt(spinnerLoaiNhanVien.getValue().toString()));
			JOptionPane.showMessageDialog(null,NVBLL.editNhanVien(NV));
			LoadDSNhanVien();
			}
		}  catch (Exception e) {
			System.out.println(e);
		}
	}
	private void deleteNhanVien() {
		try {
			NhanVienDTO NV = new NhanVienDTO();
			NV.setNhanVien_ID(Integer.parseInt(txtfMaNhanVien.getText()));
			JOptionPane.showMessageDialog(null,NVBLL.deleteNhanVien(NV));
			LoadDSNhanVien();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
