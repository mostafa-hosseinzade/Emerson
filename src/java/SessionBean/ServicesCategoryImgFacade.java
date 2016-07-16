/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.ServicesCategoryImg;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author administrator
 */
@Stateless
public class ServicesCategoryImgFacade extends AbstractFacade<ServicesCategoryImg> {

    @PersistenceContext(unitName = "Emerson2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicesCategoryImgFacade() {
        super(ServicesCategoryImg.class);
    }
    
}
