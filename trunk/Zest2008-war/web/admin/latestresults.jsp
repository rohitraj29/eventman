<%-- 
    Document   : latestresults
    Created on : Oct 11, 2008, 9:25:49 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="latestresults">
    <a4j:region>
        <rich:panel header="Latest results">
            <rich:simpleTogglePanel switchType="ajax" label="Individual Results">
            <h:form>
                <a4j:poll action="#{IndResBean.Update}" reRender="pm" interval="15000" immediate="true"/>
            <rich:dataTable value="#{IndResBean.reslist}" var="row" id="data5">
               <rich:column><f:facet name="header"><h:outputText value="Result ID"/></f:facet><h:outputText value="#{row.id}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant ID"/></f:facet><h:outputText value="#{row.participant.partid}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant Name"/></f:facet><h:outputText value="#{row.participant.partname}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="participant Reg No."/></f:facet><h:outputText value="#{row.participant.partregno}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Participant College"/></f:facet><h:outputText value="#{row.participant.collegeid.collegename}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Event Name"/></f:facet><h:outputText value="#{row.eventdetails.eventname}"/></rich:column>
                        <rich:column><f:facet name="header"><h:outputText value="Position"/></f:facet><h:outputText value="#{row.position}"/></rich:column>
            </rich:dataTable>
        </h:form>
        </rich:simpleTogglePanel>
        <rich:simpleTogglePanel switchType="ajax" label="Group Results">
            <h:form>
                <a4j:poll action="#{GrpResBean.Update}" reRender="pm" interval="15000" immediate="true"/>
                <rich:dataTable id="data4" value="#{GrpResBean.reslist}" var="row1">
                       <rich:column><f:facet name="header"><h:outputText value="Result ID"/></f:facet><h:outputText value="#{row1.id}"/></rich:column>
                       <rich:column><f:facet name="header"><h:outputText value="Group ID"/></f:facet><h:outputText value="#{row1.groupid.groupid}"/></rich:column>
                       <rich:column><f:facet name="header"><h:outputText value="Group Name"/></f:facet><h:outputText value="#{row1.groupid.groupname}"/></rich:column>
                       <rich:column><f:facet name="header"><h:outputText value="Event Name"/></f:facet><h:outputText value="#{row1.eventid.eventname}"/></rich:column>
                       <rich:column><f:facet name="header"><h:outputText value="Position"/></f:facet><h:outputText value="#{row1.position}"/></rich:column>
                    </rich:dataTable>
            </h:form>
        </rich:simpleTogglePanel>
    </rich:panel>
    </a4j:region>
</f:subview>