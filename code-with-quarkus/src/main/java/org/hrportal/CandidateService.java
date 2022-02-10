package org.hrportal;



import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("/candidate")


public class CandidateService {

    @Inject
    CandidateRepository candidateRepository;




@POST
    public Response createCandidate(CandidatePayload candidatePayload){
    Candidate candidate = candidateRepository.addCandidate(candidatePayload);
    return Response.status(Response.Status.CREATED).entity(candidate).build();

}

}
