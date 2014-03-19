package com.scratch;

import java.util.StringTokenizer;

/**
 * Created by paul.gribelyuk on 1/3/14.
 * A class to test various string parsing Java routines
 */
public class StringSplitting {
    private static final String str1 = "PRODUCT_NAME,  SID,  ORDERID,  QUANTITY,  AMOUNT,  OID, USD_AMOUNT,  SID, " +
            "ACID,  TID,  SITE_COMM,  LSN_COMM, TYPE,  ACCESS_DATE,  TRANS_DATE,  SKU_NUMBER, PROCESS_DATE";
    private static final String str2 = " this is onlya test";

    private static void tokenizer(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            st.nextToken();
//            System.out.println(st.nextToken());
        }
    }

    private static void stringSplit(String str, String delim) {
        String[] split = str.split(delim);
        for ( String s: split) {

        }
    }

    public static void main(String[] args) {
        long N = 1000000; //Long.parseLong(args[1]);
        long t0 = System.nanoTime();
        for ( int i = 0; i < N; ++i ) {
            StringSplitting.stringSplit(str1, ",");
        }
        long t1 = System.nanoTime();
        System.out.println("seconds per call " + (double)(t1 - t0) / N / 1e9);
        System.out.println("total time " + (double)(t1 - t0) / 1e9);
    }
}
