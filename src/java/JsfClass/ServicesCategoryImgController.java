package JsfClass;

import Entity.ServicesCategoryImg;
import JsfClass.util.JsfUtil;
import JsfClass.util.JsfUtil.PersistAction;
import SessionBean.ServicesCategoryImgFacade;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;

@Named("servicesCategoryImgController")
@SessionScoped
public class ServicesCategoryImgController implements Serializable {

    @EJB
    private SessionBean.ServicesCategoryImgFacade ejbFacade;
    private List<ServicesCategoryImg> items = null;
    private ServicesCategoryImg selected;
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public ServicesCategoryImgController() {
    }

    public ServicesCategoryImg getSelected() {
        return selected;
    }

    public void setSelected(ServicesCategoryImg selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ServicesCategoryImgFacade getFacade() {
        return ejbFacade;
    }

    public ServicesCategoryImg prepareCreate() {
        selected = new ServicesCategoryImg();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() throws IOException {
        int error = 0;
        String extension = FilenameUtils.getExtension(file.getFileName());
        if (extension != "") {
            String filename = "";
            File dir = new File("/opt/Emerson/uploads/servicescategory");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Path folder = Paths.get("/opt/Emerson/uploads/servicescategory");
//            System.out.println("JsfClass.ServicesCategoryImgController.create() Extension is : "+extension);
//            if (extension != "jpg" && extension != "png" && extension != "gif") {
//                JsfUtil.addErrorMessage("فرمت عکس مجاز نمی باشد فرمت های مجاز (jpeg,png,gif)");
//                error = 1;
//                this.file = null;
//            } else {
                String name = 1 + "_" + System.currentTimeMillis();
                Path path = Paths.get(folder.toString(), name + "." + extension);
                Path outFile = Files.createFile(path);
                try (InputStream input = file.getInputstream()) {
                    Files.copy(input, outFile, StandardCopyOption.REPLACE_EXISTING);
                    filename += name + "." + extension;
                }
                selected.setImg(filename);
                this.file = null;
//            }
        }
        if (error == 0) {
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ServicesCategoryImgCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
        }
    }

    public void update() throws IOException {
        if (this.file != null) {
            String filename = "";
            File dir = new File("/opt/Emerson/uploads/servicescategory");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Path folder = Paths.get("/opt/Emerson/uploads/servicescategory");
            if (selected.getImg() != null) {
                File f = new File("/opt/Emerson/uploads/servicescategory/" + selected.getImg());
                if (f.exists()) {
                    f.delete();
                }
            }
            String extension = FilenameUtils.getExtension(file.getFileName());
            String name = 1 + "_" + System.currentTimeMillis();
            Path path = Paths.get(folder.toString(), name + "." + extension);
            Path outFile = Files.createFile(path);
            try (InputStream input = file.getInputstream()) {
                Files.copy(input, outFile, StandardCopyOption.REPLACE_EXISTING);
                filename = name + "." + extension;
                selected.setImg(filename);
                this.file = null;
            }
        }
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ServicesCategoryImgUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ServicesCategoryImgDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ServicesCategoryImg> getItems() {
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
                    if (selected.getImg() != null) {
                        File f = new File("/opt/Emerson/uploads/servicescategory/" + selected.getImg());
                        if (f.exists()) {
                            f.delete();
                        }
                    }
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ServicesCategoryImg getServicesCategoryImg(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ServicesCategoryImg> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ServicesCategoryImg> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ServicesCategoryImg.class)
    public static class ServicesCategoryImgControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ServicesCategoryImgController controller = (ServicesCategoryImgController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "servicesCategoryImgController");
            return controller.getServicesCategoryImg(getKey(value));
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
            if (object instanceof ServicesCategoryImg) {
                ServicesCategoryImg o = (ServicesCategoryImg) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ServicesCategoryImg.class.getName()});
                return null;
            }
        }

    }

}
