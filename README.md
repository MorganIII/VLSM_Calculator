# VLSM Project

This project is a demonstration of Variable Length Subnet Masking (VLSM) technique used in networking to optimize IP address utilization. In this project, we have designed a network with 3 subnets, each with a different number of hosts.

## IP Addressing Plan

The network consists of three subnets, each with a different number of hosts. The subnets and their host requirements are as follows:

Subnet 1: 100 hosts\
Subnet 2: 50 hosts\
Subnet 3: 15 hosts\
The network address is 172.31.103.0/24.\
We have used VLSM to calculate the appropriate subnet masks for each subnet to optimize IP address utilization.

## VLSM Calculations

We have used the VLSM technique to calculate the subnet masks for each subnet, as well as the IP address ranges for each subnet.\
The VLSM calculations have resulted in the following IP address ranges for each subnet:

### Subnet 0

Network ID: 172.31.103.0.\
First Host IP Address: 172.31.103.1.\
Last Host IP Address: 172.31.103.126.\
Broadcast IP Address: 172.31.103.127.\
Subnet Mask: 255.255.255.128.\
Integer Subnet Mask: 25.
------------------------------------------------
### Subnet 1

Network ID: 172.31.103.128.\
First Host IP Address: 172.31.103.129.\
Last Host IP Address: 172.31.103.190.\
Broadcast IP Address: 172.31.103.191.\
Subnet Mask: 255.255.255.192.\
Integer Subnet Mask: 26.
------------------------------------------------
### Subnet 2

Network ID: 172.31.103.192.\
First Host IP Address: 172.31.103.193.\
Last Host IP Address: 172.31.103.222.\
Broadcast IP Address: 172.31.103.223.\
Subnet Mask: 255.255.255.224.\
Integer Subnet Mask: 27.
------------------------------------------------


## Conclusion

This VLSM project demonstrates how the VLSM technique can be used to optimize IP address utilization in a network. By carefully calculating the subnet masks for each subnet, we can ensure that IP addresses are allocated efficiently, reducing the risk of IP address exhaustion and minimizing the amount of wasted address space.
