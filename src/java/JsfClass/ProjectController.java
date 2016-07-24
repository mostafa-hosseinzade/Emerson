package JsfClass;

import Entity.Project;
import JsfClass.util.JsfUtil;
import JsfClass.util.JsfUtil.PersistAction;
import SessionBean.ProjectFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@Named("projectController")
@SessionScoped
public class ProjectController implements Serializable {

    private MapModel pointSelect;
    private static String center;
    private static String zoomLevel = "13";

    public String getCenter() {
        return center;
    }

    public String getZoomLevel() {
        return zoomLevel;
    }

    public MapModel getPointSelect() {
        return pointSelect;
    }

    public void onStateChange(StateChangeEvent event) {
        LatLngBounds bounds = event.getBounds();
        int zoomLevel = event.getZoomLevel();
        this.center = event.getCenter().getLat() + "," + event.getCenter().getLng();
        this.zoomLevel = String.valueOf(zoomLevel);
    }

    public void onPointSelect(PointSelectEvent event) {
        pointSelect = new DefaultMapModel();
        LatLng latlng = event.getLatLng();
        pointSelect.addOverlay(new Marker(latlng));
        this.center = event.getLatLng().getLat() + "," + event.getLatLng().getLng();
    }

    @PostConstruct
    public void init() {
        center = "35.69634053686432 , 51.391639709472656";
        zoomLevel = "13";
    }
    @EJB
    private SessionBean.ProjectFacade ejbFacade;
    private List<Project> items = null;
    private Project selected;

    public ProjectController() {
    }

    public Project getSelected() {
        return selected;
    }

    public void setSelected(Project selected) {
        this.selected = selected;
        if (this.selected != null) {
            if (this.selected.getPoints() != null) {
                pointSelect = new DefaultMapModel();
                String[] d = this.selected.getPoints().split(",");
                LatLng latlng = new LatLng(Double.valueOf(d[0]), Double.valueOf(d[1]));
                pointSelect.addOverlay(new Marker(latlng, selected.getTitleEn()));
                this.center = selected.getPoints();
            } else {
                this.pointSelect = new DefaultMapModel();
            }
        }
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProjectFacade getFacade() {
        return ejbFacade;
    }

    public Project prepareCreate() {
        pointSelect = new DefaultMapModel();
        selected = new Project();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        if (this.pointSelect.getMarkers() != null) {
            selected.setPoints(center);
        }
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/BundleProject").getString("ProjectCreated"));
        this.pointSelect = new DefaultMapModel();
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        if (this.pointSelect.getMarkers() != null) {
            selected.setPoints(center);
        }
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/BundleProject").getString("ProjectUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/BundleProject").getString("ProjectDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Project> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleProject").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/BundleProject").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Project getProject(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Project> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Project> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Project.class)
    public static class ProjectControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProjectController controller = (ProjectController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "projectController");
            return controller.getProject(getKey(value));
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
            if (object instanceof Project) {
                Project o = (Project) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Project.class.getName()});
                return null;
            }
        }

    }

}
