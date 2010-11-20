<%-- 
    Document   : collegewisereg
    Created on : Oct 7, 2008, 10:08:25 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="collegewisereg">
    <rich:panel header="College Wise Registrations">
        <h:form>
        <h:panelGrid columns="3" width="100%">
        <h:outputLabel value="College name"/>
        <rich:comboBox defaultLabel="Choose college"  value="#{ViewColRegBean.colname}" enableManualInput="false" valueChangeListener="#{viewColRegBean.ChangeFired}" immediate="true">
            <a4j:support ajaxSingle="true" event="onchange" immediate="true"/>
            <f:selectItems value="#{CollegeBean.collegelist}"/>
        </rich:comboBox>
        <a4j:commandButton value="Get Details" action="#{ViewColRegBean.RetrieveData}" immediate="true" reRender="pm"/>
        </h:panelGrid>
        </h:form>
        <rich:dataTable value="#{ViewColRegBean.partlist}" var="row">
            <rich:column><f:facet name="header"><h:outputText value="Participant ID"/></f:facet><h:outputText value="#{row.partid}"/></rich:column>
            <rich:column><f:facet name="header"><h:outputText value="Participant Name"/></f:facet><h:outputText value="#{row.partname}"/></rich:column>
            <rich:column><f:facet name="header"><h:outputText value="Participant Reg No"/></f:facet><h:outputText value="#{row.partregno}"/></rich:column>
            <rich:column><f:facet name="header"><h:outputText value="Participant Name"/></f:facet><h:outputText value="#{row.collegeid.collegename}"/></rich:column>
            
        </rich:dataTable>
    
    </rich:panel>
    
    <rich:dataTable columns="4" bgcolor="green" rows="4" />
    
</f:subview>