package org.sid.hospital.services;

import org.apache.catalina.Role;
import org.apache.catalina.User;

public class UserServiceImpl implements UserService {
    @Override
    public User addNewUser(User user) {
        return null;
    }

    @Override
    public Role addNewRole(Role role) {
        return null;
    }

    @Override
    public User findUserByUserName(String userName) {
        return null;
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return null;
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {

    }

    @Override
    public User authentificate(String userName, String password) {
        return null;
    }
}