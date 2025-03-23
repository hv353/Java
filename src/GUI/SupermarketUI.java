package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class SupermarketUI {
    private static DefaultTableModel cartModel;
    private static CardLayout cardLayout;
    private static JPanel mainPanel;
    private static JButton activeButton = null;
    private static JFrame frame = new JFrame("QUẢN LÝ CỬA HÀNG SÁCH");

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(SupermarketUI::createAndShowGUI);
//    }

    public static void createAndShowGUI() {
//    	 JFrame frame = new JFrame("QUẢN LÝ CỬA HÀNG SÁCH");
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
    	    banHangPanel.setLayout(new BorderLayout());
    	    JPanel taoHoaDon = new JPanel();
    	    taoHoaDon.setLayout(null);
    	    banHangPanel.add(taoHoaDon,BorderLayout.NORTH);
    	    JLabel headTaoHD= new JLabel("TẠO HÓA ĐƠN BÁN HÀNG");
    	    headTaoHD.setForeground(Color.RED);
    	    headTaoHD.setBounds(250, 0, 250, 100);
    	    JLabel maHD= new JLabel("Mã HD");
    	    maHD.setBounds(25, 100, 50, 10);
    	    JLabel maNV= new JLabel("Mã NV");
    	    maNV.setBounds(200, 100, 50, 10);
    	    JLabel maKH= new JLabel("Mã KH");
    	    maKH.setBounds(400, 100, 50, 10);
    	    JLabel maGG= new JLabel("Mã GG");
    	    maGG.setBounds(600, 100, 50, 10);
    	    JLabel ngayLap= new JLabel("Ngày lập");
    	    ngayLap.setBounds(25, 160, 50, 20);
    	    JTextField txtMaHD= new JTextField();
    	    txtMaHD.setBounds(70, 95, 80, 20);
    	    JTextField txtMaNV= new JTextField();
    	    txtMaNV.setBounds(250, 95, 80, 20);
    	    JTextField txtMaKH= new JTextField();
    	    txtMaKH.setBounds(450, 95, 80, 20);
    	    JTextField txtMaGG= new JTextField();
    	    txtMaGG.setBounds(650, 95, 80, 20);
    	    JTextField txtNgayLap= new JTextField();
    	    txtNgayLap.setBounds(80, 160, 100, 20);
    	    
    	    
    	    taoHoaDon.add(headTaoHD);
    	    taoHoaDon.add(maHD);
    	    taoHoaDon.add(txtMaHD);
    	    taoHoaDon.add(maNV);
    	    taoHoaDon.add(txtMaNV);
    	    taoHoaDon.add(maKH);
    	    taoHoaDon.add(txtMaKH);
    	    taoHoaDon.add(maGG);
    	    taoHoaDon.add(txtMaGG);
    	    taoHoaDon.add(ngayLap);
    	    taoHoaDon.add(txtNgayLap);
    	    
    	    
    	    

    	    banHangPanel.add(taoHoaDon);
    	    // Tạo panel "Quản Lý Sách"
    	    JPanel quanLySachPanel = new JPanel();
    	    quanLySachPanel.add(new JLabel("Quản Lý Sách"));
    	    

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
