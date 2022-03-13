package kz.anna.endterm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "team_style",
            joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "style_id", referencedColumnName = "id")}
    )
    private List<Style> styles;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="choreographer_id", insertable=false, updatable=false)
    private	Choreographer choreographer;

    @Column(name="choreographer_id")
    private Long choreographer_id;

}
