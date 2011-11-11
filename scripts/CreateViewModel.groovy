includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsCreateArtifacts")

target('default': "Creates a new ViewModel") {
    depends(checkVersion, parseArguments)

    def type = "ViewModel"
    def suffix="VM"
    promptForName(type: type)

    for (name in argsMap["params"]) {
        name = purgeRedundantArtifactSuffix(name, suffix)
        createArtifact(name: name, suffix: suffix, type: type, path: "grails-app/vms")
        createUnitTest(name: name, suffix: suffix, superClass: "GrailsUnitTestCase")
    }

}
