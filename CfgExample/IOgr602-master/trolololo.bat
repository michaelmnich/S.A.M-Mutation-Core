java org.pitest.mutationtest.commandline.MutationCoverageReport \
    --reportDir <outputdir> \
    --targetClasses com.your.package.tobemutated* \
    --targetTests com.your.packge.*
    --sourceDirs <pathtosource>
	
	    org.pitest.mutationtest.MutationCoverageReport \
    --reportDir target/pit-reports \
    --targetClasses pitexample.* \
    --sourceDirs src/main/java,src/test/java