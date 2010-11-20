<%-- 
    Document   : participantdetails
    Created on : Oct 5, 2008, 2:41:20 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="participantdetails">
    <h:form id="detailform">
    <a4j:region>
    <rich:panel header="Participant Details">
       <h:panelGrid columns="3">
       <h:outputText value="Select the Participant ID"/>
       <rich:comboBox  defaultLabel="Select Participant ID" width="160" enableManualInput="false" value="#{PartDetailBean1.partid}" valueChangeListener="#{PartDetailBean.ChangeFired}" immediate="true">
           <a4j:support ajaxSingle="true" event="onchange" immediate="true" reRender="content"/>
           <f:selectItems value="#{ParticipantBean.partlist}" />
           </rich:comboBox>
           <a4j:commandButton action="#{PartDetailBean1.updateDetails}" value="Update Details"/>
       </h:panelGrid>
           <rich:spacer height="50" width="160"/>
           <h:panelGrid columns="2" width="100%" border="1" >
       <h:outputText value="Participant Name"/>
            <h:outputText value="#{PartDetailBean1.partname}"/>
            <h:outputText value="Participant registration Number"/>
            <h:outputText value="#{PartDetailBean1.regno}"/>
            <h:outputText value="Participant ID"/>
            <h:outputText value="#{PartDetailBean1.partid}"/>
            <h:outputText value="Participant College" />
            <h:outputText value="#{PartDetailBean1.collegename}" />
       </h:panelGrid>
    </rich:panel>
</a4j:region>
</h:form>
</f:subview>