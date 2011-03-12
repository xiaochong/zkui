package org.grails.plugins.zkui.artefacts;

import org.codehaus.groovy.grails.commons.AbstractInjectableGrailsClass;

public class DefaultGrailsComposerClass extends AbstractInjectableGrailsClass
        implements GrailsComposerClass {

    public static final String COMPOSER = "Composer";
    private static final String TRANSACTIONAL = "transactional";

    private boolean transactional = true;

    @SuppressWarnings("unchecked")
    public DefaultGrailsComposerClass(Class clazz) {
        super(clazz, COMPOSER);
        Object tmpTransactional = getPropertyOrStaticPropertyOrFieldValue(TRANSACTIONAL, Boolean.class);
        transactional = tmpTransactional == null || tmpTransactional.equals(Boolean.TRUE);
    }

    public boolean isTransactional() {
        return transactional;
    }
}