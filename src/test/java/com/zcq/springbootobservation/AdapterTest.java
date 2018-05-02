package com.zcq.springbootobservation;


import com.zcq.springbootobservation.Controller.GF3ReaderAdapter;
import com.zcq.springbootobservation.Entity.ReaderAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdapterTest {

    @Test
    public void GF3ReaderTest() {
        ReaderAdapter readerAdapter = new GF3ReaderAdapter();
        readerAdapter.fileReader
                ("/home/corvo/GitRepo/Observation" +
                        "/GF3_KRN_FSII_008623_E117.9_N32.2_20180330_L1A_HHHV_L10003094723.meta.xml");
    }

}