package com.realestate.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "This field cannot be left blank.")
    @Size(max = 20)
    @NotNull(message = "Please enter agent's first name")
    @Column(nullable = false, length = 20)
    private String firstName;

    @NotEmpty(message = "This field cannot be left blank.")
    @Size(max = 20)
    @NotNull(message = "Please enter agent's last name")
    @Column(nullable = false, length = 20)
    private String lastName;

    @NotEmpty(message = "This field cannot be left blank.")
    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please enter valid phone number")
    @Size(min = 14, max = 14)
    @NotNull(message = "Please enter your phone number")
    @Column(nullable = false, length = 14)
    private String phoneNumber;

    @NotEmpty(message = "This field cannot be left blank.")
    @Email
    @Size(min = 8, max = 120)
    @NotNull(message = "Please enter agent's email")
    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agent")
    private List<Property> properties = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "agent_image_id", referencedColumnName = "id")
    private AgentImage agentImage;

    public Agent(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}