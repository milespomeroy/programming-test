package com.milespomeroy.tweettest.resources;

import com.milespomeroy.tweettest.core.Language;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

@Path("/languages")
public class LanguageResource {
    private final String lingotekLanguagesUrl = "http://gmc.lingotek.com/language";
    private final Client client;

    public LanguageResource(Client client) {
        this.client = client;
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Language> getLanguages() {
        WebResource r = client.resource(lingotekLanguagesUrl);
        Map<String, Language> result = r.get(Map.class);

        return result;
    }

    // gives raw request and response
    @GET
    @Timed
    @Produces(MediaType.TEXT_PLAIN)
    public String getLanguagesRaw() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        client.addFilter(new LoggingFilter(ps));

        WebResource r = client.resource(lingotekLanguagesUrl);
        r.get(Map.class);

        return baos.toString();
    }
}
