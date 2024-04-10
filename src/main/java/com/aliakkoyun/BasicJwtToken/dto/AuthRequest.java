package com.aliakkoyun.BasicJwtToken.dto;

public record AuthRequest(
          String username,
          String password
) {
}
