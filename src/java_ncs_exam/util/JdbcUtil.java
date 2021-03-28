package java_ncs_exam.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	public static Connection getConnection() {
		Connection con = null;
		String propertiesPath = "db.properties"; // ���ҽ� �ؿ� ���ϸ�� ��ġ�ؾߵ�

		try (InputStream in = ClassLoader.getSystemResourceAsStream(propertiesPath)) {
			Properties prop = new Properties(); // key = value
			prop.load(in);
			
			try {
				con = DriverManager.getConnection(prop.getProperty("url"), prop);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return con;
	}

}