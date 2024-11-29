package com.jut.user_currency.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
@Configuration
public class PriceFormatter implements Formatter<Number> {

    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text = {}, locale = {}", text, locale);

        // 변환 로직
        // NumberFormat이 제공하는 기능
        NumberFormat format = NumberFormat.getInstance(locale);
        // "10.000" -> 10000L
        return format.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        log.info("object = {}, locale = {}", object, locale);
        return NumberFormat.getInstance(locale).format(object);
    }
}
