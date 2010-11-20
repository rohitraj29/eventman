<%-- 
    Document   : welcomeJSF
    Created on : Oct 11, 2008, 9:08:03 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Console</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body background="images/back.jpg">
        
        <f:view>
        
            <div id="recent-posts">
                <h:form>
                    <rich:simpleTogglePanel switchType="ajax" label="ControlRoom">
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
                            </rich:panelMenu>
                        </rich:panel>
                    </rich:simpleTogglePanel>
                    <rich:simpleTogglePanel switchType="ajax" label="Reception Console">
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
                            </rich:panelMenu>  
                        </rich:panel>
                    </rich:simpleTogglePanel>
                    <rich:simpleTogglePanel switchType="ajax" label="Judgement Console">
                        <rich:panelMenu event="onclick">
                            <rich:panelMenuGroup label="Add Results">
                                <rich:panelMenuItem data="addindividualresult.jsp" label="Individual Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                                <rich:panelMenuItem data="addgroupresult.jsp" label="Group Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                            </rich:panelMenuGroup>
                            <rich:panelMenuGroup label="Modify Results">
                                <rich:panelMenuItem data="addindividualresult.jsp" label="Individual Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                                <rich:panelMenuItem data="groupmodify.jsp" label="Group Event" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                                                                                                                                                                    
                            </rich:panelMenuGroup>
                            <rich:panelMenuGroup label="Delete Results">
                                <rich:panelMenuItem data="deleteresult.jsp" label="Delete Results" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />                            
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
                            </rich:panelMenuGroup>
                            <rich:panelMenuGroup label="Participant Details">
                                <rich:panelMenuItem data="partdetail.jsp" label="Participant Details" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                                <rich:panelMenuItem data="viewgroup.jsp" label="Group Details" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                            </rich:panelMenuGroup>
                        </rich:panelMenu>
                        
                    </rich:simpleTogglePanel>
                    <rich:simpleTogglePanel switchType="ajax" label="Tyro Console">
                        <rich:panel>
                            <rich:panelMenu event="onclick">
                                <rich:panelMenuGroup label="Committee">
                                    <rich:panelMenuItem data="addcommittee.jsp" label="Add Committee" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
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
                                </rich:panelMenuGroup>
                                <rich:panelMenuGroup label="Results">
                                    <rich:panelMenuItem data="latestresults.jsp" label="Latest results" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                                    <rich:panelMenuItem data="collegewiseresult.jsp" label="College Wise results" mode="ajax" actionListener="#{url.menuaction}" reRender="pm"/>
                                    
                                    <rich:panelMenuItem data="eventwiseresult.jsp" label="Event Wise" mode="ajax" actionListener="#{url.menuaction}" reRender="pm" />
                                </rich:panelMenuGroup>
                                
                            </rich:panelMenu>
                        </rich:panel>
                    </rich:simpleTogglePanel>
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

