package com.mongoloc;

import org.junit.Assert;
import org.junit.Test;
/**
 * Created by paul on 3/26/14.
 */
public class TestIPv4Address {

    @Test
    public void convertsLongIPtoIPv4() {
        long longIP1 = 0;

        Assert.assertTrue("long IP 0 same as 0.0.0.0",
                IPv4Address.fromLongAddress(longIP1).equals("0.0.0.0"));

        long longIP2 = 255;
        Assert.assertTrue("long IP 255 same as 0.0.0.255",
                IPv4Address.fromLongAddress(longIP2).toString().equals("0.0.0.255"));

        long longIP3 = 256;
        Assert.assertTrue("long IP 256 same as 0.0.1.0",
                IPv4Address.fromLongAddress(longIP3).toString().equals("0.0.1.0"));

        long longIP4 = 1 * 256 * 256 * 256;
        Assert.assertTrue("long IP 16777216 same as 1.0.0.0",
                IPv4Address.fromLongAddress(longIP4).toString().equals("1.0.0.0"));

        long longIP5 = (long) 128 * 256 * 256 * 256 + 3 * 256 + 200;
        IPv4Address addr5 = new IPv4Address(128, 0, 3, 200);
        Assert.assertTrue("long IP of 128.0.3.200 is correct",
                IPv4Address.fromLongAddress(longIP5).equals(addr5));

        long longIP6 = (long) 255 * 256 * 256 * 256 +
                (long) 255 * 256 * 256 +
                (long) 255 * 256 +
                (long) 255;
        IPv4Address addr6 = new IPv4Address(255, 255, 255, 255);
        Assert.assertTrue("long IP of 255.255.255.255 is correct",
                IPv4Address.fromLongAddress(longIP6).equals(addr6));
    }
}
