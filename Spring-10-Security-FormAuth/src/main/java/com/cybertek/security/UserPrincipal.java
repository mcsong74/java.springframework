package com.cybertek.security;

import com.cybertek.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//spring security authentication class = UserDetails
//this class, converts User table to UserDetails
public class UserPrincipal implements UserDetails {
// not a bean, this is a UserDetails interface implementation class
    private User user;

    public UserPrincipal(User user) {
        //constructor, not autowiring constructors
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //collection will have all the permission and roles, differentiated by naming convention
        List<GrantedAuthority> authorityList = new ArrayList<>();

        //Extract list of permission
        user.getPermissionList().forEach(permission-> {
            GrantedAuthority authority=  new SimpleGrantedAuthority (permission);
            authorityList.add(authority);
        });

        //Extract list of roles
        user.getRoleList().forEach(role->{
            GrantedAuthority authority=new SimpleGrantedAuthority(role); //for hasAuthority, no need "ROLE_"
            authorityList.add(authority);

        });
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getActive()==1;
    }
}
