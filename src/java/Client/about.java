/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Entity.DiagramSection;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

@ManagedBean(name = "about")
@SessionScoped
public class about implements Serializable {

    @EJB
    private SessionBean.DiagramSectionFacade ejbFacade;
    private DefaultDiagramModel model;

    @PostConstruct
    public void init() {
        List<DiagramSection> diagramSections = new ArrayList<>();
        diagramSections = ejbFacade.findAllByOrder();
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        DiagramSection OldParent = null;
        Integer order = 1;
        FlowChartConnector connector = new FlowChartConnector();
        connector.setPaintStyle("{strokeStyle:'rgba(0,0,0,0.2)',lineWidth:2}");
        model.setDefaultConnector(connector);
        List<String> places = new ArrayList<>();
        Integer i = 2;
        for (DiagramSection d : diagramSections) {
            Element parent = null;
            order = d.getOrder();
            if (d.getParent() != null) {
                for (Element t : model.getElements()) {
                    if (t.getData() == d.getParent()) {
                        parent = t;
                    }
                }
                String XParent;
                String YParent;
                Integer XChild;
                Integer YChild;
                if (OldParent != null && OldParent == d.getParent()) {
                    XParent = parent.getX().replace("em", "");
                    YParent = parent.getY().replace("em", "");
                    XChild = Integer.valueOf(XParent) - 10;
                    YChild = Integer.valueOf(YParent) + 10;
                } else {
                    XParent = parent.getX().replace("em", "");
                    YParent = parent.getY().replace("em", "");
                    XChild = Integer.valueOf(XParent) + 10;
                    YChild = Integer.valueOf(YParent) + 10;
                }

                OldParent = d.getParent();
                String point = Checks(places, XChild, YChild);
                places.add(point);
                Element elm = new Element(d, point.split(",")[0] + "em", point.split(",")[1] + "em");
                elm.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                elm.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM));
                model.addElement(elm);
                if (parent != null) {
                    model.connect(new Connection(parent.getEndPoints().get(1), elm.getEndPoints().get(0), connector));
                }
            } else {
                Element elm = new Element(d, "50em", "0em");
                elm.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                elm.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM));
                model.addElement(elm);

                for (Element t : model.getElements()) {
                    if (t.getData() == d.getParent()) {
                        parent = t;
                    }
                }
                if (parent != null) {
                    model.connect(new Connection(parent.getEndPoints().get(1), elm.getEndPoints().get(0), connector));
                }
            }
        }
    }
    
    private String Checks(List<String> list,Integer x,Integer y){
        if(list.contains(x+ "," +y)){
            x = x+15;
            y = y+15;
            Checks(list, x,y);
        }
        return x+","+y;
    }
    public DiagramModel getModel() {
        return model;
    }
}
