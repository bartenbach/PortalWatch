package org.hopto.seed419.portalwatch;

/**
 *
 * @author seed419
 */

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {


    private final static Logger log = Logger.getLogger("PortalWatch");
    private static Handler ch;


    public Log() {
        log.setUseParentHandlers(false);
        ch = new PortalWatchConsoleHandler();
        ch.setFormatter(new LogFormatter());
        log.addHandler(ch);
    }

    public static void info(String message){
        log.log(Level.INFO, message);
    }

    public static void warning(String message){
        log.warning(message);
    }

    public static void warning(String message, Throwable t){
        log.log(Level.WARNING, message, t);
    }

    public static void severe(String message){
        log.severe(message);
    }

    public static void severe(String message, Throwable t){
        log.log(Level.SEVERE, message, t);
    }

    public static void debug(String message) {
        log.log(Level.FINE, message);
    }

    public static void setLevel(Level level) {
        log.setLevel(level);
        ch.setLevel(level);
    }
}
