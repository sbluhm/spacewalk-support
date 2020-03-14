/*
 * XMLParser.java May 2005
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

package simple.util.xml;

import org.kxml2.io.KXmlParser;
import org.kxml2.kdom.Document;
import org.kxml2.kdom.Element;
import java.io.Reader;

/**
 * The <code>XMLParser</code> represents an XML parser that performs
 * a pull method of parsing using KXML. This is used to load a source
 * XML document and parse it from a provided reader. Once the document
 * has neem parsed it can be traversed using a <code>Traverser</code>.
 * 
 * @author Niall Gallagher
 */ 
final class XMLParser extends KXmlParser {

   /**
    * This is the document that has been parsed from the reader.
    */         
   private Document root;        

   /**
    * Constructor for the <code>XMLParser</code> object. This will
    * simply create an empty document which can be populated with
    * an XML source document from a reader. Once populated its
    * elements can be traversed and its data can be collected.
    */ 
   public XMLParser() throws Exception {
      this.root = new Document();
   }

   /**
    * Constructor for the <code>XMLParser</code> object. This will
    * simply create an empty document which can be populated with
    * an XML source document from a reader. Once populated its
    * elements can be traversed and its data can be collected.
    *
    * @param source the reader that contains the XML document
    */ 
   public XMLParser(Reader source) throws Exception {
      this();
      parse(source);
   }
   

   /**
    * This method is used to parse an XML document from the provided
    * reader. The parsing process populates the internal document
    * object with the elements and attributes from the XML source.
    * 
    * @param source this is the source XML document to parse
    */ 
   public void parse(Reader source) throws Exception {
      setInput(source);           
      root.parse(this);
   }

   /**
    * This method is used to traverse the parsed XML document nodes
    * such that each node can be examined and used. This provides an
    * very simple technique for processing XML documents, as all of
    * the elements encountered within the document is dealt with.
    *
    * @param source this is the traverser used to process all nodes
    */ 
   public void process(Traverser source) throws Exception {
      Element node = root.getRootElement();                              

      if(node != null) {
         source.parse(node);              
      }
   }
}
