includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsCreateArtifacts")

target('default': "Creates a new composer") {
    depends(checkVersion, parseArguments)

    def type = "Composer"
    promptForName(type: type)

    for (name in argsMap["params"]) {
        name = purgeRedundantArtifactSuffix(name, type)
        createArtifact(name: name, suffix: type, type: type, path: "grails-app/composers")
        createUnitTest(name: name, suffix: type, superClass: "ComposerUnitTestCase")
    }

}
