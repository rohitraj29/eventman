<%-- 
    Document   : committeewisereport
    Created on : Oct 4, 2008, 12:55:48 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>


<f:subview id="committeewisereport">
        
        <rich:panel header="Committee Wise Report">
            <h:outputLabel value="Choose Committee"/>
            <rich:comboBox defaultLabel="Choose Committee">
                
            </rich:comboBox><br>
                <h:outputLabel value="Choose Event"/>
            <rich:comboBox defaultLabel="Choose Event">
                
            </rich:comboBox><br>
            <rich:dataTable></rich:dataTable>
    
    </rich:panel>
    </f:subview>
    