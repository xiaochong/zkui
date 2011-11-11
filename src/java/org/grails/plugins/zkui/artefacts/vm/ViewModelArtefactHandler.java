package org.grails.plugins.zkui.artefacts.vm;

import org.codehaus.groovy.grails.commons.ArtefactHandlerAdapter;
import org.codehaus.groovy.grails.commons.DomainClassArtefactHandler;
import org.grails.plugins.zkui.artefacts.composer.GrailsComposerClass;

public class ViewModelArtefactHandler extends ArtefactHandlerAdapter {

    public static final String TYPE = "ViewModel";

    public ViewModelArtefactHandler() {
        super(TYPE, GrailsComposerClass.class,
                DefaultGrailsViewModelClass.class,
                DefaultGrailsViewModelClass.VIEW_MODEL,
                false);
    }

    @SuppressWarnings("unchecked")
    public boolean isArtefactClass(Class clazz) {
        return super.isArtefactClass(clazz) &&
                !DomainClassArtefactHandler.isDomainClass(clazz);
    }
}
