package com.clhoac.java;

import java.io.*;

public class Processor {

    public static String proccess(File file, TextActioner actioner, boolean updateFile) {
        try {
            Reader reader = new FileReader(file);
            String result = doProcess(reader, actioner);
            if (updateFile) {
                PrintWriter writer = new PrintWriter(file, "UTF-8");
                writer.print(result);
                writer.close();
            }
            return result;
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String proccess(File file) {
        return proccess(file, null, false);
    }

    public static String proccess(String text, TextActioner actioner) {
        Reader reader = new StringReader(text);
        return doProcess(reader, actioner);
    }

    private static String doProcess(Reader reader, TextActioner actioner) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(
                    reader);
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                if (actioner != null) {
                    sb.append(actioner.actOnLine(line));
                } else {
                    sb.append(line);
                }
                line = br.readLine();
                if (line != null) {
                    sb.append(System.lineSeparator());
                }
            }
            result = sb.toString();
            br.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return result;
    }

}
