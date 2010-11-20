<%-- 
    Document   : RegSuccess
    Created on : Oct 3, 2008, 11:59:56 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<rich:panel header="Regisration">
    <a4j:region>
        <h2>Registration Successful</h2>
        <h3>
            <table  width="100%" frame="border" border="1">
            <tr>
                <td align="left">
                    <em> Participant Name</em>
                </td>
                <td align="left"><h:outputText value="#{PartRegBean.partname}"/>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <em> Participant Registration No</em>
                </td>
                <td align="left"><h:outputText value="#{PartRegBean.partregno}"/>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <em>Participant Serial ID</em>
                </td>
                <td align="left"><h:outputText value="#{PartRegBean.serialid}"/>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <em>Participant College</em>
                </td>
                <td align="left"><h:outputText value="#{PartRegBean.partcollege}"/>
                </td>
            </tr>
        </table>
    </h3>
               
        
    </a4j:region>
    </rich:panel>
    
    