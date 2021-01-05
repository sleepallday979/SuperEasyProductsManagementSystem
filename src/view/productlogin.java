package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Admindao;
import model.Admin;
import model.UserType;
import utils.StringUtil;

import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class productlogin extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JTextField passwordtextField;
	private JButton loginbutton;
	private JButton resetbutton;
	private JComboBox userTypecomboBox;
	private JLabel lblNewLabel_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productlogin frame = new productlogin();
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
	public productlogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(productlogin.class.getResource("/image/zzz.png")));
		setTitle("\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("\u7269\u54C1\u7BA1\u7406\u7CFB\u7EDF\u767B\u9646\u754C\u9762");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		usernametextField = new JTextField();
		usernametextField.setColumns(10);
		
		passwordtextField = new JTextField();
		passwordtextField.setColumns(10);
		
		loginbutton = new JButton("\u767B\u9646");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginAct();
			}
		});
		loginbutton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		resetbutton = new JButton("\u91CD\u7F6E");
		resetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		resetbutton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		userTypecomboBox = new JComboBox();
		userTypecomboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		userTypecomboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN}));
		
		lblNewLabel_3 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(137)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(138)
								.addComponent(loginbutton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(resetbutton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(129)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
										.addComponent(usernametextField, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_3)
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(userTypecomboBox, 0, 199, Short.MAX_VALUE)
											.addComponent(passwordtextField)))))))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(usernametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userTypecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginbutton)
						.addComponent(resetbutton))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct() {
		// TODO Auto-generated method stub
		String username = usernametextField.getText().toString();
		String password = passwordtextField.getText().toString();
		UserType select = (UserType)userTypecomboBox.getSelectedItem();
		if(StringUtil.isEmpty(username)){
			JOptionPane.showMessageDialog(this, "ÓÃ»§Ãû²»ÄÜÎª¿Õ£¡");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(this, "ÃÜÂë²»ÄÜÎª¿Õ£¡");
			return;
		}
		Admin admin = null;
		Admindao admindao = new Admindao();
		Admin adminTmp = new Admin();
		adminTmp.setName(username);
		adminTmp.setPassword(password);
		admin = admindao.login(adminTmp);
		admindao.closeDao();
		if(admin == null) {
			JOptionPane.showMessageDialog(this,"ÓÃ»§Ãû»òÃÜÂë´íÎó£¡");
			return;
		}
		JOptionPane.showMessageDialog(this, "»¶Ó­¡¾"+select.getName()+"¡¿£º"+admin.getName()+"µÇÂ½±¾ÏµÍ³£¡");
		this.dispose();
		new Productmain(select,admin).setVisible(true); 
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		usernametextField.setText("");
		passwordtextField.setText("");
		userTypecomboBox.setSelectedIndex(0);
	}
}
