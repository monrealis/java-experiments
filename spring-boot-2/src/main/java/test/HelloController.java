package test;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() throws IOException {
		ClassPathResource r = new ClassPathResource("/one.txt");
		InputStream is = r.getInputStream();
		byte[] b = new byte[is.available()];
		is.read(b, 0, b.length);
		return new String(b);
	}

}