package org.hrportal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CandidateRepository implements PanacheRepository<Candidate> {

    @Inject
    EntityManager em;

    @Transactional
    public Candidate addCandidate(CandidatePayload payload) {
        Candidate candidate = new Candidate();
        candidate.setFname(payload.getFname());
        candidate.setLname(payload.getLname());
        candidate.setAge(payload.getAge());
        candidate.setExperience(payload.getExperience());
        candidate.setStatus(Status.NEW);
        candidate.persist();
        return candidate;
    }

    @Transactional
    public List<Candidate> getCandidates(List<Status> status) {
        TypedQuery<Candidate> q =
                em.createQuery("select t from Candidate t where t.status in (:status)", Candidate.class);
        q.setParameter("status", status);
       return  q.getResultList();
    }

    @Transactional
    public void updateStatus(long id, Status status) {
        Candidate candidate = Candidate.findById(id);
        candidate.setStatus(status);
        candidate.persist();
    }
}
