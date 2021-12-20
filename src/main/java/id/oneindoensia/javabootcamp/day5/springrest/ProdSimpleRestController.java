package id.oneindoensia.javabootcamp.day5.springrest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("prod")
public class ProdSimpleRestController extends SimpleRestController{
}
