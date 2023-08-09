package com.fastcoder.demoapplanguage.config;

import com.fastcoder.demoapplanguage.config.local.LocalLang;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class HeaderLanguageResolver extends AcceptHeaderLocaleResolver {

    List<Locale> LOCALES;

    public HeaderLanguageResolver() {
        this.LOCALES = Arrays.stream(LocalLang.values()).map(LocalLang::getLang).map(Locale::new).collect(Collectors.toList());
        Locale.setDefault(new Locale(LocalLang.ENGLISH.getLang()));
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        return  (Objects.isNull(headerLang) || headerLang.isEmpty())
                ? Locale.getDefault()
                : Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
    }
}
