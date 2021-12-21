package id.oneindoensia.javabootcamp.day6.springrest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
public class DevSimpleRestController extends SimpleRestController{
}
