<%-- 
    Document   : judgement
    Created on : Oct 5, 2008, 11:50:53 AM
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
        <title>Judgement Console</title>
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body background="../images/back.jpg">
        
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
                    <rich:panelMenu event="onclick">
                        <rich:panelMenuGroup label="Add Results">
                            <rich:panelMenuItem data="addindividualresult.jsp" label="Individual Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="addgroupresult.jsp" label="Group Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Modify Results">
                            <rich:panelMenuItem data="addindividualresult.jsp" label="Individual Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="groupmodify.jsp" label="Group Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                                                                                                                                                                    
                        </rich:panelMenuGroup>
                        
                        <rich:panelMenuGroup label="View Results">
                            <rich:panelMenuItem data="eventwiseresult.jsp" label="Event Wise Results" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="collegewiseresult.jsp" label="College Wise Results" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="View Registrations">
                            <rich:panelMenuItem data="eventwisereg.jsp" label="Event Wise Registrations" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="collegewisereg.jsp" label="College Wise Registrations" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                                                       
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Events">
                            <rich:panelMenuItem data="eventwisereg.jsp" label="Event Details" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                            
                            <rich:panelMenuItem data="schedule.jsp" label="Events Schedule" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Participant Details">
                            <rich:panelMenuItem data="partdetail.jsp" label="Participant Details" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            <rich:panelMenuItem data="viewgroup.jsp" label="Group Details" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                        </rich:panelMenuGroup>
              
                    <rich:panelMenuGroup label="Commitee Details">
                        <rich:panelMenuItem data="viewcommitteestatus.jsp" label="Committee details" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                    </rich:panelMenuGroup>
                          </rich:panelMenu>
                    <a4j:keepAlive beanName="jurl"/>
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
