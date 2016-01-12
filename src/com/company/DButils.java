package com.company;

import javax.management.Query;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by DanNetoff on 12.12.2015.
 */
public class DButils {

    public static List<Map<String, Object>> getList(String q1, Object... params) throws SQLException, ParseException, ClassNotFoundException {

        List<Map<String, Object>> list = new LinkedList<>();
        ResultSet myRes = getResultSet(q1, params);
        ResultSetMetaData rsmd = null;

        try {
            rsmd = myRes.getMetaData();
            while (myRes.next()) {
                Map<String, Object> row = new IdentityHashMap<>();
                for (int indexCol = 1; indexCol <= rsmd.getColumnCount(); indexCol++) {
                    row.put(rsmd.getColumnLabel(indexCol), myRes.getObject(indexCol));
                }
                list.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return  list;
    }

    public static ResultSet getResultSet(String q1, Object... params) throws SQLException, ClassNotFoundException, ParseException {
        PreparedStatement stmt = null;
        try {
            stmt = connectionToMDB.getConnection().prepareStatement(q1,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            DButils.setParameters(stmt,params);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void setParameters(PreparedStatement preparedStatement, Object... params) throws SQLException {
        if(params != null){
            int pos = 0;
            for(Object o : params){
                pos++;

                if(o.getClass().equals(java.util.Date.class)){
                    preparedStatement.setDate(pos, new java.sql.Date(((Date) o).getTime()));
                    continue;
                }
                if(o.getClass().equals(java.lang.Integer.class)){
                    preparedStatement.setInt(pos, (Integer) o);
                    continue;
                }
                if(o.getClass().equals(java.lang.Double.class)){
                    preparedStatement.setDouble(pos, (Double) o);
                    continue;
                }
                if(o.getClass().equals(java.lang.String.class)){
                    preparedStatement.setString(pos, (String) o);
                    continue;
                }
            }

        }

    }

}
