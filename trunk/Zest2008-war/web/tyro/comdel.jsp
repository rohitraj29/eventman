<%-- 
    Document   : comdel
    Created on : Oct 16, 2008, 2:05:06 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="delcom">
    <a4j:region>
        <rich:panel header="Delete The Committees">
            <h:form>
                <rich:dataTable value="#{CommitteeBean.committeelist}" var="row" width="100%">
                    <rich:column>
                        <f:facet name="header">
                            <h:outputText value="Committee Name"/>
                        </f:facet>
                        <h:outputText value="#{row.label}"/>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header">
                            <h:outputText value="Click To Delete"/>
                        </f:facet>
                        <a4j:commandButton value="Delete"  reRender="pm" actionListener="#{ComDelBean.delcom}" data="#{row.label}" immediate="true"/>
                    </rich:column>
                </rich:dataTable>
            </h:form>
        </rich:panel>
    </a4j:region>
    </f:subview>
    