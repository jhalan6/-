package csh.dhsjms.Strategy1;

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
import javax.swing.SwingConstants;
/*complete a simple demo of a system
 * 
 */

public class Strategy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField price;
	private JTextField count;
	private JTextField showResult;
	private HandleSystem handleSystem=null;
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
	public Strategy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel countLable = new JLabel("0.00");
		countLable.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		countLable.setBounds(82, 232, 182, 40);
		contentPane.add(countLable);
		JButton certernButton = new JButton("确定");
		
		certernButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSystem=new HandleSystem(price.getText(),count.getText());
				if (handleSystem.getErrorMessage()!=null) {
					showResult.setText(handleSystem.getErrorMessage());
				}
				else {
					countLable.setText(handleSystem.getResult());
					showResult.setText(null);
				}
			}
		});
		certernButton.setBounds(195, 6, 117, 29);
		contentPane.add(certernButton);
		
		JButton resetButton = new JButton("重置");
		resetButton.setBounds(195, 40, 117, 29);
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
		
		showResult = new JTextField();
		showResult.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		showResult.setHorizontalAlignment(SwingConstants.CENTER);
		showResult.setBounds(6, 79, 306, 129);
		contentPane.add(showResult);
		showResult.setColumns(10);
		
		JLabel label_1 = new JLabel("总计：");
		label_1.setBounds(16, 220, 61, 16);
		contentPane.add(label_1);
		
	}
}
