/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.converter;

import br.com.proj.tasker.model.Plano;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "planoConverter", forClass = Plano.class)
public class PlanoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null & !"".equals(value)) {
            Plano p = new Plano();
            p.setIdPlan(Integer.parseInt(value));
            return p;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object != null && object instanceof Plano) {
            return String.valueOf(((Plano)object).getIdPlan());
        }
        return null;
    }
}