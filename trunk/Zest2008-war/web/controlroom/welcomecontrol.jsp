<%-- 
    Document   : welcomecontrol
    Created on : Oct 5, 2008, 3:16:49 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="welcomecontrol">
    <rich:panel header="Control Room Home">
        <h2><h:outputLabel value="Welcome to Control Room Console."/></h2>
    </rich:panel>
        
</f:subview>