package fr.esgi.fx.avis.gateway;

import java.util.List;

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
    public Editeur saveEditeur(Editeur editeur) {
        EditeurEntity editeurEntity = new EditeurEntity(editeur);
        return editeurRepository.save(editeurEntity).toEditeur();
    }

    @Override
    public List<Editeur> recupererEditeurs() {
        return editeurRepository.findAll().stream()
                .map(EditeurEntity::toEditeur).toList();
    }

}
