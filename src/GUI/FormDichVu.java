package GUI;

import DTO.NhanVienDTO;
import DTO.CTHDDichVuDTO;
import DTO.DichVuDTO;
import DTO.HoaDonDichVuDTO;
import DTO.KhachHangDTO;
import BLL.DichVuBLL;
import BLL.CTHDDichVuBLL;
import BLL.HoaDonDichVuBLL;
import BLL.KhachHangBLL;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class FormDichVu {

	protected JFrame Frame;
	private NhanVienDTO UsersLogin;
	private DichVuBLL DVBLL = new DichVuBLL();
	private CTHDDichVuBLL CTHDBLL = new CTHDDichVuBLL();
	private HoaDonDichVuBLL HDBLL = new HoaDonDichVuBLL();
	private KhachHangBLL KHBLL = new KhachHangBLL();
	private KhachHangDTO KH = new KhachHangDTO();
	private HoaDonDichVuDTO HDDV = new HoaDonDichVuDTO();
	private JButton btnTongQuan,btnBanSanPham,btnDichVu,btnQuanLyKhachHang,btnQuanLyNhapHang,btnQuanLyNhanVien,btnQuanLySanPham,btnDoanhThu,btnDangXuat;
	private JButton btnThemHD,btnXoaHD,btnTimKiemKH,btnThem,btnXoa,btnThanhToan;
	private JTable table;
	private JTextField txtfMaKhachHang,txtfTenKhachHang,txtfMaNhanVien,txtfTenNhanVien,txtfTenSanPham,txtfSoDienThoai,txtfGiaTien;
	private JComboBox<String> cbLoaiDichVu;
	private DefaultTableModel dtmHD;
	private int TongTien = 0;
	
	public FormDichVu(NhanVienDTO UserLogin) {
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
				btnDichVu.setBackground(new Color(100, 149, 237));
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/3. activeservice.png"));
				Image newimg = icon.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				btnDichVu.setIcon(icon);
	         }
		});
		btnDichVu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDichVu.setForeground(new Color(255, 250, 250));
		btnDichVu.setBackground(new Color(100, 149, 237));
		btnDichVu.setBorder(new EmptyBorder(0, 16, 0, 0));
		btnDichVu.setBounds(0, 349, 272, 55);
		ImageIcon iconDV = new ImageIcon(this.getClass().getResource("/3. activeservice.png"));
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
		pnMain.setBounds(262, 0, 1008, 800);
		pnMain.setLayout(null);
		pnMain.setBackground(new Color(247, 248, 252));
		Frame.getContentPane().add(pnMain);
		
		JLabel lblTieuDe = new JLabel("Dịch Vụ");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Arial", Font.PLAIN, 26));
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setBounds(320, 11, 318, 50);
		pnMain.add(lblTieuDe);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(115, 83, 452, 690);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(25, 83, 613, 706);
		pnMain.add(scrollPane);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng");
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenKhachHang.setBounds(647, 133, 137, 37);
		pnMain.add(lblTenKhachHang);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSoDienThoai.setBounds(647, 84, 137, 37);
		pnMain.add(lblSoDienThoai);
		
		txtfSoDienThoai = new JTextField();
		txtfSoDienThoai.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfSoDienThoai.setColumns(10);
		txtfSoDienThoai.setBounds(794, 92, 198, 29);
		pnMain.add(txtfSoDienThoai);
		
		JLabel lblTenSanPham = new JLabel("Tên Sản Phẩm");
		lblTenSanPham.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenSanPham.setBounds(647, 225, 137, 37);
		pnMain.add(lblTenSanPham);
		
		txtfTenSanPham = new JTextField();
		txtfTenSanPham.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfTenSanPham.setColumns(10);
		txtfTenSanPham.setBounds(794, 234, 198, 29);
		pnMain.add(txtfTenSanPham);
		
		JLabel lblLoaiDichVu = new JLabel("Loại Dịch Vụ");
		lblLoaiDichVu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLoaiDichVu.setBounds(647, 270, 137, 37);
		pnMain.add(lblLoaiDichVu);
		
		cbLoaiDichVu = new JComboBox<String>();
		cbLoaiDichVu.setFont(new Font("Arial", Font.PLAIN, 14));
		cbLoaiDichVu.setBounds(794, 278, 198, 29);
		pnMain.add(cbLoaiDichVu);
		loadDataCmbDichVu();
		
		JLabel lblGiaTien = new JLabel("Giá Tiền");
		lblGiaTien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGiaTien.setBounds(647, 322, 137, 37);
		pnMain.add(lblGiaTien);
		
		txtfGiaTien = new JTextField();
		txtfGiaTien.setFont(new Font("Arial", Font.PLAIN, 14));
		txtfGiaTien.setColumns(10);
		txtfGiaTien.setBounds(794, 326, 198, 29);
		pnMain.add(txtfGiaTien);
		
		JLabel lblNhanVien = new JLabel("Nhân Viên Phụ Trách");
		lblNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhanVien.setBounds(647, 369, 137, 37);
		pnMain.add(lblNhanVien);
		
		txtfTenKhachHang = new JTextField();
		txtfTenKhachHang.setEnabled(false);
		txtfTenKhachHang.setBounds(794, 141, 198, 29);
		pnMain.add(txtfTenKhachHang);
		txtfTenKhachHang.setColumns(10);
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách hàng");
		lblMaKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaKhachHang.setBounds(647, 181, 137, 33);
		pnMain.add(lblMaKhachHang);
		
		txtfMaKhachHang = new JTextField();
		txtfMaKhachHang.setEnabled(false);
		txtfMaKhachHang.setBounds(794, 186, 198, 29);
		pnMain.add(txtfMaKhachHang);
		txtfMaKhachHang.setColumns(10);
		
		txtfTenNhanVien = new JTextField();
		txtfTenNhanVien.setEnabled(false);
		txtfTenNhanVien.setBounds(794, 366, 198, 32);
		txtfTenNhanVien.setText(UsersLogin.getNhanVien_Name());
		pnMain.add(txtfTenNhanVien);
		txtfTenNhanVien.setColumns(10);
		
		JLabel lblMaNhanVien = new JLabel("Mã Nhân Viên");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaNhanVien.setBounds(647, 411, 137, 37);
		pnMain.add(lblMaNhanVien);
		
		txtfMaNhanVien = new JTextField();
		txtfMaNhanVien.setEnabled(false);
		txtfMaNhanVien.setBounds(794, 419, 198, 29);
		txtfMaNhanVien.setText(String.valueOf(UsersLogin.getNhanVien_ID()));
		pnMain.add(txtfMaNhanVien);
		txtfMaNhanVien.setColumns(10);
		
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
		btnThemHD.setBounds(649, 617, 170, 35);
		btnThemHD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnMain.add(btnThemHD);
		
		btnXoaHD = new JButton("Xoá Hóa Đơn");
		btnXoaHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteHoaDon();
			}
		});
		btnXoaHD.setForeground(Color.WHITE);
		btnXoaHD.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoaHD.setFocusPainted(false);
		btnXoaHD.setEnabled(false);
		btnXoaHD.setBorderPainted(false);
		btnXoaHD.setBackground(new Color(204, 0, 0));
		btnXoaHD.setBounds(829, 617, 170, 35);
		btnXoaHD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnMain.add(btnXoaHD);
		
		btnTimKiemKH = new JButton("Tìm Kiếm Khách Hàng");
		btnTimKiemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KiemTraKhachHang();
			}
		});
		btnTimKiemKH.setForeground(Color.WHITE);
		btnTimKiemKH.setFont(new Font("Arial", Font.BOLD, 14));
		btnTimKiemKH.setFocusPainted(false);
		btnTimKiemKH.setBorderPainted(false);
		btnTimKiemKH.setBackground(Color.ORANGE);
		btnTimKiemKH.setBounds(648, 663, 351, 35);
		ImageIcon iconTimKiem = new ImageIcon(this.getClass().getResource("/search.png"));
		Image newimgTimKiem = iconTimKiem.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconTimKiem = new ImageIcon(newimgTimKiem);
		btnTimKiemKH.setIcon(iconTimKiem);
		btnTimKiemKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnMain.add(btnTimKiemKH);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddChiTietHoaDon();
			}
		});
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem.setFocusPainted(false);
		btnThem.setEnabled(false);
		btnThem.setBorderPainted(false);
		btnThem.setBackground(new Color(102, 153, 102));
		btnThem.setBounds(649, 709, 170, 35);
		ImageIcon iconThem = new ImageIcon(this.getClass().getResource("/add.png"));
		Image newimgThem = iconThem.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconThem = new ImageIcon(newimgThem);
		btnThem.setIcon(iconThem);
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnMain.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteChiTietHoaDon();
			}
		});
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoa.setFocusPainted(false);
		btnXoa.setEnabled(false);
		btnXoa.setBorderPainted(false);
		btnXoa.setBackground(new Color(204, 0, 0));
		btnXoa.setBounds(829, 709, 170, 35);
		ImageIcon iconXoa = new ImageIcon(this.getClass().getResource("/delete.png"));
		Image newimgXoa = iconXoa.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconXoa = new ImageIcon(newimgXoa);
		btnXoa.setIcon(iconXoa);
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnMain.add(btnXoa);
		
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThanhToanHoaDon();
			}
		});
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 14));
		btnThanhToan.setFocusPainted(false);
		btnThanhToan.setEnabled(false);
		btnThanhToan.setBorderPainted(false);
		btnThanhToan.setBackground(Color.BLACK);
		btnThanhToan.setBounds(648, 754, 351, 35);
		ImageIcon iconThanhToan = new ImageIcon(this.getClass().getResource("/print.png"));
		Image newimgThanhToan = iconThanhToan.getImage().getScaledInstance(30,30, java.awt.Image.SCALE_SMOOTH);
		iconThanhToan = new ImageIcon(newimgThanhToan);
		btnThanhToan.setIcon(iconThanhToan);
		btnThanhToan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnMain.add(btnThanhToan);

		JButton btnXemHoaDon = new JButton("Xem Hóa Đơn");
		btnXemHoaDon.setFocusPainted(false);
		btnXemHoaDon.setBorderPainted(false);
		btnXemHoaDon.setBackground(new Color(72, 209, 204));
		btnXemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormHoaDonDichVu frm = new FormHoaDonDichVu();
				frm.Frame.setVisible(true);
			}
		});
		btnXemHoaDon.setFont(new Font("Arial", Font.BOLD, 14));
		btnXemHoaDon.setBounds(25, 11, 144, 50);
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
	
    private void loadDataCmbDichVu() {
        cbLoaiDichVu.removeAllItems();
        
        ArrayList<DichVuDTO> dsl = DVBLL.LayDSDV();
        for (DichVuDTO loai : dsl) {
        	cbLoaiDichVu.addItem(loai.getDichVu_ID() + " - " + loai.getDichVu_Name());
        }
    }
    
	private void LoadChiTietHoaDon() {
		dtmHD = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
		    return false;
		}};
		table.setModel(dtmHD);
		dtmHD.addColumn("Mã DV");
		dtmHD.addColumn("Tên Dịch Vụ");
		dtmHD.addColumn("Tên Sản Phẩm");
		dtmHD.addColumn("Giá tiền");
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(310);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);

	}
	
	private void KiemTraKhachHang() {
		try {
			txtfMaKhachHang.setText("");
			txtfTenKhachHang.setText("");
			if (txtfSoDienThoai.getText().length()>10 || txtfSoDienThoai.getText().length()<10){
				JOptionPane.showMessageDialog(null,"Vui lòng nhập đúng số điện thoại");
			} else if (KHBLL.hasKhachHang_PhoneNumber(Integer.parseInt(txtfSoDienThoai.getText())).equals(false)) {
				JOptionPane.showMessageDialog(null,"Khách hàng không tồn tại");
			} else {
				JOptionPane.showMessageDialog(null,"Khách hàng có tồn tại");
				Vector<KhachHangDTO> arr = KHBLL.LayDSKhachHangTheoSDT(Integer.parseInt(txtfSoDienThoai.getText()));
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
			HDDV.setHoaDonDichVu_IDKH(Integer.parseInt(txtfMaKhachHang.getText()));
			HDDV.setHoaDonDichVu_IDNV(Integer.parseInt(txtfMaNhanVien.getText()));
			HDDV.setHoaDonDichVu_NGLHD(Date.valueOf(LocalDate.now()));
			JOptionPane.showMessageDialog(null,HDBLL.addHoaDon(HDDV));
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void DeleteHoaDon() {
		try{
			JOptionPane.showMessageDialog(null,HDBLL.deleteHoaDon());
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
	private void AddChiTietHoaDon() {
		try {
		if (cbLoaiDichVu.getSelectedItem().equals("") ||
			txtfTenSanPham.getText().trim().equals("")||
			txtfGiaTien.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin!");
		} else {
			String LoaiDichVu = cbLoaiDichVu.getSelectedItem().toString();
			int iddv = LoaiDichVu.charAt(0);
			iddv = iddv -'0';
			String name = txtfTenSanPham.getText();
			int price = Integer.parseInt(txtfGiaTien.getText());
			String tendv = cbLoaiDichVu.getSelectedItem().toString();
			Object[] dtmrow = {iddv,tendv,name,price};
			dtmHD.addRow(dtmrow);
			
			int idhdb = HDBLL.LayHoaDonMoiNhat();
			CTHDDichVuDTO CTHDDV = new CTHDDichVuDTO();
			CTHDDV.setCTHDDichVu_ID(idhdb);
			CTHDDV.setCTHDDichVu_IDDV(iddv);
			CTHDDV.setCTHDDichVu_TenSP(name);
			CTHDDV.setCTHDDichVu_Price(price);
			if (CTHDBLL.kiemtraCTHDDV(CTHDDV))
				CTHDBLL.addCTHDDV(CTHDDV);
			//Xử lý cập nhật lại tổng tiền
			TongTien =(TongTien + (CTHDDV.getCTHDDichVu_Price()));
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void DeleteChiTietHoaDon () {	
		try {
			int row = table.getSelectedRow();
			int idhddv = HDBLL.LayHoaDonMoiNhat();
			String tenSP = (table.getModel().getValueAt(row, 2).toString());
			int iddv = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
			int GiaTien = (Integer.parseInt(table.getModel().getValueAt(row, 3).toString()));
			TongTien = (TongTien - GiaTien);
			JOptionPane.showMessageDialog(null,CTHDBLL.deleteCTHDDV(idhddv, tenSP, iddv));
			((DefaultTableModel)table.getModel()).removeRow(row);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void ThanhToanHoaDon() {
		try{
			JOptionPane.showMessageDialog(null,HDBLL.ThanhToan(TongTien));
			btnThemHD.setEnabled(true);
			btnXoaHD.setEnabled(false);
			btnTimKiemKH.setEnabled(true);
			btnThem.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThanhToan.setEnabled(false);
			txtfMaKhachHang.setText("");
			txtfTenKhachHang.setText("");
			txtfSoDienThoai.setText("");
			txtfTenSanPham.setText("");
			txtfGiaTien.setText("");
			
	        ArrayList<Vector> dsGioHang = new ArrayList<>();
	        int row = table.getRowCount();
	        if (row == 0) return;
	        for (int i = 0; i < row; i++) {
	            Vector vec = new Vector();
	            vec.add(table.getValueAt(i, 0));
	            vec.add(table.getValueAt(i, 1));
	            vec.add(table.getValueAt(i, 2));
	            vec.add(table.getValueAt(i, 3));
	            dsGioHang.add(vec);
	        }
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			HDDV.setHoaDonDichVu_ID(HDBLL.LayHoaDonMoiNhat());
			HDDV.setHoaDonDichVu_Total(TongTien);
			FormXuatHoaDonDichVu frm = new FormXuatHoaDonDichVu(HDDV,dsGioHang,UsersLogin,KH);
			frm.Frame.setVisible(true);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
