<%-- 
    Document   : Deletemembers
    Created on : Jan 7, 2007, 9:27:24 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>


<f:subview id="deletemembers">
    
    <rich:panel header="Committee Status">
        <h:form>
            <h:panelGrid width="100%" columns="3"> 
                <h:outputLabel value="Committee name"/>
                <rich:comboBox defaultLabel="Choose Committee" enableManualInput="false" value="#{ComDetailsBean1.comname}" valueChangeListener="#{ComDetailsBean1.ChangeFired}" immediate="true">
                    <a4j:support  ajaxSingle="true" event="onchange" immediate="true"/>
                    <f:selectItems value="#{CommitteeBean.committeelist}"/>
                </rich:comboBox>
                <a4j:commandButton action="#{ComDetailsBean1.details}" reRender="pm" value="get Details" immediate="true"/>
            </h:panelGrid>
        </h:form>
        
        <h:form>
            <rich:dataTable width="750" var="row" value="#{ComDetailsBean1.col}">
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
                <rich:column>
                    <f:facet name="header"><h:outputText value="Delete Members"/></f:facet>
                    <a4j:commandButton actionListener="#{ComDetailsBean1.delete}" data="#{row.memberregno}" reRender="pm" value="Delete" immediate="true"/>
                </rich:column>
            </rich:dataTable>
        </h:form>
    </rich:panel>
    
    
</f:subview>
