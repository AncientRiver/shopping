package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public final class JdbcUtil {
	
	private static String driver="com.mysql.jdbc.Driver";   //加载数据库驱动
	private static String url="jdbc:mysql://localhost:3306/shoppingtest";  //数据库连接的url
	private static String user="root";  //数据库用户名
	private static String password="5572121657";  //数据库密码
	private Connection conn=null; 
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private static JdbcUtil jdbcUtil=null;
	
	private JdbcUtil(){
		
	}
	
	/**
	 * @return
	 * 初始化jdbcUtil，采用懒汉式加载
	 */
	public static JdbcUtil getInitJdbcUtil(){
		if(jdbcUtil==null){
			synchronized (JdbcUtil.class) {
				if(jdbcUtil==null){
					jdbcUtil=new JdbcUtil();
				}
			}
		}
		return jdbcUtil;
	}
	
	
	/**
	 * 通过静态代码块注册数据库驱动，保证注册只执行一次
	 */
	static{
		try{
			Class.forName(driver);			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @return数据库的连接
	 */
	public Connection getConnection(){
		try{
			conn=DriverManager.getConnection(url,user,password);
			if(conn!=null){
				System.out.println("DB connection Successful!!");
			}else{
				System.out.println("DB connection Falied!");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	

	/**
	 * 依次关闭所有资源
	 */
	private  void closeAll(){
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * insert、delete、update Sql语句的执行的统一方法
	 * @param sql  sql语句
	 * @param params  参数数组，如果没有则为null
	 * @return  返回受影响的行数
	 */
	
	public int executeUpdate(String sql,Object[] params){
//		受影响的行数
		int affectedLine=0;
		
		try{
//			获取链接	
			conn=this.getConnection();
//			调用sql语句
			pstmt=conn.prepareStatement(sql);
//			参数赋值
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
//			执行更新操作
			affectedLine=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return affectedLine; 
		
	}
	

	/**
	 * 将sql查询结果直接放入到ResultSet中
	 * 
	 * @param sql 
	 *            sql语句  
	 * @param params
	 *            参数数组，如果没有则为null
	 * @return
	 *            返回结果集
	 */
	private ResultSet executeQueryRS(String sql,Object[] params){
		try{
			conn=this.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs=pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public List<Object> executeQuery(String sql,Object[] params){
//		获得结果集
		ResultSet rs=executeQueryRS(sql, params);
//		用于获取ResultSet元数据信息
		ResultSetMetaData rsmd=null;
//		结果集列数
		int columnCount=0;
		try{
			rsmd=rs.getMetaData();//获得结果集的元数据信息
			columnCount=rsmd.getColumnCount();//获得结果集列表
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		List<Object> list=new ArrayList<Object>();
//		将resultset结果存放到list中
		try{
			while(rs.next()){
				Map<String , Object> map=new HashMap<String, Object>();
				for(int i=1;i<=columnCount;i++){
					map.put(rsmd.getColumnName(i),rs.getObject(i));
				}
				list.add(map);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			closeAll();
		}
		return list;
	}
	
	
	/**
	 * 查询一行结果
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object executeQuerySingle(String sql,Object[] params){
		Map<String, Object> map=new HashMap<String, Object>();
		try{
			conn=this.getConnection();
			pstmt=conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs=executeQueryRS(sql, params);
			ResultSetMetaData rsmd=null;
			
			int columnCount=0;
			try{
				rsmd=rs.getMetaData();
				columnCount=rsmd.getColumnCount();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			if(rs.next()){  //找到一条记录
				for(int i=1;i<=columnCount;i++){
					map.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			closeAll();
		}
		return map;
	}
}
