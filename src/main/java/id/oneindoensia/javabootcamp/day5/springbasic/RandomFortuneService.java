package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String[] data = {
            "I just go luck",
            "My journey is awesome",
            "Beware of the wolf"
    };

    private Random random = new Random();

    @Override
    public String getFortune() {
        int randomIndex = random.nextInt(data.length);
        return data[randomIndex];
    }
}
