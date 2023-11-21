package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends JFrame {
    JTable table;
    JTextField Text;
    JButton searchButton,prevButton,nextButton,writeButton;
    JPanel panel;
    JLabel status;
    JComboBox jComboBox;

    MyFrame() {
        setTitle("Festview 축제리뷰");

        //창 닫을 때 DB 연결 해제하도록 설정
        /*addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closeDBConnection();
                System.exit(0);
            }
        });*/

        Container contentPane = getContentPane();
        // table
        String colNames[] = {"게시글 번호", "작성자","축제 이름", "게시글 이름"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0) {
            public boolean isCellEditable(int row, int col) {
                if (col == 0) return false;
                else return true;
            }
        };
        model.addRow(new Object[]{"1","이준희","Null","안녕하세요."});

        table = new JTable(model);
        status = new JLabel();
        table.getColumnModel().getColumn(3).setCellRenderer(new TableCell());
        table.getColumnModel().getColumn(3).setCellEditor(new TableCell());
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(500);
        table.getColumnModel().getColumn(3).setPreferredWidth(500);
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);



        // panel
        JPanel inputPanel = new JPanel();
        Text = new JTextField(20);
        searchButton = new JButton("검색");
        prevButton = new JButton("이전");
        nextButton = new JButton("다음");
        writeButton = new JButton("글 쓰기");
        String cb[] = new String[]{"작성자","게시글 이름","축제 이름"};
        jComboBox = new JComboBox(cb);

        inputPanel.add(writeButton);
        inputPanel.add(prevButton);
        inputPanel.add(nextButton);
        inputPanel.add(jComboBox);
        inputPanel.add(new JLabel("입력"));
        inputPanel.add(Text);
        inputPanel.add(searchButton);


        panel = new JPanel(new BorderLayout());
        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(status, BorderLayout.SOUTH);

        contentPane.add(panel, BorderLayout.SOUTH);

        //리스너 처리
        ALController ae = new ALController();
        writeButton.addActionListener(ae);
        nextButton.addActionListener(ae);
        prevButton.addActionListener(ae);
        searchButton.addActionListener(ae);
    }
    class ALController implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==writeButton){

            }
        }
    }


    class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
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
