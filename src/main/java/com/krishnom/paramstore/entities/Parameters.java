package com.krishnom.paramstore.entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Parameters {
    public static final Path defaultPropertiesFile = Paths.get(System.getenv("TEMP"),"parameters.ini");

    Properties parameters;
    public Parameters() throws IOException {
       parameters = readPropertiesFile(defaultPropertiesFile);
    }

    public static Properties readPropertiesFile(Path fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(String.valueOf(fileName));
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }

    public String getParameterValue(String key){
        return parameters.getProperty(key);
    }

    public static Map<String, String> getAll() throws IOException {
        Properties parameters2 = readPropertiesFile(defaultPropertiesFile);
        Map<String,String> parametersMap = new HashMap<String, String>();

        for (Object key : parameters2.keySet()){
            String value = parameters2.getProperty((String)key);
            parametersMap.put((String)key, value);
        }
        return parametersMap;
    }
}
