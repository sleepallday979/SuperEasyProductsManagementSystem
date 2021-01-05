package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.util.List;
import java.util.Vector;
import java.awt.Point;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Productdao;
import model.Product;
import utils.DoubleUtil;
import utils.IntUtil;
import utils.StringUtil;
import utils.TimeUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class ProductManage extends JInternalFrame {
	private JTextField searchtextField;
	private JTable productListtable;
	private JTextField NewNametextField;
	private JTextField NewWeighttextField;
	private JTextField NewPricetextField;
	private JTextField NewNumtextField;
	private JButton submitEditButton;
	private JButton submitDeleteButton;
	private JComboBox NewSizecomboBox;
	private JComboBox searchcomboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductManage frame = new ProductManage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public ProductManage(){
		setClosable(true);
		setIconifiable(true);
		setTitle("\u7269\u54C1\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 714, 535);
		
		searchtextField = new JTextField();
		searchtextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchAct(e);
			}
		});
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("\u7269\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEditAct(e);
			}
		});
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		submitDeleteButton = new JButton("\u5220\u9664");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delectProduct(e);
			}
		});
		submitDeleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchcomboBox = new JComboBox();
		searchcomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\u7269\u54C1\u7F16\u53F7", "\u7269\u54C1\u540D\u79F0", "\u7269\u54C1\u5355\u4EF7", "\u7269\u54C1\u5C3A\u5BF8"}));
		searchcomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u7269\u54C1\u91CD\u91CF\uFF1A");
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("\u7269\u54C1\u5355\u4EF7\uFF1A");
		lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3 = new JLabel("\u7269\u54C1\u6570\u91CF\uFF1A");
		lblNewLabel_1_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_4 = new JLabel("\u7269\u54C1\u5C3A\u5BF8\uFF1A");
		lblNewLabel_1_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		NewSizecomboBox = new JComboBox();
		NewSizecomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\u5C0F", "\u4E2D", "\u5927"}));
		
		NewNametextField = new JTextField();
		NewNametextField.setColumns(10);
		
		NewWeighttextField = new JTextField();
		NewWeighttextField.setColumns(10);
		
		NewPricetextField = new JTextField();
		NewPricetextField.setColumns(10);
		
		NewNumtextField = new JTextField();
		NewNumtextField.setColumns(10);
		
		Productdao productdao = new Productdao();
		JLabel numLabel = new JLabel("\u5E93\u4E2D\u603B\u6570\uFF1A"+productdao.SumNum());
		numLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		productdao.closeDao();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(63, Short.MAX_VALUE)
					.addComponent(searchcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(146))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(NewWeighttextField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(NewNametextField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(NewPricetextField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(NewNumtextField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(NewSizecomboBox, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(submitEditButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(submitDeleteButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(numLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(numLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(NewNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(NewWeighttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(NewPricetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(NewNumtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(submitEditButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(NewSizecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitDeleteButton))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		productListtable = new JTable();
		productListtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});
		productListtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7269\u54C1\u7F16\u53F7", "\u7269\u54C1\u540D\u79F0", "\u7269\u54C1\u91CD\u91CF", "\u7269\u54C1\u5355\u4EF7", "\u7269\u54C1\u6570\u91CF", "\u7269\u54C1\u5C3A\u5BF8", "\u5165\u5E93\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(productListtable);
		getContentPane().setLayout(groupLayout);
		setTable(new Product());
	}
	protected void searchAct(ActionEvent e) {
		// TODO Auto-generated method stub
		Product p = new Product();
		String style = searchcomboBox.getSelectedItem().toString();
		if("物品编号".equals(style) ) {
			p.setId(Integer.valueOf(searchtextField.getText().toString()));
		}else if("物品名称".equals(style) ) {
			p.setName(searchtextField.getText().toString());
		}else if("物品单价".equals(style)) {
			p.setPrice(Double.valueOf(searchtextField.getText().toString()));
		}else if("物品尺寸".equals(style)) {
			p.setSize(searchtextField.getText().toString());
		}
		setTable(p);
	}

	protected void delectProduct(ActionEvent e){
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "确定删除吗？")!=JOptionPane.OK_OPTION) {
			return;
		}
		 int index = productListtable.getSelectedRow();
		 if(index ==-1) {
			 JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			 return;
		 }
		 DefaultTableModel dft = (DefaultTableModel) productListtable.getModel();
		 int id = Integer.parseInt(dft.getValueAt(productListtable.getSelectedRow(), 0).toString());
		 Productdao productdao = new Productdao();
		 if(productdao.delete(id)) {
			 JOptionPane.showMessageDialog(this, "删除成功！");
		 }else {
			 JOptionPane.showMessageDialog(this, "删除失败！");
		 }
		 productdao.closeDao();
		 setTable(new Product());
	}

	protected void submitEditAct(ActionEvent e){
		// TODO Auto-generated method stub
		 int index = productListtable.getSelectedRow();
		 if(index ==-1) {
			 JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			 return;
		 }
		 DefaultTableModel dft = (DefaultTableModel) productListtable.getModel();
		 Product product = new Product();
		 String productname = dft.getValueAt(productListtable.getSelectedRow(), 1).toString();
		 String productweight = dft.getValueAt(productListtable.getSelectedRow(), 2).toString();
		 String productprice = dft.getValueAt(productListtable.getSelectedRow(), 3).toString();
		 String productnum = dft.getValueAt(productListtable.getSelectedRow(), 4).toString();
		 String productsize = dft.getValueAt(productListtable.getSelectedRow(), 5).toString();

		 String editProductName = NewNametextField.getText().toString();
		 String editProductWeight = NewWeighttextField.getText().toString();
		 String editProductPrice = NewPricetextField.getText().toString();
		 String editProductNum = NewNumtextField.getText().toString();
		 String editProductsize = NewSizecomboBox.getSelectedItem().toString();
		 
		 if(productname.equals(editProductName) && productweight.equals(editProductWeight) 
			&& productprice.equals(editProductPrice) && productnum.equals(editProductNum)
			&& productsize.equals(editProductsize)) {
			 JOptionPane.showMessageDialog(this, "您还未做任何修改！");
			 return;
		 }
		 int id = Integer.parseInt(dft.getValueAt(productListtable.getSelectedRow(), 0).toString());
		 if(!IntUtil.isInteger(editProductNum)) {
			JOptionPane.showMessageDialog(this, "物品数量必须为整数！");
			return;
		 }
		if(!(DoubleUtil.isDouble(editProductWeight)||IntUtil.isInteger(editProductWeight))) {
			JOptionPane.showMessageDialog(this, "物品重量必须为数字！");
			return;
		}
		if(!(DoubleUtil.isDouble(editProductPrice)||IntUtil.isInteger(editProductPrice))) {
			JOptionPane.showMessageDialog(this, "物品价格必须为数字！");
			return;
		}
		 Product p = new Product();
		 p.setId(id);
		 p.setName(editProductName);
		 p.setWeight(Double.valueOf(editProductWeight));
		 p.setPrice(Double.valueOf(editProductPrice));
		 p.setNum(Integer.valueOf(editProductNum));
		 p.setSize(editProductsize);
		 Productdao productdao = new Productdao();
		 if(productdao.update(p)) {
			 JOptionPane.showMessageDialog(this, "修改成功！");
		 }else {
			 JOptionPane.showMessageDialog(this, "修改失败！");
		 }
		 productdao.closeDao();
		 setTable(new Product());
	}

	protected void selectedTableRow(MouseEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) productListtable.getModel();
		NewNametextField.setText(dft.getValueAt(productListtable.getSelectedRow(), 1).toString());
		NewWeighttextField.setText(dft.getValueAt(productListtable.getSelectedRow(), 2).toString());
		NewPricetextField.setText(dft.getValueAt(productListtable.getSelectedRow(), 3).toString());
		NewNumtextField.setText(dft.getValueAt(productListtable.getSelectedRow(), 4).toString());
		NewSizecomboBox.setSelectedItem(dft.getValueAt(productListtable.getSelectedRow(), 5).toString());
	}

	private void setTable(Product product){
		DefaultTableModel dft = (DefaultTableModel) productListtable.getModel();
		dft.setRowCount(0);
		Productdao productdao = new Productdao();
		List<Product> productList = productdao.getProductList(product);
		for(Product p:productList) {
			Vector v =new Vector();
			v.add(p.getId());
			v.add(p.getName());
			v.add(p.getWeight());
			v.add(p.getPrice());
			v.add(p.getNum());
			v.add(p.getSize());
			v.add(p.getTime());
			dft.addRow(v);
		}
		productdao.closeDao();
	}
}
