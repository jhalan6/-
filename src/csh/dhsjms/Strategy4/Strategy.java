package csh.dhsjms.Strategy4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
/*A demo without Factory model and Strategy*/
public class Strategy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField price;
	private JTextField count;
	private HandleSystem handleSystem=null;
	private float zongQianShu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Strategy frame = new Strategy();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Strategy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 109, 290, 103);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textArea.setEditable(false);
		
		JLabel totle = new JLabel("0.00");
		totle.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		totle.setBounds(58, 232, 224, 40);
		contentPane.add(totle);
		JButton certernButton = new JButton("确定");
		
		JComboBox comboBox = new JComboBox<Object>();
		comboBox.setMaximumRowCount(5);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"无", "九折", "八折", "七折", "六折", "五折", "满300减100", "满100减50"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(57, 70, 134, 27);
		contentPane.add(comboBox);
		
		certernButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSystem=new HandleSystem(price.getText(),count.getText(),comboBox.getSelectedItem().toString());
				if (handleSystem.getErrorMessage()!=null) {
					textArea.setText(textArea.getText()+handleSystem.getErrorMessage());
				}
				else {
					zongQianShu+=handleSystem.getResult();
					totle.setText(Float.toString(zongQianShu));
					textArea.setText(textArea.getText()+"单价："+price.getText()+"\t数量："+count.getText()+"\t合计："+handleSystem.getResult()+"\n");
				}
			}
		});
		certernButton.setBounds(195, 6, 117, 29);
		contentPane.add(certernButton);
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count.setText(null);
				price.setText(null);
				comboBox.setSelectedItem("无");
				zongQianShu=0;
				totle.setText(Float.toString(zongQianShu));
				textArea.setText(null);
			}
		});
		resetButton.setBounds(195, 68, 117, 29);
		contentPane.add(resetButton);
		
		price = new JTextField();
		price.setBounds(57, 6, 134, 28);
		contentPane.add(price);
		price.setColumns(10);
		
		count = new JTextField();
		count.setBounds(57, 39, 134, 28);
		contentPane.add(count);
		count.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("单价：");
		lblNewLabel.setBounds(6, 11, 39, 16);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("数量：");
		label.setBounds(6, 45, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("总计：");
		label_1.setBounds(16, 220, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("折扣：");
		label_2.setBounds(6, 74, 61, 16);
		contentPane.add(label_2);
		
		JButton button = new JButton("清除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count.setText(null);
				price.setText(null);
				comboBox.setSelectedItem("空");
			}
		});
		button.setBounds(195, 40, 117, 29);
		contentPane.add(button);
		
		
	}

	public float getZongQianShu() {
		return zongQianShu;
	}

	public void setZongQianShu(float zongQianShu) {
		this.zongQianShu = zongQianShu;
	}
}
