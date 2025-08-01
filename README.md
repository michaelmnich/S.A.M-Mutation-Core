

# <img width="36" height="74" alt="images" src="https://github.com/user-attachments/assets/9fa93f6e-2803-4073-a857-135ebe2e897b" />S.A.M-Mutation-Core
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


## Configuration 
Configuration parameters can be specified within dedicated configuration files to ensure consistent deployment and execution.

<img width="688" height="427" alt="UseCase" src="https://github.com/user-attachments/assets/0d41ea56-2cb0-4aa8-a369-c7d4daa783e7" />

The path to project dependencies targeted for mutation is defined in the metadata.ini file.
### Configuration shema
```
run mutation -i 
--classPath 
D:\\<dir>\\PitPlayground\\IOgr602-master\\target\\test-classes\\,D:\\<dir>\\PitPlayground\\IOgr602-master\\target\\classes\\
--reportDir
D:\\trash 
--targetclasses 
matrixlibrary.* 
--targetTests 
matrixlibrary.* 
--sourceDirs 
D:\\<dir>\\PitPlayground\\IOgr602-master\\
```

### Configuration Example
```
--classPath
Drive:\\HelloWorldExample\\p\\,Drive:\\HelloWorldExample\\p\\
--reportDir
Drive:\\reports\\
--targetClasses
com.uj.atm.common.Account,com.uj.atm.common.Atm,com.uj.atm.common.CreditCard,com.uj.atm.common.DummySample
--targetTests
com.uj.atm.Test.*
--sourceDirs
Drive:\\HelloWorldExample\\
```

Environment variables relevant to the mutation process are configured in the mainconfig.cfg file.
### Configuration shema
```
<HereConfigStarts>
PIT-JAR-DIR;D:\\<dir>\\pitcmd\\PIT-1.1.11-SNAPSHOT.jar
PIT-CMD-JAR-DIR;D:\\<dir>\\pitcmd\\PIT-command-line-1.1.11-SNAPSHOT.jar
HAMCREST-DIR;C:\\JUnit\\hamcrest-core-1.3.jar
JUnit-DIR;C:\\JUnit\\JUnit-4.12.jar
PROJECT-class-DIR;D:\\<dir>\\PitPlayground\\IOgr602-master\\target\\test-classes\\
PROJECT-TEST-class-DIR;D:\\Doktorat\\PitPlayground\\IOgr602-master\\target\\classes\\
```

### Configuration Example
```
<HeareConfigStarts>
PIT_JAR_DIR;G:\\repos\\GitHub\\S.A.M-Mutation-Core\\Resources\\pitest-1.1.11-SNAPSHOT.jar
PIT_CMD_JAR_DIR;G:\\repos\\GitHub\\S.A.M-Mutation-Core\\Resources\\pitest-command-line-1.1.11-SNAPSHOT.jar
HAMCREST_DIR;G:\\repos\\GitHub\\S.A.M-Mutation-Core\\Resources\\hamcrest-core-1.3.jar
JUNIT_DIR;G:\\repos\\GitHub\\S.A.M-Mutation-Core\\Resources\\junit-4.12.jar
```

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

## Sample outputs

### Code run
<img width="1184" height="471" alt="image" src="https://github.com/user-attachments/assets/d1dcd0c7-4bf4-46c4-9eb3-3e1c8a1a35ef" />

### CSV Reprot
<img width="1159" height="404" alt="image" src="https://github.com/user-attachments/assets/3b6d6885-fd8d-497c-bb3f-0f5cb46089af" />

### Exel Reprot
<img width="1169" height="466" alt="image" src="https://github.com/user-attachments/assets/431c3bf0-eae8-410b-9699-c4f1f5eeba17" />



