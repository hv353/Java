package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class SupermarketUI {
    private static CardLayout cardLayout;
    private static JPanel mainPanel;
    private static JButton activeButton = null;
    private static JFrame frame = new JFrame("QUẢN LÝ CỬA HÀNG SÁCH");


    public static void createAndShowGUI() {
    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    frame.setSize(1000, 600);
    	    frame.setLayout(new BorderLayout());

    	    // Left Sidebar Panel
    	    JPanel sidePanel = new JPanel();
    	    sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
    	    sidePanel.setPreferredSize(new Dimension(220, 600));
    	    sidePanel.setBackground(Color.DARK_GRAY);

    	    // Top Logo
    	    ImageIcon icon = new ImageIcon("C:/Users/VIET/eclipse-workspace/btjavaswing/src/btjavaswing/logo.png");
    	    Image img1 = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    	    JLabel imgLabel = new JLabel(new ImageIcon(img1));
    	    sidePanel.setLayout(new BorderLayout());
    	    sidePanel.add(imgLabel, BorderLayout.NORTH);

    	    // Menu Items
    	    String[] menuItems = { "Bán Hàng", "Quản Lý Sách", "Quản Lý Nhân Viên", "Quản Lý Khách Hàng", 
    	                           "Nhập & Xuất Sách", "Giảm Giá", "Tài Khoản", "Thống Kê", "Nhà Cung Cấp" };

    	    JPanel menuPanel = new JPanel();
    	    menuPanel.setLayout(new GridLayout(menuItems.length, 1, 0, 0));

    	    cardLayout = new CardLayout();
    	    mainPanel = new JPanel(cardLayout);
    	    mainPanel.setBackground(Color.WHITE);

    	    JButton firstButton = null; // Nút đầu tiên (Bán Hàng)
    	    
    	    for (String menuItem : menuItems) {
    	        JButton button = new JButton(menuItem);
    	        button.setFocusPainted(false);
    	        button.setBackground(Color.DARK_GRAY);
    	        button.setForeground(Color.WHITE);

    	        // Tạo panel tương ứng
    	        JPanel panel = new JPanel();
    	        panel.add(new JLabel(menuItem));

    	        button.addActionListener(e -> {
    	            cardLayout.show(mainPanel, menuItem);
    	            if (activeButton != null) {
    	                activeButton.setBackground(Color.DARK_GRAY);
    	                activeButton.setForeground(Color.WHITE);
    	            }
    	            button.setBackground(Color.LIGHT_GRAY);
    	            button.setForeground(Color.BLACK);
    	            activeButton = button;
    	        });

    	        // Lưu nút "Bán Hàng" làm nút đầu tiên
    	        if (firstButton == null) {
    	            firstButton = button;
    	        }

    	        menuPanel.add(button);
    	        mainPanel.add(panel, menuItem);
    	    }

    	    // Tạo panel "Bán Hàng"
    	    JPanel banHangPanel = new JPanel();
    	    banHangPanel.add(new JLabel("Bán Hàng"));
    
    	    
    	    // Tạo panel "Quản Lý Sách"
    	    JPanel quanLySachPanel = new JPanel(new BorderLayout());
			quanLySachPanel.setPreferredSize(new Dimension(0,600));
    	    // JPanel quanLySach = new JPanel(new BorderLayout());
			
			// quanLySachPanel.add(quanLySach);
    	    JPanel	QLS1 = new JPanel();
    	    JLabel titelQLS = new JLabel ("QUẢN LÝ SÁCH");
			Font font = new Font("Arial", Font.BOLD, 26);
			Font font1 = new Font("Arial", Font.BOLD, 16);
			titelQLS.setFont(font);
    	    titelQLS.setForeground(Color.RED);
    	    titelQLS.setBounds(0, 0, 250, 100);
    	    QLS1.add(titelQLS);
			quanLySachPanel.add(QLS1,BorderLayout.NORTH);
			JPanel quanLySachCenter = new JPanel(new GridLayout(3,1)); 
    		JPanel QLS2= new JPanel(new GridLayout(1,4,30,2));
			QLS2.setMaximumSize(new Dimension(450,600));
			//JPanel QLS2= new JPanel();
			//QLS2.setLayout(new BoxLayout(QLS2, BoxLayout.X_AXIS));
			//  JPanel QLS2= new JPanel(new GridBagLayout());
			//  GridBagConstraints gbc = new GridBagConstraints();

			//  gbc.insets = new Insets(5, 5, 5, 5);
			//  gbc.weightx = 1; // Chiếm 30% không gian ngang
			//  gbc.fill = GridBagConstraints.HORIZONTAL; // Căn chỉnh ngang
			//  gbc.gridx = 0; gbc.gridy = 0;
			
	

    	    JPanel txt_QLS2= new JPanel(new GridLayout(8,2, 0 ,5));
    	     JLabel maSach = new JLabel ("mã sách: ");
			 maSach.setFont(font1);
    	     JLabel maNXB = new JLabel ("mã NXB: ");
			 maNXB.setFont(font1);
    	     JLabel maTheLoai = new JLabel ("mã thể loại: ");
			 maTheLoai.setFont(font1);
    	     JLabel maTacGia = new JLabel ("mã tác giả: ");
			 maTacGia.setFont(font1);
    	     JLabel tenSach = new JLabel ("tên sách: ");
			 tenSach.setFont(font1);
    	     JLabel namXuatBan = new JLabel ("năm xuất bản: ");
			 namXuatBan.setFont(font1);
    	     JLabel soLuong = new JLabel ("số lượng: ");
			 soLuong.setFont(font1);
    	     JLabel donGia = new JLabel ("đơn giá: ");
			 donGia.setFont(font1);
    	     JTextField txtMaSach = new JTextField();
    	     JTextField txtMaNXB = new JTextField();
    	     JTextField txtMaTheLoai = new JTextField();
    	     JTextField txtMaTacGia = new JTextField();
    	     JTextField txtTenSach = new JTextField();
    	     JTextField txtNamXuatBan = new JTextField();
    	     JTextField txtSoLuong = new JTextField();
    	     JTextField txtDonGia = new JTextField();
    	    
    	     txt_QLS2.add(maSach);
    	     txt_QLS2.add(txtMaSach);
    	     txt_QLS2.add(maNXB);
    	     txt_QLS2.add(txtMaNXB);
    	     txt_QLS2.add(maTheLoai);
    	     txt_QLS2.add(txtMaTheLoai);
    	     txt_QLS2.add(maTacGia);
    	     txt_QLS2.add(txtMaTacGia);
    	     txt_QLS2.add(tenSach);
    	     txt_QLS2.add(txtTenSach);
    	     txt_QLS2.add(namXuatBan);
    	     txt_QLS2.add(txtNamXuatBan);
    	     txt_QLS2.add(soLuong);
    	     txt_QLS2.add(txtSoLuong);
    	     txt_QLS2.add(donGia);
    	     txt_QLS2.add(txtDonGia);
    	     QLS2.add(txt_QLS2);
    	    
    	     JPanel btn_QLS2 = new JPanel( new GridLayout(4,1,2,10));
		
    	     JButton btnThem= new JButton("Thêm");
    	     btnThem.setForeground(Color.WHITE);
    	     btnThem.setBackground(Color.CYAN);
    	     JButton btnSua= new JButton("Sửa");
    	     btnSua.setForeground(Color.WHITE);
    	     btnSua.setBackground(Color.blue);
    	     JButton btnXoa= new JButton("Xóa");
    	     btnXoa.setForeground(Color.WHITE);
    	     btnXoa.setBackground(Color.red);
    	     JButton btnLamMoi= new JButton("Làm mới");
    	     btnLamMoi.setForeground(Color.WHITE);
    	     btnLamMoi.setBackground(Color.green);
    	     btn_QLS2.add(btnThem);
    	     btn_QLS2.add(btnSua);
    	     btn_QLS2.add(btnXoa);
    	     btn_QLS2.add(btnLamMoi);
    	     QLS2.add(btn_QLS2);
    	 
    	     JPanel img_QLS2 = new JPanel();
    	     img_QLS2.setBackground(Color.gray);
    	     QLS2.add(img_QLS2);
    	   
    	     JPanel in_out_QLS2 = new JPanel( new GridLayout(2,1,2,10));
    	     JButton inputQLS = new JButton("Nhập Excel");
    	     JButton outputQLS = new  JButton("Xuất Excel");
    	     in_out_QLS2.add(outputQLS);
    	     in_out_QLS2.add(inputQLS);
    	     QLS2.add(in_out_QLS2);
    	   
    	     JPanel QLS3 = new JPanel(new GridLayout(4, 6, 5, 5));
    	     TitledBorder blackline = BorderFactory.createTitledBorder("Tìm kiếm");
    	     blackline.setTitleJustification(TitledBorder.CENTER);
    	     QLS3.setBorder(blackline);
    	     JLabel maSach1 = new JLabel ("mã sách: ");
    	     JLabel maNXB1 = new JLabel ("mã NXB: ");
    	     JLabel maTheLoai1 = new JLabel ("mã thể loại: ");
    	     JLabel maTacGia1 = new JLabel ("mã tác giả: ");
    	     JLabel tenSach1 = new JLabel ("tên sách: ");
    	     JLabel namXuatBan1 = new JLabel ("năm xuất bản: ");
    	     JLabel khoangGia = new JLabel ("Khoảng giá: ");
    	     JLabel khoangGiaTu = new JLabel("Từ: ");
    	     JLabel khoangGiaDen = new JLabel("Đến: ");
    	     JLabel namXBTu = new JLabel("NXB Từ: ");
    	     JLabel namXBDen = new JLabel("NXB Đến: ");
    	     JLabel space = new JLabel();
    	    JButton btnTimKiem = new JButton("Tìm kiếm");
    	     JLabel space2 = new JLabel();
    	     JLabel space3 = new JLabel();
    	    
    	     JTextField txtMaSach1 = new JTextField();
    	     JTextField txtMaNXB1 = new JTextField();
    	     JTextField txtMaTheLoai1 = new JTextField();
    	     JTextField txtMaTacGia1 = new JTextField();
    	     JTextField txtTenSach1 = new JTextField();
    	     JTextField txtKhoangGiaTu = new JTextField();
    	     JTextField txtKhoangGiaDen = new JTextField();
    	     JTextField txtNXBTu = new JTextField();
    	     JTextField txtNXBDen = new JTextField();
    	     QLS3.add(maSach1);
    	     QLS3.add(txtMaSach1);
			 QLS3.add(tenSach1);
    	     QLS3.add(txtTenSach1);

			 QLS3.add(space);
    	     QLS3.add(btnTimKiem);

    	     QLS3.add(maTheLoai1);
    	     QLS3.add(txtMaTheLoai1);
			 QLS3.add(space2);
			 QLS3.add(khoangGia);
    	     QLS3.add(space3);
			 QLS3.add(namXuatBan1);
			 QLS3.add(maNXB1);
    	     QLS3.add(txtMaNXB1);
    	     QLS3.add(khoangGiaTu);
    	     QLS3.add(txtKhoangGiaTu);
			 QLS3.add(namXBTu);
    	     QLS3.add(txtNXBTu);
			 QLS3.add(maTacGia1);
    	     QLS3.add(txtMaTacGia1);
    	     QLS3.add(khoangGiaDen);
    	     QLS3.add(txtKhoangGiaDen);
    	     QLS3.add(namXBDen);
    	     QLS3.add(txtNXBDen);
    	    
    	    
    	     String[][] data1 = {
	        };
	        String[] columnNames1 = { "Mã Sách", "Tên Sách", "Số Lượng", "Đơn Giá", "Giảm Giá", "Thành Tiền" };
	       JTable j1 = new JTable(data1, columnNames1);
	        JScrollPane sp2 = new JScrollPane(j1);
    	    
    	    JPanel QLS4 = new JPanel(new FlowLayout());
			JPanel QLS4TK= new JPanel( new GridLayout(2,2));
			JButton btnThongKe = new JButton("Thống Kê");
			JLabel donGiaThapNhat = new JLabel("Đơn giá thấp nhất");
			JLabel donGiaCaoNhat = new JLabel("Đơn giá cao nhất");
			JLabel soLoaiSach = new JLabel("Số loại sách");
			JLabel tongSoSach = new JLabel("Tổng số sách");
			JTextField txtDonGiaThapNhat = new JTextField();
			JTextField txtDonGiaCaoNhat = new JTextField();
			JTextField txtSoLoaiSach = new JTextField();
			JTextField txtTongSoSach = new JTextField();
			QLS4.add(btnThongKe);
			QLS4TK.add(donGiaThapNhat);
			QLS4TK.add(txtDonGiaThapNhat);
			QLS4TK.add(soLoaiSach);
			QLS4TK.add(txtSoLoaiSach);
			QLS4TK.add(donGiaCaoNhat);
			QLS4TK.add(txtDonGiaCaoNhat);
			QLS4TK.add(tongSoSach);
			QLS4TK.add(txtTongSoSach);
			QLS4.add(QLS4TK);
			
			// quanLySachCenter.setPreferredSize(new Dimension(600, 400)); 
			// QLS2.setPreferredSize(new Dimension(600, 150));  
			// QLS3.setPreferredSize(new Dimension(600, 100));
			// sp2.setPreferredSize(new Dimension(600, 100));

    	    
    	    
			quanLySachCenter.add(QLS2);
			quanLySachCenter.add(QLS3);
			quanLySachCenter.add(sp2);
    	     
    	     quanLySachPanel.add(quanLySachCenter,BorderLayout.CENTER);
    	    quanLySachPanel.add(QLS4,BorderLayout.SOUTH);
    	    
    	    
    	    

    	    // Thêm vào CardLayout
    	    mainPanel.add(banHangPanel, "Bán Hàng");
    	    mainPanel.add(quanLySachPanel, "Quản Lý Sách");

    	    sidePanel.add(menuPanel);

    	    // **Hiển thị trang "Bán Hàng" khi khởi động**
    	    cardLayout.show(mainPanel, "Bán Hàng");

    	    // **Làm nổi bật nút "Bán Hàng" khi khởi động**
    	    if (firstButton != null) {
    	        firstButton.setBackground(Color.LIGHT_GRAY);
    	        firstButton.setForeground(Color.BLACK);
    	        activeButton = firstButton;
    	    }
    	    
    	    

    	    frame.add(sidePanel, BorderLayout.WEST);
    	    frame.add(mainPanel, BorderLayout.CENTER);
    	    frame.setVisible(true);
    }
    
    public JFrame getSuperMarketUI(){
        return frame;
    }
}
