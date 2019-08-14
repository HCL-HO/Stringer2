package com.clhoac.java;

public class SQLMaker {
    public static String getPureSql(String javaString){
            String result = javaString.replace("\"", "");
            result = Stringer.removeLineEnd(result.trim(), "+");
            return result;
    }

    public static String getJavaStringFromSQL(String sqlString){
        String result = Stringer.appendLineStart(sqlString.trim(), "\"");
        result = Stringer.appendLineEnd(result, " \"");
        return result;
    }
}
