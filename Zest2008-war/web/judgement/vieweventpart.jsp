<%-- 
    Document   : vieweventpart
    Created on : Oct 16, 2008, 4:47:28 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="vieweventpart">
    <a4j:region>
        <rich:panel header="Event partcicipation Individual and Group">
            <rich:dataTable width="100%" value="#{ViewColRegBean.eventlist}" var="row" id="data1">
                <rich:column><f:facet name="header"><h:outputText value="Participant Name"/></f:facet><h:outputText value="#{row.partid.partname}"/></rich:column>
                <rich:column><f:facet name="header"><h:outputText value="Participant Regno"/></f:facet><h:outputText value="#{row.partid.partregno}"/></rich:column>
                <rich:column><f:facet name="header"><h:outputText value="Event Name"/></f:facet><h:outputText value="#{row.eventid.eventname}"/></rich:column>
                <rich:column><f:facet name="header"><h:outputText value="Event Type"/></f:facet><h:outputText value="#{row.eventid.eventtype}"/></rich:column>
                <rich:column><f:facet name="header"><h:outputText value="Group Name"/></f:facet><h:outputText value="#{row.groupid.groupname}"/></rich:column>
                
                </rich:dataTable>
            
        </rich:panel>
        
    </a4j:region>
</f:subview>