public class Vlsm {
    private String ipAddressWithSubnetMask;
    private int numberOfHosts;    
    public Vlsm(String ipAddressWithSubnetMask, int numberOfHosts) {
        this.ipAddressWithSubnetMask = ipAddressWithSubnetMask;
        this.numberOfHosts = numberOfHosts;
    }
    public String getIpAddressWithSubnetMask() {
        return ipAddressWithSubnetMask;
    }
   
    public int getNumberOfHosts() {
        return numberOfHosts;
    }

}
