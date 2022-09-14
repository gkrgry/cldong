package com.cltwo.cldong.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ROLE_USER("ROLE_USER"),
    ROLE_MANAGE("ROLE_MANAGE"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String value;
}
