package com.RestAssured;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SingleUserData {

	private String id;
	private String email;

	@JsonProperty // used this due to UnrecognizedPropertyExceptions
	private String first_name;

	@JsonProperty // used this due to UnrecognizedPropertyExceptions
	private String last_name;
	private String avatar;

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
