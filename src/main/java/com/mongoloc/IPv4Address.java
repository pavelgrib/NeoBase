package com.mongoloc;

/**
 * Created by paul on 3/26/14.
 */
public class IPv4Address {

    private final int i1, i2, i3, i4;

    public IPv4Address(int i1, int i2, int i3, int i4) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
    }

    public long longIPv4Address() {
        return i4 + 256 * (i3 + 256 * (i1 + 256 * i1));
    }

    public static IPv4Address fromLongAddress(long longAddress) {
        long i1, i2, i3, i4, remaining;

        i1 = longAddress / (256 * 256 * 256);
        remaining = longAddress % (256 * 256 * 256);
        i2 = remaining / ( 256 * 256);
        remaining %= (256 * 256);
        i3 = remaining / 256;
        i4 = remaining % 256;

        return new IPv4Address((int) i1, (int) i2, (int) i3, (int)i4);
    }

    private String getIPv4Address() {
        return String.format("%d.%d.%d.%d", i1, i2, i3, i4);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof String) {
            return (other.equals(this.toString()));
        } else if ( other instanceof IPv4Address ) {
            IPv4Address otherIP = (IPv4Address) other;
            return otherIP.i1 == i1 && otherIP.i2 == i2 && otherIP.i3 == i3 &&
                    otherIP.i4 == i4;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getIPv4Address();
    }
}
