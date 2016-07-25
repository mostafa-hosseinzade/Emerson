package Client;

import Entity.Project;
import Entity.ProjectCategory;
import SessionBean.ProjectCategoryFacade;
import SessionBean.ProjectFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name = "clienProjectController")
@ViewScoped
public class ClientProjectController {
    
    private String lang;

    public String getLang() {
        System.out.println("Client.ClientProjectController.getLang() lang is : "+lang);
        if(lang == "null" || lang=="EN"){
            return "EN";
        }
        if(lang=="FA"){
            return "FA";
        }
        return "FA";
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
    private MapModel points;
    private List<ProjectCategory> projectCategory;

    public List<ProjectCategory> getProjectCategory() {
        return projectCategoryFacade.findAll();
    }

    public List<Project> getProject() {
        return project;
    }

    public MapModel getPoints() {
        return points;
    }
    private List<Entity.Project> project;
    private List<Project> projectShow;
    @EJB
    private ProjectFacade projectFacade;
    @EJB
    private ProjectCategoryFacade projectCategoryFacade;

    @PostConstruct
    public void init() {
        lang = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("lang");
        System.out.println("Client.ClientProjectController.init() lang is : "+lang);
        points = new DefaultMapModel();
        this.project = projectFacade.findAll();
        this.projectShow = new ArrayList<>();
        for (Entity.Project p : this.project) {
            projectShow.add(p);
            if (p.getPoints() != null) {
                String[] point = p.getPoints().split(",");
                LatLng l = new LatLng(Double.valueOf(point[0]), Double.valueOf(point[1]));
                points.addOverlay(new Marker(l, p.getTitleEn(), p));
            }
        }
    }
    private Project titleAndImg;

    public Project getTitleAndImg() {
        return this.titleAndImg;
    }

    private Marker marker;

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

    public Marker getMarker() {
        return marker;
    }

}
