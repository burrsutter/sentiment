package com.redhat;

import com.fasterxml.jackson.annotation.JsonCreator;

public record AnalyzedReview(Evaluation evaluation, String message) {

    @JsonCreator
    public AnalyzedReview {
    }

}
