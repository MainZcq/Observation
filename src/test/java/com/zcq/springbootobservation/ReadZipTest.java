package com.zcq.springbootobservation;

import com.zcq.springbootobservation.Service.DataScanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadZipTest {
    @Test
    public void ZipReaderTest() {
        try {
//            Runtime.getRuntime().exec("cd /test/");
//            Runtime.getRuntime().exec(" tar zvcf /usr/local/aaa.tar.gz   *.* ");
            //Process process = Runtime.getRuntime().exec(" tar -xzvf E:/test/GF1_WFV4_E117.7_N33.5_20180401_L1A0003097430.tar.gz -c E:/test");
            //DataScanner.readZipFile("E:\\test\\GF1_WFV4_E117.7_N33.5_20180401_L1A0003097430.tar.gz");
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("e:\\realease\\GF1_WFV4_E117.7_N33.5_20180401_L1A0003097430.tar.gz");
            DataScanner.scanner(arrayList);//解压
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
