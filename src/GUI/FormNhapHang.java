package GUI;

import DTO.NhanVienDTO;
import DTO.NhaCungCapDTO;
import DTO.SanPhamDTO;
import DTO.LoaiSanPhamDTO;
import DTO.PhieuNhapDTO;
import DTO.CTPhieuNhapDTO;
import DTO.KhachHangDTO;
import BLL.NhaCungCapBLL;
import BLL.SanPhamBLL;
import BLL.LoaiSanPhamBLL;
import BLL.PhieuNhapBLL;
import BLL.CTPhieuNhapBLL;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class FormNhapHang {
	
	protected JFrame Frame;
	private NhanVienDTO UsersLogin;
	private NhaCungCapBLL NCCBLL = new NhaCungCapBLL();
	private SanPhamBLL SPBLL = new SanPhamBLL();
	private LoaiSanPhamBLL LSPBLL = new LoaiSanPhamBLL();
	private PhieuNhapBLL PNBLL = new PhieuNhapBLL();
	private CTPhieuNhapBLL CTPNBLL = new CTPhieuNhapBLL();
	private NhaCungCapDTO NCCDTO = new NhaCungCapDTO();
	private PhieuNhapDTO PNDTO = new PhieuNhapDTO();
	private JButton btnTongQuan,btnBanSanPham,btnDichVu,btnQuanLyKhachHang,btnQuanLyNhapHang,btnQuanLyNhanVien,btnQuanLySanPham,btnDoanhThu,btnDangXuat;
	private JButton btnThemPN,btnXoaPN,btnTimKiemNCC,btnThem,btnXoa,btnThanhToan;
	private JComboBox<String> cbLoaiSanPham;
	private JSpinner spinnerSoLuong;
	private JTable tablePhieuNhap,tableSanPham;
	private JTextField txtfSDT,txtfMaNCC,txtfTenNCC,txtfMaSanPham,txtfTenSanPham,txtfMaNhanVien,txtfNhanVien;
	private JButton btnXemPhieuNhap,btnNhaCungCap;
	private DefaultTableModel dtmPN;
	private int TongTien = 0;
	
	public FormNhapHang(NhanVienDTO UserLogin) {
		UsersLogin = UserLogin;
		initComponents();
		PhanQuyen(UsersLogin);
		LoadChiTietPhieuNhap();
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
		
		JPanel PNDTOSideMenu = new JPanel();
		PNDTOSideMenu.setBounds(0, 0, 272, 800);
		PNDTOSideMenu.setBackground(new Color(0, 191, 255));
		Frame.getContentPane().add(PNDTOSideMenu);
		PNDTOSideMenu.setLayout(null);

		JLabel logo = new JLabel();
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/logo.png"));
		logo.setIcon(img);
		logo.setBounds(0, 0, 115, 102);
		PNDTOSideMenu.add(logo);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setText("<html>World<br>Computer</html>");
		lblTitle.setBounds(113, 0, 159, 102);
		PNDTOSideMenu.add(lblTitle);
		
		JLabel lblQuanLyCuaHang = new JLabel("Quản lý cửa hàng");
		lblQuanLyCuaHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLyCuaHang.setFont(new Font("Arial", Font.BOLD, 28));
		lblQuanLyCuaHang.setForeground(new Color(255, 250, 250));
		lblQuanLyCuaHang.setBounds(0, 124, 272, 55);
		PNDTOSideMenu.add(lblQuanLyCuaHang);
				
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
		PNDTOSideMenu.add(btnTongQuan);
		
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
		PNDTOSideMenu.add(btnBanSanPham);
	
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
		PNDTOSideMenu.add(btnDichVu);
				
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
		PNDTOSideMenu.add(btnQuanLyKhachHang);
		
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
				btnQuanLyNhapHang.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/5. activedelivery.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnQuanLyNhapHang.setIcon(icon);
	         }
		});
		btnQuanLyNhapHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyNhapHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyNhapHang.setFont(new Font("Arial", Font.PLAIN, 20));
		btnQuanLyNhapHang.setForeground(new Color(255, 250, 250));
		btnQuanLyNhapHang.setBackground(new Color(100, 149, 237));
		btnQuanLyNhapHang.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnQuanLyNhapHang.setBounds(0, 481, 272, 55);
		ImageIcon iconQLNH = new ImageIcon(this.getClass().getResource("/5. activedelivery.png"));
		Image newimgQLNH = iconQLNH.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconQLNH = new ImageIcon(newimgQLNH);
		btnQuanLyNhapHang.setIcon(iconQLNH);
		PNDTOSideMenu.add(btnQuanLyNhapHang);
		
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
		PNDTOSideMenu.add(btnQuanLyNhanVien);
		
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
		PNDTOSideMenu.add(btnQuanLySanPham);
		
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
		PNDTOSideMenu.add(btnDoanhThu);
		
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
		PNDTOSideMenu.add(btnDangXuat);
		
        /*
        ============================================================
                                MAIN PANEL           
        ============================================================
         */
		
		JPanel PNDTOMain = new JPanel();
		PNDTOMain.setBounds(272, 0, 1008, 800);
		PNDTOMain.setLayout(null);
		PNDTOMain.setBackground(new Color(247, 248, 252));
		Frame.getContentPane().add(PNDTOMain);
		
		JLabel lblTieuDe = new JLabel("Quản Lý Nhập Hàng");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Arial", Font.PLAIN, 26));
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setBounds(320, 11, 318, 50);
		PNDTOMain.add(lblTieuDe);
		
		tablePhieuNhap = new JTable();
		tablePhieuNhap.setFont(new Font("Arial", Font.PLAIN, 14));
		tablePhieuNhap.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablePhieuNhap.setBounds(10, 339, 988, 450);
		JScrollPane scrollPane = new JScrollPane(tablePhieuNhap);
		scrollPane.setBounds(10, 468, 628, 322);
		PNDTOMain.add(scrollPane);
		
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
		PNDTOMain.add(scrollPane1);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Arial", Font.BOLD, 14));
		lblSDT.setBounds(648, 71, 110, 30);
		PNDTOMain.add(lblSDT);
		
		txtfSDT = new JTextField();
		txtfSDT.setFont(new Font("Arial", Font.BOLD, 14));
		txtfSDT.setColumns(10);
		txtfSDT.setBounds(768, 71, 200, 30);
		PNDTOMain.add(txtfSDT);
		
		JLabel lblMaNCC = new JLabel("Mã NCC");
		lblMaNCC.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaNCC.setBounds(648, 113, 110, 30);
		PNDTOMain.add(lblMaNCC);
		
		txtfMaNCC = new JTextField();
		txtfMaNCC.setFont(new Font("Arial", Font.BOLD, 14));
		txtfMaNCC.setEnabled(false);
		txtfMaNCC.setColumns(10);
		txtfMaNCC.setBounds(768, 112, 200, 30);	
		PNDTOMain.add(txtfMaNCC);
		
		JLabel lblNhaCungCap = new JLabel("Nhà Cung Cấp");
		lblNhaCungCap.setFont(new Font("Arial", Font.BOLD, 14));
		lblNhaCungCap.setBounds(648, 155, 110, 30);
		PNDTOMain.add(lblNhaCungCap);
		
		txtfTenNCC = new JTextField();
		txtfTenNCC.setFont(new Font("Arial", Font.BOLD, 14));
		txtfTenNCC.setEnabled(false);
		txtfTenNCC.setColumns(10);
		txtfTenNCC.setBounds(768, 154, 200, 30);
		PNDTOMain.add(txtfTenNCC);

		JLabel lblLoaiSanPham = new JLabel("Loại Sản Phẩm");
		lblLoaiSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		lblLoaiSanPham.setBounds(648, 196, 110, 30);
		PNDTOMain.add(lblLoaiSanPham);
		
		cbLoaiSanPham = new JComboBox<String>();
		cbLoaiSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		cbLoaiSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadDSSanPham();
			}
		});
		cbLoaiSanPham.setBounds(768, 196, 200, 30);
		PNDTOMain.add(cbLoaiSanPham);
		loadDataCmbLoai();
		
		JLabel lblMaSanPham = new JLabel("Mã Sản Phẩm");
		lblMaSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaSanPham.setBounds(648, 237, 110, 30);
		PNDTOMain.add(lblMaSanPham);
		
		txtfMaSanPham = new JTextField();
		txtfMaSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		txtfMaSanPham.setEnabled(false);
		txtfMaSanPham.setBounds(768, 238, 200, 30);
		PNDTOMain.add(txtfMaSanPham);
		txtfMaSanPham.setColumns(10);
		
		JLabel lblTenSanPham = new JLabel("Tên Sản Phẩm");
		lblTenSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenSanPham.setBounds(648, 278, 110, 37);
		PNDTOMain.add(lblTenSanPham);
		
		txtfTenSanPham = new JTextField();
		txtfTenSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		txtfTenSanPham.setEnabled(false);
		txtfTenSanPham.setColumns(10);
		txtfTenSanPham.setBounds(768, 282, 200, 30);
		PNDTOMain.add(txtfTenSanPham);
		
		JLabel lblSoLuong = new JLabel("Số Lượng");
		lblSoLuong.setFont(new Font("Arial", Font.BOLD, 14));
		lblSoLuong.setBounds(648, 326, 110, 30);
		PNDTOMain.add(lblSoLuong);
		
		SpinnerModel spinnerModel = new SpinnerNumberModel(0,0,100,1);
		spinnerSoLuong = new JSpinner(spinnerModel);
		spinnerSoLuong.setFont(new Font("Arial", Font.BOLD, 14));
		spinnerSoLuong.setBounds(768, 327, 200, 30);
		PNDTOMain.add(spinnerSoLuong);
		
		JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên");
		lblMaNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaNhanVien.setBounds(648, 367, 110, 37);
		PNDTOMain.add(lblMaNhanVien);
		
		txtfMaNhanVien = new JTextField();
		txtfMaNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		txtfMaNhanVien.setEnabled(false);
		txtfMaNhanVien.setColumns(10);
		txtfMaNhanVien.setBounds(768, 371, 200, 30);
		txtfMaNhanVien.setText(String.valueOf(UsersLogin.getNhanVien_ID()));
		PNDTOMain.add(txtfMaNhanVien);
		
		JLabel lblNhanVien = new JLabel("Nhân Viên");
		lblNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		lblNhanVien.setBounds(648, 415, 110, 37);
		PNDTOMain.add(lblNhanVien);
		
		txtfNhanVien = new JTextField();
		txtfNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		txtfNhanVien.setEnabled(false);
		txtfNhanVien.setColumns(10);
		txtfNhanVien.setBounds(768, 419, 200, 30);
		txtfNhanVien.setText(UsersLogin.getNhanVien_Name());
		PNDTOMain.add(txtfNhanVien);

		btnTimKiemNCC = new JButton("Tìm Kiếm Nhà Cung Cấp");
		btnTimKiemNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KiemTraNhaCungCap();
			}
		});
		btnTimKiemNCC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTimKiemNCC.setForeground(Color.WHITE);
		btnTimKiemNCC.setFont(new Font("Arial", Font.BOLD, 14));
		btnTimKiemNCC.setFocusPainted(false);
		btnTimKiemNCC.setBorderPainted(false);
		btnTimKiemNCC.setBackground(Color.ORANGE);
		btnTimKiemNCC.setBounds(647, 664, 351, 35);
		ImageIcon iconTimKiem = new ImageIcon(this.getClass().getResource("/search.png"));
		Image newimgTimKiem = iconTimKiem.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconTimKiem = new ImageIcon(newimgTimKiem);
		btnTimKiemNCC.setIcon(iconTimKiem);
		PNDTOMain.add(btnTimKiemNCC);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVaoChiTietPhieuNhap();
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
		PNDTOMain.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteChiTietPhieuNhap();
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
		PNDTOMain.add(btnXoa);
		ImageIcon iconSua = new ImageIcon(this.getClass().getResource("/edit.png"));
		Image newimgSua = iconSua.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconSua = new ImageIcon(newimgSua);
		
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThanhToanPhieuNhap();
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
		PNDTOMain.add(btnThanhToan);
		
		btnThemPN = new JButton("Thêm Phiếu Nhập");
		btnThemPN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPhieuNhap();
			}
		});
		btnThemPN.setForeground(Color.WHITE);
		btnThemPN.setFont(new Font("Arial", Font.BOLD, 14));
		btnThemPN.setFocusPainted(false);
		btnThemPN.setBorderPainted(false);
		btnThemPN.setBackground(new Color(102, 153, 102));
		btnThemPN.setBounds(648, 618, 170, 35);
		btnThemPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PNDTOMain.add(btnThemPN);
		
		btnXoaPN = new JButton("Xoá Phiếu Nhập");
		btnXoaPN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePhieuNhap();
			}
		});
		btnXoaPN.setEnabled(false);
		btnXoaPN.setForeground(Color.WHITE);
		btnXoaPN.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoaPN.setFocusPainted(false);
		btnXoaPN.setBorderPainted(false);
		btnXoaPN.setBackground(new Color(204, 0, 0));
		btnXoaPN.setBounds(828, 618, 170, 35);
		btnXoaPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PNDTOMain.add(btnXoaPN);
		
		btnXemPhieuNhap = new JButton("Xem Phiếu Nhập");
		btnXemPhieuNhap.setFocusPainted(false);
		btnXemPhieuNhap.setBorderPainted(false);
		btnXemPhieuNhap.setBackground(new Color(72, 209, 204));
		btnXemPhieuNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormHoaDonPhieuNhap frm = new FormHoaDonPhieuNhap();
				frm.Frame.setVisible(true);
			}
		});
		btnXemPhieuNhap.setFont(new Font("Arial", Font.BOLD, 14));
		btnXemPhieuNhap.setBounds(10, 11, 170, 50);
		btnXemPhieuNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PNDTOMain.add(btnXemPhieuNhap);
		
		btnNhaCungCap = new JButton("Nhà Cung Cấp");
		btnNhaCungCap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormNhaCungCap frm = new FormNhaCungCap();
				frm.Frame.setVisible(true);
			}
		});
		btnNhaCungCap.setFont(new Font("Arial", Font.BOLD, 14));
		btnNhaCungCap.setFocusPainted(false);
		btnNhaCungCap.setBorderPainted(false);
		btnNhaCungCap.setBackground(new Color(72, 209, 204));
		btnNhaCungCap.setBounds(190, 11, 144, 50);
		PNDTOMain.add(btnNhaCungCap);
		
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
			btnNhaCungCap.setEnabled(false);
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
	private void LoadChiTietPhieuNhap() {
		dtmPN = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
		    return false;
		}};
		tablePhieuNhap.setModel(dtmPN);
		dtmPN.addColumn("Mã SP");
		dtmPN.addColumn("Tên Sản Phẩm");
		dtmPN.addColumn("Giá");
		dtmPN.addColumn("SL Nhập");
		dtmPN.addColumn("Thành Tiền");
		tablePhieuNhap.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablePhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(60);
		tablePhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(390);
		tablePhieuNhap.getColumnModel().getColumn(2).setPreferredWidth(52);
		tablePhieuNhap.getColumnModel().getColumn(3).setPreferredWidth(52);
		tablePhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(54);
	}
	private void AddPhieuNhap() {
		try {
		if (txtfMaNCC.getText().trim().equals("")) 
		{
			JOptionPane.showMessageDialog(null,"Vui lòng kiểm tra số điện thoại nhà cung cấp");
		} else {
			btnThemPN.setEnabled(false);
			btnXoaPN.setEnabled(true);
			btnTimKiemNCC.setEnabled(false);
			btnThem.setEnabled(true);
			btnXoa.setEnabled(true);
			btnThanhToan.setEnabled(true);
			PNDTO.setPhieuNhap_IDNCC(Integer.parseInt(txtfMaNCC.getText()));
			PNDTO.setPhieuNhap_IDNV(Integer.parseInt(txtfMaNhanVien.getText()));
			PNDTO.setPhieuNhap_Date(Date.valueOf(LocalDate.now()));
			JOptionPane.showMessageDialog(null,PNBLL.addPhieuNhap(PNDTO));
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void DeletePhieuNhap() {
		try{
			JOptionPane.showMessageDialog(null,PNBLL.deletePhieuNhap());
			btnThemPN.setEnabled(true);
			btnXoaPN.setEnabled(false);
			btnTimKiemNCC.setEnabled(true);
			btnThem.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThanhToan.setEnabled(false);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	private void KiemTraNhaCungCap() {
		try {
			txtfMaNCC.setText("");
			txtfTenNCC.setText("");
			if (txtfSDT.getText().length()>10 || txtfSDT.getText().length()<10){
				JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng số điện thoại");
			} else if (NCCBLL.hasNhaCungCap_PhoneNumber(Integer.parseInt(txtfSDT.getText())).equals(false)) {
				JOptionPane.showMessageDialog(null,"Nhà cung cấp không tồn tại");
			} else {
				JOptionPane.showMessageDialog(null,"Nhà cung cấp có tồn tại");
				Vector<NhaCungCapDTO> arr = NCCBLL.LayDSNhaCungCapTheoSDT(Integer.parseInt(txtfSDT.getText()));
				for(int i = 0;i<arr.size();i++) {
					NCCDTO = arr.get(i);
					txtfMaNCC.setText(String.valueOf(NCCDTO.getNhaCungCap_ID()));
					txtfTenNCC.setText(NCCDTO.getNhaCungCap_Name());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void AddVaoChiTietPhieuNhap() {
		try {
		if (txtfMaSanPham.getText().trim().equals("") ||
			txtfTenSanPham.getText().trim().equals("") ||
			spinnerSoLuong.getValue().equals(0) ||
			spinnerSoLuong.getValue().equals("") ) {
			JOptionPane.showMessageDialog(null,"Vui lòng chọn sản phẩm và nhập số lượng");
		} else {
			int row = tableSanPham.getSelectedRow();
			int SLNhap = (Integer.parseInt(spinnerSoLuong.getValue().toString()));
			int TonKho = (Integer.parseInt(tableSanPham.getModel().getValueAt(row, 3).toString()));
			String id = txtfMaSanPham.getText();
			String name = txtfTenSanPham.getText();
			int price = (Integer.parseInt(tableSanPham.getModel().getValueAt(row, 2).toString()));
			price = (price*95)/100;
			int total = (SLNhap * price);
			Object[] dtmrow = {id,name,price,SLNhap,total};
			dtmPN.addRow(dtmrow);
			btnThanhToan.setEnabled(true);
			//Xử lý thêm vào CTPN trong database
			int idPN = PNBLL.LayPhieuNhapMoiNhat();
			CTPhieuNhapDTO CTPNDTO = new CTPhieuNhapDTO();
			CTPNDTO.setCTPhieuNhap_ID(idPN);
			CTPNDTO.setCTPhieuNhap_IDSP(id);
			CTPNDTO.setCTPhieuNhap_Amount(SLNhap);
			CTPNDTO.setCTPhieuNhap_Price(price);
			CTPNDTO.setCTPhieuNhap_Total(total);
			if(CTPNBLL.kiemtraCTPN(CTPNDTO)) //Kiểm tra trùng sản phẩm trong CTPN
				CTPNBLL.addCTPN(CTPNDTO);
			//Xử lý cập nhật tồn kho sản phẩm trong database
			int TonKhoMoi = TonKho + SLNhap;
			SPBLL.UpdateSLSanPham(id,TonKhoMoi);
			//Xử lý cập nhật lại tổng tiền
			TongTien =(TongTien + (CTPNDTO.getCTPhieuNhap_Total()));
		} } catch (Exception e) {
			System.out.println(e);
		}
	}
	private void DeleteChiTietPhieuNhap () {
		try {
			int row = tablePhieuNhap.getSelectedRow();
			int idPN = PNBLL.LayPhieuNhapMoiNhat();
			String idsp = (tablePhieuNhap.getModel().getValueAt(row, 0).toString());
			int ThanhTien = (Integer.parseInt(tablePhieuNhap.getModel().getValueAt(row, 4).toString()));
			int SLNhap = (Integer.parseInt(tablePhieuNhap.getModel().getValueAt(row, 3).toString()));
			int TonKho = SPBLL.LaySLSPTheoMaSP(idsp);
			int TonKhoMoi = (TonKho - SLNhap);
			TongTien = (TongTien - ThanhTien);
			//Cập nhật dữ liệu trong database khi xoá chi tiết hoá đơn
			SPBLL.UpdateSLSanPham(idsp,TonKhoMoi);
			JOptionPane.showMessageDialog(null,CTPNBLL.deleteCTPN(idPN, idsp));
			((DefaultTableModel)tablePhieuNhap.getModel()).removeRow(row);
			LoadDSSanPham();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void ThanhToanPhieuNhap() {
		try{
			JOptionPane.showMessageDialog(null,PNBLL.ThanhToan(TongTien));
			btnThemPN.setEnabled(true);
			btnXoaPN.setEnabled(false);
			btnTimKiemNCC.setEnabled(true);
			btnThem.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThanhToan.setEnabled(false);
			txtfMaNCC.setText("");
			txtfTenNCC.setText("");
			txtfSDT.setText("");
			txtfTenSanPham.setText("");
			txtfMaSanPham.setText("");
	        ArrayList<Vector> dsGioHang = new ArrayList<>();
	        int row = tablePhieuNhap.getRowCount();
	        if (row == 0) return;
	        for (int i = 0; i < row; i++) {
	            Vector vec = new Vector();
	            vec.add(tablePhieuNhap.getValueAt(i, 0));
	            vec.add(tablePhieuNhap.getValueAt(i, 1));
	            vec.add(tablePhieuNhap.getValueAt(i, 2));
	            vec.add(tablePhieuNhap.getValueAt(i, 3));
	            vec.add(tablePhieuNhap.getValueAt(i, 4));
	            dsGioHang.add(vec);
	        }
			DefaultTableModel model = (DefaultTableModel) tablePhieuNhap.getModel();
			model.setRowCount(0);
			PNDTO.setPhieuNhap_ID(PNBLL.LayPhieuNhapMoiNhat());
			PNDTO.setPhieuNhap_Total(TongTien);
			FormXuatPhieuNhap frm = new FormXuatPhieuNhap(PNDTO,dsGioHang,UsersLogin,NCCDTO);
			frm.Frame.setVisible(true);
			LoadDSSanPham();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
