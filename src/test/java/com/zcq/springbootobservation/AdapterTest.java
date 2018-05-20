package com.zcq.springbootobservation;


import com.zcq.springbootobservation.Controller.GF124ReaderAdapter;
import com.zcq.springbootobservation.Controller.GF3ReaderAdapter;
import com.zcq.springbootobservation.Service.ReaderAdapter;
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
        ReaderAdapter readerAdapter2 = new GF124ReaderAdapter();
        ReaderAdapter readerAdapter1 = new GF124ReaderAdapter();
        ReaderAdapter readerAdapter3 = new GF124ReaderAdapter();

        /*readerAdapter.fileReader
                ("E:/test/GF3_KRN_FSII_008623_E117.9_N32.2_20180330_L1A_HHHV_L10003094723" +
                        "/GF3_KRN_FSII_008623_E117.9_N32.2_20180330_L1A_HHHV_L10003094723.meta.xml");*/

//        readerAdapter1.fileReader
//                ("E:/test/GF2_PMS2_E118.6_N32.0_20180101_L1A0002897559" +
//                        "/GF2_PMS2_E118.6_N32.0_20180101_L1A0002897559-MSS2.xml");
//
//        readerAdapter2.fileReader
//                ("E:/test/GF1_WFV4_E117.7_N33.5_20180401_L1A0003097430" +
//                        "/GF1_WFV4_E117.7_N33.5_20180401_L1A0003097430.xml");
//        readerAdapter2.fileReader
//                ("E:/test/GF4_PMI_E119.8_N35.3_20180411_L1A0000192168" +
//                        "/GF4_IRS_E119.8_N35.3_20180411_L1A0000192168.xml");


    }

}