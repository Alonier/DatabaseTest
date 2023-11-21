package src;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Findfest extends JFrame {

	private JPanel contentPane;
	private JTextField FestField;
	private JTable table;
	private JButton searchButton,confirmButton;
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	DefaultTableModel model;
	DBConnManager dbConnManager;
	Object IDvalue;

	public String Festresult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Findfest frame = new Findfest();
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
	public Findfest() {
		//GUI 구현
		setBounds(100, 100, 800, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("축제 이름");
		lblNewLabel.setBounds(32, 44, 57, 15);
		contentPane.add(lblNewLabel);
		
		FestField = new JTextField();
		FestField.setBounds(101, 41, 529, 21);
		contentPane.add(FestField);
		FestField.setColumns(10);
		
		searchButton = new JButton("검색");
		searchButton.setBounds(642, 40, 97, 23);
		contentPane.add(searchButton);

		String colNames[] = {"축제ID", "축제 이름"};
		model = new DefaultTableModel(colNames,0){
			public boolean isCellEditable(int row,int col){
				if(col == 0) return false;
				else return true;
			}
		};
		model.addRow(new Object[]{"1","1"});

		table = new JTable();
		table.setModel(model);

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		JScrollPane jcp = new JScrollPane(table);
		jcp.setBounds(101,83,639,236);
		contentPane.add(jcp);
		
		confirmButton = new JButton("등록");
		confirmButton.setBounds(642, 353, 97, 23);
		contentPane.add(confirmButton);

		//컨트롤러 등록
		ALController ae = new ALController();
		MController me = new MController();
		searchButton.addActionListener(ae);
		confirmButton.addActionListener(ae);
		table.addMouseListener(me);

		//데이터베이스 연결
		try{
			conn = DBConnManager.getConnection();
			stmt = conn.prepareStatement("select ID, NAME from stdt079.festival WHERE name LIKE ?;");
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	private class ALController implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==searchButton){
				String fest = "%"+FestField.getText().trim()+"%";
				try {
					stmt.setString(1, fest);
					rs = stmt.executeQuery();
					model = (DefaultTableModel) table.getModel();
					int rowNum = model.getRowCount();

					for(int i = rowNum-1;i>=0;i--)
						model.removeRow(i);

					String arr[] = new String[2];


					while(rs.next()){
						Long id = rs.getLong(1);
						arr[0] = id.toString();
						arr[1] = rs.getString(2);
						model.addRow(arr);
					}

				}catch (SQLException l){
					l.printStackTrace();
				}
			}

			//여기가 문제
			else if(e.getSource()==confirmButton){
				try {
					DBConnManager.closeConnection(conn);
					Fest fest = new Fest();
					Fest.setFestName(FestField.getText());
					Fest.setFestId(Long.valueOf(String.valueOf(IDvalue)));
				}catch (SQLException l){
					l.printStackTrace();
				}
				dispose();
			}
		}
	}

	private class WController implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
			try{
				DBConnManager.closeConnection(conn);
			}catch (SQLException l){
				l.printStackTrace();
			}
		}

		@Override
		public void windowClosed(WindowEvent e) {

		}

		@Override
		public void windowIconified(WindowEvent e) {

		}

		@Override
		public void windowDeiconified(WindowEvent e) {

		}

		@Override
		public void windowActivated(WindowEvent e) {

		}

		@Override
		public void windowDeactivated(WindowEvent e) {

		}
	}

	private class MController implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			int col = table.getSelectedColumn();
			IDvalue = table.getModel().getValueAt(row, 0);
			Object arr = table.getModel().getValueAt(row, 1);
			FestField.setText(arr.toString());
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}
}

