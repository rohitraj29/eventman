<%-- 
    Document   : addcollege
    Created on : Oct 7, 2008, 11:24:37 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="addcollege">
    
        <a4j:region>
        <rich:panel header="Register New College">
            <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Please Enter the full name of the college"/>
                <h:inputText value="#{AddCollegeBean.collegename}" size="20" immediate="true">
                    <a4j:support ajaxSingle="true"  event="onblur"/>
                </h:inputText>
                <a4j:commandButton action="#{AddCollegeBean.register}" value="Register College" immediate="true" reRender="content"/>
            </h:panelGrid>
        </h:form>
        </rich:panel>
    </a4j:region>

</f:subview>