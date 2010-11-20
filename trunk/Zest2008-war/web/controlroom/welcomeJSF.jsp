<%-- 
    Document   : Control Room Home Page
    Created on : Oct 5, 2008, 12:04:10 PM
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
                        <rich:panelMenuGroup label="Participant Details">
                            <rich:panelMenuItem data="participantdetails.jsp" label="View Participant Details" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                                                       
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Committee">                            
                            <rich:panelMenuItem data="viewcommitteestatus.jsp" label="View Committee Status" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Colleges">
                            <rich:panelMenuItem data="viewcollege.jsp" label="View Colleges" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                            
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Events">
                            <rich:panelMenuItem data="eventwisereg.jsp" label="Events Details" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="schedule.jsp" label="Events Schedule" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Results">
                           <rich:panelMenuItem data="latestresults.jsp" label="Latest results" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                            <rich:panelMenuItem data="collegewiseresult.jsp" label="College Wise results" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                            
                            <rich:panelMenuItem data="eventwiseresult.jsp" label="Event Wise" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="View Registrations">
                            <rich:panelMenuItem data="eventwisereg.jsp" label="Event Wise" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                                                       
                            <rich:panelMenuItem data="collegewisereg.jsp" label="College Wise" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                                                       
                        </rich:panelMenuGroup> 
                        <rich:panelMenuGroup label="Important Telephone Numbers">
                            <rich:panelMenuItem data="tellist.jsp" label="Telephone numbers" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                                                       
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
