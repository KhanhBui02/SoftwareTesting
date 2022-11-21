package GUI;

import DTO.NhanVienDTO;
import DTO.KhachHangDTO;
import DTO.SanPhamDTO;
import DTO.LoaiSanPhamDTO;
import DTO.HoaDonBanDTO;
import DTO.CTHDBanDTO;
import BLL.KhachHangBLL;
import BLL.SanPhamBLL;
import BLL.LoaiSanPhamBLL;
import BLL.HoaDonBanBLL;
import BLL.CTHDBanBLL;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class FormBanSanPham {

	protected JFrame Frame;
	private NhanVienDTO UsersLogin;
	private KhachHangBLL KHBLL = new KhachHangBLL();
	private SanPhamBLL SPBLL = new SanPhamBLL();
	private LoaiSanPhamBLL LSPBLL = new LoaiSanPhamBLL();
	private HoaDonBanBLL HDBBLL = new HoaDonBanBLL();
	private CTHDBanBLL CTHDBBLL = new CTHDBanBLL();
	private KhachHangDTO KH = new KhachHangDTO();
	private HoaDonBanDTO HDB = new HoaDonBanDTO();
	private JButton btnTongQuan,btnBanSanPham,btnDichVu,btnQuanLyKhachHang,btnQuanLyNhapHang,btnQuanLyNhanVien,btnQuanLySanPham,btnDoanhThu,btnDangXuat;
	private JTable tableHoaDon,tableSanPham;
	private JTextField txtfSDT,txtfMaKhachHang,txtfTenKhachHang,txtfMaSanPham,txtfTenSanPham,txtfMaNhanVien,txtfNhanVien;
	private JComboBox<String> cbLoaiSanPham;
	private JSpinner spinnerSoLuong;
	private JButton btnThemHD,btnXoaHD,btnTimKiemKH,btnThem,btnXoa,btnThanhToan;
	private DefaultTableModel dtmHD;
	private int TongTien = 0;
	
	public FormBanSanPham(NhanVienDTO UserLogin) {
		UsersLogin = UserLogin;
		initComponents();
		PhanQuyen(UsersLogin);
		LoadChiTietHoaDon();
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
				btnBanSanPham.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/2. activesale.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnBanSanPham.setIcon(icon);
	         }
		});
		btnBanSanPham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBanSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnBanSanPham.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBanSanPham.setForeground(new Color(255, 250, 250));
		btnBanSanPham.setBackground(new Color(100, 149, 237));
		btnBanSanPham.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnBanSanPham.setBounds(0, 283, 272, 55);
		ImageIcon iconBSP = new ImageIcon(this.getClass().getResource("/2. activesale.png"));
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
		pnMain.setBounds(272, 0, 1008, 800);
		pnMain.setLayout(null);
		pnMain.setBackground(new Color(247, 248, 252));
		Frame.getContentPane().add(pnMain);
		
		JLabel lblTieuDe = new JLabel("Bán Sản Phẩm");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Arial", Font.PLAIN, 26));
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setBounds(320, 11, 318, 50);
		pnMain.add(lblTieuDe);
		
		tableHoaDon = new JTable();
		tableHoaDon.setFont(new Font("Arial", Font.PLAIN, 14));
		tableHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableHoaDon.setBounds(10, 339, 988, 450);
		JScrollPane scrollPane = new JScrollPane(tableHoaDon);
		scrollPane.setBounds(10, 468, 628, 322);
		pnMain.add(scrollPane);
		
		tableSanPham = new JTable();
		tableSanPham.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				BindingSanPham();
			}});
		tableSanPham.setFont(new Font("Arial", Font.PLAIN, 14));
		tableSanPham.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableSanPham.setBounds(10, 403, 295, -314);
		JScrollPane scrollPane1 = new JScrollPane(tableSanPham);
		scrollPane1.setBounds(10, 71, 628, 387);
		pnMain.add(scrollPane1);
		
		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setFont(new Font("Arial", Font.BOLD, 14));
		lblSDT.setBounds(648, 71, 110, 30);
		pnMain.add(lblSDT);
		
		txtfSDT = new JTextField();
		txtfSDT.setFont(new Font("Arial", Font.BOLD, 14));
		txtfSDT.setColumns(10);
		txtfSDT.setBounds(768, 71, 200, 30);
		pnMain.add(txtfSDT);
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng");
		lblMaKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaKhachHang.setBounds(648, 113, 110, 30);
		pnMain.add(lblMaKhachHang);
		
		txtfMaKhachHang = new JTextField();
		txtfMaKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		txtfMaKhachHang.setEnabled(false);
		txtfMaKhachHang.setColumns(10);
		txtfMaKhachHang.setBounds(768, 112, 200, 30);	
		pnMain.add(txtfMaKhachHang);
		
		JLabel lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		lblKhachHang.setBounds(648, 155, 110, 30);
		pnMain.add(lblKhachHang);
		
		txtfTenKhachHang = new JTextField();
		txtfTenKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		txtfTenKhachHang.setEnabled(false);
		txtfTenKhachHang.setColumns(10);
		txtfTenKhachHang.setBounds(768, 154, 200, 30);
		pnMain.add(txtfTenKhachHang);

		JLabel lblLoaiSanPham = new JLabel("Loại Sản Phẩm");
		lblLoaiSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		lblLoaiSanPham.setBounds(648, 196, 110, 30);
		pnMain.add(lblLoaiSanPham);
		
		cbLoaiSanPham = new JComboBox<String>();
		cbLoaiSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		cbLoaiSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadDSSanPham();
			}
		});
		cbLoaiSanPham.setBounds(768, 196, 200, 30);
		pnMain.add(cbLoaiSanPham);
		loadDataCmbLoai();
		
		JLabel lblMaSanPham = new JLabel("Mã Sản Phẩm");
		lblMaSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaSanPham.setBounds(648, 237, 110, 30);
		pnMain.add(lblMaSanPham);
		
		txtfMaSanPham = new JTextField();
		txtfMaSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		txtfMaSanPham.setEnabled(false);
		txtfMaSanPham.setBounds(768, 238, 200, 30);
		pnMain.add(txtfMaSanPham);
		txtfMaSanPham.setColumns(10);
		
		JLabel lblTenSanPham = new JLabel("Tên Sản Phẩm");
		lblTenSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenSanPham.setBounds(648, 278, 110, 37);
		pnMain.add(lblTenSanPham);
		
		txtfTenSanPham = new JTextField();
		txtfTenSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		txtfTenSanPham.setEnabled(false);
		txtfTenSanPham.setColumns(10);
		txtfTenSanPham.setBounds(768, 282, 200, 30);
		pnMain.add(txtfTenSanPham);
		
		JLabel lblSoLuong = new JLabel("Số Lượng");
		lblSoLuong.setFont(new Font("Arial", Font.BOLD, 14));
		lblSoLuong.setBounds(648, 326, 110, 30);
		pnMain.add(lblSoLuong);
		
		SpinnerModel spinnerModel = new SpinnerNumberModel(0,0,100,1);
		spinnerSoLuong = new JSpinner(spinnerModel);
		spinnerSoLuong.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerSoLuong.setBounds(768, 327, 200, 30);
		pnMain.add(spinnerSoLuong);
		
		JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên");
		lblMaNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaNhanVien.setBounds(648, 367, 110, 37);
		pnMain.add(lblMaNhanVien);
		
		txtfMaNhanVien = new JTextField();
		txtfMaNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		txtfMaNhanVien.setEnabled(false);
		txtfMaNhanVien.setColumns(10);
		txtfMaNhanVien.setBounds(768, 371, 200, 30);
		txtfMaNhanVien.setText(String.valueOf(UsersLogin.getNhanVien_ID()));
		pnMain.add(txtfMaNhanVien);
		
		JLabel lblNhanVien = new JLabel("Nhân Viên");
		lblNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		lblNhanVien.setBounds(648, 415, 110, 37);
		pnMain.add(lblNhanVien);
		
		txtfNhanVien = new JTextField();
		txtfNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		txtfNhanVien.setEnabled(false);
		txtfNhanVien.setColumns(10);
		txtfNhanVien.setBounds(768, 419, 200, 30);
		txtfNhanVien.setText(UsersLogin.getNhanVien_Name());
		pnMain.add(txtfNhanVien);

		btnTimKiemKH = new JButton("Tìm Kiếm Khách Hàng");
		btnTimKiemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KiemTraKhachHang();
			}
		});
		btnTimKiemKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTimKiemKH.setForeground(Color.WHITE);
		btnTimKiemKH.setFont(new Font("Arial", Font.BOLD, 14));
		btnTimKiemKH.setFocusPainted(false);
		btnTimKiemKH.setBorderPainted(false);
		btnTimKiemKH.setBackground(Color.ORANGE);
		btnTimKiemKH.setBounds(647, 664, 351, 35);
		ImageIcon iconTimKiem = new ImageIcon(this.getClass().getResource("/search.png"));
		Image newimgTimKiem = iconTimKiem.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconTimKiem = new ImageIcon(newimgTimKiem);
		btnTimKiemKH.setIcon(iconTimKiem);
		pnMain.add(btnTimKiemKH);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVaoChiTietHoaDon();
			}
		});
		btnThem.setEnabled(false);
		btnThem.setFocusPainted(false);
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBorderPainted(false);
		btnThem.setBackground(new Color(102, 153, 102));
		btnThem.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem.setBounds(648, 710, 170, 35);
		ImageIcon iconThem = new ImageIcon(this.getClass().getResource("/add.png"));
		Image newimgThem = iconThem.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconThem = new ImageIcon(newimgThem);
		btnThem.setIcon(iconThem);
		pnMain.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteChiTietHoaDon();
			}
		});
		btnXoa.setEnabled(false);
		btnXoa.setFocusPainted(false);
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setBorderPainted(false);
		btnXoa.setBackground(new Color(204, 0, 0));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoa.setBounds(828, 710, 170, 35);
		ImageIcon iconXoa = new ImageIcon(this.getClass().getResource("/delete.png"));
		Image newimgXoa = iconXoa.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconXoa = new ImageIcon(newimgXoa);
		btnXoa.setIcon(iconXoa);
		pnMain.add(btnXoa);
		ImageIcon iconSua = new ImageIcon(this.getClass().getResource("/edit.png"));
		Image newimgSua = iconSua.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconSua = new ImageIcon(newimgSua);
		
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThanhToanHoaDon();
			}
		});
		btnThanhToan.setEnabled(false);
		btnThanhToan.setFocusPainted(false);
		btnThanhToan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThanhToan.setBorderPainted(false);
		btnThanhToan.setBackground(new Color(0, 0, 0));
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 14));
		btnThanhToan.setBounds(647, 755, 351, 35);
		ImageIcon iconThanhToan = new ImageIcon(this.getClass().getResource("/print.png"));
		Image newimgThanhToan = iconThanhToan.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconThanhToan = new ImageIcon(newimgThanhToan);
		btnThanhToan.setIcon(iconThanhToan);
		pnMain.add(btnThanhToan);
		
		btnThemHD = new JButton("Thêm Hóa Đơn");
		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddHoaDon();
			}
		});
		btnThemHD.setForeground(Color.WHITE);
		btnThemHD.setFont(new Font("Arial", Font.BOLD, 14));
		btnThemHD.setFocusPainted(false);
		btnThemHD.setBorderPainted(false);
		btnThemHD.setBackground(new Color(102, 153, 102));
		btnThemHD.setBounds(648, 618, 170, 35);
		btnThemHD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnMain.add(btnThemHD);
		
		btnXoaHD = new JButton("Xoá Hóa Đơn");
		btnXoaHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteHoaDon();
			}
		});
		btnXoaHD.setEnabled(false);
		btnXoaHD.setForeground(Color.WHITE);
		btnXoaHD.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoaHD.setFocusPainted(false);
		btnXoaHD.setBorderPainted(false);
		btnXoaHD.setBackground(new Color(204, 0, 0));
		btnXoaHD.setBounds(828, 618, 170, 35);
		btnXoaHD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnMain.add(btnXoaHD);
		
		JButton btnXemHoaDon = new JButton("Xem Hóa Đơn");
		btnXemHoaDon.setFocusPainted(false);
		btnXemHoaDon.setBorderPainted(false);
		btnXemHoaDon.setBackground(new Color(72, 209, 204));
		btnXemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormHoaDonBan frm = new FormHoaDonBan();
				frm.Frame.setVisible(true);
			}
		});
		btnXemHoaDon.setFont(new Font("Arial", Font.BOLD, 14));
		btnXemHoaDon.setBounds(10, 11, 144, 50);
		btnXemHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnMain.add(btnXemHoaDon);
		
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
    private void loadDataCmbLoai() {
        cbLoaiSanPham.removeAllItems();
        ArrayList<LoaiSanPhamDTO> dsl = LSPBLL.LayDSLoaiSanPham();
        for (LoaiSanPhamDTO loai : dsl) {
        	cbLoaiSanPham.addItem(loai.getLoaiSanPham_ID() + " - " + loai.getLoaiSanPham_Name());
        }
    }
	private void LoadDSSanPham(){
		DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }};
		tableSanPham.setModel(dtm);
		dtm.addColumn("Mã SP");
		dtm.addColumn("Tên Sản Phẩm");
		dtm.addColumn("Giá");
		dtm.addColumn("SL Tồn Kho");
		tableSanPham.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableSanPham.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableSanPham.getColumnModel().getColumn(1).setPreferredWidth(390);
		tableSanPham.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableSanPham.getColumnModel().getColumn(3).setPreferredWidth(80);
		String LoaiSanPham = cbLoaiSanPham.getSelectedItem().toString();
		int int0 = LoaiSanPham.charAt(0);
		int MaLoaiSanPham = int0 - '0';
		Vector<SanPhamDTO> arr = SPBLL.LayDSSanPhamTheoLoai(MaLoaiSanPham);
		for(int i = 0;i<arr.size();i++){
			SanPhamDTO SP = arr.get(i);
			String id = SP.getSanPham_ID();
			String name = SP.getSanPham_Name();
			int price = SP.getSanPham_Price();
			int amount = SP.getSanPham_Amount();
			Object[] row = {id,name,price,amount};
			dtm.addRow(row);
		}
	}
	private void BindingSanPham(){
		try {
			int row = tableSanPham.getSelectedRow();
			txtfMaSanPham.setText(tableSanPham.getModel().getValueAt(row, 0).toString());
			txtfTenSanPham.setText(tableSanPham.getModel().getValueAt(row, 1).toString());
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	private void LoadChiTietHoaDon() {
		dtmHD = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
		    return false;
		}};
		tableHoaDon.setModel(dtmHD);
		dtmHD.addColumn("Mã SP");
		dtmHD.addColumn("Tên Sản Phẩm");
		dtmHD.addColumn("Giá");
		dtmHD.addColumn("SL Mua");
		dtmHD.addColumn("Thành Tiền");
		tableHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableHoaDon.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableHoaDon.getColumnModel().getColumn(1).setPreferredWidth(390);
		tableHoaDon.getColumnModel().getColumn(2).setPreferredWidth(52);
		tableHoaDon.getColumnModel().getColumn(3).setPreferredWidth(52);
		tableHoaDon.getColumnModel().getColumn(4).setPreferredWidth(54);
	}

	private void AddHoaDon() {
		try {
		if (txtfMaKhachHang.getText().trim().equals("")) 
		{
			JOptionPane.showMessageDialog(null,"Vui lòng kiểm tra số điện thoại khách hàng");
		} else {
			btnThemHD.setEnabled(false);
			btnXoaHD.setEnabled(true);
			btnTimKiemKH.setEnabled(false);
			btnThem.setEnabled(true);
			btnXoa.setEnabled(true);
			btnThanhToan.setEnabled(true);
			HDB.setHoaDonBan_IDKH(Integer.parseInt(txtfMaKhachHang.getText()));
			HDB.setHoaDonBan_IDNV(Integer.parseInt(txtfMaNhanVien.getText()));
			HDB.setHoaDonBan_DateHD(Date.valueOf(LocalDate.now()));
			JOptionPane.showMessageDialog(null,HDBBLL.addHoaDon(HDB));
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void DeleteHoaDon() {
		try{
			JOptionPane.showMessageDialog(null,HDBBLL.deleteHoaDon());
			btnThemHD.setEnabled(true);
			btnXoaHD.setEnabled(false);
			btnTimKiemKH.setEnabled(true);
			btnThem.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThanhToan.setEnabled(false);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	private void KiemTraKhachHang() {
		try {
			txtfMaKhachHang.setText("");
			txtfTenKhachHang.setText("");
			if (txtfSDT.getText().length()>10 || txtfSDT.getText().length()<10){
				JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng số điện thoại");
			} else if (KHBLL.hasKhachHang_PhoneNumber(Integer.parseInt(txtfSDT.getText())).equals(false)) {
				JOptionPane.showMessageDialog(null,"Khách hàng không tồn tại");
			} else {
				JOptionPane.showMessageDialog(null,"Khách hàng có tồn tại");
				Vector<KhachHangDTO> arr = KHBLL.LayDSKhachHangTheoSDT(Integer.parseInt(txtfSDT.getText()));
				for(int i = 0;i<arr.size();i++) {
					KH = arr.get(i);
					txtfMaKhachHang.setText(String.valueOf(KH.getKhachHang_ID()));
					txtfTenKhachHang.setText(KH.getKhachHang_Name());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void AddVaoChiTietHoaDon() {
		try {
		if (txtfMaSanPham.getText().trim().equals("") ||
			txtfTenSanPham.getText().trim().equals("") ||
			spinnerSoLuong.getValue().equals(0) ||
			spinnerSoLuong.getValue().equals("") ) {
			JOptionPane.showMessageDialog(null,"Vui lòng chọn sản phẩm và nhập số lượng");
		} else {
			int row = tableSanPham.getSelectedRow();
			int SLMua = (Integer.parseInt(spinnerSoLuong.getValue().toString()));
			int TonKho = (Integer.parseInt(tableSanPham.getModel().getValueAt(row, 3).toString()));
			if ((SLMua > TonKho || TonKho <=0)) {
					JOptionPane.showMessageDialog(null,"Sản phẩm trong kho không đủ");
			} else {
					String id = txtfMaSanPham.getText();
					String name = txtfTenSanPham.getText();
					int price = (Integer.parseInt(tableSanPham.getModel().getValueAt(row, 2).toString()));
					int total = (SLMua * price);
					Object[] dtmrow = {id,name,price,SLMua,total};
					dtmHD.addRow(dtmrow);
					btnThanhToan.setEnabled(true);
					//Xử lý thêm vào CTHDB trong database
					int idhdb = HDBBLL.LayHoaDonMoiNhat();
					CTHDBanDTO CTHDB = new CTHDBanDTO();
					CTHDB.setCTHDBan_ID(idhdb);
					CTHDB.setCTHDBan_IDSP(id);
					CTHDB.setCTHDBan_Amount(SLMua);
					CTHDB.setCTHDBan_Price(price);
					CTHDB.setCTHDBan_TotalPrice(total);
					if(CTHDBBLL.kiemtraCTHDBan(CTHDB)) //Kiểm tra trùng sản phẩn trong CTHDBán
						CTHDBBLL.addCTHDBan(CTHDB);
					//Xử lý cập nhật tồn kho sản phẩm trong database
					int TonKhoMoi = TonKho - SLMua;
					SPBLL.UpdateSLSanPham(id,TonKhoMoi);
					//Xử lý cập nhật lại tổng tiền
					TongTien =(TongTien + (CTHDB.getCTHDBan_TotalPrice()));
					LoadDSSanPham();
			}
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void DeleteChiTietHoaDon () {
		try {
			int row = tableHoaDon.getSelectedRow();
			int idhdb = HDBBLL.LayHoaDonMoiNhat();
			String idsp = (tableHoaDon.getModel().getValueAt(row, 0).toString());
			int ThanhTien = (Integer.parseInt(tableHoaDon.getModel().getValueAt(row, 4).toString()));
			int SLMua = (Integer.parseInt(tableHoaDon.getModel().getValueAt(row, 3).toString()));
			int TonKho = SPBLL.LaySLSPTheoMaSP(idsp);
			System.out.println("Ton Kho ="+TonKho);
			int TonKhoMoi = (TonKho + SLMua);
			TongTien = (TongTien - ThanhTien);
			//Cập nhật dữ liệu trong database khi xoá chi tiết hoá đơn
			SPBLL.UpdateSLSanPham(idsp,TonKhoMoi);
			JOptionPane.showMessageDialog(null,CTHDBBLL.deleteCTHDBan(idhdb, idsp));
			((DefaultTableModel)tableHoaDon.getModel()).removeRow(row);
			LoadDSSanPham();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void ThanhToanHoaDon() {
		try{
			JOptionPane.showMessageDialog(null,HDBBLL.ThanhToan(TongTien));
			btnThemHD.setEnabled(true);
			btnXoaHD.setEnabled(false);
			btnTimKiemKH.setEnabled(true);
			btnThem.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThanhToan.setEnabled(false);
			txtfMaKhachHang.setText("");
			txtfTenKhachHang.setText("");
			txtfSDT.setText("");
			txtfTenSanPham.setText("");
			txtfMaSanPham.setText("");
	        ArrayList<Vector> dsGioHang = new ArrayList<>();
	        int row = tableHoaDon.getRowCount();
	        if (row == 0) return;
	        for (int i = 0; i < row; i++) {
	            Vector vec = new Vector();
	            vec.add(tableHoaDon.getValueAt(i, 0));
	            vec.add(tableHoaDon.getValueAt(i, 1));
	            vec.add(tableHoaDon.getValueAt(i, 2));
	            vec.add(tableHoaDon.getValueAt(i, 3));
	            vec.add(tableHoaDon.getValueAt(i, 4));
	            dsGioHang.add(vec);
	        }
			DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
			model.setRowCount(0);
			HDB.setHoaDonBan_ID(HDBBLL.LayHoaDonMoiNhat());
			HDB.setHoaDonBan_Total(TongTien);
			FormXuatHoaDonBan frm = new FormXuatHoaDonBan(HDB,dsGioHang,UsersLogin,KH);
			frm.Frame.setVisible(true);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}