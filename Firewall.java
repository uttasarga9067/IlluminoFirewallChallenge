package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Firewall {

    static Set<Rule> rules = new HashSet<Rule>();

    public static void main(String[] args) {
        Firewall firewall = new Firewall("/Users/uttas/OneDrive/Desktop/input.csv");
        boolean rule1 = firewall.acceptPacket("inbound", "tcp", 80, "192.168.1.2");
        boolean rule2 = firewall.acceptPacket("inbound", "udp",53,"192.168.2.1");
        boolean rule3 = firewall.acceptPacket("outbound", "tcp",10234,"192.168.10.11");
        boolean rule4 = firewall.acceptPacket("inbound", "tcp",81,"192.168.1.2");
        boolean rule5 = firewall.acceptPacket("inbound", "udp",24,"52.12.48.92");
       boolean rule6 = firewall.acceptPacket("inbound", "tcp",600000,"52.12.48.92");
        if(rule1==true) {
            System.out.println("True" + "\n Firewall can allow the IP Address");
        }
        if(rule2==true) {
            System.out.println("True" + "\n Firewall can allow the IP Address");
        }
        if(rule3==true) {
            System.out.println("True" + "\n Firewall can allow the IP Address");
        }
        if(rule4==true) {
            System.out.println("True" + "\n Firewall can allow the IP Address");
        }else
            {
                System.out.println("False" + "\n Firewall will block the IP Address");
            }
        if(rule5==true) {
            System.out.println("True" + "\n Firewall can allow the IP Address");
        }else {
            System.out.println("False" + "\n Firewall will block the IP Address");
        }
        if(rule6 == true){
            System.out.println("True" + "\n Firewall can allow the IP Address");
        }else{
            System.out.println("False" + "\n Firewall will block the IP Address");
        }

    }
    public Firewall(String name){

        try(BufferedReader br = new BufferedReader(new FileReader(name))) {

            String line;
            while((line = br.readLine()) != null) {

                String [] rule = line.split(",");

                if (rule[2].contains("-")) {
                    String [] Ranges = rule[2].split("-");
                    int Min = Integer.parseInt(Ranges[0]);
                    int Max = Integer.parseInt(Ranges[1]);
                    int Range = Max - Min;


                    if (rule[3].contains("-")) {
                        String [] ipAddressRanges = rule[3].split("-");
                        long ipAddressMin = Long.parseLong(ipAddressRanges[0].replaceAll("\\.", ""));
                        long ipAddressMax = Long.parseLong(ipAddressRanges[1].replaceAll("\\.", ""));
                        long ipRange = ipAddressMax - ipAddressMin;

                        for (int i = 0; i <= Range; i++) {
                            for (int j = 0; j <= ipRange; j++) {
                                Rule currRule = new Rule(rule[0], rule[1], Min + i, ipAddressMin + j);
                                rules.add(currRule);
                            }
                        }


                        for (int i = 0; i <= Range; i++) {
                            for (int j = 0; j <= ipRange; j++) {
                                Rule currRule = new Rule(rule[0], rule[1], Min + i, ipAddressMin + j);
                                rules.add(currRule);
                            }
                        }
                    }else{


                        for (int i = 0; i <= Range; i++) {
                            Rule currRule = new Rule(rule[0],rule[1], Min + i, rule[3]);
                            rules.add(currRule);
                        }
                    }
                }

                else

                {

                    if (rule[3].contains("-")) {
                        String [] ipAddressRanges = rule[3].split("-");
                        long ipAddressMin = Long.parseLong(ipAddressRanges[0].replaceAll("\\.", ""));
                        long ipAddressMax = Long.parseLong(ipAddressRanges[1].replaceAll("\\.", ""));
                        long ipRange = ipAddressMax - ipAddressMin;


                        for (int i = 0; i <= ipRange; i++) {
                            Rule currRule = new Rule(rule[0],rule[1],rule[2], ipAddressMin + i);
                            rules.add(currRule);
                        }
                    }
                    else

                    {
                        Rule currRule = new Rule(rule[0],rule[1],rule[2],rule[3]);
                        rules.add(currRule);
                    }

                }

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("The Location of the file given is Invalid "+ name );
        }
        catch(Exception e) {
            System.out.println("Caught the Exception " + e.getMessage());
        }
    }

    public boolean acceptPacket(String direction, String protocol, int port, String ipAddress) {
       Rule rule = new Rule(direction, protocol, port, ipAddress);
        if (rules.contains(rule)) {
            return true;
        }
        else {
            return false;
        }

    }

}

