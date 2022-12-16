import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Calculator{


      public static List<String> getSubnets (String ipAdrressBinary , int oldSubnetMask , int newSubnetMask){

            List<String> subnets = new ArrayList<String>();
            ipAdrressBinary = VlsmService.deleteDots(ipAdrressBinary);
            int numberOfBits = newSubnetMask - oldSubnetMask;
            List<String> subnetCombinations = VlsmService.getCombinations(numberOfBits);
            for(int i = 0 ; i < subnetCombinations.size() ; i++){
                  String subnet = ipAdrressBinary.substring(0 , oldSubnetMask) + subnetCombinations.get(i)+ ipAdrressBinary.substring(newSubnetMask);
                  subnet = VlsmService.addDots(subnet);
                  subnets.add(subnet);
            }
            return subnets;
      }
        
      //method that takes the subnet ip address and return the first host ip address
      public static String getFirstHostIpAddress(String subnetIpAddress){
            String firstHostIpAddress = subnetIpAddress.substring(0, subnetIpAddress.length() - 1) + "1";
            return firstHostIpAddress;
      }

     //method that takes the subnet ip address and subnet mask and return the last host ip address
     public static String getLastHostIpAddress(String subnetIpAddress , int subnetMask){
            subnetMask += 3;
            String lastHostIpAddress = subnetIpAddress.substring(0, subnetMask);
            for(int i = subnetMask ; i < subnetIpAddress.length()-1 ; i++){
                  if(subnetIpAddress.charAt(i) == '.'){
                        lastHostIpAddress += ".";
                        continue;
                  }
                  else{
                        lastHostIpAddress += "1";
                  }
                 
            }
            return lastHostIpAddress+"0";
            }
      
            //method that takes the subnet ip address and subnet mask and return the broadcast ip address
            public static String getBroadcastIpAddress(String subnetIpAddress , int subnetMask){
                  subnetMask += 3;
                  String broadcastIpAddress = subnetIpAddress.substring(0, subnetMask);
                  for(int i = subnetMask ; i < subnetIpAddress.length() ; i++){
                        if(subnetIpAddress.charAt(i) == '.'){
                              broadcastIpAddress += ".";
                              continue;
                        }
                        else{
                              broadcastIpAddress += "1";
                        }
                       
                  }
                  return broadcastIpAddress;
            }

            public static Map<String ,Subnet> getSubnetsInfo(List<String> subnets , int subnetMask){
                  Map<String , Subnet> subnetsInfo = new LinkedHashMap<String , Subnet>();
                  for(int i = 0 ; i < subnets.size() ; i++){
                        Subnet subnet = new Subnet();

                        subnet.setNetworkId(VlsmService.convertAnyAddressToInt(subnets.get(i)));
                        subnet.setFirstIpAddress(VlsmService.convertAnyAddressToInt(getFirstHostIpAddress(subnets.get(i))));
                        subnet.setLastIpAddress(VlsmService.convertAnyAddressToInt(getLastHostIpAddress(subnets.get(i) , subnetMask)));
                        subnet.setBroadCastIpAdress(VlsmService.convertAnyAddressToInt(getBroadcastIpAddress(subnets.get(i) , subnetMask)));
                        subnet.setIntsubnetMask(subnetMask);
                        subnet.setSubnetMask(VlsmService.convertSubnetMaskToInt(subnetMask));
                        subnetsInfo.put("Subnet " + i, subnet);
                  }
                  return subnetsInfo;
            }

            public static Map<String ,Subnet> calculateVLSM(Vlsm vlsm){
                  String ipAdressWithSubnetMask = vlsm.getIpAddressWithSubnetMask();
                  int numberOfHosts = vlsm.getNumberOfHosts();
                  String ipAdress = VlsmService.getIpAddressWithoutSubnetMask(ipAdressWithSubnetMask);
                  int subnetMask = VlsmService.getSubnetMaskWithoutIpAdress(ipAdressWithSubnetMask);
                  String ipAdressBinary = VlsmService.convertAnyAddressToBinary(ipAdress);
                  int numberOfBits = VlsmService.getNumberOfBits(numberOfHosts);
                  int newSubnetMask = VlsmService.getNewSubnetMask(numberOfBits);
                  List<String> subnets = getSubnets(ipAdressBinary , subnetMask , newSubnetMask);
                  Map<String , Subnet> subnetsInfo = getSubnetsInfo(subnets , newSubnetMask);
                  return subnetsInfo;
            }

            public static Subnet  getFirstSubnet(Vlsm vlsm){

                     Map<String,Subnet> subnets = calculateVLSM(vlsm);
                     return subnets.get("Subnet 0");
            }

            public static void printFirstSubnet(Subnet subnet){
                System.out.println("Subnet 0");
                System.out.println("Network ID: " + subnet.getNetworkId());
                System.out.println("First Host IP Address: " + subnet.getFirstIpAddress());
                System.out.println("Last Host IP Address: " + subnet.getLastIpAddress());
                System.out.println("Broadcast IP Address: " + subnet.getBroadCastIpAdress());
                System.out.println("Subnet Mask: " + subnet.getSubnetMask());
                System.out.println("Integer Subnet Mask: " + subnet.getIntsubnetMask());

            }
            public static void printAllSubnetsInfo(Map<String , Subnet> subnetsInfo){
                  for(Map.Entry<String , Subnet> entry : subnetsInfo.entrySet()){
                        System.out.println(entry.getKey());
                        System.out.println("Network ID: " + entry.getValue().getNetworkId());
                        System.out.println("First Host IP Address: " + entry.getValue().getFirstIpAddress());
                        System.out.println("Last Host IP Address: " + entry.getValue().getLastIpAddress());
                        System.out.println("Broadcast IP Address: " + entry.getValue().getBroadCastIpAdress());
                        System.out.println("Subnet Mask: " + entry.getValue().getSubnetMask());
                        System.out.println("Integer Subnet Mask: " + entry.getValue().getIntsubnetMask());
                        System.out.println("------------------------------------------------");
                  }
                 
            }


            public static Map<String ,Subnet> findall(String ip , List<Integer> hosts){
               Map<String ,Subnet> subnetMap = new LinkedHashMap<>();

               hosts =VlsmService.getNumberOfHostsSorted(hosts);
               int number = 0;
               String ipAddress =ip;
               for(int i = hosts.size()-1;i >= 0; i--){
                   Subnet subnet =getFirstSubnet(new Vlsm(ipAddress,hosts.get(i)));
                   subnetMap.put("Subnet " + number, subnet );
                   String temp = VlsmService.addOneToBinaryNumber(subnet.getBroadCastIpAdress());
                   ipAddress=temp+"/"+subnet.getIntsubnetMask();
                   System.out.println(ipAddress);
                   number++;
               }

               return subnetMap;
            }
} 
