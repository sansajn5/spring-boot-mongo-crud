package it.tdgroup.eroi.controller;

import io.swagger.annotations.*;
import it.tdgroup.eroi.dto.UserDTO;
import it.tdgroup.eroi.exception.ApplicationException;
import it.tdgroup.eroi.exception.MapperException;
import it.tdgroup.eroi.exception.ServiceException;
import it.tdgroup.eroi.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;


@Api(value = "User", tags = "User")
@RestController
@RequestMapping({"${jwt.context-path}/users", "${app.context-path}/users"})
public class RestUserController extends BaseController {

    private static final Log LOG = LogFactory.getLog(RestUserController.class);

    @Autowired
    UserService userService;

    //Function findUserById
    @ApiOperation(value = "Find User", response = UserDTO.class, responseContainer = "entity")
    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<UserDTO> getUsers(@RequestParam (value = "name", defaultValue = "") String name) throws ApplicationException {
        try {
            UserDTO user = userService.read(name);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            //return new ResponseEntity<>(user, HttpStatus.OK);
            return ResponseEntity.ok(user);
        } catch (ServiceException ex) {
            throw new ApplicationException(ex);
        } catch (MapperException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Function createUser

    //Function deleteUser

    //Function upedateUser

}



