package org.example.testtask.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.testtask.enums.Degree;


@Entity
@Table(name = "lectors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Enumerated(EnumType.STRING)
    private Degree degree;

}
