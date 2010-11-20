<%-- 
    Document   : collegewisereg
    Created on : Oct 7, 2008, 10:08:25 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="collegewisereg">
    <rich:panel header="College Wise Registrations">
        <h:outputLabel value="College name"/>
        <rich:comboBox defaultLabel="Choose college" enableManualInput="false">
        </rich:comboBox>
    </rich:panel>
    <rich:dataTable columns="4" bgcolor="green" rows="4" />
    
</f:subview>