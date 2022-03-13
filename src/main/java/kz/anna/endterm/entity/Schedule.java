package kz.anna.endterm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String day1;
    private String day2;
    private String day3;
    private String time1;
    private String time2;
    private String time3;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="room_id", insertable=false, updatable=false)
    private	Room room;

    @Column(name="room_id")
    private Long room_id;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="team_id", insertable=false, updatable=false)
    private	Team team;

    @Column(name="team_id")
    private Long team_id;
}
