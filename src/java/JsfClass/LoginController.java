/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsfClass;

import JsfClass.util.JsfUtil;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "loginController")
public class LoginController {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void login() throws ServletException, IOException{
        try{
        if(this.username == null || this.password == null){
            JsfUtil.addErrorMessage("اطلاعات ارسال شده کامل نمی باشد");
        }
        HttpServletRequest servletRequest =(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        servletRequest.login(username, password);
        }catch(ServletException s){
            JsfUtil.addErrorMessage("اطلاعات وارد شده نامعتبر است");
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/Admin/?faces-redirect=true");
    }
    
    public void logout() throws IOException {
        HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
            origRequest.logout();
            origRequest.getSession().invalidate();
        } catch (ServletException ex) {
            JsfUtil.addErrorMessage("خطا در خروج از سیستم");
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()+"/Admin/?faces-redirect=true");
    }
}
