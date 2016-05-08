package com.android.website.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	public static void main(String[] args) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// SQL数据库引擎
		String connectDB = "jdbc:sqlserver://192.168.1.106:1433;DatabaseName=wiscosysdb";
		// 数据源 ！！！！注意若出现加载或者连接数据库失败一般是这里出现问题
		// 我将在下面详述
		try {
			// 加载数据库引擎，返回给定字符串名的类
			Class.forName(JDriver);
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		System.out.println("数据库驱动成功");

		try {
			String user = "sa";
			// 这里只要注意用户名密码不要写错即可
			String password = "root";
			Connection con = DriverManager.getConnection(connectDB, user, password);
			// 连接数据库对象
			System.out.println("连接数据库成功");
			Statement stmt = con.createStatement();
			// 创建SQL命令对象

			// 创建表
			System.out.println("开始创建表");
			// 创建表SQL语句
			String query = "create table TABLE(ID NCHAR(2),NAME NCHAR(10))";
			stmt.executeUpdate(query);// 执行SQL命令对象
			System.out.println("表创建成功");

			// 输入数据
			System.out.println("开始插入数据");
			String a1 = "INSERT INTO TABLE1 VALUES('1','旭哥')";
			// 插入数据SQL语句
			String a2 = "INSERT INTO TABLE1 VALUES('2','伟哥')";
			String a3 = "INSERT INTO TABLE1 VALUES('3','张哥')";
			stmt.executeUpdate(a1);// 执行SQL命令对象
			stmt.executeUpdate(a2);
			stmt.executeUpdate(a3);
			System.out.println("插入数据成功");

			// 读取数据
			System.out.println("开始读取数据");
			ResultSet rs = stmt.executeQuery("SELECT * FROM TABLE1");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				System.out.println(rs.getString("ID") + "\t" + rs.getString("NAME"));
			}
			System.out.println("读取完毕");

			// 关闭连接
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getErrorCode());
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
	}
}