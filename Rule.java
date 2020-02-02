package com.company;

public class Rule
{
    protected String direction;
    protected String protocol;
    protected int port;
    protected long ipAddress;

    public Rule(String direction, String protocol, String port, String ipAddress) {
        this.direction = direction;
        this.protocol = protocol;
        this.port = Integer.parseInt(port);
        this.ipAddress = Long.parseLong(ipAddress.replaceAll("\\.", ""));
    }
    public Rule(String direction, String protocol, String port, long ipAddress) {
        this.direction = direction;
        this.protocol = protocol;
        this.port = Integer.parseInt(port);
        this.ipAddress = ipAddress;
    }

    public Rule(String direction, String protocol, int port, long ipAddress) {
        this.direction = direction;
        this.protocol = protocol;
        this.port = port;
        this.ipAddress = ipAddress;
    }

    public Rule(String direction, String protocol, int port, String ipAddress) {
        this.direction = direction;
        this.protocol = protocol;
        this.port = port;
        this.ipAddress = Long.parseLong(ipAddress.replaceAll("\\.", ""));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rule)) return false;
        Rule rule = (Rule) obj;
        return  direction.equalsIgnoreCase(rule.direction) && protocol.equalsIgnoreCase(rule.protocol)
                && port == rule.port && ipAddress == rule.ipAddress;
    }

    @Override
    public String toString() {
        return this.direction +  ", " + this.protocol + ", " + Integer.toString(this.port) + ", " + Long.toString(this.ipAddress);
    }

    public int hashCode() {
        long hash =  31 * (this.ipAddress + this.port + this.direction.hashCode() + this.protocol.hashCode());
        return Long.valueOf(hash).hashCode();
    }
}
