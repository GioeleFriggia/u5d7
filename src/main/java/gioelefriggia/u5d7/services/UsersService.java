package gioelefriggia.u5d7.services;

import lombok.Getter;
import org.springframework.stereotype.Service;
import gioelefriggia.u5d7.entities.Users;
import gioelefriggia.u5d7.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Getter
@Service
public class UsersService {
    private final List<Users> usersList = new ArrayList<>();

    public Users saveUser(Users user) {
        Random rndm = new Random();
        user.setId(rndm.nextInt(1, 10000));
        this.usersList.add(user);
        return user;
    }

    public Users findById(int id) {
        return usersList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Users findByIdAndUpdate(int id, Users updatedUser) {
        Users userToUpdate = findById(id);
        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setSurname(updatedUser.getSurname());
        return userToUpdate;
    }

    public void findByIdAndDelete(int id) {
        Iterator<Users> iterator = this.usersList.iterator();
        while (iterator.hasNext()) {
            Users current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
                return;
            }
        }
        throw new NotFoundException(id);
    }
}
