package com.fastcoder.demoapplanguage.config.local;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class LocaleUtils {

    public static Locale getLocale(){
        return LocaleContextHolder.getLocale();
    }
}
