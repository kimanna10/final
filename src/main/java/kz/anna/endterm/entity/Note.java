package kz.anna.endterm.entity;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id")
    private Long client_id;

    @Column(name = "team_id")
    private Long team_id;

    private Date date;




}
