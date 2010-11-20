<%-- 
    Document   : confcom
    Created on : Oct 7, 2008, 7:37:54 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="confcom">
    <a4j:region>
        <h:form>
        <rich:panel header="Committee Successfully Registered">
            <h:panelGrid columns="2" border="1" width="100%">
                <h:outputText value="Committee Name"/>
                <h:outputText value="#{AddComBean.comm.commname}"/>
                <h:outputText value="Committee ID"/>
                <h:outputText value="#{AddComBean.comm.commid}"/>
            </h:panelGrid>
        </rich:panel>
        </h:form>
        
    </a4j:region>
</f:subview>