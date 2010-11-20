<%-- 
    Document   : Tyro Home Page
    Created on : Jan 7, 2007, 6:36:52 AM
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
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>TYRO CLUB CONSOLE</title>
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
                        <rich:panelMenuGroup label="Committee">
                            <rich:panelMenuItem data="addcommittee.jsp" label="Add Committee" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="comdel.jsp" label="Delete Committee" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="viewcommitteestatus.jsp" label="View Committee Status" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                            <rich:panelMenuItem data="addmember.jsp" label="Add Committee Members" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="deletemembers.jsp" label="Remove Committee Members" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                                                                                                                                                                    
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Colleges">
                            <rich:panelMenuItem data="viewcollege.jsp" label="View Colleges" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                            
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Events">
                            <rich:panelMenuItem data="eventwisereg.jsp" label="View Events" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="addevent.jsp" label="Add Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="modifyevent.jsp" label="Modify Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="deleteevents.jsp" label="Delete Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                            
                            <rich:panelMenuItem data="schedule.jsp" label="Events Schedule" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                        </rich:panelMenuGroup>
                         <rich:panelMenuGroup label="Results">
                           <rich:panelMenuItem data="latestresults.jsp" label="Latest results" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                            <rich:panelMenuItem data="collegewiseresult.jsp" label="College Wise results" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                            
                            <rich:panelMenuItem data="eventwiseresult.jsp" label="Event Wise" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
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
