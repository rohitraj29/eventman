<%-- 
    Document   : participate
    Created on : Oct 5, 2008, 8:25:59 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="participate">
    
    <a4j:region>
        <rich:tabPanel>
            <rich:tab switchType="ajax"  label="Individual Events" name="Individual Events" >
                <rich:panel  header="Participate in Events">
                    <h:form>
                        <h:panelGrid columns="2">
                            <h:outputText value="Please Select the Event You Wish to participate"/>
                            <rich:comboBox value="#{EventPartBean.eventname}" defaultLabel="Select Events" enableManualInput="false" valueChangeListener="#{EventPartBean.ChangeFired}" immediate="true">
                                <a4j:support ajaxSingle="true" immediate="true" event="onchange" reRender="content"/>
                                <f:selectItems value="#{EventBean.eventlist}"/>
                            </rich:comboBox>
                            
                            <h:outputText value="Committee Organizing the Event"/>
                            <h:outputText value="#{EventPartBean.commname}"/>
                            
                            <h:outputText value="Please Select the Participant id"/>
                            <rich:comboBox value="#{EventPartBean.partid}" defaultLabel="Select Participant id" enableManualInput="false" valueChangeListener="#{EventPartBean.PartChanged}" immediate="true">
                                <a4j:support ajaxSingle="true" event="onchange" reRender="content" immediate="true"/>
                                <f:selectItems value="#{ParticipantBean.partlist}"/>
                            </rich:comboBox>
                            <a4j:commandButton value="Participate in Events" action="#{EventPartBean.participate}" reRender="content" immediate="true"/>
                        </h:panelGrid>
                    </h:form>
                </rich:panel>
            </rich:tab>
            
            
            
            
            <%-- Group Events Participation Tab--%>
            
            <rich:tab switchType="ajax" name="Group and Duet Events" label="Group and Duet Events">
                <rich:panel  header="Participate in Events">
                    <h:form>
                        <h:panelGrid columns="2">
                            <h:outputLabel value="Please Select the Event You Wish to participate"/>
                            <rich:comboBox value="#{EventpartGroupBean.eventname}" defaultLabel="Select Events" enableManualInput="false" valueChangeListener="#{EventpartGroupBean.ChangeFired}" immediate="true">
                                <a4j:support ajaxSingle="true" immediate="true" event="onchange" reRender="content"/>
                                <f:selectItems value="#{EventBean.eventgrouplist}"/>
                            </rich:comboBox>
                            
                            
                            
                            <h:outputLabel value="Please Select the Group ID"/>
                            <rich:comboBox value="#{EventpartGroupBean.groupid}" defaultLabel="Select Group id" enableManualInput="false" valueChangeListener="#{EventpartGroupBean.GroupChanged}" immediate="true">
                                <a4j:support ajaxSingle="true" event="onchange" reRender="content" immediate="true"/>
                                <f:selectItems value="#{GroupBean.grouplist}"/>
                            </rich:comboBox>
                            <a4j:commandButton value="Participate in Events" action="#{EventpartGroupBean.participate}" reRender="content" immediate="true"/>
                        </h:panelGrid>
                        
                    </h:form>
                </rich:panel>
            </rich:tab>
        </rich:tabPanel>
    </a4j:region>
    
</f:subview>