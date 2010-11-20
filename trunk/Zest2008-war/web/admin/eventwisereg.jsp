<%-- 
    Document   : viewevents
    Created on : Oct 8, 2008, 10:35:01 AM
    Author     : root
--%>


<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<f:subview id="eventdetails">
<h:form>
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
</h:form>
</f:subview>

