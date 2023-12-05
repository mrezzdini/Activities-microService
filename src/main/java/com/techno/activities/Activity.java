package com.techno.activities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String image;
    private String name;
    private String description;
    private String dateStart;
    private String dateEnd;
    private String responsible;
    private Long weeklyProgramId;
}
