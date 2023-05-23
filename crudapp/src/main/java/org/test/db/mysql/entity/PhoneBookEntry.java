package org.test.db.mysql.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "contacts")
public class PhoneBookEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "Phone number is required")
    @Size(max = 10, message = "Phone number must be at most 10 characters long")
    @Pattern(regexp = "\\d+", message = "Phone number must contain only numeric values")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}
