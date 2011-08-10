includeTargets << grailsScript("Init")

target(main: "Copy the default zk.xml file to the main app at web-app/WEB-INF/") {
    def targetFile = "${basedir}/web-app/WEB-INF/zk.xml"
    def proceed = true
    if(new File(targetFile).exists()) {
        proceed = false
        ant.input(message: "Overwrite the existing zk.xml?", addproperty: "overwrite.zk", validargs: "y,n")
        proceed = ant.antProject.properties["overwrite.zk"] == 'y'
    }

    if(proceed == true) {
        ant.copy(file:"${zkuiPluginDir}/src/templates/zkui/xml/zk.xml", todir:"${basedir}/web-app/WEB-INF/", overwrite: true)
    }
}

setDefaultTarget(main)
