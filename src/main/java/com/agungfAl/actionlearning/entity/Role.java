package com.agungfAl.actionlearning.entity;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Role {
    @Id @GeneratedValue Long id;
    String rolename;

    @OneToMany(mappedBy = "role")
    Collection<User> users;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    public Role() {
    }
    public Role(Long id, String rolename) {
        this.id = id;
        this.rolename = rolename;
    }
    // public int getUsers() {
    //     return users.size();
    // }
    // public Collection<User> getUsers() {
    //     return users;
    // }
    
}



