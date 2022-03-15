package student.crud.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "address", nullable = false, length = 40)
    private String address;

    @Column(name = "contact", nullable = false, length = 25)
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 6,
            nullable = true)
    private Gender gender;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

}


