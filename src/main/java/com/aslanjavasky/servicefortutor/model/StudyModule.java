package com.aslanjavasky.servicefortutor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class StudyModule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @OneToMany(mappedBy = "studyModule",cascade = CascadeType.ALL)
    private List<Topic> topics;

}
