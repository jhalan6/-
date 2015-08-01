package csh.dhsjms.Calculator3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Calculator extends JFrame {
	private BufferCalcutalor bufferCalcutalor=new BufferCalcutalor();
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 248, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 6, 232, 52);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(null);

		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bufferCalcutalor.setNext(textField.getText());
				bufferCalcutalor.setOperate("+");
				textField.setText(Float.toString(bufferCalcutalor.getResult()));
				System.out.println(bufferCalcutalor.getResult());
			}
		});
		btnNewButton.setBounds(6, 61, 67, 67);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bufferCalcutalor.setNext(textField.getText());
				bufferCalcutalor.setOperate("-");
				textField.setText(Float.toString(bufferCalcutalor.getResult()));
			}
		});
		btnNewButton_1.setBounds(85, 61, 67, 67);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("*");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bufferCalcutalor.setNext(textField.getText());
				bufferCalcutalor.setOperate("*");
				textField.setText(Float.toString(bufferCalcutalor.getResult()));
			}
		});
		btnNewButton_2.setBounds(6, 140, 67, 67);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("/");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bufferCalcutalor.setNext(textField.getText());
				bufferCalcutalor.setOperate("/");
				textField.setText(Float.toString(bufferCalcutalor.getResult()));
			}
		});
		btnNewButton_3.setBounds(85, 140, 67, 67);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("C");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bufferCalcutalor.reset();
				textField.setText(null);
			}
		});
		btnNewButton_4.setBounds(171, 61, 67, 67);
		contentPane.add(btnNewButton_4);
		
		JButton button = new JButton("=");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bufferCalcutalor.setNext(textField.getText());
				bufferCalcutalor.setOperate(null);
				textField.setText(Float.toString(bufferCalcutalor.getResult()));
			}
		});
		button.setBounds(171, 140, 67, 67);
		contentPane.add(button);
		
		
	}
}
