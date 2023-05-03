package com.webite.crossplatform.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long role_id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;

    // constructors, getters, setters, etc.

    public String getName() {
        return name;
    }

    public Long getRole_id() {
        return role_id;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }
}
