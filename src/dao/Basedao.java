package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import utils.JDBCUtils;
import utils.StringUtil;
public class Basedao {
	public Connection con = new JDBCUtils().getConnection();
	public void closeDao() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
