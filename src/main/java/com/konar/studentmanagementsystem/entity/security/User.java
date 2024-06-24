package com.konar.studentmanagementsystem.entity.security;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "pw")
    private String pw;

    @Column(name = "active")
    private int active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Role role;

}
