package twonyizin.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import twonyizin.springframework.examplebeans.FakeDataSource;
import twonyizin.springframework.examplebeans.FakeJmsBroker;

@Configuration
//@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
//@PropertySources({@PropertySource("classpath:datasource.properties"),
//                 @PropertySource("classpath:jms.properties")})
public class PropertyConfig {

    @Autowired
    Environment environment;

    @Value("${twonyizin.username}")
    String user;

    @Value("${twonyizin.password}")
    String password;

    @Value("${twonyizin.dburl}")
    String url;

    @Value("${twonyizin.jms.username}")
    String jmsUsername;

    @Value("${twonyizin.jms.password}")
    String jmsPassword;

    @Value("${twonyizin.jms.url}")
    String jmsUrl;

    //if configuration class need to add @Bean annotataion
    @Bean
public FakeDataSource fakeDataSource(){
    FakeDataSource fakeDataSource = new FakeDataSource();
    fakeDataSource.setUser(user);
    //fakeDataSource.setUser(environment.getProperty("USERNAME"));
    fakeDataSource.setPassword(password);
    fakeDataSource.setUrl(url);
    return  fakeDataSource;
}

@Bean
public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUsername);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setUrl(jmsUrl);
        return  fakeJmsBroker;
}
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return  propertySourcesPlaceholderConfigurer;
    }
}
