package com.study.azsia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;


@Getter
@AllArgsConstructor
public enum Role {
    ADMIN(
            Set.of(
                    Permission.ADMIN_DELETE,
                    Permission.ADMIN_CREATE,
                    Permission.ADMIN_UPDATE
            )),
    USER(Collections.EMPTY_SET);

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new java.util.ArrayList<>(getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
