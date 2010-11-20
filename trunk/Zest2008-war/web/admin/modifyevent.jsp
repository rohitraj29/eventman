<%-- 
    Document   : modifyevent
    Created on : Oct 4, 2008, 12:20:58 PM
    Author     : root
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>


<f:subview id="modifyevent">
    <a4j:region>
        <rich:panel header="Modify Event">
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputLabel value="Choose Event"/>
                    <rich:comboBox defaultLabel="Choose Events" listHeight="200" enableManualInput="false" value="#{EventModBean.eventname}" valueChangeListener="#{EventModBean.ChangeFired}" immediate="true">
                        <a4j:support ajaxSingle="true" event="onchange" immediate="true"/>
                        <f:selectItems value="#{EventBean.alleventlist}" />
                    </rich:comboBox>
                    <a4j:commandButton action="#{EventModBean.TriggerDetails}" value="Get Details" reRender="pm" immediate="true"/>
                </h:panelGrid>
            </h:form>
        </rich:panel>
    </a4j:region>
</f:subview>

<f:subview id="modeventdetails">
    <a4j:region>
        <rich:panel header="Selected Event Details">
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputLabel value="Event name"/>
                    <h:inputText size="30" value="#{EventModBean.eventname}" immediate="true">
                        <a4j:support ajaxSingle="true" event="onblur"  immediate="true"/>
                    </h:inputText>
                    <h:outputLabel value="Event Hours"/>
                    <rich:inputNumberSpinner value="#{EventModBean.hour}" enableManualInput="false" minValue="1" maxValue="24">
                        <a4j:support ajaxSingle="true" event="onblur"  immediate="true"/>
                    </rich:inputNumberSpinner>
                    <h:outputLabel value="Event Minutes"/>
                    <rich:inputNumberSpinner value="#{EventModBean.minute}" enableManualInput="false" minValue="0" maxValue="59">
                        <a4j:support ajaxSingle="true" event="onblur"  immediate="true"/>
                    </rich:inputNumberSpinner>
                    <h:outputLabel value="Event Date"/>
                    <rich:calendar enableManualInput="false"  value="#{EventModBean.eventdate}" >
                        <a4j:support ajaxSingle="true" event="onblur" onbeforedomupdate="true" immediate="true"/>
                    </rich:calendar>
                    <a4j:commandButton value="Modify" action="#{EventModBean.register}" reRender="pm"/>
                </h:panelGrid>
            </h:form>
        </rich:panel>
    </a4j:region>
    </f:subview> 
    