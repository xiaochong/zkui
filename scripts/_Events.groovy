eventDocEnd = { kind ->
    if (kind == "groovydoc") {
        ant.copy(todir: "${basedir}/target/docs/ref/img") {
            fileset(dir: "${basedir}/src/docs/resources/img")
        }
    }

}