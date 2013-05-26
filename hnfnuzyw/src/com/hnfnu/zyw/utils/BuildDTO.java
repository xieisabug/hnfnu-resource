package com.hnfnu.zyw.utils;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class BuildDTO {
	private DatabaseMetaData dbMetaData = null;
	private Connection conn = null;
	private PrintWriter pw = null;

	private void getDatabaseMetaData() {
		try {
			if (dbMetaData == null) {

				conn = DBUtil.getConnection();
				dbMetaData = conn.getMetaData();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得该用户下面的所有表
	 */
	public void getAllTableList(String schemaName) {
		getDatabaseMetaData();
		try {
			String[] types = { "TABLE" };
			ResultSet rs = dbMetaData.getTables(null, schemaName, "%", types);
			while (rs.next()) {
				String tableName = rs.getString("TABLE_NAME");
				//开始生成Dto
				build(schemaName, tableName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void build(String schemaName, String tableName) {

		String className = "";
		try {
			ResultSet rs = dbMetaData.getColumns(null, schemaName, tableName,
					"%");
			
			String[] classNameT = tableName.split("_");
			for(int i=1;i<classNameT.length;i++){
				
				className += classNameT[i].substring(0,1).toUpperCase();
				className += classNameT[i].substring(1);
			}
			
			
			//String _className = tableName.substring(2);
			//System.out.println("类名" + className);
			//className = _className.substring(0,1);
			//className = className.toUpperCase();
			//className += _className.substring(1);
			
		//System.out.println("类名" + className);
			//生成后的Dto所在的文件
			pw = new PrintWriter(new File("e:\\javaDto\\" + className + "Dto.java"));

			pw.println("/**");
			pw.println("* 通过数据库内表的字段动态生成 " + className + "Dto");
			pw.println("**/");
			pw.println("public class " + className + "Dto \n{\t");



			while (rs.next()) {
				String pStr = ""; // setXxxx
				String typeStr = ""; // 类型
				String notes = "";// 注释

				// 获取列名
				String columName = rs.getString("COLUMN_NAME");
				// 获取每一列的数据类型
				int type = rs.getInt("DATA_TYPE");
				System.out.println("数据类型：" + type);

				String comments = rs.getString("REMARKS");

				// 判断
				if (Types.INTEGER == type) {
					typeStr = "Integer";
				} else if (Types.VARCHAR == type ||type == -1) {
					typeStr = "String";
				}else if (Types.DATE == type || type == 93){//这是因为我没找到text的类型常量是什么。
					typeStr = "Date";
				}

				// 组装注释
				//System.out.println("comments:" + comments);
				if (comments != null && !comments.equals("")) {
					notes += "\t//";
					notes += comments;
					// 输出注释
					pw.println(notes);
				}

				// 组装 private 的语句
				pStr += "private " + typeStr + " " + columName + ";";

				// 输出 private 的字段
				pw.println("\t" + pStr + "");

			}

			String constructStr = ""; // 构造
			// 组装空参构造
			constructStr += "public " + className + "Dto()\n\t{\n\n\t}";
			// 输出空参构造
			pw.println("\n\t" + constructStr + "\n");

			rs = dbMetaData.getColumns(null, schemaName, tableName, "%");

			while (rs.next()) {
				String getStr = "";
				String setStr = "";
				String typeStr = "";

				// 获取列名
				String columName = rs.getString("COLUMN_NAME");
				// 获取每一列的数据类型
				int type = rs.getInt("DATA_TYPE");

				// 判断
				if (Types.INTEGER == type) {
					typeStr = "Integer";
				} else if (Types.VARCHAR == type ||type == -1) {
					typeStr = "String";
				}else if (Types.DATE == type || type == 93){//这是因为我没找到text的类型常量是什么。
					typeStr = "Date";
				}
				// 组装 set 的语句
				setStr += "public void set"
						+ columName.substring(0, 1).toUpperCase() + ""
						+ columName.substring(1) + "(" + typeStr + " "
						+ columName + ")\n\t{\n";
				setStr += "\t\tthis." + columName + " = " + columName
						+ ";\n\t}";

				// 组装get语句
				getStr += "public " + typeStr + " get"
						+ columName.substring(0, 1).toUpperCase() + ""
						+ columName.substring(1) + "()\n\t{\n\t";
				getStr += "\treturn this." + columName + ";\n\t}";
				// 输出 set
				pw.println("\t" + setStr);
				// 输出 get
				pw.println("\t" + getStr);
			}

			pw.println("}");

			// 缓冲
			pw.flush();
			pw.close();
			System.out.println(className+"Dto.java创建成功！");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		BuildDTO dto = new BuildDTO();

		dto.getAllTableList("hnfnuzyw");
	}
}