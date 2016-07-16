package Theme;
 
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import Theme.Theme;
import Theme.ThemeService;
 
@ManagedBean
public class ThemeSwitcherView {
 
    private List<Theme> themes;
     
    @ManagedProperty("#{themeService}")
    private ThemeService service;
 
    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }
     
    public List<Theme> getThemes() {
        return themes;
    } 
 
    public void setService(ThemeService service) {
        this.service = service;
    }
    private String name="start";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}