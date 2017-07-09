package javaexamples.cert.datetime;

import java.util.*;
import java.sql.*;

// Note that the imports do not cause the compilation issue,
// the ambiguity comes into play only when you try to use one of the imports
// Remember java figures out what is actually used and does not actually compile all
// methods into the classS
public class DateClassAmbiguityExample {

    //private Date rob = new Date(); // Compile error on ambiguity
    private java.util.Date sharon = new java.util.Date();

}
