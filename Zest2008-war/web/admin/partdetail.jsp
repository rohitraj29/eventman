<%-- 
    Document   : partdetail
    Created on : Oct 5, 2008, 12:55:52 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<h:form id="detailform">
    <a4j:region>
    <rich:panel header="Participant Details">
       <h:panelGrid columns="3">
       <h:outputText value="Select the Participant ID"/>
       <rich:comboBox  defaultLabel="Select Participant ID" width="160" enableManualInput="false" value="#{PartDetailBean.partid}" valueChangeListener="#{PartDetailBean.ChangeFired}" immediate="true">
           <a4j:support ajaxSingle="true" event="onchange" immediate="true" reRender="pm"/>
           <f:selectItems value="#{ParticipantBean.partlist}" />
           </rich:comboBox>
           <a4j:commandButton action="#{PartDetailBean.updateDetails}" reRender="pm" value="Update Details"/>
       </h:panelGrid>
           <rich:spacer height="50" width="160"/>
           <h:panelGrid columns="2" width="100%" border="1" >
       <h:outputText value="Participant Name"/>
            <h:outputText value="#{PartDetailBean.partname}"/>
            <h:outputText value="Participant registration Number"/>
            <h:outputText value="#{PartDetailBean.regno}"/>
            <h:outputText value="Participant ID"/>
            <h:outputText value="#{PartDetailBean.partid}"/>
            <h:outputText value="Participant College" />
            <h:outputText value="#{PartDetailBean.collegename}" />
       </h:panelGrid>
       <rich:dataTable width="100%" value="#{PartDetailBean.particlist}" var="row">
           <rich:column><f:facet name="header"><h:outputText value="Event id"/></f:facet><h:outputText value="#{row.eventid.eventid}"/></rich:column>
           <rich:column><f:facet name="header"><h:outputText value="Event Name"/></f:facet><h:outputText value="#{row.eventid.eventname}"/></rich:column>
           <rich:column><f:facet name="header"><h:outputText value="Event Type"/></f:facet><h:outputText value="#{row.eventid.eventtype}"/></rich:column>
       </rich:dataTable>
       
    </rich:panel>
</a4j:region>
</h:form>

