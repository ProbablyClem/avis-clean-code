package fr.esgi.fx.avis.gateway;

import org.springframework.stereotype.Component;

import fr.esgi.fx.avis.entity.EditeurEntity;
import fr.esgi.fx.avis.model.Editeur;
import fr.esgi.fx.avis.repository.EditeurRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EditeurDbGatewayImpl
        implements EditeurDbGateway {

    EditeurRepository editeurRepository;

    @Override
    public void createEditeur(Editeur editeur) {
        EditeurEntity editeurEntity = new EditeurEntity(editeur);
        editeurRepository.save(editeurEntity);
    }

}
