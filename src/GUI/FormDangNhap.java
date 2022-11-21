package GUI;

import DTO.NhanVienDTO;
import BLL.NhanVienBLL;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FormDangNhap {

	protected JFrame Frame;
	private JLabel OpenEye,HiddenEye;
	private JTextField txtfTenTaiKhoan;
	private JPasswordField txtfMatKhau;

	public static void main(String[] args) {
		FormDangNhap frm = new FormDangNhap();
		frm.Frame.setVisible(true);
	}

	public FormDangNhap() {
		initComponents();
	}

	public void initComponents() {
		Frame = new JFrame();
		Frame.getContentPane().setBackground(new Color(0, 191, 255));
		Frame.setSize(380, 582);
		Frame.setLocationRelativeTo(null);
		Frame.setResizable(false);
		Frame.setUndecorated(true);
		Frame.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel();
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Logo.png"));
		logo.setIcon(img);
		logo.setBounds(166, 40, 48, 48);
		Frame.getContentPane().add(logo);
		
		JLabel lblTitle1 = new JLabel("Chương Trình Quản Lý Máy Tính");
		lblTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblTitle1.setBounds(32, 100, 316, 24);
		Frame.getContentPane().add(lblTitle1);
		
		JLabel lblTitle2 = new JLabel("Đăng Nhập");
		lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTitle2.setBounds(32, 156, 316, 30);
		Frame.getContentPane().add(lblTitle2);
		
		JLabel lblHelp = new JLabel("Nhập vào tài khoản và mật khẩu bên dưới");
		lblHelp.setForeground(Color.GRAY);
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblHelp.setBounds(32, 198, 316, 20);
		Frame.getContentPane().add(lblHelp);
		
		JLabel lblUserName = new JLabel("Tài Khoản");
		lblUserName.setForeground(Color.GRAY);
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUserName.setBounds(32, 252, 316, 16);
		Frame.getContentPane().add(lblUserName);
		
		txtfTenTaiKhoan = new JTextField();
		txtfTenTaiKhoan.setMargin(new Insets(2, 10, 2, 2));
		txtfTenTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtfTenTaiKhoan.setBounds(32, 279, 316, 42);
		txtfTenTaiKhoan.setToolTipText("");
		Frame.getContentPane().add(txtfTenTaiKhoan);
		txtfTenTaiKhoan.setColumns(10);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(32, 332, 316, 16);
		Frame.getContentPane().add(lblPassword);
		
		OpenEye = new JLabel();
		OpenEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpenEye.setVisible(false);
				HiddenEye.setVisible(true);
				txtfMatKhau.setEchoChar((char)0);
			}
		});
		OpenEye.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/eyeview.png"));
		OpenEye.setIcon(img2);
		OpenEye.setBounds(318, 332, 30, 24);
		Frame.getContentPane().add(OpenEye);
		
		HiddenEye = new JLabel();
		HiddenEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpenEye.setVisible(true);
				HiddenEye.setVisible(false);
				txtfMatKhau.setEchoChar('*');
			}
		});
		HiddenEye.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img3 = new ImageIcon(this.getClass().getResource("/eyehidden.png"));
		HiddenEye.setIcon(img3);
		HiddenEye.setBounds(318, 332, 30, 24);
		HiddenEye.setVisible(false);
		Frame.getContentPane().add(HiddenEye);
		
		txtfMatKhau = new JPasswordField();
		txtfMatKhau.setMargin(new Insets(2, 10, 2, 2));
		txtfMatKhau.setEchoChar('*');
		txtfMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtfMatKhau.setBounds(32, 359, 316, 42);
		Frame.getContentPane().add(txtfMatKhau);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuLyDangNhap();
			}
		});
		btnDangNhap.setFocusPainted(false);
		btnDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDangNhap.setMargin(new Insets(8, 8, 8, 8));
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 18));   
		btnDangNhap.setBackground(new Color(100, 149, 237));
		btnDangNhap.setBorderPainted(false);
		btnDangNhap.setBounds(32, 442, 316, 48);
		Frame.getContentPane().add(btnDangNhap);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuLyThoat();
			}
		});
		btnThoat.setFocusPainted(false);
		btnThoat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnThoat.setBackground(Color.GRAY);
		btnThoat.setBorderPainted(false);
		btnThoat.setBounds(32, 500, 316, 48);
		Frame.getContentPane().add(btnThoat);
		
	}
	
    /*
    ============================================================
                            EVENTS           
    ============================================================
     */
	
	private void XuLyDangNhap() {
        NhanVienBLL USERSBLL = new NhanVienBLL();
        NhanVienDTO UserLogin = USERSBLL.GetTaiKhoanDangNhap(txtfTenTaiKhoan.getText(),txtfMatKhau.getText());
        if (UserLogin != null) {
            FormMainMenu frm = new FormMainMenu(UserLogin);
            frm.Frame.setVisible(true);
            Frame.dispose();
        }
	}

	private void XuLyThoat() {
		int qes;
		qes = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn thoát?", "Question",JOptionPane.YES_NO_OPTION);			 
		if(qes == JOptionPane.YES_OPTION){
			System.exit(0);
		}
    }
	
}
