package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.FileIndao;
import dao.FileOutdao;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import model.UserType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class Productmain extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productmain frame = new Productmain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Productmain(UserType userType,Object userObject) {
		setTitle("\u7269\u54C1\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		this.userType=userType;
		this.userObject=userObject;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 696);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E\r\n");
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801\r\n");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editPassword();
			}
		});
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(Productmain.this, "确定退出吗？")==JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		mntmNewMenuItem_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("\u7269\u54C1\u7BA1\u7406");
		mnNewMenu_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u7269\u54C1\u6DFB\u52A0");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productAdd(e);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u7269\u54C1\u5217\u8868");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProductManage(e);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_6.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_2 = new JMenu("\u6587\u4EF6\u7BA1\u7406");
		mnNewMenu_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5BFC\u51FAXLS\u6587\u4EF6");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Output(e);
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5BFC\u5165XLS\u6587\u4EF6");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						Input(e);
					} catch (BiffException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		mntmNewMenuItem_4.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("\u5E2E\u52A9");
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		mntmNewMenuItem_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutUs(e);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	protected void Input(ActionEvent e) throws BiffException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		FileIndao filein = new FileIndao();
		filein.Input();
		JOptionPane.showMessageDialog(this, "导入完成！");
	}

	protected void Output(ActionEvent e) throws RowsExceededException, WriteException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		FileOutdao fileout = new FileOutdao();
		fileout.Outfile();
		JOptionPane.showMessageDialog(this, "导出完成！");
	}

	protected void productAdd(ActionEvent e) {
		// TODO Auto-generated method stub
		ProductAdd productadd = new ProductAdd();
		productadd.setVisible(true);
		desktopPane.add(productadd);
	}

	protected void ProductManage(ActionEvent e) throws ParseException {
		// TODO Auto-generated method stub
		ProductManage productmanage = new ProductManage();
		productmanage.setVisible(true);
		desktopPane.add(productmanage);
	}

	protected void editPassword() {
		// TODO Auto-generated method stub
		Editpassword edit = new Editpassword();
		edit.setVisible(true);
		desktopPane.add(edit);
	}

	protected void aboutUs(ActionEvent e) {
		// TODO Auto-generated method stub
		String info = "【王世宇】【Xb18620219】\n";
		info +="JAVA大作业期末成果展示";
		//JOptionPane.showMessageDialog(this, info);
		String[] buttons = {"非常优秀","还想知道更多"};
		int ret = JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(productlogin.class.getResource("/image/zzz.png")), buttons, null);
		if(ret != 0) {
			//JOptionPane.showMessageDialog(this, "你很明智");
			//采用 java调用系统浏览器打开
			try {
				URI uri = new URI("http://sleepallday.top");
				Desktop.getDesktop().browse(uri);
				//Runtime.getRuntime().exec("explorer https://sleepallday.top");
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(this, "我想也是");
		}
	}
}
