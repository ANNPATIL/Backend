package org.hrportal;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
@Path("/candidate")

public class CandidateController {
    @Inject
    CandidateRepository candidateRepository;

    @POST
    public Response createCandidate(CandidatePayload candidatePayload) {
        System.out.println("Creating new candidate"+candidatePayload);

        Candidate candidate = candidateRepository.addCandidate(candidatePayload);
        return Response.status(Response.Status.CREATED).entity(candidate).build();
    }
}
