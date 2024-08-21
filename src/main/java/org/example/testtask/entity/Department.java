package org.example.testtask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToOne
    @JoinColumn(name = "head_id")
    private Lector head;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Set<Lector> lectors;


}
