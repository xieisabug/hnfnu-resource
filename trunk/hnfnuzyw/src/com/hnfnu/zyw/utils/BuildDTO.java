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
	 * 
	 */
	public void getAllTableList(String schemaName) {
		getDatabaseMetaData();
		try {
			String[] types = { "TABLE" };
			ResultSet rs = dbMetaData.getTables(null, schemaName, "%", types);
			while (rs.next()) {
				String tableName = rs.getString("TABLE_NAME");
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
			//className = _className.substring(0,1);
			//className = className.toUpperCase();
			//className += _className.substring(1);
			
			pw = new PrintWriter(new File("e:\\javaDto\\" + className + "Dto.java"));

			pw.println("/**");
			pw.println("* ͨ����ݿ��ڱ���ֶζ�̬��� " + className + "Dto");
			pw.println("**/");
			pw.println("public class " + className + "Dto \n{\t");



			while (rs.next()) {
				String pStr = ""; // setXxxx
				String typeStr = ""; // ����
				String notes = "";// ע��

				// ��ȡ����
				String columName = rs.getString("COLUMN_NAME");
				// ��ȡÿһ�е��������
				int type = rs.getInt("DATA_TYPE");

				String comments = rs.getString("REMARKS");

				// �ж�
				if (Types.INTEGER == type) {
					typeStr = "Integer";
				} else if (Types.VARCHAR == type ||type == -1) {
					typeStr = "String";
				}else if (Types.DATE == type || type == 93){//������Ϊ��û�ҵ�text�����ͳ�����ʲô��
					typeStr = "Date";
				}

				// ��װע��
				//System.out.println("comments:" + comments);
				if (comments != null && !comments.equals("")) {
					notes += "\t//";
					notes += comments;
					// ���ע��
					pw.println(notes);
				}

				// ��װ private �����
				pStr += "private " + typeStr + " " + columName + ";";

				// ��� private ���ֶ�
				pw.println("\t" + pStr + "");

			}

			String constructStr = ""; // ����
			// ��װ�ղι���
			constructStr += "public " + className + "Dto()\n\t{\n\n\t}";
			// ����ղι���
			pw.println("\n\t" + constructStr + "\n");

			rs = dbMetaData.getColumns(null, schemaName, tableName, "%");

			while (rs.next()) {
				String getStr = "";
				String setStr = "";
				String typeStr = "";

				// ��ȡ����
				String columName = rs.getString("COLUMN_NAME");
				// ��ȡÿһ�е��������
				int type = rs.getInt("DATA_TYPE");

				// �ж�
				if (Types.INTEGER == type) {
					typeStr = "Integer";
				} else if (Types.VARCHAR == type ||type == -1) {
					typeStr = "String";
				}else if (Types.DATE == type || type == 93){//������Ϊ��û�ҵ�text�����ͳ�����ʲô��
					typeStr = "Date";
				}
				// ��װ set �����
				setStr += "public void set"
						+ columName.substring(0, 1).toUpperCase() + ""
						+ columName.substring(1) + "(" + typeStr + " "
						+ columName + ")\n\t{\n";
				setStr += "\t\tthis." + columName + " = " + columName
						+ ";\n\t}";

				// ��װget���
				getStr += "public " + typeStr + " get"
						+ columName.substring(0, 1).toUpperCase() + ""
						+ columName.substring(1) + "()\n\t{\n\t";
				getStr += "\treturn this." + columName + ";\n\t}";
				// ��� set
				pw.println("\t" + setStr);
				// ��� get
				pw.println("\t" + getStr);
			}

			pw.println("}");

			// ����
			pw.flush();
			pw.close();
			System.out.println(className+"Dto.java�����ɹ���");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		BuildDTO dto = new BuildDTO();

		dto.getAllTableList("hnfnuzyw");
	}
}