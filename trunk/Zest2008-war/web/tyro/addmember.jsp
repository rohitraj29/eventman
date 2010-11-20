<%-- 
    Document   : addmembers
    Created on : Oct 4, 2008, 10:18:42 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="addcommitteemember">
    <a4j:region>
        
            <rich:panel header="Add Committee Members">
                <h:form>
                <h:panelGrid columns="2">
                <h:outputLabel value="Choose Committee"/>
                <rich:comboBox defaultLabel="Choose Committee" value="#{AddMemBean.commname}" valueChangeListener="#{AddMemBean.ChangeFired}" immediate="true">
                    <a4j:support event="onchange" ajaxSingle="true" immediate="true" />
                    <f:selectItems value="#{CommitteeBean.committeelist}" />
                 </rich:comboBox>
                <h:outputLabel value="Member name"/>
                <h:inputText value="#{AddMemBean.memname}" size="30"/>
                <a4j:support ajaxSingle="true" event="onblur" immediate="true"/>
                <h:outputLabel value="Member Registration Number"/>
                <h:inputText value="#{AddMemBean.memregno}" size="30"/>
                <a4j:support ajaxSingle="true" event="onblur" immediate="true"/>
                <h:outputLabel value="Member Designation"/>
                <rich:comboBox value="#{AddMemBean.memdes}" defaultLabel="Select designation" enableManualInput="false" valueChangeListener="#{AddMemBean.DesFired}" immediate="true">
                    <a4j:support ajaxSingle="true" event="onchange" immediate="true" />
                    <f:selectItem itemLabel="Coordinator" itemValue="Coordinator"/>
                    <f:selectItem itemLabel="Convenor" itemValue="Convenor"/>
                    <f:selectItem itemLabel="Co-Convenor" itemValue="Co-Convenor"/>
                    <f:selectItem itemLabel="Organiser" itemValue="Organiser"/>
                    <f:selectItem itemLabel="Volunteer" itemValue="Volunteer"/>
                </rich:comboBox>
                <a4j:commandButton value="Add Member" action="#{AddMemBean.register}" reRender="pm"/>                    
                
                </h:panelGrid>
                    </h:form>
            </rich:panel>         
        
        </a4j:region>
</f:subview>