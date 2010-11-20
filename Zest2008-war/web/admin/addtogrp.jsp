<%-- 
    Document   : addtogrp
    Created on : Oct 11, 2008, 10:00:57 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="addtogrp">
    <rich:panel header="Add Members to Group">
        <h:form>
            <h:panelGrid columns="2">
            <h:outputText value="Please Select the Group"/>
            <rich:comboBox value="#{AddToGrpBean.groupid}" valueChangeListener="#{AddToGrpBean.ChangeFired}" immediate="true">
                <a4j:support ajaxSingle="true" event="onchange" immediate="true"/>
                <f:selectItems value="#{GroupBean.grouplist}"/>
            </rich:comboBox>
            <h:outputText value="Please Select the Participant ID"/>
            <rich:comboBox value="#{AddToGrpBean.partid}" valueChangeListener="#{AddToGrpBean.PartFired}" immediate="true">
                <a4j:support ajaxSingle="true" event="onchange" immediate="true"/>
                <f:selectItems value="#{ParticipantBean.partlist}"/>
            </rich:comboBox>
            <a4j:commandButton value="Add To group" action="#{AddToGrpBean.register}"reRender="pm" />
            </h:panelGrid>
            
        </h:form>
    </rich:panel>
</f:subview>