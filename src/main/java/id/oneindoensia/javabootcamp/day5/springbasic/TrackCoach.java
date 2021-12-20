package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class TrackCoach implements Coach {

	// init method
	public void initBean(){
		System.out.println("init somethings!");
	}

	// destroy method
	public void destroyBean(){
		System.out.println("destroy  somethings!");
	}

	@Autowired //@Qualifier("RESTFortuneService")
	private FortuneService fortuneService;

	@Value("${sport.email}")
	private String emailAddress;

	@Value("${sport.team}")
	private String team;

	private FortuneService fortuneServiceOne;
	private FortuneService fortuneServiceTwo;

	public TrackCoach(){}

	// auto wiring constructor injection
	@Autowired
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}


	public FortuneService getFortuneService() {
		return fortuneService;
	}

	// auto wiring setter injection
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getFortuneCombination(){
		return fortuneServiceOne.getFortune() +" || combine to || "+ fortuneServiceTwo.getFortune();
	}

	//@Autowired
	public void setFortuneCombination(@Qualifier("randomFortuneService") FortuneService fortuneServiceOne
			, @Qualifier("RESTFortuneService") FortuneService fortuneServiceTwo){
		this.fortuneServiceOne = fortuneServiceOne;
		this.fortuneServiceTwo = fortuneServiceTwo;
	}

	// after initiate bean, always call this method
	@PostConstruct
	public void postConstruct(){
		System.out.println("post construct bean");
	}

	// before destroy bean, always call this method
	@PreDestroy
	public void preDestroy(){
		System.out.println("pre destroy bean");
	}
}










