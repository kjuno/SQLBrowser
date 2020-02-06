package richard.mysqltest.mysql.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONExport {
    public static String convertTabletoJSON(Table table){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String json = gson.toJson(table);
        return json;
    }
}
