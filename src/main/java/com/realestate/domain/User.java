package com.realestate.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.realestate.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15)
    @NotNull(message = "Please enter your first name")
    @Column(nullable = false, length = 15)
    private String firstName;

    @Size(max = 15)
    @NotNull(message = "Please enter your last name")
    @Column(nullable = false, length = 15)
    private String lastName;

    @Size(min = 4, max = 60, message = "Please enter min 4 characters")
    @NotNull(message = "Please enter your password")
    @Column(nullable = false, length = 120)
    private String password;

    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please enter valid phone number")
    @Size(min = 14, max = 14, message = "Phone number should be exact 10 characters")
    @NotNull(message = "Please enter your phone number")
    @Column(nullable = false, length = 14)
    private String phoneNumber;

    @Email(message = "Please enter valid email")
    @Size(min = 5, max = 150)
    @NotNull(message = "Please enter your email")
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Size(max = 250)
    @NotNull(message = "Please enter your address")
    @Column(nullable = false, length = 250)
    private String address;

    @Size(max = 15)
    @NotNull(message = "Please enter your zip code")
    @Column(nullable = false, length = 15)
    private String zipCode;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    private Role role;

    @Column(nullable = false)
    private Boolean builtIn;//?

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<TourRequest> tourRequests;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Review> reviews= new HashSet<>();

    public User( String firstName, String lastName, String password, String phoneNumber, String email,
                String address, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
    }

    public User(String firstName, String lastName, String password, String phoneNumber, String email,
                String address, String zipCode, Role roles, Boolean builtIn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.role = roles;
        this.builtIn = builtIn;
    }
    public User(Long id, String firstName, String lastName, String password, String phoneNumber,
                String email, String address, String zipCode, Role roles, Boolean builtIn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.role = roles;
        this.builtIn = builtIn;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getRoles() {

        if (role.getName().equals(UserRole.ROLE_ADMIN))
            return "Administrator";
        return "User";
    }
}