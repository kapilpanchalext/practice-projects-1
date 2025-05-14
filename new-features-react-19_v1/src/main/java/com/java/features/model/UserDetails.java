package com.java.features.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDetails implements Serializable {
	private static final long serialVersionUID = -4382586412268563300L;

	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private long phone;

}
