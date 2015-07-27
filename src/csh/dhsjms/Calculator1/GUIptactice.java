package csh.dhsjms.Calculator1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIptactice {
	Calculator1 calculator1=new Calculator1();
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIptactice window = new GUIptactice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIptactice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("计算器");
		frame.setBounds(100, 100, 254, 293);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculator1.setOperate('+');
				Calculator1.setOperated(Float.parseFloat(textField.getText()));
				textField.setText(null);
			}
		});
		button.setBounds(20, 78, 63, 50);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculator1.setOperate('-');
				Calculator1.setOperated(Float.parseFloat(textField.getText()));
				textField.setText(null);
			}
		});
		button_1.setBounds(97, 78, 63, 50);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("*");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculator1.setOperate('*');
				Calculator1.setOperated(Float.parseFloat(textField.getText()));
				textField.setText(null);
			}
		});
		button_2.setBounds(20, 137, 63, 50);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("/");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculator1.setOperate('/');
				Calculator1.setOperated(Float.parseFloat(textField.getText()));
				textField.setText(null);
			}
		});
		button_3.setBounds(97, 137, 63, 50);
		frame.getContentPane().add(button_3);
		
		textField = new JTextField("请输入数字");
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()=='+') {
					Calculator1.setOperate('+');
					Calculator1.setOperated(Float.parseFloat(textField.getText()));
					textField.setText(null);
				}
				else if (e.getKeyChar()=='\n') {
					Calculator1.operating=Float.parseFloat(textField.getText());
					textField.setText(null);
					Calculator1.chooseRightFactory();
					if (Calculator1.result!=Float.MAX_VALUE) {
						System.out.println(Calculator1.result);
						textField.setText(""+Calculator1.result);
					}
					else {
						System.out.println("nothing");
						textField.setText("输错了！重写！");
					}
				}
			}
		});
		textField.setBounds(26, 16, 206, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("=");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculator1.operating=Float.parseFloat(textField.getText());
				textField.setText(null);
				Calculator1.chooseRightFactory();
				if (Calculator1.result!=Float.MAX_VALUE) {
					System.out.println(Calculator1.result);
					textField.setText(""+Calculator1.result);
				}
				else {
					System.out.println("nothing");
					textField.setText("输错了！重写！");
				}
			}
		});
		btnNewButton.setBounds(20, 199, 212, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("%");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculator1.setOperate('%');
				Calculator1.setOperated(Float.parseFloat(textField.getText()));
				textField.setText(null);
			}
		});
		btnNewButton_1.setBounds(172, 78, 63, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnNewButton_2.setBounds(172, 140, 60, 47);
		frame.getContentPane().add(btnNewButton_2);
	}
}
