package javaexamples.cert.main;

// To compile and run
// 1) cd src\javaexamples\cert
// 2) javac DodgyMainMethod.java
// 3) java javaexamples.cert.main.DodgyMainMethod from C:\Dev\Workspaces\Reactive-Spring\JavaCert\src
// 4) Output: Error: StringBufferBuilderExamples method not found in class javaexamples.cert.main.DodgyMainMethod, please define the main method as:
//                public static void main(String[] args)
//            or a JavaFX application class must extend javafx.application.Application

public class DodgyMainMethod {

    private static boolean heatWave = true;
    public static void main(){
        boolean heatWave = false;
        System.out.println(heatWave);
    }
}

// Note the java command uses a period to separate packages, not a slash /
// Note you can compile entire directories using javac dir1/*.java dir2/*.java dir3/dir4/*.java dir3/dir5/*.java dir6/*src/*.java


/*C:\Dev\Workspaces\Reactive-Spring\JavaCert\src\javaexamples\cert>java -cp DodgyMainMethod
        Usage: java [-options] class [args...]
        (to execute a class)
        or  java [-options] -jar jarfile [args...]
        (to execute a jar file)
        where options include:
        -d32          use a 32-bit data model if available
        -d64          use a 64-bit data model if available
        -server       to select the "server" VM
        The default VM is server.

        -cp <class search path of directories and zip/jar files>
        -classpath <class search path of directories and zip/jar files>
        A ; separated list of directories, JAR archives,
        and ZIP archives to search for class files.
        -D<name>=<value>
                  set a system property
                          -verbose:[class|gc|jni]
        enable verbose output
        -version      print product version and exit
        -version:<value>
                  require the specified version to run
                          -showversion  print product version and continue
                          -jre-restrict-search | -no-jre-restrict-search
                          include/exclude user private JREs in the version search
        -? -help      print this help message
        -X            print help on non-standard options
        -ea[:<packagename>...|:<classname>]
        -enableassertions[:<packagename>...|:<classname>]
        enable assertions with specified granularity
        -da[:<packagename>...|:<classname>]
        -disableassertions[:<packagename>...|:<classname>]
        disable assertions with specified granularity
        -esa | -enablesystemassertions
        enable system assertions
        -dsa | -disablesystemassertions
        disable system assertions
        -agentlib:<libname>[=<options>]
        load native agent library <libname>, e.g. -agentlib:hprof
        see also, -agentlib:jdwp=help and -agentlib:hprof=help
        -agentpath:<pathname>[=<options>]
        load native agent library by full pathname
        -javaagent:<jarpath>[=<options>]
        load Java programming language agent, see java.lang.instrument
        -splash:<imagepath>
                  show splash screen with specified image

              */

