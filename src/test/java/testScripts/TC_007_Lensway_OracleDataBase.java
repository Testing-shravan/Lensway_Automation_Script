package testScripts;

import dataBase.OracleDataBase;
import driverUtility.DBconfiguration;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TC_007_Lensway_OracleDataBase {

    @Test(enabled=true)

    public void testDataBase() throws IOException, SQLException {

        OracleDataBase.oracleConnect();
        ResultSet rs=OracleDataBase.getDataBase("SELECT * FROM MERCURY");
        ResultSetMetaData rsmd=rs.getMetaData();
        int columns=rsmd.getColumnCount();
        while(rs.next())
        {
            for(int i=1; i<=columns; i++)
            {
              // System.out.println("  "+rsmd.getColumnName(i));

                System.out.println("  "+rs.getString(i));
            }
                System.out.println(); //Printing next line
        }
            OracleDataBase.closeDB();


    }

@Test(description ="Checking Successfull entry")

    public void crudDataBase()
{


    }



    }





