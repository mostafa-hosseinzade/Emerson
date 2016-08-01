package JsfClass;

import Entity.DiagramSection;
import JsfClass.util.JsfUtil;
import JsfClass.util.JsfUtil.PersistAction;
import SessionBean.DiagramSectionFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

@Named("diagramSectionController")
@SessionScoped
public class DiagramSectionController implements Serializable {

    @EJB
    private SessionBean.DiagramSectionFacade ejbFacade;
    private List<DiagramSection> items = null;
    private DiagramSection selected;

    public DiagramSectionController() {
    }

    public DiagramSection getSelected() {
        return selected;
    }

    public void setSelected(DiagramSection selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DiagramSectionFacade getFacade() {
        return ejbFacade;
    }

    public DiagramSection prepareCreate() {
        selected = new DiagramSection();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle4").getString("DiagramSectionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle4").getString("DiagramSectionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle4").getString("DiagramSectionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DiagramSection> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle4").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle4").getString("PersistenceErrorOccured"));
            }
        }
    }

    public DiagramSection getDiagramSection(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<DiagramSection> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DiagramSection> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = DiagramSection.class)
    public static class DiagramSectionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DiagramSectionController controller = (DiagramSectionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "diagramSectionController");
            return controller.getDiagramSection(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DiagramSection) {
                DiagramSection o = (DiagramSection) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DiagramSection.class.getName()});
                return null;
            }
        }

    }

    private DefaultDiagramModel model;

    @PostConstruct
    public void init() {
        List<DiagramSection> diagramSections = new ArrayList<>();
        diagramSections = ejbFacade.findAllByOrder();
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        List<Element> e = new ArrayList<>();
        Integer i = 0;
        for (DiagramSection d : diagramSections) {
            if (d.getParent() != null) {
                System.out.println("JsfClass.DiagramSectionController.init() items is : " + d.getParent().getId());
            }
            e.add(new Element(d, i + "em", i + "em"));
            i += 5;
        }

        Element ceo = new Element("CEO", "25em", "6em");
        ceo.addEndPoint(createEndPoint(EndPointAnchor.BOTTOM));
        model.addElement(ceo);

        //CFO
        Element cfo = new Element("CFO", "10em", "18em");
        cfo.addEndPoint(createEndPoint(EndPointAnchor.TOP));
        cfo.addEndPoint(createEndPoint(EndPointAnchor.BOTTOM));

        Element fin = new Element("FIN", "5em", "30em");
        fin.addEndPoint(createEndPoint(EndPointAnchor.TOP));

        Element pur = new Element("PUR", "20em", "30em");
        pur.addEndPoint(createEndPoint(EndPointAnchor.TOP));

        model.addElement(cfo);
        model.addElement(fin);
        model.addElement(pur);

        //CTO
        Element cto = new Element("CTO", "40em", "18em");
        cto.addEndPoint(createEndPoint(EndPointAnchor.TOP));
        cto.addEndPoint(createEndPoint(EndPointAnchor.BOTTOM));

        Element dev = new Element("DEV", "35em", "30em");
        dev.addEndPoint(createEndPoint(EndPointAnchor.TOP));

        Element tst = new Element("TST", "50em", "30em");
        tst.addEndPoint(createEndPoint(EndPointAnchor.TOP));

        model.addElement(cto);
        model.addElement(dev);
        model.addElement(tst);

        StraightConnector connector = new StraightConnector();
        connector.setPaintStyle("{strokeStyle:'#404a4e', lineWidth:3}");
        connector.setHoverPaintStyle("{strokeStyle:'#20282b'}");

        //connections
        model.connect(new Connection(ceo.getEndPoints().get(0), cfo.getEndPoints().get(0), connector));
        model.connect(new Connection(ceo.getEndPoints().get(0), cto.getEndPoints().get(0), connector));
        model.connect(new Connection(cfo.getEndPoints().get(1), fin.getEndPoints().get(0), connector));
        model.connect(new Connection(cfo.getEndPoints().get(1), pur.getEndPoints().get(0), connector));
        model.connect(new Connection(cto.getEndPoints().get(1), dev.getEndPoints().get(0), connector));
        model.connect(new Connection(cto.getEndPoints().get(1), tst.getEndPoints().get(0), connector));
    }

    private EndPoint createEndPoint(EndPointAnchor anchor) {
        DotEndPoint endPoint = new DotEndPoint(anchor);
        endPoint.setStyle("{fillStyle:'#404a4e'}");
        endPoint.setHoverStyle("{fillStyle:'#20282b'}");

        return endPoint;
    }

    public DiagramModel getModel() {
        return model;
    }

}
