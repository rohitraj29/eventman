<%-- 
    Document   : eventwiseresult
    Created on : Oct 5, 2008, 3:12:19 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="eventwiseresult">
    
    <rich:tabPanel>
        <rich:tab switchType="ajax" label="Individual Events">
            <rich:panel header="Event Wise Results for Individual Events">
                <h:form>
                    <h:panelGrid columns="3">
                        <h:outputText value="Select the Event"/>
                        <rich:comboBox value="#{IndEventResBean.eventname}" immediate="true" valueChangeListener="#{IndEventResBean.ChangeFired}">
                            <a4j:support ajaxSingle="true" event="onchange" immediate="true" reRender="pm"/>
                            <f:selectItems value="#{EventBean.eventlist}" />
                        </rich:comboBox>
                        <a4j:commandButton value="Get Results" reRender="pm" action="#{IndEventResBean.RetrieveData}"/>
                    
                    </h:panelGrid>
                    <rich:dataTable value="#{IndEventResBean.reslist}" var="row" id="data1">
                        <rich:column><f:facet name="header"><h:outputText value="Result ID"/></f:facet><h:outputText value="#{row.id}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant ID"/></f:facet><h:outputText value="#{row.participant.partid}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant Name"/></f:facet><h:outputText value="#{row.participant.partname}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="participant Reg No."/></f:facet><h:outputText value="#{row.participant.partregno}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant College"/></f:facet><h:outputText value="#{row.participant.collegeid.collegename}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Event Name"/></f:facet><h:outputText value="#{row.eventdetails.eventname}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Position"/></f:facet><h:outputText value="#{row.position}"/></rich:column>
                    </rich:dataTable>
                </h:form>
            </rich:panel>
            
        </rich:tab>
        
        <%-- Group Events Result Tab--%>
        <rich:tab switchType="ajax" label="Group Events">
            <rich:panel header="Event Wise Results from Group Events">
                <h:form>
                    <h:panelGrid columns="3">
                        <h:outputText value="Please Select the Event"/>
                        <rich:comboBox value="#{GrpEventResBean.eventname}" immediate="true" valueChangeListener="#{GrpEventResBean.ChangeFired}">
                            <a4j:support ajaxSingle="true" immediate="true" event="onchange" />
                            <f:selectItems value="#{EventBean.eventgrouplist}"/>
                        </rich:comboBox>
                        <a4j:commandButton action="#{GrpEventResBean.RetrieveData}" reRender="pm" value="Get Results"/>
                    </h:panelGrid>
                    <rich:dataTable id="data4" value="#{GrpEventResBean.reslist}" var="row1">
                       <rich:column><f:facet name="header"><h:outputText value="Result ID"/></f:facet><h:outputText value="#{row1.id}"/></rich:column>
                       <rich:column><f:facet name="header"><h:outputText value="Group ID"/></f:facet><h:outputText value="#{row1.groupid.groupid}"/></rich:column>
                       <rich:column><f:facet name="header"><h:outputText value="Group Name"/></f:facet><h:outputText value="#{row1.groupid.groupname}"/></rich:column>
                       <rich:column><f:facet name="header"><h:outputText value="Event Name"/></f:facet><h:outputText value="#{row1.eventid.eventname}"/></rich:column>
                       <rich:column><f:facet name="header"><h:outputText value="Position"/></f:facet><h:outputText value="#{row1.position}"/></rich:column>
                    </rich:dataTable>
                </h:form>
            </rich:panel>
        </rich:tab>
    </rich:tabPanel>
</f:subview>