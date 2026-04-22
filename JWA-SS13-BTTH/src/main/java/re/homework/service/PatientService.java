package re.homework.service;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import re.homework.model.entity.Patient;


import java.util.List;

@Service
@Transactional
public class PatientService {

    private final SessionFactory sessionFactory;

    public PatientService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Patient> findAllPatients() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(
                "SELECT p FROM Patient p JOIN FETCH p.doctor",
                Patient.class
        ).getResultList();
    }

    public Long countTotalPatients() {
        Session session = sessionFactory.getCurrentSession();

        return ((Number) session.createNativeQuery(
                "SELECT COUNT(*) FROM patients"
        ).getSingleResult()).longValue();
    }

    public void save(Patient patient) {
        sessionFactory.getCurrentSession().merge(patient);
    }
}
