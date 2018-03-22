//package com.Test;

package com.elasticcloudservice.predict;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class JUnitTest {
    @org.junit.Test
    public void testFunc() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] str = new String[2];
        str[0] = "2015-02-20 00:00:00";
        str[1] = "2015-02-27 00:00:00";
        long preD = simpleDateFormat.parse(str[0]).getTime();
        long curD = simpleDateFormat.parse(str[1]).getTime();
        long pDay = simpleDateFormat.parse("2015-02-20 00:00:00").getTime();
        long cDay = simpleDateFormat.parse("2015-02-27 00:00:00").getTime();
        long days = (curD-preD)/(1000*60*60*24);
        assertEquals(pDay,preD);
        assertEquals(cDay,curD);
    }

}
