package com.app.dashboard.bean;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBean {
	private String id;
    private String name;
    private String email;
    private String password;
    private String city;
    private String state;
    private String country;
    private String occupation;
    private String phoneNumber;
    private List<String> transactions;
    private String role;
}
