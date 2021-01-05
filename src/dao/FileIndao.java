package dao;

import jxl.*;
import jxl.read.biff.BiffException;
import model.Product;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FileIndao{

    public void Input() throws BiffException, IOException, ClassNotFoundException {
        Workbook book = Workbook.getWorkbook(new File("D:/product.xls"));
        
        //获得第一个工作表对象  
        //Sheet sheet = book.getSheet("sheet_one");
        Sheet sheet = book.getSheet(0);
         int rows = sheet.getRows();
         int j=0;
         int max;
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
                    while(rs.next()){
                		Productdao productdao = new Productdao();
                		Product product = new Product();
                		max = productdao.IdGet()+1;
                		//多了就更新已有的，添加没有的
                		if(max<rows) {
                         	 for(j=1;j<max;j++) {
 	                    	 	
 	                    	 	product.setId(Integer.parseInt(sheet.getCell(0, j).getContents()));
 		                		product.setName(sheet.getCell(1, j).getContents());
 		                		product.setWeight(Double.parseDouble(sheet.getCell(2, j).getContents()));
 		                		product.setPrice(Double.parseDouble(sheet.getCell(3, j).getContents()));
 		                		product.setNum(Integer.parseInt(sheet.getCell(4, j).getContents()));
 		                		product.setSize(sheet.getCell(5, j).getContents());
 		                		product.setTime(sheet.getCell(6, j).getContents());
 		                		productdao.update(product);
 		                     }
                			 for(j=max;j<rows;j++) {
		                 		product.setName(sheet.getCell(1, j).getContents());
		                 		product.setWeight(Double.parseDouble(sheet.getCell(2, j).getContents()));
		                 		product.setPrice(Double.parseDouble(sheet.getCell(3, j).getContents()));
		                 		product.setNum(Integer.parseInt(sheet.getCell(4, j).getContents()));
		                 		product.setSize(sheet.getCell(5, j).getContents());
		                 		product.setTime(sheet.getCell(6, j).getContents());
 		                		productdao.addProduct(product);
	                		}
                    }
	                     else if(max>=rows){
	                    	//更新已经有的
	                    	 Product product1 = new Product();
	                    	 for(j=1;j<rows;j++) {
	                    	 	
	                    	 	product1.setId(Integer.parseInt(sheet.getCell(0, j).getContents()));
		                		product1.setName(sheet.getCell(1, j).getContents());
		                		product1.setWeight(Double.parseDouble(sheet.getCell(2, j).getContents()));
		                		product1.setPrice(Double.parseDouble(sheet.getCell(3, j).getContents()));
		                		product1.setNum(Integer.parseInt(sheet.getCell(4, j).getContents()));
		                		product1.setSize(sheet.getCell(5, j).getContents());
		                		product1.setTime(sheet.getCell(6, j).getContents());
 		                		productdao.update(product1);
		                     }
                    	}
                        productdao.closeDao();
                 } 
                    ps.close();
                    con.close();
                    
             }catch (SQLException e) {
                     e.printStackTrace();
                 }
    }
}
