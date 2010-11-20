<%-- 
    Document   : viewgroup
    Created on : Oct 11, 2008, 12:12:34 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="viewGroups">
    <rich:panel header="View Group Details">
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="Select the Group ID"/>
                <rich:comboBox value="#{ViewGroupBean.groupid}" valueChangeListener="#{ViewGroupBean.ChangeFired}" immediate="true">
                <a4j:support ajaxSingle="true" immediate="true" event="onchange"/>
                <f:selectItems value="#{GroupBean.grouplist}" />
                </rich:comboBox>
                <a4j:commandButton value="Get Details" reRender="pm" action="#{ViewGroupBean.GetDetails}"/>
                <a/>
                <h:outputText value="Group Name"/>
                <h:outputText value="#{ViewGroupBean.groupname}"/>
                
                <h:outputText value="Group College"/>
                <h:outputText value="#{ViewGroupBean.collegename}"/>
                
            </h:panelGrid>
            
            <rich:dataTable value="#{ViewGroupBean.partlist}" var="row" >
                <rich:column><f:facet name="header"><h:outputText value="Participant ID" /></f:facet><h:outputText value="#{row.partid}"/></rich:column>
                <rich:column><f:facet name="header"><h:outputText value="Participant Name" /></f:facet><h:outputText value="#{row.partname}"/></rich:column>
                <rich:column><f:facet name="header"><h:outputText value="Participant Regno" /></f:facet><h:outputText value="#{row.partregno}"/></rich:column>
                <rich:column><f:facet name="header"><h:outputText value="Participant College" /></f:facet><h:outputText value="#{row.collegeid.collegename}"/></rich:column>
            </rich:dataTable>
        </h:form>
    </rich:panel>
</f:subview>