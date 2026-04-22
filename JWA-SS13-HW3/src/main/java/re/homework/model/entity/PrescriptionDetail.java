package re.homework.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "prescription_details")
public class PrescriptionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicineName;
    private int quantity;

    // Quan hệ N - 1
    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    public PrescriptionDetail() {}

    public Long getId() {
        return id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
