<%-- 
    Document   : schedule
    Created on : Oct 16, 2008, 10:02:57 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<rich:panel header="Zest Schedule">
    <h:form>
        <rich:dataTable value="#{ScheduleBean.eventlist}" var="row">
            <rich:column><f:facet name="header"><h:outputText value="Event Name"/></f:facet><h:outputText value="#{row.eventname}"/></rich:column>
            <rich:column><f:facet name="header"><h:outputText value="Event Date"/></f:facet><h:outputText value="#{row.eventdate}"/></rich:column>
            <rich:column><f:facet name="header"><h:outputText value="Event Time"/></f:facet><h:outputText value="#{row.eventtime}"/></rich:column>
            <rich:column><f:facet name="header"><h:outputText value="Event Venue"/></f:facet><h:outputText value="#{row.eventvenue}"/></rich:column>
            
        </rich:dataTable>
    </h:form>
</rich:panel>