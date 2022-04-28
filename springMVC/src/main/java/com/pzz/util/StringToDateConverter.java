package com.pzz.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        String patter="YYYY/MM/dd";
        if(source.contains("-")){
            patter="YYYY-MM-dd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patter);
        Date parse=null;
        try {
             parse = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
