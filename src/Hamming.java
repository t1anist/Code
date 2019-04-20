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
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.*;

public class Hamming extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hamming frame = new Hamming();
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
	public Hamming() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 520);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6D77\u660E\u7F16\u7801\u4E0E\u89E3\u7801");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		label.setBounds(113, 22, 276, 102);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u539F\u7801\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("黑体", Font.PLAIN, 18));
		label_1.setBounds(72, 146, 136, 56);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6D77\u660E\u7801\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("黑体", Font.PLAIN, 18));
		label_2.setBounds(72, 282, 136, 56);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6821\u9A8C\u7801\u4F4D\u6570\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("黑体", Font.PLAIN, 18));
		label_3.setBounds(72, 216, 136, 56);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("0");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("黑体", Font.PLAIN, 18));
		label_4.setBounds(218, 216, 136, 56);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("0\u4F4D");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("黑体", Font.PLAIN, 18));
		label_5.setBounds(381, 146, 136, 56);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("0\u4F4D");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("黑体", Font.PLAIN, 18));
		label_6.setBounds(381, 282, 136, 56);
		contentPane.add(label_6);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()<KeyEvent.VK_0||e.getKeyChar()>KeyEvent.VK_1) e.consume();
			}
		});
		textField.addFocusListener(new FocusListener(){
            public void focusLost(FocusEvent e) {  
            	int k=textField.getText().length();
            	label_5.setText(String.valueOf(k)+"位");
            }
            public void focusGained(FocusEvent e) {
            }
        });
		textField.setBounds(168, 159, 203, 36);
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
            	label_5.setText(String.valueOf(k)+"位");
            }
            public void focusGained(FocusEvent e) {
            }
        });
		textField_1.setColumns(10);
		textField_1.setBounds(168, 295, 203, 36);
		contentPane.add(textField_1);
		
		JButton button = new JButton("\u7F16\u7801");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input=textField.getText();
				int k=input.length();
				label_5.setText(String.valueOf(k)+"位");
				int r=0;
				while(Math.pow(2,r)<k+r+1) r++;
				label_4.setText(String.valueOf(r));
				int m;
				m=k+r;
				label_6.setText(String.valueOf(m)+"位");
				char[] pbit=new char[r];
				char[] bbit=input.toCharArray();
				char[] result=new char[m];
				for(int j=0;j<r;j++) pbit[j]='0';
				for(int j=0,bflags=0,pflags=0,twoflags=0;j<m;j++){
					if(j==Math.pow(2, twoflags)-1) {
						result[j]=pbit[pflags++];
						twoflags++;
					}else {
						result[j]=bbit[bflags++];
					}
				};
				for(int j=0;j<r;j++) {
					int count=(int)Math.pow(2,j);
					int temp=0;
					for(int flags=count-1,num=0,state=1;flags<m;flags++) {
						if(state==1){
							int temp1=result[flags]-'0';
							temp=temp^temp1;
						}
						num++;
						if(num==count) {
							if(state==0) {
								state=1;
								num=0;
							}else {
								state=0;
								num=0;
							}
						}
						
					}
					pbit[j]=(char)(temp+48);
				}
				for(int j=0,bflags=0,pflags=0,twoflags=0;j<m;j++){
					if(j==Math.pow(2, twoflags)-1) {
						result[j]=pbit[pflags++];
						twoflags++;
					}else {
						result[j]=bbit[bflags++];
					}
				};			
				String output=String.valueOf(result);
				textField_1.setText(output);
			}
		});
		button.setFont(new Font("黑体", Font.PLAIN, 18));
		button.setBounds(49, 364, 110, 43);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8BD1\u7801");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input=textField_1.getText();
				int m=input.length();
				label_6.setText(String.valueOf(m)+"位");
				int r=0;
				while(Math.pow(2,r)<m+1) r++;
				label_4.setText(String.valueOf(r));
				int k;
				k=m-r;
				label_5.setText(String.valueOf(k)+"位");
				char[] pbit=new char[r];
				char[] bbit=new char[k];
				char[] total=input.toCharArray();
				for(int j=0;j<r;j++){
					pbit[j]=total[(int)Math.pow(2, j)-1];
				}
				for(int j=0;j<r;j++) {
					int count=(int)Math.pow(2,j);
					int temp=0;
					for(int flags=count-1,num=0,state=1;flags<m;flags++) {
						if(state==1){
							int temp1=total[flags]-'0';
							temp=temp^temp1;
						}
						num++;
						if(num==count) {
							if(state==0) {
								state=1;
								num=0;
							}else {
								state=0;
								num=0;
							}
						}
						
					}
					pbit[j]=(char)(temp+48);
				}
				int errorstate=0,errorbit=0;
				for(char x:pbit) {
					if(x!='0') {
						errorstate=1;
					}
				}
				if(errorstate==1) {
					for(int j=0;j<r;j++) {
						int temp=pbit[j]-'0';
						errorbit+=(int)Math.pow(2,j)*temp;
					}
					if(total[errorbit-1]=='0') {
						total[errorbit-1]='1';
					}else {
						total[errorbit-1]='0';
					}
				}
				for(int j=0,bflags=0,twoflags=0;j<m;j++) {
					if(j!=(int)Math.pow(2,twoflags)-1) {
						bbit[bflags++]=total[j];
					}else {
						twoflags++;
					}
				}			
				String output=String.valueOf(bbit);
				textField.setText(output);
			}
		});
		button_1.setFont(new Font("黑体", Font.PLAIN, 18));
		button_1.setBounds(198, 364, 110, 43);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u6E05\u7A7A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				label_4.setText("0");
				label_5.setText("0位");
				label_6.setText("0位");
			}
		});
		button_2.setFont(new Font("黑体", Font.PLAIN, 18));
		button_2.setBounds(351, 364, 110, 43);
		contentPane.add(button_2);
		
	}
}
