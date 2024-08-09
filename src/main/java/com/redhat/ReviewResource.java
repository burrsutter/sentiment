package com.redhat;

import jakarta.inject.Inject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/review")
public class ReviewResource {

    @Inject
    ReviewService reviewer;

    record Review(String review) {
    }

    @GET
    public String hello() {
        return "This service requires a POST with a review body\n";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AnalyzedReview review(Review toBeReviewed) {
        System.out.println(toBeReviewed);
        return reviewer.review(toBeReviewed.review());
    }
}