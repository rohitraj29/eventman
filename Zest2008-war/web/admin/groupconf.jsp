<%-- 
    Document   : groupconf
    Created on : Oct 7, 2008, 12:42:43 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="groupconf">
    <h:form>
        <rich:panel header="College Successfully Registered">
            <h2>Group has been successfully Registered</h2>
            <h3>
            <h:panelGrid columns="2" border="1">
               <h:outputText value="Group ID"/>
                <h:outputText value="#{AddGroupBean.group.groupid}"/>
                <h:outputText value="Group Name"/>
                <h:outputText value="#{AddGroupBean.group.groupname}"/>
                <h:outputText value="College Name"/>
                <h:outputText value="#{AddGroupBean.group.college.collegename}"/>
                    
                
           </h:panelGrid>
        </h3>
        </rich:panel>
    </h:form>
</f:subview>