package org.grails.plugins.zkui.artefacts;

import org.codehaus.groovy.grails.commons.*;

public class DefaultGrailsComposerClass extends AbstractInjectableGrailsClass
        implements GrailsComposerClass {

    public static final String COMPOSER = "Composer";

    @SuppressWarnings("unchecked")
    public DefaultGrailsComposerClass(Class clazz) {
        super(clazz, COMPOSER);
    }
}