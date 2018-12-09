package com.women.online.shop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "users")
public class User extends AbstractEntity {
  @Embedded private Name name;
  @Email private String email;
  private LocalDate dateOfBirth;
  @Embedded private Address address;
  @Embedded private Phones phones;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  private List<UserOrder> userOrders = new ArrayList<>();

  @ElementCollection(targetClass = Category.class)
  @Enumerated(EnumType.STRING)
  @Column(name = "category")
  private Set<Category> favouriteCategories = new HashSet<>();

  public User(Name name, String email, LocalDate dateOfBirth, Address address, Phones phones) {
    this.name = name;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.address = address;
    this.phones = phones;
  }

  public User(Name name, String email) {
    this(name, email, null, null, null);
  }

  public void addCategory(Category category) {
    favouriteCategories.add(category);
  }

  public void removeCategory(Category category) {
    favouriteCategories.remove(category);
  }

  public void removeCategories() {
    favouriteCategories.clear();
  }
}
