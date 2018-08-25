package com.example.adiphong.rx2.component;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateJsonDeserializer implements JsonDeserializer<Date> {

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    private DateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);

    @Override
    public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        try {
            String dateTimeString = json.getAsString();

            System.out.println("------------- dateTimeString "+dateTimeString +" format "+dateTimeFormat.parse(json.getAsString()));
            if (dateTimeString == null) {
                return null;
            } else {
                return dateFormat.parse("11/20/2017");
//                return dateFormat.parse(json.getAsString());
            }
        } catch (ParseException e) {
            return null;
        }
    }
}
