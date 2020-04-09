package com.pgyhr.core.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixg
 * @title: CaptchaProperties
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {

    private List<String> image = new ArrayList<>();

    private List<String> sms = new ArrayList<>();

    private List<String> vaptcha = new ArrayList<>();

    private List<String> email = new ArrayList<>();
}
