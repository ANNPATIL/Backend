package org.hrportal;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("manager")
public class ManagerController {

    @Inject
    CandidateRepository candidateRepository;

    @GET
    public List<Candidate> getCandidates(){
        System.out.println("fetching candidate list for manager");
        List<Candidate> candidates = candidateRepository.getCandidates(Status.HR_APPROVAL);
        System.out.println(candidates);
        return candidates;
    }

    @POST
    @Path("approve/{id}")
    public Response approveCandidate( @PathParam("id") long id){
        System.out.println("id" +id );
        candidateRepository.updateStatus(id, Status.MANAGER_APPROVAL);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("reject/{id}")
    public Response rejectCandidate( @PathParam("id") long id){
        System.out.println("id" +id );
        candidateRepository.updateStatus(id, Status.MANAGER_REJECT);
        return Response.status(Response.Status.OK).build();
    }
}
