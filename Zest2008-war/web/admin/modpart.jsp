<%-- 
    Document   : modpart
    Created on : Oct 4, 2008, 12:23:13 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="modview">
    <rich:panel id="update" header="Modify Participants">
       
        <h:form>
        
            <table> 
                <tr>
                    <td>
                        
                        <h:outputText value="Select Participant Serial ID"/>
                    </td>
                    <td>
                        <rich:comboBox value="#{ModPartBean.serialid}" enableManualInput="false"  defaultLabel="Select Serial ID" valueChangeListener="#{ModPartBean.changeFired}" width="120" immediate="true">
                            <a4j:support ajaxSingle="true" event="onchange" immediate="true"  reRender="content,name,regno"/>
                            <f:selectItems value="#{ParticipantBean.partlist}"/>
                    </rich:comboBox></td><td><a4j:commandButton action="#{ModPartBean.populate}" reRender="content"  value="find"/>
                        
                    </td>
                </tr>
                <tr>
                <td>Participant Name</td>
                <td><h:inputText id="name" value="#{ModPartBean.name}">
                        <a4j:support ajaxSingle="true" immediate="true"/>
                </h:inputText></td>
                </tr>
                <tr>
                <td>Participant Reg No.</td>
                <td><h:inputText id="regno" value="#{ModPartBean.regno}">
                    <a4j:support ajaxSingle="true" immediate="true"/>
                </h:inputText></td>
                </tr>
                <tr><td><a4j:commandButton action="#{ModPartBean.persistChanges}" value="Update Values" /></td></tr>
                
            </table>
            
        </h:form>
    </rich:panel>
</f:subview>