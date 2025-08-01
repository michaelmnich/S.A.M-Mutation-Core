# S.A.M-Mutation-Core
S.A.M. is an automated mutation testing system designed to optimize and
manage mutation-based software testing processes. Developed for research
purposes, its core includes modules for mutation, configuration, and network
communication, facilitating efficient test execution and analysis. The sys-
tem is language-agnostic, provided mutation testing framework and static
code metric tools are available. Initially built around the PIT mutation
testing framework, S.A.M. integrates enhanced mutation selection models,
probability-based optimizations, and distributed computing support. Its ad-
vancements improve software test efficiency, making it suitable for research
and practical applications. Future developments may further refine mutation
testing methodologies and expand real-world implementations.


## Network configuration
SAM nodes require network configuration. SAM can be deployed as distributed software, where each node processes a designated subset of mutated data.
<img width="554" height="368" alt="ExampleTopology" src="https://github.com/user-attachments/assets/cb42f447-dd21-4b40-a719-cfd380b05c24" />



Setting up worker 1.
```
start
Set server working port Port:
8081
Server waiting for request on port:
8081
```

Setting up worker 2.
```
> start
Set server working port Port: 
> 8082
Server waiting for request on port:
> 8082
```

Setting up a master node.
```
> connect
Server address: 
> localhost
Server Port: 
> 8081
FROM SERVER: You are connected to SAM-SYSTEM Node

> connect
Server address: 
> localhost
Server Port: 
> 8082
FROM SERVER: You are connected to SAM-SYSTEM Node
```




