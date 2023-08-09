package com.fastcoder.demoapplanguage.controller;

import com.fastcoder.demoapplanguage.config.local.LocaleUtils;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController
@RequestMapping("/api/v1")
public class HomeController {


    private final MessageSource messageSource;

    public HomeController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @GetMapping("/hello")
    public String sayHello(){
        return messageSource.getMessage("welcome", null, LocaleUtils.getLocale());
    }
}
