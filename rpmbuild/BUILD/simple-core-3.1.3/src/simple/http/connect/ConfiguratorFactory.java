/*
 * ConfiguratorFactory.java August 2005
 *
 * Copyright (C) 2005, Niall Gallagher <niallg@users.sf.net>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General 
 * Public License along with this library; if not, write to the 
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330, 
 * Boston, MA  02111-1307  USA
 */
 
package simple.http.connect;

/**
 * The <code>ConfiguratorFactory</code> retrives an instance of 
 * the <code>Configurator</code> interface, used to configure the
 * connected TCP sockets. This is used to that a sinlge system 
 * wide configuration can be applied without changing any code.
 * So, essentially it provides a pluggable configuration system. 
 * <p>
 * In order to define a system wide implementation a property is
 * needed to define the object. This uses the <code>System</code>
 * properties to define the class name for the default instance.
 * The property <code>simple.http.connect.configurator</code> is
 * used to specify the implementation the server should use.
 * <pre>
 * java -Dsimple.http.connect.configurator=demo.DemoConfigurator
 * </pre>
 * This will set the <code>System</code> property to the class 
 * name <code>demo.DemoConfigurator</code>. When the factory
 * method <code>getInstance</code> is invoked it will return an
 * implementation of this object or if the implementation cannot
 * be loaded by the class loader a default implementation called
 * <code>DefaultConfigurator</code> is returned instead.
 *
 * @author Niall Gallagher
 */
public final class ConfiguratorFactory {

   /**
    * This produces the system wide <code>Configurator</code> to
    * provide a uniform configuration for the server. This uses a
    * system property <code>simple.http.connect.configurator</code> 
    * to define the class name of the implementation that will be 
    * used for the system wide <code>Configurator</code>. This must
    * contain the fully qualified class name of the implementation
    * and should be loadable by this classes class loader. If the 
    * specified class cannot be loaded a default implementation is
    * used called <code>DefaultConfigurator</code>.
    *
    * @return an implementation of the <code>Configurator</code> 
    */
   public static Configurator getInstance() {
      String property = "simple.http.connect.configurator";
      String className = System.getProperty(property);
      
      if(className == null){ 
         return new DefaultConfigurator();
      }
      try {    
         Class type = Class.forName(className,
            false, ConfiguratorFactory.class.getClassLoader());         
         return (Configurator)type.newInstance();         
      }catch(Exception e){
         return new DefaultConfigurator();
      }
   }
}

