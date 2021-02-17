package com.example.demo.model;

public enum Role {
    ADMIN {
        public String toString() {
            return "ADMIN_ROLE";
        }
    },
    USER {
        public String toString() {
            return "USER_ROLE";
        }
    }

}
