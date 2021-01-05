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
	 //1. 导出Excel的路径
    String filePath = "D:/product.xls";
    WritableWorkbook wwb =null;

    try {
        wwb = Workbook.createWorkbook(new File(filePath));
    } catch (Exception e) {
        e.printStackTrace();
    }
    WritableSheet sheet = wwb.createSheet("物品信息",0);//或者rwb.getSheet(0)获取第一个区域
    //设置titles
    String[] titles={"物品编号","物品名称","物品重量","物品单价","物品数量","物品尺寸","入库时间"};
    //单元格
    Label label=null;
    //第一行设置列名
    for(int i=0;i<titles.length;i++){

        label=new Label(i,0,titles[i]);
          //添加单元格
        sheet.addCell(label);
     }

    try {
        //连接数据库
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
            //Number对应数据库的int double类型数据
            sheet.addCell(new Number(0,i+1,list.get(i).getId()));//0 列，i+1行
            //Label对应数据库String类型数据
            sheet.addCell(new Label(1,i+1,list.get(i).getName()));//1列，i+1行
            //Label对应数据库String类型数据
            sheet.addCell(new Number(2,i+1,list.get(i).getWeight()));//2列，i+1行
            sheet.addCell(new Number(3,i+1,list.get(i).getPrice()));//3列，i+1行
            sheet.addCell(new Number(4,i+1,list.get(i).getNum()));//4列，i+1行
            sheet.addCell(new Label(5,i+1,list.get(i).getSize()));//5列，i+1行
            sheet.addCell(new Label(6,i+1,list.get(i).getTime()));//6列，i+1行
        }
        wwb.write();

    } catch (SQLException e) {
        e.printStackTrace();
    }finally{
        wwb.close();
    }
}
}

