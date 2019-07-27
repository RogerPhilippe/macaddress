package br.com.philippesis.macaddress;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {

        try {
            // get all network interfaces of the current system
            Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
            // iterate over all interfaces
            while (networkInterface.hasMoreElements()) {
                // get an interface
                NetworkInterface network = networkInterface.nextElement();
                // get its hardware or mac address
                byte[] macAddressBytes = network.getHardwareAddress();
                if (macAddressBytes != null) {
                    System.out.print("MAC address of interface \"" + network.getName() + "\" is : ");
                    // initialize a string builder to hold mac address
                    StringBuilder macAddressStr = new StringBuilder();
                    // iterate over the bytes of mac address
                    for (int i = 0; i < macAddressBytes.length; i++) {
                        // convert byte to string in hexadecimal form
                        macAddressStr.append(String.format("%02X", macAddressBytes[i])+":");
                        // check if there are more bytes, then add a "-" to make it more readable
                    }
                    String newMac = (String) macAddressStr.subSequence(0, macAddressStr.length() -1);
                    System.out.println(newMac);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}