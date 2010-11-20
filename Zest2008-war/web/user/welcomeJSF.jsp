<%-- 
    Document   : welcomeJSF
    Created on : Oct 16, 2008, 11:03:59 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control Room Console</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body background="images/back.jpg">
        <table align="center">
            <tr>
                <td align="center">
                    <img width="1200" height="250"src="images/banner.jpg" />
                </td>
            </tr>
        </table>
        <f:view>
            
            <div id="recent-posts">
                <h:form>
                    
                    <rich:panel>
                    <rich:panelMenu event="onclick">
                        <rich:panelMenuGroup label="Event Results">
                            <rich:panelMenuItem data="latestresults.jsp" label="Latest results" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Schedule">
                            <rich:panelMenuItem data="schedule.jsp" label="Events Schedule" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                        </rich:panelMenuGroup>
                    </rich:panelMenu>
                </rich:panel>
                    <a4j:keepAlive beanName="url"/>
                </h:form>
                
            </div>            
            <div id="latest-post">
                
                <a4j:outputPanel ajaxRendered="true" id="pm">
                    <a4j:include viewId="#{url.pageid}" ajaxRendered="true" styleClass="contentdiv" />
                </a4j:outputPanel>
                
            </div>
            
            
        </f:view>
        
    </body>
</html>
