package bansach.demo.confic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class Restconfic implements RepositoryRestConfigurer {


    private String url = "http://localhost:3000" ;

    @Autowired
    private EntityManager entityManager ;


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));
        cors.addMapping("/**").allowedOrigins(url).allowedMethods("GET" , "PUT" ,"POST" ,"DELETE");

        HttpMethod[] chancacphuongthuc = {
           HttpMethod.POST , HttpMethod.PUT , HttpMethod.DELETE , HttpMethod.PATCH ,
        } ;

    }

    private void disableHttpMethod (Class c , RepositoryRestConfiguration  configurer , HttpMethod[] methods ) {
            configurer.getExposureConfiguration().forDomainType(c).withItemExposure((metdata, httpMethods) ->
                    httpMethods.disable(methods)
                    ).withCollectionExposure((metdata, httpMethods) -> httpMethods.disable());


    }

}
