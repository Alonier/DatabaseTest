package src;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WriteFrame extends JFrame {

	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private final JLabel lblNewLabel = new JLabel("");
	private final JTextField titleField = new JTextField();
	private JTextField FestField;
	private JTextArea contentField;
	private static String festResult = null;
	private final JButton FestFind_btn,Confirm_btn,refreshBtn,Reset_Btn;
	Connection conn = null;
	PreparedStatement stmt = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WriteFrame frame = new WriteFrame();
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
	public WriteFrame() {
		setBounds(100, 100, 1280, 720);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		layeredPane.setBounds(0, 0, 1264, 681);
		contentPane.add(layeredPane);
		
		Reset_Btn = new JButton("초기화");
		Reset_Btn.setBounds(1121, 542, 97, 23);
		layeredPane.add(Reset_Btn);
		
		refreshBtn = new JButton("새로고침");
		refreshBtn.setBounds(1012, 542, 97, 23);
		layeredPane.add(refreshBtn);
		
		JLabel label = new JLabel("글 제목");
		label.setFont(new Font("굴림", Font.PLAIN, 16));
		label.setBounds(164, 147, 74, 31);
		layeredPane.add(label);
		titleField.setBounds(268, 147, 732, 31);
		layeredPane.add(titleField);
		titleField.setColumns(10);
		
		contentField = new JTextArea();
		contentField.setBounds(268, 198, 732, 334);
		layeredPane.add(contentField);
		
		JLabel label_1 = new JLabel("글 내용");
		label_1.setFont(new Font("굴림", Font.PLAIN, 16));
		label_1.setBounds(164, 327, 74, 31);
		layeredPane.add(label_1);
		
		FestField = new JTextField();
		FestField.setColumns(10);
		FestField.setBounds(268, 538, 623, 31);
		layeredPane.add(FestField);
		
		FestFind_btn = new JButton("축제 찾기");
		FestFind_btn.setBounds(903, 542, 97, 23);
		layeredPane.add(FestFind_btn);
		
		JLabel label_1_1 = new JLabel("축제 이름");
		label_1_1.setFont(new Font("굴림", Font.PLAIN, 16));
		label_1_1.setBounds(164, 538, 74, 31);
		layeredPane.add(label_1_1);
		
		Confirm_btn = new JButton("작성 완료");
		Confirm_btn.setBounds(903, 590, 97, 23);
		layeredPane.add(Confirm_btn);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\junhee\\Desktop\\새 폴더\\과제\\23_2학기\\데이터베이스\\Test_2\\static\\BackgroundImage.png"));
		lblNewLabel.setBounds(0, 0, 1264, 681);
		layeredPane.add(lblNewLabel);

		//컨트롤러 등록
		ALController ae = new ALController();
		FestFind_btn.addActionListener(ae);
		Confirm_btn.addActionListener(ae);
		refreshBtn.addActionListener(ae);
		Reset_Btn.addActionListener(ae);
	}



	private class ALController implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==FestFind_btn){
				new Findfest();
			}
			if(e.getSource()==refreshBtn){
				FestField.setText(Fest.getFestId()+" "+Fest.getFestName());
			}
			if(e.getSource()==Confirm_btn){
				try{
					conn = DBConnManager.getConnection();
					stmt = conn.prepareStatement("insert stdt079.board(title,writer,content,Festival_id) values(?,?,?,?);");
					stmt.setString(1,titleField.getText());
					stmt.setString(2,"admin");
					stmt.setString(3,contentField.getText());
					if(Fest.getFestId()==0){
						stmt.setString(4,null);
					}
					else {
						stmt.setString(4, Long.valueOf(Fest.getFestId()).toString());
					}
					stmt.executeUpdate();
				}catch (SQLException l){
					l.printStackTrace();
				}

				dispose();
			}
			if(e.getSource() == Reset_Btn){
				Fest fest = new Fest();
				Fest.setFestId(0);
				FestField.setText("");
			}
		}
	}
}
