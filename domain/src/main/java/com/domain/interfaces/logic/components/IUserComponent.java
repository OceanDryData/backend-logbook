package com.domain.interfaces.logic.components;

import com.domain.interfaces.ICRUD;
import com.domain.models.User;

public interface IUserComponent extends ICRUD<User,Long> {
    User login(String email, String password);

}
