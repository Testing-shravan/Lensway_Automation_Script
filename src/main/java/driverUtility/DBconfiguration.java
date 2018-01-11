package driverUtility;

import jdk.internal.dynalink.beans.StaticClass;

import java.io.*;
import java.util.Properties;

public class DBconfiguration {


      static File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\propertiesFile\\OracleDB.Properties");
      static FileInputStream fis;
      static Properties prop = new Properties();

        public static String getDriver() throws IOException {
            try
            {
                fis=new FileInputStream(file);
                prop.load(fis);
                return prop.getProperty("driver");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            finally
            {
                fis.close();
            }

            return null;
    }

    public static String getconnectionString() throws IOException {
        try
        {
            fis=new FileInputStream(file);
            prop.load(fis);
            return prop.getProperty("driver");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        finally
        {
            fis.close();
        }

        return null;
    }

    public static String getusername() throws IOException {
        try
        {
            fis=new FileInputStream(file);
            prop.load(fis);
            return prop.getProperty("driver");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        finally
        {
            fis.close();
        }

        return null;
    }

    public static String getpassword() throws IOException {
        try
        {
            fis=new FileInputStream(file);
            prop.load(fis);
            return prop.getProperty("driver");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        finally
        {
            fis.close();
        }

        return null;
    }

}
