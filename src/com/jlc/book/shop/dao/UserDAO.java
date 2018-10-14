package com.jlc.book.shop.dao;

import com.jlc.book.shop.to.*;

public interface UserDAO {
public UserTO verifyUser(String username,String password);
public UserTO changePassword(UserTO usto,String password);
public String searchPassword(String username,String email);
public boolean registerUser(UserTO uto);
public boolean alreadyExist(String username);
public boolean updateUserInfo(String useId,String email,long phone);
public UserTO getUserInfoById(String userId);
public boolean alreadyExistEmail(String email);
public boolean alreadyExistPhone(String phone);
}
