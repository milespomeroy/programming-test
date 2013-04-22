package com.milespomeroy.tweettest.resources;

import com.milespomeroy.tweettest.core.Tweet;
import com.milespomeroy.tweettest.core.TwitterSearchResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/search")
public class SearchTwitterResource {
    private final String twitterSearchUrl = "https://search.twitter.com/search.json";
    private final Client client;
    private final URI twitterSearchUri;

    public SearchTwitterResource (Client client) throws URISyntaxException {
        this.client = client;
        this.twitterSearchUri = new URI(twitterSearchUrl);
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tweet> searchWithQuery (@QueryParam("q") String query) {
        URI uri = UriBuilder.fromUri(twitterSearchUri).queryParam("q", query).build();

        WebResource r = client.resource(uri);

        TwitterSearchResponse twitterSearchResponse =
                r.accept(MediaType.APPLICATION_JSON).get(TwitterSearchResponse.class);

        return twitterSearchResponse.getResults();
    }

    // Gives raw request and response
    @GET
    @Timed
    @Produces(MediaType.TEXT_PLAIN)
    public String searchWithQueryRaw (@QueryParam("q") String query) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        client.addFilter(new LoggingFilter(ps));

        URI uri = UriBuilder.fromUri(twitterSearchUri).queryParam("q", query).build();

        WebResource r = client.resource(uri);
        r.accept(MediaType.APPLICATION_JSON).get(TwitterSearchResponse.class);

        return baos.toString();
    }
}
