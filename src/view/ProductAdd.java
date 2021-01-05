package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.Productdao;
import model.Product;
import utils.DoubleUtil;
import utils.IntUtil;
import utils.StringUtil;
import utils.TimeUtil;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ProductAdd extends JInternalFrame {
	private JTextField ProducttextField;
	private JTextField WeighttextField;
	private JTextField PricetextField;
	private JTextField NumtextField;
	private JComboBox SizecomboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductAdd frame = new ProductAdd();
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
	public ProductAdd() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u7269\u54C1\u4FE1\u606F");
		setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u7269\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		ProducttextField = new JTextField();
		ProducttextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7269\u54C1\u91CD\u91CF\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitProduct(e);
			}
		});
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("\u7269\u54C1\u5355\u4EF7\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("\u7269\u54C1\u6570\u91CF\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("\u7269\u54C1\u5C3A\u5BF8\uFF1A");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		WeighttextField = new JTextField();
		WeighttextField.setColumns(10);
		
		PricetextField = new JTextField();
		PricetextField.setColumns(10);
		
		NumtextField = new JTextField();
		NumtextField.setColumns(10);
		
		SizecomboBox = new JComboBox();
		SizecomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\u5C0F", "\u4E2D", "\u5927"}));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(PricetextField, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(SizecomboBox, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(NumtextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ProducttextField)
								.addComponent(WeighttextField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(ProducttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(WeighttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(PricetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(NumtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(SizecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(22))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitProduct(ActionEvent e) {
		// TODO Auto-generated method stub
		String Productname = ProducttextField.getText().toString();
		String Productweight = WeighttextField.getText().toString();
		String Productprice = PricetextField.getText().toString();
		String Productnum = NumtextField.getText().toString();
		String Productsize = SizecomboBox.getSelectedItem().toString();
		if(StringUtil.isEmpty(Productname)) {
			JOptionPane.showMessageDialog(this, "物品名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(Productweight)) {
			JOptionPane.showMessageDialog(this, "物品重量不能为空！");
			return;
		}
		if(StringUtil.isEmpty(Productprice)) {
			JOptionPane.showMessageDialog(this, "物品价格不能为空！");
			return;
		}
		if(StringUtil.isEmpty(Productnum)) {
			JOptionPane.showMessageDialog(this, "物品数量不能为空！");
			return;
		}
		if(!(DoubleUtil.isDouble(Productweight)||IntUtil.isInteger(Productweight))) {
			JOptionPane.showMessageDialog(this, "物品重量必须为数字！");
			return;
		}
		if(!(DoubleUtil.isDouble(Productprice)||IntUtil.isInteger(Productprice))) {
			JOptionPane.showMessageDialog(this, "物品价格必须为数字！");
			return;
		}
		if(!IntUtil.isInteger(Productnum)) {
			JOptionPane.showMessageDialog(this, "物品数量必须为整数！");
			return;
		}
		if(StringUtil.isEmpty(Productsize)) {
			JOptionPane.showMessageDialog(this, "物品尺寸不能为空！");
			return;
		}
		if(Double.valueOf(Productweight)<0) {
			JOptionPane.showMessageDialog(this, "物品重量不能小于0！");
			return;
		}
		if(Double.valueOf(Productprice)<0) {
			JOptionPane.showMessageDialog(this, "物品价格不能小于0！");
			return;
		}
		if(Integer.valueOf(Productnum)<0) {
			JOptionPane.showMessageDialog(this, "物品数量不能小于0！");
			return;
		}
		Product product = new Product();
		product.setName(Productname);
		product.setWeight(Double.valueOf(Productweight));
		product.setPrice(Double.valueOf(Productprice));
		product.setNum(Integer.valueOf(Productnum));
		product.setSize(Productsize);
		product.setTime(TimeUtil.timeGet());
		Productdao productdao = new Productdao();
		if(productdao.addProduct(product)) {
			JOptionPane.showMessageDialog(this, "物品添加成功！");
		}else {
			JOptionPane.showMessageDialog(this, "库中有同名物品！");
		}
		productdao.closeDao();
		resetValue(e);
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		ProducttextField.setText("");
		WeighttextField.setText("");
		PricetextField.setText("");
		NumtextField.setText("");
		SizecomboBox.setSelectedIndex(0);
	}
}
