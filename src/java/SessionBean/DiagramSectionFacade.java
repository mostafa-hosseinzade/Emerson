/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Entity.DiagramSection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author administrator
 */
@Stateless
public class DiagramSectionFacade extends AbstractFacade<DiagramSection> {

    @PersistenceContext(unitName = "Emerson2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagramSectionFacade() {
        super(DiagramSection.class);
    }
    
    public List<DiagramSection> findAllByOrder(){
       return em.createNamedQuery("DiagramSection.findAllByOrder").getResultList();
    }
    
}
