package com.udemy.backendninja.component;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component("contactConverter")
public class ContactConverter {

    /**
     * Model 2 entity.
     *
     * @param contactModel the contact model
     * @return the contact
     */
    public Contact model2Entity(ContactModel contactModel) {
        Contact contact = new Contact();
        contact.setId(contactModel.getId());
        contact.setFirstname(contactModel.getFirstname());
        contact.setLastname(contactModel.getLastname());
        contact.setTelephone(contactModel.getTelephone());
        contact.setCity(contactModel.getCity());
        return contact;
    }

    /**
     * Entity 2 model.
     *
     * @param contact the contact
     * @return the contact model
     */
    public ContactModel entity2Model(Contact contact) {
        ContactModel contactModel = new ContactModel();
        contactModel.setId(contact.getId());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setLastname(contact.getLastname());
        contactModel.setTelephone(contact.getTelephone());
        contactModel.setCity(contact.getCity());
        return contactModel;
    }

    /**
     * Entity list to model list.
     *
     * @param contactList the contact list
     * @return the list
     */
    public List<ContactModel> entityListToModelList(List<Contact> contactList) {
        List<ContactModel> contactModelList = new ArrayList<ContactModel>();
        for (Contact contact : contactList) {
            ContactModel contactModel = new ContactModel();
            contactModel.setId(contact.getId());
            contactModel.setFirstname(contact.getFirstname());
            contactModel.setLastname(contact.getLastname());
            contactModel.setTelephone(contact.getTelephone());
            contactModel.setCity(contact.getCity());
            contactModelList.add(contactModel);
        }
        return contactModelList;
    }

}
