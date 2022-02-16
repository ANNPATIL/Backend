package org.hrportal;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("hr")
public class HRController {

    @Inject
    CandidateRepository candidateRepository;

    @GET
    public List<Candidate> getCandidates(){
        System.out.println("fetching candidate list for hr");
        List<Candidate> candidates = candidateRepository.getCandidates(Arrays.asList(Status.NEW));
        System.out.println(candidates);
        return candidates;
    }

    @POST
    @Path("approve/{id}")
    @Transactional
    public Response approveCandidate( @PathParam("id") long id, String feedback){
        System.out.println("Approve candidate id : " +id+ ", feedback : "+feedback);
        Candidate candidate = Candidate.findById(id);
        candidate.setFeedback(feedback);
        candidate.setStatus(Status.HR_APPROVAL);
        candidate.persist();
        return Response.status(Response.Status.OK).build();

    }

    @POST
    @Path("reject/{id}")
    @Transactional
    public Response rejectCandidate( @PathParam("id") long id, String feedback){
        System.out.println("Reject candidate id : " +id+ ", feedback : "+feedback);
        Candidate candidate = Candidate.findById(id);
        candidate.setFeedback(feedback);
        candidate.setStatus(Status.HR_REJECT);
        candidate.persist();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("approved_candidates")
    public List<Candidate> GetApprovedCandidates() {
        System.out.println("fetching approved candidate list for hr");
        List<Candidate> candidates = candidateRepository.getCandidates(Arrays.asList(Status.HR_APPROVAL, Status.MANAGER_APPROVAL, Status.MANAGER_REJECT));
        System.out.println(candidates);
        return candidates;
    }

    @GET
    @Path("rejected_candidates")
    public List<Candidate> GetRejectedCandidates() {
        System.out.println("fetching rejected candidate list for hr");
        List<Candidate> candidates = candidateRepository.getCandidates(Arrays.asList(Status.HR_REJECT));
        System.out.println(candidates);
        return candidates;
    }
}
