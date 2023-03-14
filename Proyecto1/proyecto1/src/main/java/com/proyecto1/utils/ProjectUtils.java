package com.proyecto1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectUtils {

    public static Date StringToDate(String date, String format){
        //el formato de la fecha es yyyy-MM-dd
        SimpleDateFormat formato = new SimpleDateFormat(format);
        Date dataFormateada = null;
        try {
            dataFormateada = formato.parse(date);
            return dataFormateada;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
