<%-- 
    Document   : committeewiseresult
    Created on : Oct 5, 2008, 2:54:05 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<f:subview id="committeewiseresult">
    
    <rich:panel header="Committee Wise Result">
        <h:outputLabel value="Choose Committee"/>
        <rich:comboBox defaultLabel="Choose Committee" />        
        <br>        
        <rich:dataTable></rich:dataTable>
        
    </rich:panel>
</f:subview>