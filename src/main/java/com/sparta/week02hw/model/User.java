package com.sparta.week02hw.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class User implements UserDetails {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(length = 100, nullable = false, unique = true)
  private String nickname;

  @Column(length = 100, nullable = false, unique = true)
  private String email;

  @Column(length = 30, nullable = false)
  private String password;

  @ElementCollection(fetch = FetchType.EAGER)
  @Builder.Default
  private List<String> roles = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.roles.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
  }

  @Override
  public String getUsername() {
    return email;
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
    return true;
  }




  //Service
  public User(String name, String nickname, String password, String email) {
    this.name = name;
    this.nickname = nickname;
    this.password = password;
    this.email = email;
  }
}
