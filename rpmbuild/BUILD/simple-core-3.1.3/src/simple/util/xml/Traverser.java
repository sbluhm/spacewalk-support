/*
 * Traverser.java May 2005
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

import org.kxml2.kdom.Element;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.Serializable;
import java.io.Reader;
import java.io.File;

/**
 * The <code>Traverser</code> object is used to parse an XML document
 * in a simple element by element manner. This makes use of KDOM to
 * parse and represent the document as a tree. Once the tree has been
 * created each element is processed from the KDOM in order, that is,
 * first come first served. This provides a SAX like parsing model
 * using KDOM, this allows simple parsing with optional KDOM usage.
 *
 * @author Niall Gallagher
 */ 
public abstract class Traverser {

   /**
    * This is the document builder used by this XML parser object.
    */ 
   private XMLParser parser;

   /**
    * Constructor for the <code>Traverser</code> object this is used
    * to create a new instance with a new document builder object.
    * This will simply query a document builder factory for a default
    * implementation, which it will use to parse all KDOM documents.
    */ 
   protected Traverser() {
      super();
   }
   
   /**
    * This is used to parse the provided source document. This will
    * parse the provided document source using KDOM and then traverse
    * each element encountered within the KDOM object such that it
    * can be processed in a sequential manner. If the source is not
    * a valid XML document a parsing exception it thrown.
    *
    * @param source this is the XML document source to be parsed
    */ 
   public void parse(String source) throws Exception {
      parse(new StringReader(source));           
   }

   /**
    * This is used to parse the provided source document. This will
    * parse the provided document source using KDOM and then traverse
    * each element encountered within the KDOM object such that it
    * can be processed in a sequential manner. If the source is not
    * a valid XML document a parsing exception it thrown.
    *
    * @param source this is the XML document source file to parse
    */    
   public void parse(File source) throws Exception {
      parse(source, "utf-8");         
   }

   /**
    * This is used to parse the provided source document. This will
    * parse the provided document source using KDOM and then traverse
    * each element encountered within the KDOM object such that it
    * can be processed in a sequential manner. If the source is not
    * a valid XML document a parsing exception it thrown.
    *
    * @param source this is the XML document source file to parse
    * @param charset this is the character set to read the XML with
    */     
   public void parse(File source, String charset) throws Exception {
      parse(new FileInputStream(source), charset);           
   }
   
   /**
    * This is used to parse the provided source document. This will
    * parse the provided document source using KDOM and then traverse
    * each element encountered within the KDOM object such that it
    * can be processed in a sequential manner. If the source is not
    * a valid XML document a parsing exception it thrown.
    *
    * @param source this is the XML document source to be parsed
    */ 
   public void parse(InputStream source) throws Exception {
      parse(source, "utf-8");
   }

   /**
    * This is used to parse the provided source document. This will
    * parse the provided document source using KDOM and then traverse
    * each element encountered within the KDOM object such that it
    * can be processed in a sequential manner. If the source is not
    * a valid XML document a parsing exception it thrown.
    *
    * @param source this is the XML document source to be parsed
    * @param charset this is the charset to read the stream with
    */ 
   public void parse(InputStream source, String charset) throws Exception {
      parse(new InputStreamReader(source, charset));           
   }
   
   /**
    * This is used to parse the provided source document. This will
    * parse the provided document source using KDOM and then traverse
    * each element encountered within the KDOM object such that it
    * can be processed in a sequential manner. If the source is not
    * a valid XML document a parsing exception it thrown.
    *
    * @param source this is the XML document source to be parsed
    */    
   public void parse(Reader source) throws Exception {
      if(parser == null) {           
         parser = new XMLParser(source);
      }         
      parser.process(this);
   }

   /**
    * This is used to parse the provided KDOM element. In order to
    * parse a KDOM element sucessfully the parser needs to initialize
    * itself, before processing the XML elements. This will ensure
    * that the <code>start</code> method is invoked before the KDOM
    * object is traversed. Once the traversal has finished the parser
    * can commit all data using the <code>finish</code> method.
    * 
    * @param source this is the XML document that is to be parsed
    */    
   public void parse(Element source) throws Exception {
      start();           
      traverse(source);
      finish();
   } 

   /**
    * This method is provided as a convinience for parsing the node
    * provided. This will simply call <code>parse(Element)</code> 
    * with the element taken from the given node. This will be used
    * if an XML parser wishes to delegate to another, which can be
    * done by simply invoking this method with a visited node
    * 
    * @param source this is the XML element thay is to be parsed
    */ 
   public void parse(Node source) throws Exception {
      parse(source.getElement());           
   }

   /**
    * This method is used to traverse all KDOM nodes acquired. This 
    * allows the document to be processed element by element. Each
    * node is extracted and processed from the provided object in 
    * order of appearence. So data is build up sequentially and the
    * parsing procedure can construct its view of the XML document.
    *
    * @param node this is the KDOM element to be traversed
    */    
   protected void traverse(Element node) throws Exception {
      int count = node.getChildCount();
   
      process(new Block(node));              
      traverse(node, count);
      commit(new Block(node));
   }

   /**
    * This method is used to traverse all KDOM nodes acquired. This 
    * allows the document to be processed element by element. Each
    * node is extracted and processed from the provided object in 
    * order of appearence. So data is build up sequentially and the
    * parsing procedure can construct its view of the XML document.
    *
    * @param node this is the KDOM node list to be traversed
    * @param count this is the number of elements to traverse
    */   
   protected void traverse(Element node, int count) throws Exception {
      for(int i = 1; i < count; i++){
         Element next = node.getElement(i);

         if(next != null) {
            traverse(next);                 
         }         
      }  
   }

   /**
    * Once an element and all its child elements have been processed
    * this method is invoked to close the processing of the element.
    * This is useful when data accumulated needs to be committed.
    * It allows properties and attributes collected during the
    * processing of the element used for larger data structures.
    *
    * @param node this is the node that has just finished traversal
    */ 
   protected void commit(Node node) throws Exception {}   

   /**
    * When all elements of the KDOM have been traversed this method
    * is used to perform post processing of the collected data.
    * This is used to commit any lingering data structures and to
    * perform operations other than those involved in parsing.
    */ 
   protected void finish() throws Exception {}
   
   /**
    * This is used to initialize the XML parser. This is invoked
    * before any of the elements are processed. It allows all data
    * structures to be created for processing and collecting the
    * attributes and values of processed elements. This is abstract
    * and must be implemented by an XML parser object.
    */ 
   protected abstract void start() throws Exception;

   /**
    * This is used to process an element from the KDOM document. The
    * element provided to this method can be used to collect data
    * which can later be used to construct data structures based
    * on the XML document. Typically an implementation of this will
    * examine the node name and process the element based on that.
    * 
    * @param node this is the node that is to be processed by this
    */ 
   protected abstract void process(Node node) throws Exception;
           
}
