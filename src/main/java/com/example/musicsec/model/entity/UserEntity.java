package com.example.musicsec.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {
  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<UserRoleEntity> roles = new ArrayList<>();
private String fullname;

  public String getFullname () {
    return fullname;
  }

  public UserEntity setFullname (String fullname) {
    this.fullname = fullname;
    return this;
  }

  public String getName() {
    return name;
  }

  public UserEntity setName(String name) {
    this.name = name;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserEntity setPassword(String password) {
    this.password = password;
    return this;
  }

  public List<UserRoleEntity> getRoles() {
    return roles;
  }

  public UserEntity setRoles(List<UserRoleEntity> roles) {
    this.roles = roles;
    return this;
  }
  public UserEntity addRole(UserRoleEntity userRoleEntity){
    this.roles.add (userRoleEntity);
    return this;
  }
}
