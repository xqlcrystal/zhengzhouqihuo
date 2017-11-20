/**
 * 
 */
package com.crystal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import com.crystal.domain.FutureDataTradeamt;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class DbUtil {

    /**
     * @param sql
     */
    public static void insert(String sql, List<FutureDataTradeamt> students) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);

            for(FutureDataTradeamt student:students){
            ps.setString(1, student.getMemberno());
            ps.setString(2, student.getMembername());
            ps.setInt(3, student.getRankingvol());
            ps.setInt(4, student.getRankingamount());
            ps.setDouble(5, student.getVol());
            ps.setDouble(6, student.getAmount());
            ps.setDate(7, student.getCurdate());

            boolean flag = ps.execute();
            if(!flag){
                System.out.println(student.toString());
            }}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

/*    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List selectOne(String sql, Student student) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("no").equals(student.getNo()) || rs.getString("name").equals(student.getName())|| rs.getString("age").equals(student.getAge())){
                    list.add(1);
                }else{
                    list.add(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    
    public static ResultSet selectAll(String sql) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return rs;
    }*/

}