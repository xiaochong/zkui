package org.grails.plugins.zkui.util

import org.zkoss.zul.impl.InputElement
import org.zkoss.zk.ui.Component

class ComponentErrorRendererUtil{
   
   public void addRenderMapAsErrors(){
      org.zkoss.zk.ui.Component.metaClass.renderMapAsErrors = {Map args->
         for(_error in args.bean.errors){
            def name = _error.field

            def selectedComponentList = delegate.select("[name='${name}']")
            if(selectedComponentList.size() > 0 && selectedComponentList[0] instanceof InputElement){
               selectedComponentList[0].setErrorMessage(_error.error)
            }
         }

      }
   }
}
