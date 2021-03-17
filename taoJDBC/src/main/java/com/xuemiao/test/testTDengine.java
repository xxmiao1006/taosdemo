package com.xuemiao.test;

import com.taosdata.jdbc.TSDBDriver;

import java.sql.*;
import java.util.Properties;

/**
 * @author xxm
 * @date 2021/3/8 15:44
 */
public class testTDengine {
    private static String str = "";

    public static void main(String[] args) throws Exception {

        /*Class.forName("com.taosdata.jdbc.rs.RestfulDriver");
        String jdbcUrl = "jdbc:TAOS-RS://node1:6041/test?user=root&password=taosdata";
        Connection conn = DriverManager.getConnection(jdbcUrl);*/


        Class.forName("com.taosdata.jdbc.TSDBDriver");
        String jdbcUrl = "jdbc:TAOS://node1:6030/test?user=root&password=taosdata";
        Connection conn = DriverManager.getConnection(jdbcUrl);


        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from test.meters limit 1000000");
        printResult(resultSet);




        //单个新增
        //int i = statement.executeUpdate("insert into db.stack001 values ('2021-03-08 14:07:42.422',1,2,3);");

        //批量新增
        /*statement.addBatch("insert into db.stack001 values ('2021-03-08 14:07:42.432',1,2,3)");
        statement.addBatch("insert into db.stack001 values ('2021-03-08 14:07:42.442',1,2,3)");
        int[] ints = statement.executeBatch();*/


    }

    private static void printResult(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int  j = 1;
        while (resultSet.next()) {
            System.out.println(j++);
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnLabel = metaData.getColumnLabel(i);
                String value = resultSet.getString(i);
                System.out.printf("%s: %s\t", columnLabel, value);
            }
            System.out.println();
        }
    }

}
