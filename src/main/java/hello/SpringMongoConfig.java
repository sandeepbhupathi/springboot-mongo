package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories("hello")
@PropertySource("mongoconfig.properties")
public class SpringMongoConfig extends AbstractMongoConfiguration {
   /* @Value("${spring.profiles.active}")
    private String profileActive;

    @Value("${spring.application.name}")
    private String proAppName;

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;*/

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private int mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;
    
    @Value("${spring.data.mongodb.username}")
    private String userName;
    
    @Value("${spring.data.mongodb.password}")
    private char[] propPassword;
    
    @Override
    public MongoMappingContext mongoMappingContext()
        throws ClassNotFoundException {
        // TODO Auto-generated method stub
        return super.mongoMappingContext();
    }
    @Override
    @Bean
    public Mongo mongo() throws Exception {
    	MongoClientOptions options = MongoClientOptions.builder().connectTimeout(2000000000).build();
    	//2w1ubp7MOdN54-GOvvLHCXpegjfP3pwP
    	 char[] passWord = { '2', 'w', '1', 'u', 'b', 'p', '7',
 			    'M', 'O', 'd', 'N', '5', '4','-','G','O','v','v','L','H','C','X','p','e','g','j','f',
 			    'P','3','p','w','P' };
    	 
    	 System.out.println(userName+"---"+mongoDB+"---"+propPassword+"---"+mongoHost+"---"+mongoPort);
    	List<MongoCredential> credentialsList = new ArrayList<>();
    	credentialsList.add(MongoCredential.createCredential(
    					userName, 
    					mongoDB, propPassword));
        return new MongoClient(new ServerAddress(mongoHost,mongoPort),credentialsList,options);
    }
    @Override
    protected String getDatabaseName() {
        // TODO Auto-generated method stub
        return "CloudFoundry_h7d69dsj_tomptbqo";
    }
}

