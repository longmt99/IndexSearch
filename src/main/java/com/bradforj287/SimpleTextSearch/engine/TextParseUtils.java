package com.bradforj287.SimpleTextSearch.engine;

import org.apache.commons.lang3.StringUtils;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brad on 6/6/15.
 */
public class TextParseUtils {

    private TextParseUtils() {

    }

    public static String stemWord(String word) {
        return word;
    }

    public static List<String> tokenize(String rawText) {

        List<String> retVal = new ArrayList<>();
        if (StringUtils.isEmpty(rawText)) {
            return retVal;
        }

        return retVal;
    }

}
