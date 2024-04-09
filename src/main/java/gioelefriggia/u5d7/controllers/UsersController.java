package gioelefriggia.u5d7.controllers;

import gioelefriggia.u5d7.services.UsersService;
import org.springframework.web.bind.annotation.*;
import gioelefriggia.u5d7.entities.Users;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getUsersList(); // Accesso diretto al campo usersList invece del metodo getUsersList()
    }

    @GetMapping("/{id}")
    public Users getUsersById(@PathVariable int id) {
        return usersService.findById(id);
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersService.saveUser(user);
    }

    @PutMapping("/{id}")
    public Users updateUserById(@PathVariable int id, @RequestBody Users user) {
        return usersService.findByIdAndUpdate(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        usersService.findByIdAndDelete(id);
    }
}
