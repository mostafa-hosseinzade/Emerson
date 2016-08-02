package JsfClass;

import Entity.DiagramSection;
import JsfClass.util.JsfUtil;
import JsfClass.util.JsfUtil.PersistAction;
import SessionBean.DiagramSectionFacade;

import java.io.Serializable;
import java.sql.Date;
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
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
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
        DiagramSection OldParent = null;
        Integer order = 1;
        FlowChartConnector connector = new FlowChartConnector();
        connector.setPaintStyle("{strokeStyle:'rgba(0,0,0,0.2)',lineWidth:2}");
        model.setDefaultConnector(connector);
        List<String> places = new ArrayList<>();
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
                    XChild = Integer.valueOf(XParent) - 20;
                    YChild = Integer.valueOf(YParent) + 10;
                } else {
                    XParent = parent.getX().replace("em", "");
                    YParent = parent.getY().replace("em", "");
                    XChild = Integer.valueOf(XParent) + 20;
                    YChild = Integer.valueOf(YParent) + 10;
                }

                OldParent = d.getParent();
                if (places.contains(XChild + "," + YParent)) {
                    YChild += YChild + 3;
                    XChild += XChild+1;
                }

                places.add(XChild + "," + YParent);
                Element elm = new Element(d, XChild + "em", YChild + "em");
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

    public DiagramModel getModel() {
        return model;
    }

}
