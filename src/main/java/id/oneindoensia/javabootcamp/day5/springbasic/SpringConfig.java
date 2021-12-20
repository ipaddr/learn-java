package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@Configurable
//@ComponentScan("id.oneindoensia.javabootcamp.day5.springbasic")
@PropertySource("classpath:sport.properties")
public class SpringConfig {

    @Bean
    @Qualifier("happyFortuneService")
    public FortuneService happyFortuneService(){
        return new HappyFortuneService();
    }

    @Bean
    public Coach trackCoach(){
        return new TrackCoach(happyFortuneService());
    }

}
