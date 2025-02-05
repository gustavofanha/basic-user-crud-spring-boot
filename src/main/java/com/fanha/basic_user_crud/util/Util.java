package com.fanha.basic_user_crud.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Util {

    public static ZonedDateTime zonedTimeStamp() {
        var instant = Instant.now();
        return instant.atZone(ZoneId.of("America/Sao_Paulo"));
    }
}
