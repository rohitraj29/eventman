<%-- 
    Document   : addindivisualevent
    Created on : Oct 7, 2008, 10:38:23 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="addindividualresult">
    <rich:panel header="Individual Event">
        <h:form>
        <h:panelGrid columns="3">
        <h:outputLabel value="Event name"/>
        <rich:comboBox id="eventbox" value="#{IndResAddBean.eventname}" defaultLabel="Choose event" enableManualInput="false" valueChangeListener="#{IndResAddBean.ChangeFired}" immediate="true">
            <a4j:support ajaxSingle="true" immediate="true" event="onchange"/>
            <f:selectItems value="#{EventBean.eventlist}"/>
        </rich:comboBox>
        <a4j:commandButton value="Get Participants" action="#{IndResAddBean.GetPart}" reRender="pm" immediate="true"/>
    
        <h:outputLabel  value="Participant Id"/>
        <rich:comboBox id="particicipantbox" value="#{IndResAddBean.partid}" defaultLabel="Choose Participant" enableManualInput="false" valueChangeListener="#{IndResAddBean.PartChanged}" immediate="true">
            <f:selectItems  value="#{IndResAddBean.partlist}"/>
            <a4j:support ajaxSingle="true" event="onchange" immediate="true"/>
        </rich:comboBox>
        
<br/>
        <h:outputLabel value="Choose Result"/>
       
        <rich:comboBox  value="#{IndResAddBean.position}" defaultLabel="Choose Result" enableManualInput="false" valueChangeListener="#{IndResAddBean.PosChanged}" immediate="true">
            <a4j:support event="onchange" ajaxSingle="true"  immediate="true"/>
            <f:selectItem itemLabel="1" itemValue="1" />
            <f:selectItem itemLabel="2" itemValue="2" />
            <f:selectItem itemLabel="3" itemValue="3" />
        </rich:comboBox>
    
        <a4j:commandButton value="Submit Result" action="#{IndResAddBean.register}" reRender="pm" immediate="true"/>
    
    </h:panelGrid>
</h:form>
    </rich:panel>
    
</f:subview>