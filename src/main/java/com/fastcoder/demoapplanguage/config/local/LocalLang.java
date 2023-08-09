package com.fastcoder.demoapplanguage.config.local;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum LocalLang {
    ENGLISH("en"),
    ARABIC("ar"),
    FRENCH("fr");

    private final String lang;

    public static LocalLang getLanguageByValue(String value){
       return Arrays.stream(LocalLang.values())
               .filter(value::equals).findFirst().orElse(ENGLISH);
    }
}
