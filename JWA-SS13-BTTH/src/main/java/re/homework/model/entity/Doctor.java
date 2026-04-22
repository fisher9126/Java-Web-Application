package re.homework.model.entity;



import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;

    @OneToMany(mappedBy = "doctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Patient> patients;

    public Doctor() {}

    // getter setter
    public Long getId() { return id; }

    public String getName() { return name; }

    public String getSpecialization() { return specialization; }

    public List<Patient> getPatients() { return patients; }

    public void setName(String name) { this.name = name; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public void setPatients(List<Patient> patients) { this.patients = patients; }

    public void setId(Long id) {
        this.id = id;
    }
}