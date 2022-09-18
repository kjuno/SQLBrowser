package de.kjuno.sqlbrowser.mysql.data;

public class ConnectionData {
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ConnectionData(String hostname, String user, String password, int port) {
        this.hostname = hostname;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    private String hostname;
    private String user;
    private String password;
    private int port;
}
