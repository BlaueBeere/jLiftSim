/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jliftsim;

/**
 *
 * @author BVirtual
 */
import java.io.IOException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class MainLogger {
    private static Logger logger = null;

    private MainLogger() {
        super();
    }

    public static Logger getInstance(String path) {
        if (logger == null)
            initLogger(path);
        return logger;
    }

    private static void initLogger(String path) {
        try {
            logger = Logger.getLogger(MainLogger.class);
            PatternLayout appenderLayout = new PatternLayout();
            appenderLayout.setConversionPattern("%d %p - %m%n");
            FileAppender appender = new FileAppender(appenderLayout,path);
            logger.addAppender(appender);
            logger.setLevel(org.apache.log4j.Level.ALL);
        } catch (IOException ex) {
            logger.error("Cannot access log file: " + ex.getLocalizedMessage());
        } catch (Exception ex) {
            logger.error("Unknown exception: " + ex.getLocalizedMessage());
        }
    }
}