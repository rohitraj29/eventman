<%-- 
    Document   : welcomefile
    Created on : Oct 9, 2008, 2:14:04 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="welcomefile">
    <a4j:region>
        <rich:panel header="EventMan Welcome Console">
            <h1 id="title">EVENTMAN</h1><br/>
            <rich:effect for="title" type="Appear" event="onload" params="duration:0.8,from:0.3,to:1.0"/>
                
        </rich:panel>
            
    </a4j:region>
</f:subview>

