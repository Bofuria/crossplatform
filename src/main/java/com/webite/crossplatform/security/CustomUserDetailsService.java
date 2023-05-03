//package com.webite.crossplatform.security;
//
//import com.webite.crossplatform.dao.UserDao;
//import com.webite.crossplatform.entities.RoleEntity;
//import com.webite.crossplatform.entities.UserEntity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        UserEntity user = userDao.findByLogin(login);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthorities(user));
//    }
//
//    private Set<GrantedAuthority> getAuthorities(UserEntity user) {
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        // add user roles as authorities
//        for (RoleEntity role : user.getRoles()) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return authorities;
//    }
//}
