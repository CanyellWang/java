package com.zhao.esayui.persistence;

import com.zhao.esayui.domain.User;

public interface UserMapper {
	User getUserByName(String name);
	void saveUser(User user);
}
