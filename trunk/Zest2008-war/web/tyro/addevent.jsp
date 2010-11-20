<%-- 
    Document   : addevent
    Created on : Oct 4, 2008, 12:12:53 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="addevent">
 <a4j:region>
  <rich:panel header="Add Event">
        <h:form>
            <h:panelGrid columns="2">
                <h:outputLabel value="Event name"/>
                <h:inputText size="30"  value="#{AddEventBean.eventname}"/>
                <h:outputLabel value="Event Committee"/>
                <rich:comboBox value="#{AddEventBean.eventcom}" defaultLabel="Select Committee"  enableManualInput="false" valueChangeListener="#{AddEventBean.ChangeFired}" immediate="true">
                    <a4j:support event="onchange" ajaxSingle="true" immediate="true"/>
                    <f:selectItems value="#{CommitteeBean.committeelist}" />
                </rich:comboBox>
                <h:outputLabel value="Select the Event type"/>
                <rich:comboBox value="#{AddEventBean.evnttype}" defaultLabel="Select Type" valueChangeListener="#{AddEventBean.TypeChanged}" >
                    <a4j:support event="onchange" ajaxSingle="true" />
                    <f:selectItem itemValue="1" itemLabel="Individual Event"/>
                    <f:selectItem itemValue="2" itemLabel="Group Event"/>
                </rich:comboBox>
                <h:outputLabel value="Select the Date of Event"/>
                <rich:calendar value="#{AddEventBean.eventdate}" ajaxSingle="true" immediate="true">
                    <a4j:support event="onblur" ajaxSingle="true" />
                </rich:calendar>
                <h:outputText value="Select Hour"/>
                <rich:inputNumberSpinner value="#{AddEventBean.hour}" minValue="1" maxValue="24" enableManualInput="false" immediate="true">
                    <a4j:support ajaxSingle="true" event="onblur" immediate="true"/>
                </rich:inputNumberSpinner>
                <h:outputText value="Select Minutes"/>
                <rich:inputNumberSpinner value="#{AddEventBean.minute}" minValue="0" maxValue="59" enableManualInput="false" immediate="true">
                    <a4j:support ajaxSingle="true" event="onblur" immediate="true"/>
                </rich:inputNumberSpinner>
                <h:outputLabel value="Event Venue"/>
                <h:inputText size="30"  value="#{AddEventBean.eventvenue}" immediate="true"/>
                    
                <a4j:commandButton value="Add Event" reRender="pm" action="#{AddEventBean.register}"/> 
            </h:panelGrid>
        </h:form>
    </rich:panel>         
    </a4j:region>
    
</f:subview>