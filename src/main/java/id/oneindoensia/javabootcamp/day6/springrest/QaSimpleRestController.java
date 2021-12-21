package id.oneindoensia.javabootcamp.day6.springrest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("qa")
public class QaSimpleRestController extends SimpleRestController{
}
