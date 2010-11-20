<%-- 
    Document   : confeventpart
    Created on : Oct 6, 2008, 12:49:38 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<h:form id="confeventpart">
    <a4j:region>
        <rich:panel header="Participation Confirmed">
            <h:panelGrid columns="2">
                <h:outputText value="Participant name"/>
                <h:outputText value="#{EventPartBean.part.partname}"/>
                <h:outputText value="Participant ID"/>
                <h:outputText value="#{EventPartBean.part.partid}"/>
                <h:outputText value="Participant Registration number"/>
                <h:outputText value="#{EventPartBean.part.partregno}"/>
                <h:outputText value="Participant College "/>
                <h:outputText value="#{EventPartBean.part.collegeid.collegeid}"/>
                <h:outputText value="Event Name"/>
                <h:outputText value="#{EventPartBean.eventname}"/>
            </h:panelGrid>
        </rich:panel>
    </a4j:region>
</h:form>
