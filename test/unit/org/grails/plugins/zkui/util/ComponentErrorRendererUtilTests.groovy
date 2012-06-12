package org.grails.plugins.zkui.util

import static org.junit.Assert.*
import org.zkoss.zul.impl.InputElement
import org.zkoss.zk.ui.Component
import org.zkoss.zul.Textbox
import org.zkoss.zul.Window
import grails.test.*

class ComponentErrorRendererUtilTests extends ComposerUnitTestCase{

   Window component
   Textbox txt1

   @Before
   void setUp(){
      Window.metaClass.select = { [txt1] }
      component = new Window()
      txt1 = new Textbox()
      txt1.setName('name')
      component.appendChild(txt1)
   }

   @Test
   void should_add_renderMapAsErrors_to_InputElement(){
      ComponentErrorRendererUtil util = new ComponentErrorRendererUtil()
      util.addRenderMapAsErrors()

      def params = [errors:[[field: 'name', error: 'Name can not be empty']]]

      component.renderMapAsErrors(bean: params)

      assertEquals 'Name can not be empty', txt1.getErrorMessage()


   }

}
