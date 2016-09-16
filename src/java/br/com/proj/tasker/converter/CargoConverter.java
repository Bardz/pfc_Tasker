/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.converter;

import br.com.proj.tasker.model.Cargo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Oswaldo
 */
@FacesConverter(value = "cargoConverter", forClass = Cargo.class)
public class CargoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null & !"".equals(value)) {
            Cargo c = new Cargo();
            c.setIdCargo(Integer.parseInt(value));
            return c;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object != null && object instanceof Cargo) {
            return String.valueOf(((Cargo)object).getIdCargo());
        }
        return null;
    }    

}
