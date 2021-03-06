package integrativeproject.digitalbooking.util;

import integrativeproject.digitalbooking.model.entity.security.Role;
import integrativeproject.digitalbooking.security.enums.RoleName;
import integrativeproject.digitalbooking.service.impl.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//CommandLineRunnery ApplicationRunner, para ejecutar fragmentos de código específicos cuando una
//aplicación se inicia por completo. Estas interfaces se llaman justo antes de que se complete run()una vez
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RoleService roleService;

    @Override
    public void  run (String...args)throws  Exception{
        if (!roleService.getByRoleName(RoleName.ADMIN).isPresent())
        {
            Role adminRole = new Role(RoleName.ADMIN);
            roleService.save(adminRole);
        }

        if (!roleService.getByRoleName(RoleName.USER).isPresent())
        {
            Role userRole = new Role(RoleName.USER);
            roleService.save(userRole);
        }
    }
}
