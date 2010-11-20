<%-- 
    Document   : viewcommitteestatus
    Created on : Jan 7, 2007, 9:27:24 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="committeestatus">
      <rich:tabPanel>
            <rich:tab switchType="ajax" label="Member Details">
        <rich:panel header="Committee Members">
        <h:form>
            <h:panelGrid width="100%" columns="3"> 
                <h:outputLabel value="Committee name"/>
                <rich:comboBox defaultLabel="Choose Committee" enableManualInput="false" value="#{ComDetailsBean.comname}" valueChangeListener="#{ComDetailsBean.ChangeFired}" immediate="true">
                    <a4j:support  ajaxSingle="true" event="onchange" immediate="true"/>
                    <f:selectItems value="#{CommitteeBean.committeelist}"/>
                </rich:comboBox>
                <a4j:commandButton action="#{ComDetailsBean.details}" reRender="pm" value="get Details" immediate="true"/>
            </h:panelGrid>
        </h:form>
        <h:form>
            <rich:dataTable width="750" var="row" value="#{ComDetailsBean.col}">
                <rich:column>
                    <f:facet name="header"><h:outputText value="Member Name"/></f:facet>
                    <h:outputText value="#{row.membername}"/>
                </rich:column>
                <rich:column>
                    <f:facet name="header"><h:outputText value="Member Registration No."/></f:facet>
                    <h:outputText value="#{row.memberregno}"/>
                </rich:column>
                <rich:column>
                    <f:facet name="header"><h:outputText value="Member Designation"/></f:facet>
                    <h:outputText value="#{row.memberdes}"/>
                </rich:column>
            </rich:dataTable>
        </h:form>
    </rich:panel>
</rich:tab>
<rich:tab switchType="ajax" label="Events by the Committee">
    <rich:panel header="Committee Events">
        <h:form>
            <h:panelGrid width="100%" columns="3"> 
                <h:outputLabel value="Committee name"/>
                <rich:comboBox defaultLabel="Choose Committee" enableManualInput="false" value="#{ComDetailsBean.comname}" valueChangeListener="#{ComDetailsBean.ChangeFired}" immediate="true">
                    <a4j:support  ajaxSingle="true" event="onchange" immediate="true"/>
                    <f:selectItems value="#{CommitteeBean.committeelist}"/>
                </rich:comboBox>
                <a4j:commandButton action="#{ComDetailsBean.renderevents}" reRender="pm" value="get Details" immediate="true"/>
            </h:panelGrid>
        </h:form>
       <h:form>
            <rich:dataTable width="750" var="row" value="#{ComDetailsBean.eventlist}">
                <rich:column>
                    <f:facet name="header"><h:outputText value="Event Name"/></f:facet>
                    <h:outputText value="#{row.eventname}"/>
                </rich:column>
                <rich:column>
                    <f:facet name="header"><h:outputText value="Event Type "/></f:facet>
                    <h:outputText value="#{row.eventtype}"/>
                </rich:column>
                <rich:column>
                    <f:facet name="header"><h:outputText value="Event Date"/></f:facet>
                    <h:outputText value="#{row.eventtime}"/>
                </rich:column>
            </rich:dataTable>
        </h:form>
    </rich:panel>
</rich:tab>
</rich:tabPanel>
</f:subview>