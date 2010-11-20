<%-- 
    Document   : viewcollege
    Created on : Oct 4, 2008, 12:03:20 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>


<f:subview id="registeredcolleges">
    <h:form>
        <rich:panel header="Registered Colleges">
            <rich:dataTable align="center" id="table1" var="row" value="#{CollegeBean.collegelist}" width="750" rows="5" >
            
            <rich:column width="750" >
                <f:facet name="header"><h:outputText  value="Colleges Currently Registered"/></f:facet>
                <h:outputText value="#{row.label}"/>
                
            </rich:column>
            
        </rich:dataTable>
        <rich:datascroller for="table1" />
    </rich:panel>
    </h:form>
    </f:subview>
    