package org.grails.plugins.zkui.artefacts.vm;

import org.codehaus.groovy.grails.commons.AbstractInjectableGrailsClass;

public class DefaultGrailsViewModelClass extends AbstractInjectableGrailsClass
        implements GrailsViewModelClass {

    public static final String VIEW_MODEL = "VM";

    @SuppressWarnings("unchecked")
    public DefaultGrailsViewModelClass(Class clazz) {
        super(clazz, VIEW_MODEL);
    }
}
