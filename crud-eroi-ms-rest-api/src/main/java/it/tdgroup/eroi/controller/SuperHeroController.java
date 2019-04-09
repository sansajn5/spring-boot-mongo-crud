package it.tdgroup.eroi.controller;

import it.tdgroup.eroi.dto.CreateSuperHeroDTO;
import it.tdgroup.eroi.dto.SuperHeroDTO;
import it.tdgroup.eroi.exception.ApplicationException;
import it.tdgroup.eroi.exception.MapperException;
import it.tdgroup.eroi.exception.ServiceException;
import it.tdgroup.eroi.service.SuperHeroService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Resource SuperHero controller
 * Holds all EndPoints for SuperHero
 *
 * @author sansajn
 */
@RestController
@RequestMapping("/api/heros")
public class SuperHeroController extends BaseController {

    /**
     * Instance of logger
     */
    private static final Log LOG = LogFactory.getLog(SuperHeroController.class);

    /**
     * SuperHero service
     */
    private SuperHeroService superHeroService;

    /**
     * Constructor for SuperHeroController
     *
     * @param superHeroService
     */
    @Autowired
    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    /**
     * Handles POST /super-heros endpoint
     *
     * @param createSuperHeroDTO
     * @return
     */
    @PostMapping()
    public ResponseEntity createSuperHero(@RequestBody @Valid CreateSuperHeroDTO createSuperHeroDTO) throws ApplicationException {
        LOG.info("Handle POST /super-heros");
        try {
            this.superHeroService.createSuperHero(createSuperHeroDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (ServiceException ex) {
            throw new ApplicationException(ex);
        }
    }

    /**
     * Handles GET /heros endpoint
     *
     * @return
     * @throws ApplicationException
     */
    @GetMapping()
    public ResponseEntity<List<SuperHeroDTO>> getSuperHeros(
            @RequestParam(value="name", defaultValue="") String name,
            @RequestParam(value="superHero", defaultValue="") String superHero,
            @RequestParam(value="power", defaultValue="")String power
    ) throws ApplicationException {
        LOG.info("Handle GET /super-heros");
        try {
            List<SuperHeroDTO> payload;
            if(name.equals("") && superHero.equals("") && power.equals("")) {
                // Temp solution for using generic method
                payload = this.superHeroService.getAll();
            } else {
                // Using specific getAll
                payload = this.superHeroService.getAll(name, superHero, power);
            }
            return new ResponseEntity<List<SuperHeroDTO>>(payload, HttpStatus.OK);
        } catch (MapperException ex) {
            throw new ApplicationException(ex);
        }
    }

    /**
     * Handles GET /heros/{id} endpoint
     *
     * @param id Document id
     * @return
     * @throws ApplicationException
     */
    @GetMapping("/{id}")
    public ResponseEntity<SuperHeroDTO> getSuperHero(@PathVariable("id") String id) throws ApplicationException {
        LOG.info("Handle GET /super-heros/" + id);
        try {
            return new ResponseEntity<SuperHeroDTO>(this.superHeroService.getOne(id), HttpStatus.OK);
        } catch (ServiceException | MapperException ex) {
            throw new ApplicationException(ex);
        }
    }

    /**
     * Handles DELETE /heros/{id} endpoint
     *
     * @param id Document id
     * @return
     * @throws ApplicationException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSuperHero(@PathVariable("id") String id) throws ApplicationException {
        try {
            this.superHeroService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (ServiceException ex) {
            throw new ApplicationException(ex);
        }
    }

    /**
     * Handles PUT /heros/id
     *
     * @param superHeroDTO
     * @param id Document id
     * @return
     * @throws ApplicationException
     */
    @PutMapping("/{id}")
    public ResponseEntity updateSuperHero(@RequestBody @Valid SuperHeroDTO superHeroDTO, @PathVariable("id") String id) throws ApplicationException {
        try {
            this.superHeroService.updateSuperHero(superHeroDTO, id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (ServiceException | MapperException ex) {
            throw new ApplicationException(ex);
        }
    }

}
