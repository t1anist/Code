import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class CRC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6315345571922054753L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRC frame = new CRC();
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
	public CRC() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("CRC\u7F16\u7801\u4E0E\u8BD1\u7801");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("黑体", Font.PLAIN, 30));
		title.setBounds(77, 10, 405, 105);
		contentPane.add(title);
		
		JLabel label = new JLabel("\u539F\u7801\uFF1A");
		label.setFont(new Font("黑体", Font.PLAIN, 20));
		label.setBounds(77, 145, 179, 57);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u751F\u6210\u591A\u9879\u5F0F\uFF1A");
		label_1.setFont(new Font("黑体", Font.PLAIN, 20));
		label_1.setBounds(77, 221, 179, 57);
		contentPane.add(label_1);
		
		JLabel label_5 = new JLabel("CRC\u7801\uFF1A");
		label_5.setFont(new Font("黑体", Font.PLAIN, 20));
		label_5.setBounds(77, 308, 179, 57);
		contentPane.add(label_5);
		
		JLabel label_2 = new JLabel("0\u4F4D");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("黑体", Font.PLAIN, 20));
		label_2.setBounds(468, 144, 63, 58);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("0\u4F4D");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("黑体", Font.PLAIN, 20));
		label_3.setBounds(468, 221, 63, 58);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("0\u4F4D");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("黑体", Font.PLAIN, 20));
		label_4.setBounds(468, 308, 63, 58);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				if(e.getKeyChar()<KeyEvent.VK_0||e.getKeyChar()>KeyEvent.VK_1) e.consume();
			}
		});
		textField.addFocusListener(new FocusListener(){
            public void focusLost(FocusEvent e) {  
            	int k=textField.getText().length();
            	label_2.setText(String.valueOf(k)+"位");
            }
            public void focusGained(FocusEvent e) {
            }
        });
		textField.setBounds(179, 145, 279, 57);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()<KeyEvent.VK_0||e.getKeyChar()>KeyEvent.VK_1) e.consume();
			}
		});
		textField_1.addFocusListener(new FocusListener(){
            public void focusLost(FocusEvent e) {  
            	int k=textField_1.getText().length();
            	label_3.setText(String.valueOf(k)+"位");
            }
            public void focusGained(FocusEvent e) {
            }
        });
		textField_1.setColumns(10);
		textField_1.setBounds(207, 221, 251, 57);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()<KeyEvent.VK_0||e.getKeyChar()>KeyEvent.VK_1) e.consume();
			}
		});
		textField_2.addFocusListener(new FocusListener(){
            public void focusLost(FocusEvent e) {  
            	int k=textField_2.getText().length();
            	label_4.setText(String.valueOf(k)+"位");
            }
            public void focusGained(FocusEvent e) {
            }
        });
		textField_2.setColumns(10);
		textField_2.setBounds(179, 308, 279, 57);
		contentPane.add(textField_2);
		
		JButton button = new JButton("\u7F16\u7801");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input=textField.getText();
				String poly=textField_1.getText().replaceAll("^(0+)", "");
				if(input.isEmpty()||poly.isEmpty()) return;
				String tempInput=input;
				int l=poly.length();
				char[] polya=poly.toCharArray();
				int m=input.length()+l-1;
				label_4.setText(String.valueOf(m)+"位");
				for(int i=l;i>1;i--) {
					tempInput=tempInput+"0";
				}
				char[] remainder=new char[l];
				char[] array=tempInput.toCharArray();
				while(array[0]=='0') {
					tempInput=tempInput.substring(1);
					array=tempInput.toCharArray();
				}
				char[] value=tempInput.substring(0,l).toCharArray();
				tempInput=tempInput.substring(l);
				do {
					for(int j=1;j<l;j++) {
						remainder[j-1]=(char)((int)(polya[j]-'0')^(int)(value[j]-'0')+48);
					}
					array=tempInput.toCharArray();
					if(tempInput.length()==0) break;
					tempInput=tempInput.substring(1);
					remainder[l-1]=array[0];
					while(remainder[0]=='0') {
						for(int k=0;k<l-1;k++) {
							remainder[k]=remainder[k+1];
						}
						array=tempInput.toCharArray();
						if(tempInput.length()==0) break;
						tempInput=tempInput.substring(1);
						remainder[l-1]=array[0];
					}
					for(int j=1;j<l;j++) {
						value[j]=remainder[j];
					}
					if(tempInput.length()==0) break;
				}while(Boolean.TRUE);
				char[] behind=new char[l-1];
				for(int j=0;j<l-1;j++) {
					behind[j]=remainder[j];
				}
				String output=input+String.valueOf(behind);
				textField_2.setText(output);
			}
		});
		button.setFont(new Font("黑体", Font.PLAIN, 20));
		button.setBounds(44, 388, 146, 47);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8BD1\u7801");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input=textField_2.getText();
				String poly=textField_1.getText().replaceAll("^(0+)", "");
				if(input.isEmpty()||poly.isEmpty()) return;
				String tempInput=input;
				int l=poly.length();
				char[] polya=poly.toCharArray();
				int k=input.length()-l+1;
				label_2.setText(String.valueOf(k)+"位");
				char[] remainder=new char[l];
				char[] array=tempInput.toCharArray();
				while(array[0]=='0') {
					tempInput=tempInput.substring(1);
					array=tempInput.toCharArray();
				}
				char[] value=tempInput.substring(0,l).toCharArray();
				tempInput=tempInput.substring(l);
				do {
					for(int j=1;j<l;j++) {
						remainder[j-1]=(char)((int)(polya[j]-'0')^(int)(value[j]-'0')+48);
					}
					array=tempInput.toCharArray();
					if(tempInput.length()==0) break;
					tempInput=tempInput.substring(1);
					remainder[l-1]=array[0];
					while(remainder[0]=='0') {
						for(int flags=0;flags<l-1;flags++) {
							remainder[flags]=remainder[flags+1];
						}
						array=tempInput.toCharArray();
						if(tempInput.length()==0) break;
						tempInput=tempInput.substring(1);
						remainder[l-1]=array[0];
					}
					for(int j=1;j<l;j++) {
						value[j]=remainder[j];
					}
					if(tempInput.length()==0) break;
				}while(Boolean.TRUE);
				int errorstate=0;
				for(int j=0;j<remainder.length;j++) {
					if(remainder[j]=='1') {
						errorstate=1;
					}
				}
				String output="";
				if(errorstate==0) {
					output=input.substring(0,k);
				}else if(errorstate==1){
					output="数据出错！";
				}
				textField.setText(output);
			}
		});
		button_1.setFont(new Font("黑体", Font.PLAIN, 20));
		button_1.setBounds(230, 388, 146, 47);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u6E05\u7A7A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				label_2.setText("0位");
				label_3.setText("0位");
				label_4.setText("0位");
			}
		});
		button_2.setFont(new Font("黑体", Font.PLAIN, 20));
		button_2.setBounds(406, 388, 146, 47);
		contentPane.add(button_2);
	}
}
