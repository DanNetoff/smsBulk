
package com.company;


import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {


        String query = "SELECT * FROM operation WHERE op = ? AND date_op = ?";

        /*
        Map<Integer, Map<String, Object>> map = new LinkedHashMap<>();

        int i =1;

        Map<String, Object> row = new HashMap<>();

        try {

            PreparedStatement stmt = connectionToMDB.getConnection().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            stmt.setInt(1,1);


            Date param1;
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern("dd/MM/yyyy");
            // Date myDate = null;
            java.util.Date myDate = new java.util.Date();
            myDate = sdf.parse("01/12/2015");


            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());





            stmt.setDate(2, sqlDate);
            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData rsmt = resultSet.getMetaData();

            int rowsCount = 0;

            while (resultSet.next()){
                rowsCount++;
            }

            System.out.println(rowsCount);

           resultSet.beforeFirst();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Map.Entry<Integer, Map<String, Object>>> myCollection= map.entrySet();

        for(Entry<Integer, Map<String, Object>> entry : map.entrySet()){
            System.out.println("rowNumber:" + entry.getKey());
            Map<String, Object> value = entry.getValue();
            for (Entry<String,Object> e : value.entrySet()) {
                System.out.println(e.getKey());
                System.out.println(e.getValue());
            }
        }
        */
/*
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd/MM/yyyy");
        // Date myDate = null;
        java.util.Date myDate = new java.util.Date();
        myDate = sdf.parse("07/12/2015");


        List<Map<String, Object>> myList = DButils.getList(query,1,myDate);


        System.out.println(myList.toString());
*/

        

    }



}
