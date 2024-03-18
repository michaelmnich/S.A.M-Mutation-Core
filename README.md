

# S.A.M-Mutation-Core

INFO: Project supported by IntelliJ development environment and Maven builder.

Main Directory: pitest-master -> Contains the Modified PiTest system and S.A.M-Mutation-Core modules,
which manage the mutation process and optimize this process.

S.A.M-Mutation-Core/pitest-master/metadata.ini -> Configuration file for the mutation process.

S.A.M-Mutation-Core/pitest-master/mainconfig.cfg -> Configuration file for the S.A.M and PiTest environment.

S.A.M-Mutation-Core/pitest-master/MutationProbabilityConfig.ini -> Configuration file for optimization
based on Bayesian statistical inference.

Latest release: [Link to GitHub Release](https://github.com/michaelmnich/S.A.M-Mutation-Core/releases/tag/1.0)

## Commands

- `test`: Performs an internal test (not important).
- `connect`: Connects to a SAM server. Prompts for server address and port.
- `start`: Starts the SAM system server on the local machine. Prompts for port.
- `run mutation -broadcast`: Sends a start mutation request to all connected SAM servers.
- `rm`: Executes a single instance of mutation testing using project configuration.
- `tqed`: Executes mutation testing on multiple files with detailed reporting.
- `run mutation -pc`: Executes mutation testing on a single project class by class.
- `run mutation -bayes -pc`: Executes mutation testing on a single project with Bayes' consideration class by class.
- `run mutation -bayes`: Executes mutation testing on a single project with Bayes' consideration.
- `run mutation -i`: Executes mutation testing with hardcoded input.
- `Send`: Sends a custom message to all connected nodes.
- `help`: Displays available commands and their descriptions.
