package com.processing;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * Created by paul.gribelyuk on 1/31/14.
 *
 * Use this to parse an individual delimited line of text
 */
public class LineParser {

    private static final int MAX_LINE_LENGTH = 80000;
    private byte [] byteArray;
    private String string;
    private String[] split;
    private HashMap<String, String> fields;

    CharsetDecoder decoder;

    public LineParser(String str) {
        this.string = str;
    }

    public LineParser( ByteBuffer buffer ) throws CharacterCodingException {
        decoder = StandardCharsets.UTF_8.newDecoder();
        CharBuffer cb = decoder.decode( buffer );
        this.string = cb.toString();
    }

    public LineParser tokenize( String[] schema, String delimiter ) {
        this.split = this.string.split( delimiter );
        this.fields = new HashMap<String, String>( schema.length );

        for ( int i = 0; i < schema.length; ++i ) {
            this.fields.put(schema[i], split[i]);
        }

        return this;
    }

    public String get( String key ) {
        return this.fields.get( key );
    }
}
