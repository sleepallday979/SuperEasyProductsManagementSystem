package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Product;
import utils.JDBCUtils;
import utils.StringUtil;
import utils.TimeUtil;
import view.*;
public class Productdao  extends Basedao{
	public int IdGet() {
		int newId = 1;
		String sqlString = "select max(id) from product";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()) {
				newId= executeQuery.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(StringUtil.isEmpty(newId+"")) {
			newId = 1;
		}
		return newId;
	}
	public int SumNum() {
		int sum = 0;
		String sqlString = "select count(*) from product";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()) {
				sum= executeQuery.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(StringUtil.isEmpty(sum+"")) {
			sum = 0;
		}
		System.out.print(sum);
		return sum;
	}
	public List<Product> getProductList(Product product){
		List<Product> reList = new ArrayList<Product>();
		String sqlString = "select * from product";
		if(product.getId()!=0) {
			sqlString+=" where id = "+product.getId()+"";
		}
		if(!StringUtil.isEmpty(product.getName())) {
			sqlString+=" where name like '%"+product.getName()+"%'";
		}
		if(product.getPrice()!=0) {
			sqlString+=" where price = "+product.getPrice()+"";
		}
		if(!StringUtil.isEmpty(product.getSize())) {
			sqlString+=" where size like '%"+product.getSize()+"%'";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()) {
				Product p = new Product();
				p.setId(executeQuery.getInt(1));
				p.setName(executeQuery.getString(2));
				p.setWeight(executeQuery.getDouble(3));
				p.setPrice(executeQuery.getDouble(4));
				p.setNum(executeQuery.getInt(5));
				p.setSize(executeQuery.getString(6));
				p.setTime(executeQuery.getString(7));
				reList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reList;
	}
	public boolean addProduct(Product product) {
		String sql = "insert into product values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, String.valueOf((IdGet()+1)));
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getWeight());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setInt(5, product.getNum());
			preparedStatement.setString(6, product.getSize());
			preparedStatement.setString(7, product.getTime());
			if(preparedStatement.executeUpdate()>0)	return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int id) {
		String sql = "delete from product where id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate()>0)	return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Product product) {
		String sql="update product set name=?,weight=?,price=?,num=?,size=?,time=? where id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getWeight());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getNum());
			preparedStatement.setString(5, product.getSize());
			preparedStatement.setString(6, TimeUtil.timeGet());
			preparedStatement.setInt(7, product.getId());
			if(preparedStatement.executeUpdate()>0)	return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
