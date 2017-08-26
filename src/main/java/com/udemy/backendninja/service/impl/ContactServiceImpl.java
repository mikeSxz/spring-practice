package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.ContactService;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {
    
    private static Log LOG = LogFactory.getLog(ContactServiceImpl.class);
    
    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;
    
    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;
    
    @Override
    public ContactModel addContact(ContactModel contactModel) {
        return contactConverter.entity2Model(contactRepository.save(contactConverter.model2Entity(contactModel)));
    }
    
    @Override
    public List<ContactModel> listaAllContacts() {
        return contactConverter.entityListToModelList(contactRepository.findAll());
    }
    
    @Override
    public ContactModel findContacById(int id) {
        return contactConverter.entity2Model(contactRepository.findById(id));
    }
    
    @Override
    public void removeContact(int id) {
        LOG.info("id desde el metodo remove contact en el implement: " + id);
        ContactModel contactModel = findContacById(id);
        LOG.info("objeto contactModel desde el metodo remove contact en el implement: " + contactModel.toString());
        LOG.info("objeto entity contact desde el metodo remove contact en el implement:" + contactConverter.model2Entity(contactModel).toString());
        if (contactModel != null) {
            contactRepository.delete(contactConverter.model2Entity(contactModel));
        }
        
    }
    
}
