package com.redhat;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;


@RegisterAiService
public interface ReviewService {

    @SystemMessage("""
            You are an AI processing customer reviews. You need to perform sentiment analysis and identify positive and negative ones.
            You will always answer with a JSON document, and only this JSON document.
            """)

    @UserMessage("""
            Your task is to process the review delimited by ---.
            Apply a sentiment analysis to the passed review to determine if it is positive or negative.
            The review can be in any language. So, you will need to identify the language.

            For example:
            - "I love your product, you are the best!", this is a 'POSITIVE' review
            - "J'adore votre produit", this is a 'POSITIVE' review
            - "I hate your product, you are the worst!", this is a 'NEGATIVE' review

             Your answer needs to contain the following information:
            - the 'evaluation' key set to 'POSITIVE' if the review is positive, 'NEGATIVE' otherwise, depending if the review is positive or negative
            - the 'message' key set to a message thanking the customer in the case of a positive review, or an apology and a note that the bank is going to contact the customer in the case of a negative review. These messages must be polite and use the same language as the passed review.

            ---
            {review}
            ---
            """)

    AnalyzedReview review(String review);
}