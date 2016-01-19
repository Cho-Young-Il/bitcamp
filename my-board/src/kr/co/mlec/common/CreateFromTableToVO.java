package kr.co.mlec.common;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class CreateFromTableToVO {
	private StringBuilder sb = new StringBuilder();
	private final String TAB = "    ";
	public static void main(String[] args) throws Exception {
		CreateFromTableToVO test = new CreateFromTableToVO();
		test.execute();
	}
	
	private void execute() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521", "hr", "hr");
			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.print("VO를 생성할 테이블명(종료 : exit) : ");
				
				String tableName = sc.nextLine();  
				if (tableName.equals("exit")) break;
				
				String sql = "select * from " + tableName;
				stmt = con.prepareStatement(sql);
				sb.delete(0, sb.length());
	
				ResultSet rs = stmt.executeQuery();
				ResultSetMetaData rsMeta = rs.getMetaData();
				
				tableName = tableName.replace("T77_", "")
						             .replace("t77_", "")
									 .replace("t_", "")
									 .replace("T_", "");
				
				String className = getInitCap(makeFieldName(tableName)) + "VO";
				
				sb.append("public class " + className + " {\n");
				
				makeField(rsMeta);  // 필드 생성
				
				makeMethod(rsMeta); // set, get 메서드 생성
	
				sb.append("}");
				System.out.println(sb.toString());
				// class 클래스 생성
				makeClassFile(className, sb);
				
				// 버퍼 내용 삭제
				sb.delete(0, sb.length());
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getInitCap(String name){
		String result = name.substring(0,1).toUpperCase() + name.substring(1,name.length());
		return result;
	}
	
	private String getUpperName(String name){
		return name.substring(0,1).toUpperCase() + name.substring(1,name.length()).toLowerCase();
	}
	
	private String getLowerName(String name){
		return name.substring(0,1).toLowerCase() + name.substring(1,name.length()).toLowerCase();
	}
	
	private String makeDataTypeName(String colTypeName){
		if (colTypeName.equalsIgnoreCase("VARCHAR2") ||
				colTypeName.equalsIgnoreCase("CHAR")) {
			return "String";
		} else if (colTypeName.equalsIgnoreCase("NUMBER")) {
			return "Integer";
		} else if (colTypeName.equalsIgnoreCase("DATE")) {
			return "Date";
		}
		return "String";
	}
	
	private void makeField(ResultSetMetaData rsMeta) throws Exception {
		for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
			sb.append("    private ");
			// 데이터 타입 선언
			String dataType = makeDataTypeName(rsMeta.getColumnTypeName(i));
			if (dataType.equalsIgnoreCase("Date")) {
				sb.insert(0, "import java.util.Date;\n");
			}
			sb.append(makeDataTypeName(rsMeta.getColumnTypeName(i)) + " ");
			
			// 필드명 선언
			sb.append(makeFieldName(rsMeta.getColumnName(i)) + ";\n");
		}
	}
	
	private String makeFieldName(String colName){
		String resultName = "";
		String[] colNameArr = colName.split("_");
		for(int i = 0; i < colNameArr.length; i++) {
			if (i == 0) {
				resultName =  getLowerName(colNameArr[i]);
				continue;
			}
			resultName += getUpperName(colNameArr[i]);
		}
		return resultName;
	}

	private void makeMethod(ResultSetMetaData rsMeta) throws Exception {
		sb.append("\n");
		for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
			String colName = rsMeta.getColumnName(i);
			String colType = rsMeta.getColumnTypeName(i);
			sb.append("\n");
			makeSetMethod(colName, colType);
			sb.append("\n");
			makeGetMethod(colName, colType);
		}
		System.out.println(sb.toString());
	}
	
	private void makeSetMethod(String colName, String colType) {
		String fieldName = makeFieldName(colName);
		sb.append(TAB + "public void set" + getInitCap(fieldName));
		sb.append("(" + makeDataTypeName(colType) + " " + fieldName + ")");
		sb.append(" { \n");
		sb.append(TAB + TAB + "this." + fieldName + " = " + fieldName + ";\n");
		sb.append(TAB + "}\n");
	}
	
	private void makeGetMethod(String colName, String colType) {
		String fieldName = makeFieldName(colName);
		sb.append(TAB + "public " + makeDataTypeName(colType) + " get" + getInitCap(fieldName) + "()");
		sb.append(" { \n");
		sb.append(TAB + TAB + "return " + makeFieldName(colName) + ";\n");
		sb.append(TAB + "}\n");
	}
	
	public void makeClassFile (String className, StringBuilder sb) throws Exception {
		FileWriter fw = new FileWriter("./result/" + className + ".java");
		fw.write(sb.toString());
		fw.close();
	}
}