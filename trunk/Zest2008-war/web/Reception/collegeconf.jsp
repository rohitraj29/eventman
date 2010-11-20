<%-- 
    Document   : collegeconf
    Created on : Oct 7, 2008, 11:35:09 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="collegeconf">
    <h:form>
        <rich:panel header="College Successfully Registered">
            <h2>College has been successfully Registered</h2>
            <h3>
            <h:panelGrid columns="2" border="1">
                <h:outputText value="College ID"/>
                <h:outputText value="#{AddCollegeBean.college.collegeid}"/>
                <h:outputText value="CollegeName"/>
                <h:outputText value="#{AddCollegeBean.college.collegename}"/>
           </h:panelGrid>
        </h3>
        </rich:panel>
    </h:form>
</f:subview>