<%-- 
    Document   : addgroup
    Created on : Oct 7, 2008, 12:32:43 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="addgroup">
    
    <a4j:region>
        <rich:panel header="Register New Group">
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Please Enter the full name of Group"/>
                    <h:inputText value="#{AddGroupBean.groupname}" size="20" immediate="true">
                        <a4j:support ajaxSingle="true"  event="onblur"/>
                    </h:inputText>
                    <h:outputText value="Please Select the College"/>
                    <rich:comboBox value="#{AddGroupBean.collegename}" valueChangeListener="#{AddGroupBean.CollegeChanged}" immediate="true">
                        <a4j:support ajaxSingle="true" immediate="true" event="onchange" />
                        <f:selectItems value="#{CollegeBean.collegelist}"/>
                    </rich:comboBox>
                    <a4j:commandButton action="#{AddGroupBean.register}" value="Register Group" immediate="true" reRender="content"/>
                </h:panelGrid>
            </h:form>
        </rich:panel>
    </a4j:region>
    
</f:subview>