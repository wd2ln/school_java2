package com.pzz.util;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//自定义日期转换器
public class DateUtil implements Formatter<Date> {
    private String partme="yyyy/MM/dd";
    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        if (text.contains("-")){
            partme="yyyy-MM-dd";
        }
        return new SimpleDateFormat(partme,locale).parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return new SimpleDateFormat(partme,locale).format(object);
    }
}
