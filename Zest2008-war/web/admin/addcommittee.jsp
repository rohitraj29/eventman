<%-- 
    Document   : addcommittee
    Created on : Jan 7, 2007, 8:00:42 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="addcomview">
    <h:form>
        <rich:panel header="Add Committee">
            <h:panelGrid columns="2">
            <h:outputLabel value="Committee name"/>
            <h:inputText value="#{AddComBean.comname}" size="50">
                <a4j:support ajaxSingle="true" event="onblur" immediate="true"/>
            </h:inputText>
            
            <a4j:commandButton value="Add Committee" reRender="ol" action="#{AddComBean.register}"/>
            <h:outputLabel id="ol"/>
        </h:panelGrid>
        </rich:panel>
        
    </h:form>           
    </f:subview>
       