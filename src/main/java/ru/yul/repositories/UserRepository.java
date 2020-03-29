package ru.yul.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yul.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByDeviceId(String deviceId);
}
