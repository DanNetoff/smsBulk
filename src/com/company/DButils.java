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

    public static ResultSet getResultSet(String q1, Object... params) throws SQLException, ClassNotFoundException, ParseException {


        PreparedStatement stmt = null;
        try {
        stmt = connectionToMDB.getConnection().prepareStatement(
                                q1,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


            DButils.setParameters(stmt,params);

            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static List<Map<String, Object>> getList(String q1, Object... params) throws SQLException, ParseException, ClassNotFoundException {

        List<Map<String, Object>> list = new LinkedList<>();
        ResultSet myRes = getResultSet(q1,params);
        ResultSetMetaData rsmt = null;


        try {
            rsmt = myRes.getMetaData();

            while (myRes.next()) {
                Map<String, Object> row = new IdentityHashMap<>();
                for (int indexCol = 1; indexCol <= rsmt.getColumnCount(); indexCol++) {
                    row.put(rsmt.getColumnLabel(indexCol), myRes.getObject(indexCol));
                }
                list.add(row);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();

        }



        Map<String, Object> row = new IdentityHashMap<>();
        int i =1;
        while (myRes.next()){
            row.put("id", myRes.getObject("id"));
            row.put("op", myRes.getObject("op"));
            row.put("date_op", myRes.getObject("date_op"));
            list.add(row);
            i++;
        }
      return  list;
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
