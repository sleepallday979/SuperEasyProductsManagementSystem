package dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import model.Product;
public class FileOutdao extends Basedao{
	public void Outfile() throws RowsExceededException, WriteException, IOException, ClassNotFoundException {
	 //1. ����Excel��·��
    String filePath = "D:/product.xls";
    WritableWorkbook wwb =null;

    try {
        wwb = Workbook.createWorkbook(new File(filePath));
    } catch (Exception e) {
        e.printStackTrace();
    }
    WritableSheet sheet = wwb.createSheet("��Ʒ��Ϣ",0);//����rwb.getSheet(0)��ȡ��һ������
    //����titles
    String[] titles={"��Ʒ���","��Ʒ����","��Ʒ����","��Ʒ����","��Ʒ����","��Ʒ�ߴ�","���ʱ��"};
    //��Ԫ��
    Label label=null;
    //��һ����������
    for(int i=0;i<titles.length;i++){

        label=new Label(i,0,titles[i]);
          //��ӵ�Ԫ��
        sheet.addCell(label);
     }

    try {
        //�������ݿ�
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/product?serverTimezone-UTC&useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
        String sql = "select * from product";
		con=DriverManager.getConnection(url,user,password);
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        List<Product> list = new ArrayList<>();
        while(rs.next()){
        	Product product = new Product();
        	product.setId(rs.getInt(1));
        	product.setName(rs.getString(2));
        	product.setWeight(rs.getDouble(3));
        	product.setPrice(rs.getDouble(4));
        	product.setNum(rs.getInt(5));
        	product.setSize(rs.getString(6));
        	product.setTime(rs.getString(7));
            list.add(product);
        }
        ps.close();
        con.close();
        for(int i = 0; i<list.size(); i++){
            //Number��Ӧ���ݿ��int double��������
            sheet.addCell(new Number(0,i+1,list.get(i).getId()));//0 �У�i+1��
            //Label��Ӧ���ݿ�String��������
            sheet.addCell(new Label(1,i+1,list.get(i).getName()));//1�У�i+1��
            //Label��Ӧ���ݿ�String��������
            sheet.addCell(new Number(2,i+1,list.get(i).getWeight()));//2�У�i+1��
            sheet.addCell(new Number(3,i+1,list.get(i).getPrice()));//3�У�i+1��
            sheet.addCell(new Number(4,i+1,list.get(i).getNum()));//4�У�i+1��
            sheet.addCell(new Label(5,i+1,list.get(i).getSize()));//5�У�i+1��
            sheet.addCell(new Label(6,i+1,list.get(i).getTime()));//6�У�i+1��
        }
        wwb.write();

    } catch (SQLException e) {
        e.printStackTrace();
    }finally{
        wwb.close();
    }
}
}

