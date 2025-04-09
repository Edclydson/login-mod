package com.api.master.loginmod.model;

public enum Role {

        USER("ROLE_USER"),
        ADMIN("ROLE_ADMIN"),;

        final String roleName;
        Role(String roleName) {
            this.roleName = roleName;
        }

    public String getRoleName() {
        return roleName;
    }
}
