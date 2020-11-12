/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodies;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Gubi
 */
@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, Character>{

    @Override
    public Character convertToDatabaseColumn(Boolean attrib) {
        if (attrib != null) {
            if (attrib) {
                return 'Y';
            } else {
                return 'N';
            }
        }
        return null;
    }

    @Override
    public Boolean convertToEntityAttribute(Character attrib) {
        if (attrib != null) {
            return attrib.equals('Y');
        }
        return null;
    }
   
    
}
