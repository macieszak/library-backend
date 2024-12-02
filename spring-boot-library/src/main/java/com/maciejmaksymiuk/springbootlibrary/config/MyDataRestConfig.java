package com.maciejmaksymiuk.springbootlibrary.config;

import com.maciejmaksymiuk.springbootlibrary.entity.Book;
import com.maciejmaksymiuk.springbootlibrary.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String theAllowedOrigins = "http://localhost:3000";


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration configuration, CorsRegistry corsRegistry) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PATCH, HttpMethod.PUT, HttpMethod.DELETE};
        configuration.exposeIdsFor(Book.class);
        configuration.exposeIdsFor(Review.class);

        dissableHttpMethods(Book.class, configuration, theUnsupportedActions);
        dissableHttpMethods(Review.class, configuration, theUnsupportedActions);

        // Configure CORS Mapping
        corsRegistry.addMapping(configuration.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins);
    }

    private void dissableHttpMethods(Class theClass, RepositoryRestConfiguration configuration, HttpMethod[] theUnsupportedActions) {
        configuration.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) ->
                        httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) ->
                        httpMethods.disable(theUnsupportedActions)));
    }

}
