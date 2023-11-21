package src;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class JoinFrame extends JFrame {

	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JTextField IDField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField mailField;
	private JTextField birthField1;
	private JTextField birthField2;
	private JTextField birthField3;
	private JTextField addressField;
	private JTextField nicknameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinFrame frame = new JoinFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JoinFrame() {
		setVisible(true);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		layeredPane.setBounds(0, 0, 484, 561);
		contentPane.add(layeredPane);
		
		JRadioButton Gender_W = new JRadioButton("");
		Gender_W.setBounds(225, 257, 24, 23);
		layeredPane.add(Gender_W);
		
		JRadioButton Gender_M = new JRadioButton("");
		Gender_M.setBounds(106, 257, 24, 23);
		layeredPane.add(Gender_M);

		ButtonGroup bg = new ButtonGroup();
		bg.add(Gender_M);
		bg.add(Gender_W);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2 = new JLabel("여");
		lblNewLabel_1_1_1_1_1_1_1_1_2.setBounds(257, 261, 24, 15);
		layeredPane.add(lblNewLabel_1_1_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_2 = new JLabel("남");
		lblNewLabel_1_1_1_1_1_1_1_2.setBounds(138, 261, 24, 15);
		layeredPane.add(lblNewLabel_1_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(50, 118, 57, 15);
		layeredPane.add(lblNewLabel_1);
		
		IDField = new JTextField();
		IDField.setBounds(106, 115, 216, 21);
		layeredPane.add(IDField);
		IDField.setColumns(10);
		
		JButton dupCheck_btn = new JButton("중복 검사");
		dupCheck_btn.setBounds(334, 114, 97, 23);
		layeredPane.add(dupCheck_btn);
		
		JLabel dupCheck_label = new JLabel("");
		dupCheck_label.setBounds(106, 143, 162, 15);
		layeredPane.add(dupCheck_label);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setBounds(46, 171, 61, 15);
		layeredPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(106, 168, 216, 21);
		layeredPane.add(passwordField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("이름");
		lblNewLabel_1_1_1.setBounds(74, 201, 33, 15);
		layeredPane.add(lblNewLabel_1_1_1);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(106, 198, 216, 21);
		layeredPane.add(nameField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("메일");
		lblNewLabel_1_1_1_1.setBounds(74, 231, 33, 15);
		layeredPane.add(lblNewLabel_1_1_1_1);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(106, 228, 216, 21);
		layeredPane.add(mailField);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("성별");
		lblNewLabel_1_1_1_1_1.setBounds(74, 261, 33, 15);
		layeredPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("생일");
		lblNewLabel_1_1_1_1_1_1.setBounds(74, 291, 33, 15);
		layeredPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("년");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(173, 291, 24, 15);
		layeredPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		birthField1 = new JTextField();
		birthField1.setColumns(10);
		birthField1.setBounds(106, 291, 57, 21);
		layeredPane.add(birthField1);
		
		birthField2 = new JTextField();
		birthField2.setColumns(10);
		birthField2.setBounds(196, 291, 57, 21);
		layeredPane.add(birthField2);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("월");
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(265, 291, 24, 15);
		layeredPane.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		birthField3 = new JTextField();
		birthField3.setColumns(10);
		birthField3.setBounds(287, 291, 57, 21);
		layeredPane.add(birthField3);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("일");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(356, 291, 24, 15);
		layeredPane.add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("주소");
		lblNewLabel_1_1_1_1_1_1_2.setBounds(74, 321, 33, 15);
		layeredPane.add(lblNewLabel_1_1_1_1_1_1_2);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(106, 321, 216, 21);
		layeredPane.add(addressField);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2_1 = new JLabel("닉네임");
		lblNewLabel_1_1_1_1_1_1_2_1.setBounds(62, 351, 45, 15);
		layeredPane.add(lblNewLabel_1_1_1_1_1_1_2_1);
		
		nicknameField = new JTextField();
		nicknameField.setColumns(10);
		nicknameField.setBounds(106, 351, 216, 21);
		layeredPane.add(nicknameField);
		
		JButton register_btn = new JButton("회원 가입");
		register_btn.setBounds(334, 429, 97, 23);
		layeredPane.add(register_btn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\junhee\\Desktop\\새 폴더\\과제\\23_2학기\\데이터베이스\\Test_2\\static\\LoginImage.png"));
		lblNewLabel.setBounds(0, 0, 484, 561);
		layeredPane.add(lblNewLabel);
	}
}
