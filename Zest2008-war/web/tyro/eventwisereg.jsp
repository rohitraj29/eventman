<%-- 
    Document   : eventdetails
    Created on : Oct 5, 2008, 2:24:02 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="eventdetails">
    <a4j:region>
      
            <rich:tabPanel>
            <rich:tab switchType="ajax" label="Individual Events">
                <rich:panel header="Event Wise Registrations">
                    <h:form>
                        <h:panelGrid columns="2">
                            <h:outputText value="Choose Event"/>
                            <rich:comboBox value="#{EventWiseReg.eventname}" valueChangeListener="#{EventWiseReg.ChangeFired}" defaultLabel="Choose Events" enableManualInput="false" immediate="true">
                                <a4j:support ajaxSingle="true"event="onchange" reRender="pm" immediate="true"/>
                                <f:selectItems value="#{EventBean.eventlist}" />
                            </rich:comboBox>
                            <a4j:commandButton value="Get Details" action="#{EventWiseReg.Trigger}" immediate="true"/>
                            <a></a>
                            <h:outputText value="Event Type"/>
                            <h:outputText value="#{EventWiseReg.event.eventtype}" />
                            <h:outputText value="Event Time"/>
                            <h:outputText value="#{EventWiseReg.event.eventtime}"/>
                            <h:outputText value="Event Venue"/>
                            <h:outputText value="#{EventWiseReg.event.eventvenue}"/>
                            
                        </h:panelGrid>
                    </h:form>
                    <rich:dataTable id="data2" value="#{EventWiseReg.partlist}" var="row">
                        <rich:column><f:facet name="header"><h:outputText value="Participant ID"/></f:facet><h:outputText value="#{row.partid}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant Name"/></f:facet><h:outputText value="#{row.partname}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant Registration no."/></f:facet><h:outputText value="#{row.partregno}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant College"/></f:facet><h:outputText value="#{row.collegeid.collegeid}"/></rich:column>
                    </rich:dataTable>
                </rich:panel>
            </rich:tab>
            
            
            <rich:tab switchType="ajax" label="GroupEvents">
                <rich:panel header="Event Wise Registrations">
                    <h:form>
                        <h:panelGrid columns="2">
                            <h:outputText value="Choose Event"/>
                            <rich:comboBox value="#{EvenWiseRegGroup.eventname}" valueChangeListener="#{EvenWiseRegGroup.ChangeFired}" defaultLabel="Choose Events" enableManualInput="false" immediate="true">
                                <a4j:support ajaxSingle="true"event="onchange" reRender="pm" immediate="true"/>
                                <f:selectItems value="#{EventBean.eventgrouplist}" />
                            </rich:comboBox>
                            <a4j:commandButton value="Get Details" action="#{EvenWiseRegGroup.Trigger}" immediate="true"/>
                            <a/>
                            <h:outputText value="Event Type"/>
                            <h:outputText value="#{EvenWiseRegGroup.event.eventtype}" />
                            <h:outputText value="Event Time"/>
                            <h:outputText value="#{EvenWiseRegGroup.event.eventtime}"/>
                            <h:outputText value="Event Venue"/>
                            <h:outputText value="#{EventWiseReg.event.eventvenue}"/>
                        </h:panelGrid>
                    </h:form>
                    <rich:dataTable id="data3" value="#{EvenWiseRegGroup.grouplist}" var="row">
                        <rich:column><f:facet name="header"><h:outputText value="Group ID"/></f:facet><h:outputText value="#{row.groupid}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Group Name"/></f:facet><h:outputText value="#{row.groupname}"/></rich:column>
                        
                    </rich:dataTable>
                </rich:panel>
            </rich:tab>
        </rich:tabPanel>
        
    </a4j:region>
    
    
    </f:subview>
           