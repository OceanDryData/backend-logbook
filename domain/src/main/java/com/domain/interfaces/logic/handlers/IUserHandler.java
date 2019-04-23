package com.domain.interfaces.logic.handlers;

import com.domain.interfaces.logic.IHandlerCRUD;
import com.domain.models.User;

public interface IUserHandler extends IHandlerCRUD<User,Long> {
    User login(String email, String password);
}
