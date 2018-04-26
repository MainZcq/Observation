package com.zcq.springbootobservation;

import com.zcq.springbootobservation.Service.DataScanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootObservationApplicationTests {

	@Test
	public void contextLoads() {
		DataScanner.scanner();
	}

}
