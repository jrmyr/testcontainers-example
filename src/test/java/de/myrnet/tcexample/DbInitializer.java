package de.myrnet.tcexample;

import java.sql.Connection;
import java.sql.SQLException;

public class DbInitializer {

    public static void sampleInitFunction(Connection connection) throws SQLException {

        System.err.println("I SHOULD DO ANYTHING CLEVER ...  Do'h!");

        /*
         * TODO: multiple init file handling
         * Add here some init code which should be able to treat multiple files. With multiple files it should be
         * easier to apply a nice and clean structure for the data to import instead of messing it all into one file.
         * Of course, this is more interesting for heavier init scripts (with multiple (big) tables and more data).
         */

    }

}
