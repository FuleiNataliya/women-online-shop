package com.women.online.shop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class User extends AbstractEntity {
    @Embedded
    private Name name;
    @Email
    private String email;
    private LocalDate dateOfBirth;
    @Embedded
    private Address address;
    @Embedded
    private Phones phones;
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "user"
    )
    private List<UserOrder> userOrders = new ArrayList<>();
    @ElementCollection(targetClass = Category.class)
    @Enumerated(EnumType.STRING)
    private Set<Category> favouriteCategories = new HashSet<>();

    public User(Name name, String email, LocalDate dateOfBirth, Address address, Phones phones) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phones = phones;
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

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                ", phones=" + phones +
                ", orders=" + userOrders +
                ", favouriteCategories=" + favouriteCategories +
                '}';
    }

}
