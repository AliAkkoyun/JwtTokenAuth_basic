package com.aliakkoyun.BasicJwtToken.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN"),
    ROLE_MAD("MAD"),
    ROLE_MOD("MOD");


    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
    @Override
    public String getAuthority() {
        return name();
    }


}
