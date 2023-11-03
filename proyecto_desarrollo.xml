<?xml version="1.0" encoding="UTF-8"?>
<definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xmlns:activiti="http://activiti.org/bpmn"
             xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI"
             xmlns:omgdc="http://www.omg.org/spec/DD/20100524/DC"
             xmlns:omgdi="http://www.omg.org/spec/DD/20100524/DI"
             xmlns:dc="http://www.omg.org/spec/DD/20100524/DC"
             id="Definitions_1"
             targetNamespace="http://bpmn.io/schema/bpmn"
             exporter="Camunda Modeler"
             exporterVersion="2.3.2">

    <process id="proceso_desarrollo_software" name="Proyecto Desarrollo de Software">
        <startEvent id="inicio_proceso" name="Inicio del Proceso"/>
        <userTask id="gestion_sucursales" name="Gestionar Sucursales"/>
        <userTask id="gestion_inventarios" name="Gestionar Inventarios"/>
        <userTask id="generar_cotizaciones" name="Generar Cotizaciones"/>
        <userTask id="realizar_ventas" name="Realizar Ventas"/>
        <userTask id="gestion_ordenes_trabajo" name="Gestionar Órdenes de Trabajo"/>
        <userTask id="consultar_estado_reparacion" name="Consultar Estado de Reparación"/>
        <userTask id="generar_reportes" name="Generar Reportes"/>
        <endEvent id="fin_proceso" name="Fin del Proceso"/>

        <sequenceFlow id="secuencia_gestion_sucursales" sourceRef="inicio_proceso" targetRef="gestion_sucursales"/>
        <sequenceFlow id="secuencia_gestion_inventarios" sourceRef="gestion_sucursales" targetRef="gestion_inventarios"/>
        <sequenceFlow id="secuencia_generar_cotizaciones" sourceRef="gestion_inventarios" targetRef="generar_cotizaciones"/>
        <sequenceFlow id="secuencia_realizar_ventas" sourceRef="generar_cotizaciones" targetRef="realizar_ventas"/>
        <sequenceFlow id="secuencia_gestion_ordenes_trabajo" sourceRef="realizar_ventas" targetRef="gestion_ordenes_trabajo"/>
        <sequenceFlow id="secuencia_consultar_estado_reparacion" sourceRef="gestion_ordenes_trabajo" targetRef="consultar_estado_reparacion"/>
        <sequenceFlow id="secuencia_generar_reportes" sourceRef="consultar_estado_reparacion" targetRef="generar_reportes"/>
        <sequenceFlow id="secuencia_fin_proceso" sourceRef="generar_reportes" targetRef="fin_proceso"/>
    </process>

    <bpmndi:BPMNDiagram id="BPMNDiagram_1">
        <bpmndi:BPMNPlane id="BPMNPlane_1" bpmnElement="proceso_desarrollo_software">
            <bpmndi:BPMNShape id="_BPMNShape_StartEvent_2" bpmnElement="inicio_proceso">
                <dc:Bounds x="173" y="102" width="36" height="36"/>
            </bpmndi:BPMNShape>
            <!-- Otros elementos del diagrama -->
        </bpmndi:BPMNPlane>
    </bpmndi:BPMNDiagram>
</definitions>

