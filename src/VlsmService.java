import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public abstract class VlsmService{


    //method that takes the number of hosts and returns the number of bits needed for the subnet mask
    public static int getNumberOfBits(int number){
        int numberOfBits = 0;
        int numberNeeded = number + 2;
        while (numberNeeded > 0){
            numberNeeded = numberNeeded / 2;
            numberOfBits++;
        }
        return numberOfBits;
    }
     //method that takes the number of bits and returns the new subnet mask as int
        public static int getNewSubnetMask(int numberOfBits){
            return 32 - numberOfBits;
        }

    //method that takes the ip address with the subnet mask and returns the ip address without the subnet mask
    public static String getIpAddressWithoutSubnetMask(String ipAddressWithSubnetMask){
        String ipAddressWithoutSubnetMask = "";
        for (int i = 0; i < ipAddressWithSubnetMask.length(); i++){
            if (ipAddressWithSubnetMask.charAt(i) == '/'){
                break;
            }
            ipAddressWithoutSubnetMask += ipAddressWithSubnetMask.charAt(i);
        }
        return ipAddressWithoutSubnetMask;
    }


    //method that takes the ip address and subnetmask then returns the subnet mask
    public static int getSubnetMaskWithoutIpAdress(String ipAddressWithSubnetMask){
        String subnetMask = "";
        for (int i = 0; i < ipAddressWithSubnetMask.length(); i++){
            if (ipAddressWithSubnetMask.charAt(i) == '/'){
                subnetMask = ipAddressWithSubnetMask.substring(i + 1);
                break;
            }
    }
        return Integer.parseInt(subnetMask);
    }

    //method that takes ip address or subnet mask and convert it to binary
    public static String convertAnyAddressToBinary(String address){
        String binaryAddress = "";
        String[] addressArray = address.split("\\.");
        for (int i = 0; i < addressArray.length; i++){
            int number = Integer.parseInt(addressArray[i]);
            String binaryNumber = Integer.toBinaryString(number);
            while (binaryNumber.length() < 8){
                binaryNumber = "0" + binaryNumber;
            }
            binaryAddress += binaryNumber;
            if (i != addressArray.length - 1){
                binaryAddress += ".";
            }
        }
        return binaryAddress;
    }

      //method that takes the binary ip address or subnet mask and return the its format in integer
      public static String convertAnyAddressToInt(String addressBinary){
        String addressAsInt = "";
        String[] AddressBinaryArray = addressBinary.split("\\.");
        for (int i = 0; i < AddressBinaryArray.length; i++){
            int number = Integer.parseInt(AddressBinaryArray[i], 2);
            addressAsInt += number;
            if (i != AddressBinaryArray.length - 1){
                addressAsInt += ".";
            }
        }
        return addressAsInt;
    }


    //method that takes the subnet mask as int and returns the subnet mask in binary format
    public static String convertSubnetMaskToBinary(int subnetMask){
        String binarySubnetMask = "";
        for (int i = 0; i < 32; i++){
            if (i < subnetMask){
                binarySubnetMask += "1";
            }
            else{
                binarySubnetMask += "0";
            }
        }
        binarySubnetMask = addDots(binarySubnetMask);
        return binarySubnetMask;
    }
    

    //method that takes the binary subnet mask format and returns the subnet mask in integer format
    public static String convertSubnetMaskToInt(int subnetMask){
        String binarySubnetMask = convertSubnetMaskToBinary(subnetMask);
        String intSubnetMask = convertAnyAddressToInt(binarySubnetMask);
        return intSubnetMask;
    }
    
   
     
    //method that takes number of bits and returns all the cominations of this number of bits
    public static List<String> getCombinations(int numberOfBits){
        List<String> combinations = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, numberOfBits); i++){
            String combination = Integer.toBinaryString(i);
            while (combination.length() < numberOfBits){
                combination = "0" + combination;
            }
            combinations.add(combination);
        }
        return combinations;
    }


    //method that delete dots in the binary ip address or subnet mask
    public static String deleteDots(String addressBinary){
        String addressBinaryWithoutDots = "";
        for(int i = 0 ; i < addressBinary.length() ; i++){
              if(addressBinary.charAt(i) == '.'){
                    continue;
              }
              else{
                addressBinaryWithoutDots += addressBinary.charAt(i);
              }
        }
        return addressBinaryWithoutDots;
  }

  //method that add dots in the binary ip address or subnet mask
    public static String addDots(String addressBinaryWithoutDots){
            String addressBinary = "";
            for(int i = 0 ; i < addressBinaryWithoutDots.length() ; i++){
                if(i % 8 == 0 && i != 0){
                    addressBinary += ".";
                }
                addressBinary += addressBinaryWithoutDots.charAt(i);
            }
            return addressBinary;
    }
 



    public static List<Integer> getNumberOfHostsSorted(List<Integer> Hosts){

        Hosts.sort(Integer::compareTo);

        return Hosts;
    }

    public static String addOneToBinaryNumber(String binaryAddress){

        String[] tokens =binaryAddress.split("\\.");

        for(int i = tokens.length-1;i>=0;i--){
            int item = Integer.parseInt(tokens[i]);
            if(item<255){
                tokens[i]=String.valueOf(item+1);
                for (int j = i+1;j<4;j++){
                    tokens[j] ="0";
                }
                break;
            }
        }
return new StringBuilder()
        .append(tokens[0]).append('.')
        .append(tokens[1]).append('.')
        .append(tokens[2]).append('.')
        .append(tokens[3])
        .toString();
    }
}