package org.sid.hospital.services;


import org.apache.catalina.Role;
import org.apache.catalina.User;

public interface UserService
{
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName,String roleName);
    User authentificate(String userName,String password);
}