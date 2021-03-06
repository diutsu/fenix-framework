package pt.ist.fenixframework.backend.jvstmojb.pstm;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.server.UID;

import pt.ist.fenixframework.FenixFramework;

public class Util {

    private static final String uidString = (new UID()).toString();

    public static String getServerName() {
        final String hostAddress = getHostAddress();
        final String username = getUsername();
        final String appName = getAppName();
        return username + "@" + hostAddress + ":" + appName + ":" + uidString;
    }

    public static String getHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException uhe) {
            throw new Error("Couldn't get this host address, which is needed to register in the database");
        }
    }

    public static String getAppName() {
        return FenixFramework.getConfig().getAppName();
    }

    public static String getUsername() {
        final String user = System.getenv("USER");
        final String username = System.getenv("USERNAME");

        return (user != null) ? user : (username != null) ? username : "unknown";
    }
}
