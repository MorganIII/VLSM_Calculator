public class Subnet {
    private String networkId;
    private String firstIpAddress;
    private String lastIpAddress;
    private String broadCastIpAdress;
    private String subnetMask;
    private int intsubnetMask;
    //create a constructor that takes all the parameters
    public Subnet() {

    }
    public Subnet(String networkId, String firstIpAddress, String lastIpAddress, String broadCastIpAdress, String subnetMask, int intsubnetMask) {
        this.networkId = networkId;
        this.firstIpAddress = firstIpAddress;
        this.lastIpAddress = lastIpAddress;
        this.broadCastIpAdress = broadCastIpAdress;
        this.subnetMask = subnetMask;
        this.intsubnetMask = intsubnetMask;
    }
    //create getters and setters for all the parameters
    public String getNetworkId() {
        return networkId;
    }
    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }
    public String getFirstIpAddress() {
        return firstIpAddress;
    }
    public void setFirstIpAddress(String firstIpAddress) {
        this.firstIpAddress = firstIpAddress;
    }
    public String getLastIpAddress() {
        return lastIpAddress;
    }
    public void setLastIpAddress(String lastIpAddress) {
        this.lastIpAddress = lastIpAddress;
    }

    public String getBroadCastIpAdress() {
        return broadCastIpAdress;
    }
    public void setBroadCastIpAdress(String broadCastIpAdress) {
        this.broadCastIpAdress = broadCastIpAdress;
    }
    public String getSubnetMask() {
        return subnetMask;
    }
    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }
    public int getIntsubnetMask() {
        return intsubnetMask;
    }
    public void setIntsubnetMask(int intsubnetMask) {
        this.intsubnetMask = intsubnetMask;
    }

    //create to string method
    @Override
    public String toString() {
        return "Subnet [broadCast=" + broadCastIpAdress + ", firstIpAddress=" + firstIpAddress + ", intsubnetMask=" + intsubnetMask
                + ", lastIpAddress=" + lastIpAddress + ", networkId=" + networkId + ", subnetMask=" + subnetMask + "]";
    }
    


}
