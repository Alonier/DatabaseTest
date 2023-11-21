package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class MainFrame extends JFrame {
	private JButton writeButton,searchButton;
	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JTable table;
	private JButton prevButton;
	private JButton nextButton;
	private JTextField searchField;

	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		layeredPane.setBounds(0, 0, 1264, 681);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(12, 630, 1240, 41);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		prevButton = new JButton("이전");
		prevButton.setBounds(12, 10, 97, 23);
		panel.add(prevButton);
		
		nextButton = new JButton("다음");
		nextButton.setBounds(121, 10, 97, 23);
		panel.add(nextButton);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"글 제목", "글 작성자", "축제 제목"}));
		comboBox.setBounds(542, 10, 117, 23);
		panel.add(comboBox);
		
		searchField = new JTextField();
		searchField.setBounds(672, 11, 447, 21);
		panel.add(searchField);
		searchField.setColumns(10);
		
		searchButton = new JButton("검색");
		searchButton.setBounds(1131, 10, 97, 23);
		panel.add(searchButton);
		
		writeButton = new JButton("글 쓰기");
		writeButton.setBounds(342, 10, 97, 23);
		panel.add(writeButton);

		String colNames[] = {"게시글 번호", "작성자","축제 이름", "작성 시간", "게시글 이름"};
		DefaultTableModel model = new DefaultTableModel(colNames,0){
			public boolean isCellEditable(int row, int col){
				if(col == 0) return false;
				else return true;
			}
		};
		model.addRow(new Object[]{"1","이준희","NULL","2023-11-21 10:19","안녕하세요."});

		table = new JTable();
		table.setModel(model);

		table.getColumnModel().getColumn(4).setCellEditor(new TableCell());
		table.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(600);
		table.setRowHeight(48);
		table.setBounds(12, 123, 1240, 484);
		layeredPane.add(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\junhee\\Desktop\\새 폴더\\과제\\23_2학기\\데이터베이스\\Test_2\\static\\BackgroundImage.png"));
		lblNewLabel.setBounds(0, 0, 1264, 681);
		layeredPane.add(lblNewLabel);

		ALController ae = new ALController();
		writeButton.addActionListener(ae);
		prevButton.addActionListener(ae);
		nextButton.addActionListener(ae);
		searchButton.addActionListener(ae);

	}

	private class ALController implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == writeButton){
				new WriteFrame();
			}
		}
	}


	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton jb;
		public TableCell(){
			jb = new JButton("안녕하세요.");
			jb.addActionListener(e -> {
				new BoardFrame();
			});
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			return jb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			return jb;
		}
	}
}
