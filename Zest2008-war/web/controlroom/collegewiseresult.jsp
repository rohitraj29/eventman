<%-- 
    Document   : collegewiseresult
    Created on : Oct 7, 2008, 10:18:08 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="collegewiseresult">
    
    <rich:tabPanel>
        <rich:tab switchType="ajax" label="Individual Results">
            <rich:panel header="College Wise Result">
                <h:form>
                    <h:panelGrid columns="3">
                        <h:outputLabel value="Choose college"/>
                        <rich:comboBox defaultLabel="Choose College" value="#{CollegeResBean.collegename}" immediate="true" valueChangeListener="#{CollegeResBean.ChangeFired}">
                            <a4j:support action="#{CollegeResBean.RetrieveData}" ajaxSingle="true" reRender="pm" immediate="true" event="onchange" />
                            <f:selectItems value="#{CollegeBean.collegelist}"/>
                        </rich:comboBox>
                        <a4j:commandButton value="Get Results" action="#{CollegeResBean.RetrieveData}" reRender="pm"/>
                    </h:panelGrid>
                    </h:form>
                    <rich:dataTable value="#{CollegeResBean.reslist}" var="row" id="data1">
                        <rich:column><f:facet name="header"><h:outputText value="Result ID"/></f:facet><h:outputText value="#{row.id}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant ID"/></f:facet><h:outputText value="#{row.participant.partid}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant Name"/></f:facet><h:outputText value="#{row.participant.partname}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="participant Reg No."/></f:facet><h:outputText value="#{row.participant.partregno}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant College"/></f:facet><h:outputText value="#{row.participant.collegeid.collegename}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Event Name"/></f:facet><h:outputText value="#{row.eventdetails.eventname}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Position"/></f:facet><h:outputText value="#{row.position}"/></rich:column>
                    </rich:dataTable>
                
            </rich:panel>
        </rich:tab>
        <rich:tab switchType="ajax" label="GroupWise Results">
            <rich:panel header="College Wise Group Results">
                <h:form>
                    <h:panelGrid columns="3">
                        <rich:comboBox defaultLabel="Choose College" value="#{CollegeResGrpBean.collegename}" immediate="true" valueChangeListener="#{CollegeResGrpBean.ChangeFired}">
                            <a4j:support action="#{CollegeResGrpBean.RetrieveData}" ajaxSingle="true" reRender="pm" immediate="true" event="onchange" />
                            <f:selectItems value="#{CollegeBean.collegelist}"/>
                            <a4j:commandButton value="Get Results" action="#{CollegeResGrpBean.RetrieveData}" reRender="pm"/>
                        </rich:comboBox>
                    </h:panelGrid>
                    <rich:dataTable id="data4" value="#{CollegeResGrpBean.reslist}" var="row1">
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