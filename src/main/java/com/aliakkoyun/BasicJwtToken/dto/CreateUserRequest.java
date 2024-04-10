package com.aliakkoyun.BasicJwtToken.dto;


import com.aliakkoyun.BasicJwtToken.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String userName,
        String password,
        Set<Role> authorities
) {
}
