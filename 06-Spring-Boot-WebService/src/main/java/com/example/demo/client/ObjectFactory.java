
package com.example.demo.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.demo.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ShowTwo_QNAME = new QName("http://service.demo.example.com", "showTwo");
    private final static QName _ShowResponse_QNAME = new QName("http://service.demo.example.com", "showResponse");
    private final static QName _ShowTwoResponse_QNAME = new QName("http://service.demo.example.com", "showTwoResponse");
    private final static QName _Show_QNAME = new QName("http://service.demo.example.com", "show");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.demo.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ShowResponse }
     * 
     */
    public ShowResponse createShowResponse() {
        return new ShowResponse();
    }

    /**
     * Create an instance of {@link ShowTwo }
     * 
     */
    public ShowTwo createShowTwo() {
        return new ShowTwo();
    }

    /**
     * Create an instance of {@link Show }
     * 
     */
    public Show createShow() {
        return new Show();
    }

    /**
     * Create an instance of {@link ShowTwoResponse }
     * 
     */
    public ShowTwoResponse createShowTwoResponse() {
        return new ShowTwoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowTwo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.demo.example.com", name = "showTwo")
    public JAXBElement<ShowTwo> createShowTwo(ShowTwo value) {
        return new JAXBElement<ShowTwo>(_ShowTwo_QNAME, ShowTwo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.demo.example.com", name = "showResponse")
    public JAXBElement<ShowResponse> createShowResponse(ShowResponse value) {
        return new JAXBElement<ShowResponse>(_ShowResponse_QNAME, ShowResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowTwoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.demo.example.com", name = "showTwoResponse")
    public JAXBElement<ShowTwoResponse> createShowTwoResponse(ShowTwoResponse value) {
        return new JAXBElement<ShowTwoResponse>(_ShowTwoResponse_QNAME, ShowTwoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Show }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.demo.example.com", name = "show")
    public JAXBElement<Show> createShow(Show value) {
        return new JAXBElement<Show>(_Show_QNAME, Show.class, null, value);
    }

}
