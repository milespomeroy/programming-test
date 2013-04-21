package com.milespomeroy.tweettest;

import com.milespomeroy.tweettest.resources.LanguageResource;
import com.milespomeroy.tweettest.resources.SearchTwitterResource;
import com.sun.jersey.api.client.Client;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.client.JerseyClientBuilder;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class TweetTestService extends Service<TweetTestConfiguration> {
    public static void main(String[] args) throws Exception {
        new TweetTestService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TweetTestConfiguration> bootstrap) {
        bootstrap.setName("tweet-test");

        bootstrap.addBundle(new AssetsBundle("/app/", "/"));
    }

    @Override
    public void run(TweetTestConfiguration configuration, Environment environment) throws Exception {
        final Client client = new JerseyClientBuilder().using(configuration.getJerseyClientConfiguration())
                                                           .using(environment)
                                                           .build();

        environment.addResource(new SearchTwitterResource(client));
        environment.addResource(new LanguageResource(client));

//        environment.addHealthCheck(new ConfigHealthCheck(configuration));
    }
}
