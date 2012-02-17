package org.grails.plugins.zkui.artefacts.composer;

import org.codehaus.groovy.grails.commons.ArtefactHandlerAdapter;
import org.codehaus.groovy.grails.commons.DomainClassArtefactHandler;


public class ComposerArtefactHandler extends ArtefactHandlerAdapter {

    public static final String TYPE = "Composer";

    public ComposerArtefactHandler() {
        super(TYPE, GrailsComposerClass.class,
                DefaultGrailsComposerClass.class,
                DefaultGrailsComposerClass.COMPOSER,
                false);
    }

    @SuppressWarnings("unchecked")
    public boolean isArtefactClass(Class clazz) {
        return super.isArtefactClass(clazz) &&
                !DomainClassArtefactHandler.isDomainClass(clazz);
    }
}
