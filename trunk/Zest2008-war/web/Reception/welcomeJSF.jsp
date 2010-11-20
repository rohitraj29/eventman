<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<%--reception Committee Home Page--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zest 2008</title>
        <link rel="stylesheet"type="text/css" href="style.css"/>
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
            <h:form>
                <rich:panel>
           
                </rich:panel>
                <div id="recent-posts">
                    <rich:panel>
                    <rich:panelMenu>
                        <rich:panelMenuGroup label="Participants">
                            <rich:panelMenuItem  data="regpart.jsp" actionListener="#{url.menuaction}" reRender="pm"  mode="ajax" label="Register Participants"/>
                            <rich:panelMenuItem  data="modpart.jsp" actionListener="#{url.menuaction}" reRender="pm"   mode="ajax" label="Modify Participants"/>
                            <rich:panelMenuItem  data="participate.jsp" actionListener="#{url.menuaction}" mode="ajax" reRender="pm" label="Participate in events"/>
                            <rich:panelMenuItem data="partdetail.jsp" actionListener="#{url.menuaction}"  mode="ajax" reRender="pm" label="View Participant Details"/>
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Events">
                            <rich:panelMenuItem data="eventwisereg.jsp" actionListener="#{url.menuaction}"  mode="ajax"reRender="pm" label="View Events"/>
                            <rich:panelMenuItem data="eventwisereg.jsp" actionListener="#{url.menuaction}"  mode="ajax"reRender="pm" label="view Participation"/>
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="College">
                            <rich:panelMenuItem  data="addcollege.jsp" actionListener="#{url.menuaction}" mode="ajax"reRender="pm" label="Add College"/>
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Groups">
                            <rich:panelMenuItem data="addgroup.jsp" actionListener="#{url.menuaction}" reRender="pm" mode="ajax" label="Add Groups"/>
                            <rich:panelMenuItem data="addtogrp.jsp"  actionListener="#{url.menuaction}" reRender="pm" mode="ajax" label="Add participants to group"/>
                            <rich:panelMenuItem data="viewgroup.jsp"  actionListener="#{url.menuaction}" reRender="pm" mode="ajax" label="View Group details"/>
                        </rich:panelMenuGroup>
                        <rich:panelMenuGroup label="Schedule of Events">
                            <rich:panelMenuItem data="schedule.jsp" actionListener="#{url.menuaction}" reRender="pm" mode="ajax" label="view Schedule"/>
                        </rich:panelMenuGroup>
                    </rich:panelMenu>  
</rich:panel>
                </div>
            </h:form>
            <a4j:keepAlive beanName="url"/>
            <a4j:keepAlive beanName="PartRegBean"/>
            <a4j:outputPanel ajaxRendered="true" id="pm" >
                <a4j:include viewId="#{url.pageid}"  layout="block" ajaxRendered="true" styleClass="contentdiv" />
            </a4j:outputPanel>
            
        </f:view>
    </body>
</html>
