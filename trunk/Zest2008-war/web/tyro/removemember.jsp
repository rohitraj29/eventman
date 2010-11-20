<%-- 
    Document   : removemember
    Created on : Oct 4, 2008, 11:23:59 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>


<f:subview id="removecommitteemember">
<h:form>
            <rich:panel header="Remove Committee Members">
                <h:outputLabel value="Choose Committee"/>
                <rich:comboBox defaultLabel="Choose Committee">
                    
                </rich:comboBox><br>
                
                <rich:pickList>
                    <f:facet name="sourceCaption">
                        <h:outputText value="Members to be removed" />
                    </f:facet>
                    <f:facet name="targetCaption">
                        <h:outputText value="All Members list" />
                    </f:facet>
                    <rich:column>                        
                        <h:outputText value="hsassa" />
                    </rich:column>
                    
                    
                </rich:pickList>
                <a4j:commandButton value="Submit" action="remove" reRender="ol"/>
                <h:outputLabel id="ol"/>
            </rich:panel>
        </h:form>
        </f:subview>
    
