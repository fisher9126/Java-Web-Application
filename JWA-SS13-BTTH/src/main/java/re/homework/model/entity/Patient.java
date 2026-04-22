package re.homework.model.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Patient() {}

    // getter setter
    public Long getId() { return id; }

    public String getFullName() { return fullName; }

    public String getDiagnosis() { return diagnosis; }

    public Doctor getDoctor() { return doctor; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
}