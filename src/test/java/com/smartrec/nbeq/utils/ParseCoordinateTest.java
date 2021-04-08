package com.smartrec.nbeq.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(PER_CLASS)
@DisplayName("Latitude and Longitude parser check")
class ParseCoordinateTest {

    @Test
    @DisplayName("Parsed Latitude should be equal to expected")
    void parseLatitudeTest() {
        assertEquals(40.730610, ParseCoordinates.parseLatitude("41.232613"));
    }

    @Test
    @DisplayName("Parsed Longitude should be equal to expected")
    void parseLongitudeTest() {
        assertEquals(-73.935242, ParseCoordinates.parseLongitude("-73.935242"));
    }

    @Test
    @DisplayName("Exception should be thrown when Latitude string is null")
    void parseNullLatitudeTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> ParseCoordinates.parseLatitude(null));
        assertEquals("Latitude can not be null or empty!", exception.getMessage());
    }

    @Test
    @DisplayName("Exception should be thrown when Longitude string is empty")
    void parseEmptyLongitudeTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> ParseCoordinates.parseLongitude(""));
        assertEquals("Longitude can not be null or empty!", exception.getMessage());
    }


}
