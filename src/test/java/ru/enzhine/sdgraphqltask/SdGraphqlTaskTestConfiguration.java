package ru.enzhine.sdgraphqltask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.context.WebApplicationContext;

@TestConfiguration
public class SdGraphqlTaskTestConfiguration {
    @Autowired
    private WebApplicationContext context;

    @Bean
    public HttpGraphQlTester graphQlTester() {
        WebTestClient client =
                MockMvcWebTestClient.bindToApplicationContext(context)
                        .configureClient()
                        .baseUrl("/graphql")
                        .build();

        return HttpGraphQlTester.create(client);
    }
}
