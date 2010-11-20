<%-- 
    Document   : deleteevents
    Created on : Oct 4, 2008, 12:49:53 PM
    Author     : root
--%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<f:subview id="deleteevents">
<h:form>
    <a4j:region>
        
                <rich:panel header="Delete Individual Events">
                    
                    <h:panelGrid columns="3">
                        <h:outputText value="Select the Committee to View the Event"/>
                        <rich:comboBox value="#{DelEventBean.comname}" valueChangeListener="#{DelEventBean.ChangeFired}" immediate="true">
                        <a4j:support ajaxSingle="true" event="onchange" immediate="true"/>
                        <f:selectItems value="#{CommitteeBean.committeelist}"/>
                        </rich:comboBox>
                        <a4j:commandButton value="Get Details" action="#{DelEventBean.RetrieveDetails}" reRender="pm" immediate="true"/>
                    </h:panelGrid>
                    <rich:dataTable value="#{DelEventBean.eventlist}" var="row">
                        <rich:column><f:facet name="header"><h:outputText value="Event ID"/></f:facet><h:outputText value="#{row.eventid}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Event Name"/></f:facet><h:outputText value="#{row.eventname}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Event Type[0 for Ind 1 for Grp]"/></f:facet><h:outputText value="#{row.eventtype}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Delete"/></f:facet><a4j:commandButton data="#{row.eventid}" value="Delete" actionListener="#{DelEventBean.delete}" reRender="pm"/></rich:column>
                    </rich:dataTable>
                </rich:panel>
            
    </a4j:region>
</h:form>
</f:subview>