/**
 * 
 */
package com.crystal;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class Common {

    // connect the database
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_NAME = "futuredata";
    public static final String USERNAME = "root";
//    public static final String PASSWORD = "root";
    public static final String PASSWORD = "";
    //   public static final String IP = "192.168.16.105";
    public static final String IP = "localhost";
    public static final String PORT = "3306";
    public static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME+"?characterEncoding=utf-8";
    
    // common
    //public static final String EXCEL_PATH = "lib/student_info.xls";
    
    // sql
    public static final String INSERT_STUDENT_SQL = "insert into futuredatatradeamt(memberno, membername, rankingvol, rankingamount,vol,amount,curdate) values(?, ?, ?, ?,?, ?, ?)";
//    public static final String UPDATE_STUDENT_SQL = "update student_info set no = ?, name = ?, age= ?, score = ? where id = ? ";
//    public static final String SELECT_STUDENT_ALL_SQL = "select id,no,name,age,score from student_info";
//    public static final String SELECT_STUDENT_SQL = "select * from student_info where name like ";
}