package com.example.adiphong.rx2;

import com.example.adiphong.rx2.component.DateJsonDeserializer;
import com.example.adiphong.rx2.model.Account;
import com.example.adiphong.rx2.model.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by adiphong on 27/11/2017 AD.
 */

public class TestMapJson {

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    @Test
    public void mapJson() {
        UserData userData = new UserData();
        Account account = new Account();

        userData.setDate(new Date("01/31/2018"));

        Map<Date, String> map = new HashMap<>();
        map.put(new Date("01/31/2018"), "a");
        map.put(new Date("12/1/2017"), "b");
        map.put(new Date("11/20/2017"), "c");
        account.setMap(map);
        userData.setAccount(account);

        for (Date date : map.keySet()) {
            System.out.println("------------- all date "+date);
        }

        Gson gson = new GsonBuilder()
                .setDateFormat("dd/MM/yyyy")
//                .registerTypeAdapter(Date.class, new DateJsonDeserializer())
//                .setDateFormat(DateFormat.FULL, DateFormat.FULL)
                .create();


        Type listType = new TypeToken<Map<Date, String>>() {
        }.getType();

        String userDataFromJson = gson.toJson(userData);
        JsonParser parser = new JsonParser();
        JsonObject responseJsonObject = parser.parse(userDataFromJson).getAsJsonObject();
        responseJsonObject.remove("account");

        System.out.println("-------------- responseJsonObject " + responseJsonObject);
//        System.out.println("-------------- userDataFromJson " + userDataFromJson);
        String userDataGson = "{\"account\":{\"map\":{\"null\":\"a\",\"null\":\"b\",\"null\":\"b\"}}}";

//        System.out.println("---------- userDataFromJson"+userDataFromJson);
//
        UserData userData2 = gson.fromJson(responseJsonObject, UserData.class);

        System.out.println("--------------- userData "+userData2.getDate());
        System.out.println("--------------- userData2.getDate() "+userData2.getDate());


//        System.out.println("-------- userDataFromJson "+userDataFromJson);
//        System.out.println("-------- userDataFromJson "+userData2.getAccount().getMap().size());

//        for (Date date : userData2.getAccount().getMap().keySet()) {
//            System.out.println("-------- userDataFromJson " + date);
//        }

//        Gson gson = new Gson();
//
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put(null, 1);
//        map.put(null, 2);
//        map.put(null, 3);
//
//        System.out.println(gson.toJson(map));

    }
}
