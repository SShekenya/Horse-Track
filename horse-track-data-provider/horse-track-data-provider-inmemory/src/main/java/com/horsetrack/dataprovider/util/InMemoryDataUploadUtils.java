package com.horsetrack.dataprovider.util;

import com.horsetrack.model.Horse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergii.shekenya on 14.06.2015.
 */
public final class InMemoryDataUploadUtils {
    private static final Pattern HORSE_PATTERN = Pattern.compile("(\\d*),(.+),(\\d*)");

    private InMemoryDataUploadUtils() {
    }

    public static Map<Long, Horse> uploadEntryHorses() throws IOException {
        Map<Long, Horse> result = new HashMap<Long, Horse>();

        InputStream in = InMemoryDataUploadUtils.class.getClassLoader().getResourceAsStream("initial-horse-list");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                Horse horse = parseLineToHorseEntry(line);
                result.put(horse.getId(), horse);
            }
        } finally {
            bufferedReader.close();
        }
        return result;
    }

    private static Horse parseLineToHorseEntry(String line) {
        Matcher matcher = HORSE_PATTERN.matcher(line);
        if (matcher.matches()) {
            Horse horse = new Horse();
            horse.setId(Long.valueOf(matcher.group(1)));
            horse.setName(matcher.group(2));
            horse.setOdds(Long.valueOf(matcher.group(3)));
            return horse;
        } else {
            throw new IllegalStateException("Initial horse list is not matching pattern");
        }
    }
}
