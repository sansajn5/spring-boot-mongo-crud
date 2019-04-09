package it.tdgroup.eroi.mapperimpl;

import it.tdgroup.eroi.domain.hero.collection.SuperHero;
import it.tdgroup.eroi.domain.hero.embedded.SuperPower;
import it.tdgroup.eroi.dto.SuperHeroDTO;
import it.tdgroup.eroi.dto.SuperPowerDTO;
import it.tdgroup.eroi.exception.MapperException;
import org.springframework.data.mapping.MappingException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

/**
 * Mapper implementation for {@link SuperHero}
 *
 * @author sansajn
 */
@Component
public class SuperHeroMapperImpl extends AbstractMapperComponent<SuperHeroDTO, SuperHero> {

    @Override
    public SuperHeroDTO convertEntityToDto(SuperHero entity) throws MapperException {
        try {

            SuperHeroDTO superHeroDTO = new SuperHeroDTO();
            superHeroDTO.setId(entity.getId());
            superHeroDTO.setName(entity.getName());
            superHeroDTO.setSurname(entity.getSurname());
            superHeroDTO.setSuperHeroName(entity.getSuperHeroName());
            superHeroDTO.setCreatedAt(entity.getCreatedAt());
            superHeroDTO.setUpdatedAt(entity.getCreatedAt());
            superHeroDTO.setUpdatedAt(entity.getUpdatedAt());
            superHeroDTO.setSuperPowers(entity.getPowers()
                    .stream()
                    .map(power -> {
                        return new SuperPowerDTO(power.getName(), power.getDescription());
                    })
                    .collect(Collectors.toList()));
            return superHeroDTO;

        } catch (Exception ex) {
            throw new MappingException(ex.getMessage());
        }
    }

    @Override
    public SuperHero convertDtoToEntity(SuperHeroDTO dto) throws MapperException {
        try {
            SuperHero superHero = new SuperHero();
            superHero.setUpdatedAt(new Date());
            superHero.setName(dto.getName());
            superHero.setSurname(dto.getSurname());
            superHero.setSuperHeroName(dto.getSuperHeroName());
            superHero.setPowers(dto.getSuperPowers()
                    .stream()
                    .map(power -> {
                        return new SuperPower(
                            power.getName(),
                            power.getDescription()
                        );
                    })
                    .collect(Collectors.toList()));
            return superHero;
        } catch (Exception ex) {
            throw new MapperException(ex.getMessage());
        }
    }
}
