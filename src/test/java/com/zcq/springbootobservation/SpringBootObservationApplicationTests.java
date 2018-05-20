package com.zcq.springbootobservation;

import com.zcq.springbootobservation.Service.DataScanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootObservationApplicationTests {

	@Test
	public void contextLoads() {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("e:\\realease\\GF4_PMI_E119.8_N35.3_20180411_L1A0000192168.tar.gz");
		DataScanner.scanner(arrayList);
	}

}
