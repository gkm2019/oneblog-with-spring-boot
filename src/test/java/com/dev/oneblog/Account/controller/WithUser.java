package com.dev.oneblog.Account.controller;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by kyeongmin ku
 */

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "kyeongmin", roles = "USER")
public @interface WithUser {
}
