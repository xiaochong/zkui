eventDocEnd = { kind ->
    if (kind == "groovydoc") {
        ant.copy(todir: "${basedir}/target/docs/img") {
            fileset(dir: "${basedir}/src/docs/resources/img")
        }
    }

}