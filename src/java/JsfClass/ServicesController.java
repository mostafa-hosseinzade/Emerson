package JsfClass;

import Entity.Services;
import JsfClass.util.JsfUtil;
import JsfClass.util.JsfUtil.PersistAction;
import SessionBean.ServicesFacade;
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

@Named("servicesController")
@SessionScoped
public class ServicesController implements Serializable {

    @EJB
    private SessionBean.ServicesFacade ejbFacade;
    private List<Services> items = null;
    private Services selected;
    private UploadedFile file;
    private UploadedFile pdf;

    public UploadedFile getPdf() {
        return pdf;
    }

    public void setPdf(UploadedFile pdf) {
        this.pdf = pdf;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public ServicesController() {
    }

    public Services getSelected() {
        return selected;
    }

    public void setSelected(Services selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ServicesFacade getFacade() {
        return ejbFacade;
    }

    public Services prepareCreate() {
        selected = new Services();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() throws IOException {
        int error = 0;
        String extension = FilenameUtils.getExtension(file.getFileName());
        if (extension != "") {
            String filename = "";
            File dir = new File("/opt/Emerson/uploads/services");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Path folder = Paths.get("/opt/Emerson/uploads/services");
            
            if (extension != "jpg" && extension != "png" && extension != "gif") {
                JsfUtil.addErrorMessage("فرمت عکس مجاز نمی باشد فرمت های مجاز (jpg,png,gif)");
                error = 1;
                this.file = null;
            } else {
                String name = 1 + "_" + System.currentTimeMillis();
                Path path = Paths.get(folder.toString(), name + "." + extension);
                Path outFile = Files.createFile(path);
                try (InputStream input = file.getInputstream()) {
                    Files.copy(input, outFile, StandardCopyOption.REPLACE_EXISTING);
                    filename += name + "." + extension;
                }
                selected.setImg(filename);
                this.file = null;
            }
        }
        extension = FilenameUtils.getExtension(pdf.getFileName());
        if (extension != "") {
            String filename = "";
            File dir = new File("/opt/Emerson/uploads/services");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Path folder = Paths.get("/opt/Emerson/uploads/services");
            if (extension != "pdf") {
                error = 1;
                JsfUtil.addErrorMessage("فرمت فایل کتاب الکترونیک درست نمی باشد");
                this.pdf = null;
            } else {
                String name = 1 + "_" + System.currentTimeMillis();
                Path path = Paths.get(folder.toString(), name + "." + extension);
                Path outFile = Files.createFile(path);
                try (InputStream input = pdf.getInputstream()) {
                    Files.copy(input, outFile, StandardCopyOption.REPLACE_EXISTING);
                    filename += name + "." + extension;
                }
                selected.setPdf(filename);
                this.pdf = null;
            }
        }
        if (error == 0) {
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ServicesCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
        }
    }

    public void update() throws IOException {
        int error = 0;
        if (this.file != null) {
            String filename = "";
            File dir = new File("/opt/Emerson/uploads/services");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Path folder = Paths.get("/opt/Emerson/uploads/services");
            if (selected.getImg() != null) {
                File f = new File("/opt/Emerson/uploads/services/" + selected.getImg());
                if (f.exists()) {
                    f.delete();
                }
            }
            String extension = FilenameUtils.getExtension(file.getFileName());
            if (extension != "jpg" && extension != "png" && extension != "gif") {
                System.out.println("JsfClass.ServicesController.update() : errrrrrrrrrrooooooooorrrrrrrr");
                JsfUtil.addErrorMessage("Format img Not True");
                error = 1;
            } else {
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
        }

        if (this.pdf != null) {
            String filename = "";
            File dir = new File("/opt/Emerson/uploads/services");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Path folder = Paths.get("/opt/Emerson/uploads/services");
            if (selected.getPdf() != null) {
                File f = new File("/opt/Emerson/uploads/services/" + selected.getPdf());
                if (f.exists()) {
                    f.delete();
                }
            }
            String extension = FilenameUtils.getExtension(pdf.getFileName());
            if (extension != "pdf") {
                error = 1;
                JsfUtil.addErrorMessage("Format PDf Not True");
            }
            String name = 1 + "_" + System.currentTimeMillis();
            Path path = Paths.get(folder.toString(), name + "." + extension);
            Path outFile = Files.createFile(path);
            try (InputStream input = pdf.getInputstream()) {
                Files.copy(input, outFile, StandardCopyOption.REPLACE_EXISTING);
                filename = name + "." + extension;
                selected.setPdf(filename);
                this.pdf = null;
            }
        }
        if (error == 0) {
            persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ServicesUpdated"));
        }
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ServicesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Services> getItems() {
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
                        File f = new File("/opt/Emerson/uploads/services/" + selected.getImg());
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

    public Services getServices(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Services> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Services> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Services.class)
    public static class ServicesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ServicesController controller = (ServicesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "servicesController");
            return controller.getServices(getKey(value));
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
            if (object instanceof Services) {
                Services o = (Services) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Services.class.getName()});
                return null;
            }
        }

    }

}
